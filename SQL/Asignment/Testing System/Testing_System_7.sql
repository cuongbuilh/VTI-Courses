use Testing_System;
# trigger
-- q1
drop trigger if exists trg_group_time_limit;
create trigger trg_group_time_limit
    before insert
    on `Group`
    for each row
begin
    if timestampdiff(year, NEW.CreateDate, curdate()) > 1 then
        signal sqlstate '12345' -- disallow insert this recort
            set message_text = 'createDate must less than 1 year before now';
    end if;
end;

insert into `Group`(CreateDate)
values ('2009-12-12');

-- q2
drop trigger if exists trg_not_allow_sale;
create trigger trg_not_allow_sale
    before insert
    on Account
    for each row
begin
    declare insert_department_name varchar(50);

    if ((select DepartmentName
         from Department
         where DepartmentId = NEW.DepartmentId) like '%Sale%')
    then
        signal sqlstate '12346'
            set message_text = 'department Sale cannot add more user';
    end if;
end;
insert into Account(UserName, DepartmentId)
values ('asdasd', 2);


-- q3
-- q4
-- q5


-- q7
-- q8
-- q9
-- q10
create trigger trg_cau10
    before delete
    on Question
    for each row
begin
    end;
# case...when...
-- q11--none
-- q12
select ExamID,
       Code,
       Title,
       Duration,
       if(Duration <= 30, 'Short time',
          if(Duration <= 60, 'Medium time',
             if(Duration > 60, 'Long time', null))) as kind_of_exam
from Exam;

-- q13
select G.GroupID,
       GroupName,
       count(AccountID)                                  as numOfUser,
       if(count(AccountID) <= 5, 'few',
          if(count(AccountID) <= 20, 'normal',
             if(count(AccountID) > 20, 'higher', null))) as the_number_user_amount
from `Group` G
         left join GroupAccount GA on G.GroupID = GA.GroupID
group by G.GroupID;


-- q14
select D.DepartmentID,
       DepartmentName,
       case count(AccountId)
           when 0 then 'không có User'
           else count(AccountId)
           end as num_of_user
from Department D
         left join Account A
                   on D.DepartmentID = A.DepartmentId
group by D.DepartmentID;


