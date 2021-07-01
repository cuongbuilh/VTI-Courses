use Testing_System_Asignment_1;

-- q1
create view v_saleMember
as
select A.AccountID, email, username, fullname, departmentid, A.positionid, createdate
from Account A
         inner join Position P on A.PositionID = P.PositionID
where PositionName = 'sale';

select * from v_saleMember;

