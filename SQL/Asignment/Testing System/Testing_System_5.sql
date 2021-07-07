use Testing_System;

-- q1
create or replace view v_saleMember
as
select A.AccountID, email, username, fullname, departmentid, A.positionid, createdate
from Account A
         inner join Position P on A.PositionID = P.PositionID
where PositionName = 'sale';

select *
from v_saleMember;

-- q2
create or replace view v_account_join_most_group as
with CTE_tbl as (
    select count(GroupID) as totalGroup,
           A.AccountId,
           Email,
           UserName,
           FullName,
           DepartmentId,
           PositionID,
           CreateDate
    from Account A,
         GroupAccount G
    where A.AccountId = G.AccountID
    group by A.AccountId
)
select *
from CTE_tbl
where totalGroup = (select max(totalGroup) from CTE_tbl);

select *
from v_account_join_most_group;



-- q3
create or replace view v_long_content as
select *
from Question
where character_length(Content) > 10;

drop view v_long_content;

begin work ;
delete  from v_long_content;
select * from v_long_content;
select * from Question;
rollback ;


select *
from v_account_join_most_group;


-- q4
create or replace view v_department_have_most_menmber as
with CTE_department_count as (
    select count(AccountId) as numOfMember, A.DepartmentId, DepartmentName
    from Department D
             left join
         `Account` A
         on D.DepartmentID = A.DepartmentId
    group by D.DepartmentId
)
select *
from CTE_department_count
where numOfMember = (select max(numOfMember) from CTE_department_count);

select *
from v_department_have_most_menmber;


-- q5
create or replace view v_Nguyen_questions as
select A.FullName as creator,Q.QuestionID, Q.Content, Q.CategoryID, Q.TypeID, Q.CreatorID, Q.CreateDate
from Question Q
         join Account A on Q.CreatorID = A.AccountId
where A.FullName like 'nguyen%';

select * from v_Nguyen_questions;