show databases;
use Testing_System_Asignment_1;

select *
from Department;

select *
from Department
limit 2;

select DepartmentName
from Department;

select distinct DepartmentName
from Department;

select DepartmentName as 'tên phòng ban'
from Department
where DepartmentID = 1;

select *
from Department
order by DepartmentName asc;

select *
from Department
where DepartmentID in (1, 5);

select *
from Department
where DepartmentID between 1 and 5;

select *
from Department
where DepartmentName like '%v%';

-- insert some record
insert into Department(DepartmentName) values (null);
insert into Department(DepartmentName) values ('sale');

select count(DepartmentName) from Department;
select count(distinct DepartmentName) from Department;
select count(*) from Department;
select count(1) from Department;

