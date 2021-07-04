use Testing_System;
--

-- q1
delimiter //
drop procedure if exists sp_show_account_in_department;
create procedure sp_show_account_in_department(in department_name varchar(50))
begin
    select D.DepartmentName,
           A.AccountId,
           Email,
           UserName,
           FullName,
           A.DepartmentId,
           PositionID,
           CreateDate
    from Account A
             join Department D on A.DepartmentId = D.DepartmentID
    where DepartmentName like concat('%', department_name, '%');
end //
delimiter ;

call sp_show_account_in_department('dev 2');

-- q2
delimiter //
drop procedure if exists sp_show_num_of_acc_in_group;
create procedure sp_show_num_of_acc_in_group()
begin
    select count(AccountID) as numOfMember, G.GroupID, G.GroupName
    from `Group` G
             join GroupAccount GA on G.GroupID = GA.GroupID
    group by G.GroupID;
end //
delimiter ;

call sp_show_num_of_acc_in_group();

-- q3
delimiter //
drop procedure if exists sp_num_of_question_created_in_this_month;
create procedure sp_num_of_question_created_in_this_month()
begin
    select count(QuestionID) as numOfQuestion, T.TypeID, TypeName
    from TypeQuestion T
             join Question Q on Q.TypeID = T.TypeID
    where month(CreateDate) = month(now())
      and year(CreateDate) = year(now())
    group by T.TypeID;
end //
delimiter ;

call sp_num_of_question_created_in_this_month();

-- q4
delimiter //
drop procedure if exists sp_typeID_max_num_question;
create procedure sp_typeID_max_num_question(out type_id int unsigned)
begin
    select T.TypeID
    into type_id
    from TypeQuestion T
             join Question Q on T.TypeID = Q.TypeID
    group by Q.TypeID
    order by count(QuestionID)
    limit 1;
end //
delimiter ;
-- q5
set @a = 0;
call sp_typeID_max_num_question(@a);
select @a;

select TypeName
from TypeQuestion
where TypeID = @a;

set @a=null;

-- q6
delimiter //
drop procedure if exists sp_find_by_name;
create procedure sp_find_by_name(in keyword char(50)) begin
    select  GroupID as ID, GroupName as Name from `Group` G where GroupName like concat('%',keyword,'%')
    union
    select AccountID as ID, FullName as Name from Account where FullName like concat('%',keyword,'%');
end //
delimiter ;

call sp_find_by_name('a');

-- q7


#-- -------------------------------------
