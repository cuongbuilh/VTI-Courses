use testing;

-- update data for 2a
select * from salary;	
update salary set `month` = 5 where salary_id in (1,2,3);

-- q 2a
select u.user_id, u.first_name, u.last_name, s.total_salary 
from users u 
	join user_department ud on u.user_id = ud.user_id
    join user_role ur on ur.user_department_id = ud.user_department_id
    join salary s on s.user_role_id = ur.user_role_id
where `month` = '5';

-- 2b Get danh sách lương tháng 5 của 1 phòng bất kì sắp xếp theo tổng
-- lương giảm dần

select ud.user_department_id,  sum(s.total_salary) as total
from user_department ud
    join user_role ur on ur.user_department_id = ud.user_department_id
    join salary s on s.user_role_id = ur.user_role_id
where `month` = '5'
group by ud.user_department_id ;

select * from salary;
select * from user_role;

-- 2c Get nhưng user bị tính lương sai(total_salary != total detail salary)
-- trong tháng 5/2020
-- note bỏ qua các operation để giảm độ khó
-- note total salary = sum(amount)
select u.user_id
from users u 
	join user_department ud on u.user_id = ud.user_id
    join user_role ur on ur.user_department_id = ud.user_department_id
    join salary s on s.user_role_id = ur.user_role_id
    join salary_detail sd on sd.salary_id = s.salary_id
where `month` = '5' 
	and `year` = '2020'
group by u.user_id, s.salary_id, s.total_salary 
having s.total_salary <> sum(sd.amount);


-- 2d
select ud.user_department_id , sum(s.total_salary) as 'tong chi phi'
from user_department ud 
    join user_role ur on ur.user_department_id = ud.user_department_id
    join salary s on s.user_role_id = ur.user_role_id
where `month` = '5' 
	and `year` = '2020'
group by ud.user_department_id; 


-- 3
-- note bỏ qua các operation để giảm độ khó
drop procedure if exists sp_cau3;

delimiter //
create procedure sp_cau3(in input_id int)
begin
	select  sdt.salary_detail_type_name as 'type' ,sd.amount as 'amount', sd.operation  as 'operation'
from users u 
	join user_department ud on u.user_id = ud.user_id
    join user_role ur on ur.user_department_id = ud.user_department_id
    join salary s on s.user_role_id = ur.user_role_id
    join salary_detail sd on sd.salary_id = s.salary_id
    join salary_detail_type sdt on sdt.salary_detail_type_id = sd.salary_detail_type_id
where u.user_id = input_id  
union
select  'Total' as 'type' ,s.total_salary as 'amount', '0'  as 'operation'
from users u 
	join user_department ud on u.user_id = ud.user_id
    join user_role ur on ur.user_department_id = ud.user_department_id
    join salary s on s.user_role_id = ur.user_role_id
    join salary_detail sd on sd.salary_id = s.salary_id
    join salary_detail_type sdt on sdt.salary_detail_type_id = sd.salary_detail_type_id
where u.user_id = input_id ;
end //
delimiter ;

-- update data for test cau 3
select * from salary_detail;
update salary_detail set salary_id = 1 where salary_detail_id in (2,3,4);   
call sp_cau3(1);



-- 4
drop procedure if exists sp_cau4;

delimiter //
create procedure sp_cau4(in input_id int)
begin
select  concat(u.first_name,' ', u.last_name) as fullname, 
		d.department_name as department,
        r.role_name as 'role',
        s.total_salary as salary
from users u 
	join user_department ud on u.user_id = ud.user_id
    join user_role ur on ur.user_department_id = ud.user_department_id
    join salary s on s.user_role_id = ur.user_role_id
    join departments d on d.department_id = ud.department_id
    join roles r on r.role_id = ur.role_id
where u.user_id = input_id ;
end //
delimiter ;

