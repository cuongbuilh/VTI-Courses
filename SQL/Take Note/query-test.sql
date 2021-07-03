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
insert into Department(DepartmentName)
values (null);
insert into Department(DepartmentName)
values ('sale');

select count(DepartmentName)
from Department;
select count(distinct DepartmentName)
from Department;
select count(*)
from Department;
select count(1)
from Department;

-- CTE common table expression
select *
from Department;
with cte_department(id)
         as (
        select departmentid as id
        from Department
    )
select *
from cte_department;

-- temporary table
drop temporary table if exists tmp_table;
create temporary table tmp_table
as
select *
from Department;
select *
from tmp_table;
--
show databases;
--
use Testing_System;
show table status;

use master;
create database test;
use test;
CREATE table unique_tbl
(
    uq int unique
);

insert into unique_tbl(uq)
values (null);
select *
from unique_tbl;
--

use Testing_System;
show tables;

select *
from Question Q,
     Answer A
where A.QuestionID = Q.QuestionID;

select *
from Question Q
         cross join Answer A;
-- on Q.QuestionID = A.QuestionID;


--
use test;
create table a
(
    a int
);
create table b
(
    a int
);

insert into a
values (1),
       (2),
       (3),
       (4),
       (5);
insert into b
values (6),
       (7),
       (8),
       (4),
       (5);

select *
from a
union
select *
from b;


select *
from a
union all
select *
from b;

--
select * from a;
select * from a where exists ( select * from b);

--
use test;

-- test proceduree
delimiter //
create procedure helloSql()
begin
    select 'my sql';
end //
delimiter ;

call helloSql();
--
-- create sum procedure
delimiter //
create procedure sumInt(in a int, in b int, out c int)
begin
    set c = a+b;
    select c;
end //
delimiter ;

set @a=0;
call sumInt(1,1,@a);
select @a;
set