-- update data for test cau4
select * from salary;
update salary set total_salary = 1000 where salary_id =1;
-- test
call sp_cau4(1);
 

 
-- cau 5
drop trigger if exists tgr_cau5;

delimiter //
create trigger tgr_cau5
before insert on user_role
for each row
begin
	-- khai báo các biến để sử dụng
    declare start_date_in_department date;
    declare end_date_in_department date;
    
    declare start_date_in_position date;
    declare end_date_in_position date;
    
-- khai bao cho vong lap
    -- bien done se duoc gan = true neu duyet het bang user_detai
    declare done int default false;    
     declare cur cursor 
		for select start_date, end_date 
        from user_role ur 
        where ur.user_department_id = new.user_department_id ;
	declare continue handler for not found set done = true;
	
    
-- kiểm tra nằm trong thời gian ở phòng ban
	-- lấy thời gian
    select start_date , end_date into start_date_in_department, end_date_in_department
    from user_department ud
    where ud.user_department_id = new.user_department_id ;
    -- id của user_role mới insert vào
    -- kiểm tra
    if( new.start_date  <= start_date_in_department )
    then
        signal sqlstate '45000' set message_text ='thoi gian khong hop le';
	end if;
    if( new.end_date  >= end_date_in_department )
    then
        signal sqlstate '45000' set message_text ='thoi gian khong hop le';
	end if;
    

-- kiểm tra thời gian với các role khác khi làm trong phòng ban đó   	
    open cur; -- bat dau
    -- vong lap -> duyet qua tat ca cac posiotion
    read_loop: 
    loop
		-- lay ra ngay bat dau + ket thuc cua 1 position
		fetch cur into start_date_in_position,end_date_in_position;
         -- leave loop
        if done then
            leave read_loop;
        end if;
        
        
        -- kiem tra thoi gian co bij trung voi cac position khac khong
        if( new.start_date between  start_date_in_position and end_date_in_position )
			then
				signal sqlstate '45000' set message_text ='thoi gian khong hop le';
		end if;
        if( new.end_date between  start_date_in_position and end_date_in_position )
			then
				signal sqlstate '45000' set message_text ='thoi gian khong hop le';
		end if;
        
        if( start_date_in_position between  new.start_date and new.end_date )
			then
				signal sqlstate '45000' set message_text ='thoi gian khong hop le';
		end if;
        if( end_date_in_position between  new.start_date and new.end_date )
			then
				signal sqlstate '45000' set message_text ='thoi gian khong hop le';
		end if;
    end loop;
    close cur; -- remember close cusor
end //
delimiter ;

update user_department set start_date = '1990-01-01', end_date='2020-01-01' where user_department_id=1;
select * from user_department where user_department_id = 1;
select * from user_role where user_department_id = 1;

-- khi insert se loi
insert into user_role(user_department_id,role_id,start_date,end_date)
values(1, 2, '1994-01-01', '2014-06-17' );
insert into user_role(user_department_id,role_id,start_date,end_date)
values(1, 2, '2021-01-01', '2022-01-01' );
insert into user_role(user_department_id,role_id,start_date,end_date)
values(1, 2, '1991-01-01', '2014-06-17' );


-- insert dung
insert into user_role(user_department_id,role_id,start_date,end_date)
values(1, 2, '2013-01-01', '2018-01-01' );
insert into user_role(user_department_id,role_id,start_date,end_date)
values(1, 2, '2019-01-01', '2018-01-01' );




--
select user_id, gender from users;
-- if(dieu_kien, gia_tri_tra_ve_neu_dung, neu_sai)
select user_id, if(gender='M', 'nam', if(gender='F', 'nu', 'khong biet')) as 'gioi tinh'
from users;

-- su dung case when
select user_id, case gender when 'M' then 'nam'
							when 'F' then 'nu'
                            when 'U' then 'khong biet'
							else 'gia tri khac, hoac chua insert'
					end as 'gioi tinh'
from users;

    