-- tạo database mới
drop database if exists myDB; -- xóa database cũ nếu có
create database myDB;
use myDB;
-- chuyển qua database cần thao tác

-- tạo các table
create table tbl_1
(
    _id       int identity (1,1) primary key, -- identity(1,1) để khóa tự tăng 1 bắt đầu từ 1
    _name     nvarchar(50),
    _username varchar(32)
)

create table tbl_2
(
    _id   int identity primary key, -- identity mặc định bắt đầu từ 1 và tăng dần thêm 1
    _name nvarchar(50)
)

insert into tbl_1 (_name, _username) -- thêm dữ liệu vào bảng tbl_1
values ('1', '1'),
       ('2', '2'),
       ('3', '3');

insert into tbl_2(_name) -- thêm dữ liệu vào bảng tbl_2
values ('1'),
       ('2'),
       ('3');

select *
from tbl_1;
select *
from tbl_2;

-- tạo procedure

drop proc if exists sp_sum;
go
create proc sp_sum @a int, @b int, @c int out
as
begin
    set @c = @a + @b;
end;
go

go
declare @a int;
exec sp_sum 1, 1, @a out;
select @a;
go

-- tao funtion
drop function if exists f_sum;
go
create function f_sum(@a int, @b int)
    returns int
as
begin
    return @a + @b;
end;
go

select dbo.f_sum(1, 2) as 'tong';

-- tao view
create or alter view v_all(id1, id2, name1, name2, username)
as
select tb1._id, tb2._id, tb1._name, tb2._name, _username
from tbl_1 as tb1,
     tbl_2 as tb2;


-- select
select *
from v_all;

select *
from tbl_1
         left join tbl_2 t on tbl_1._id = t._id;

select *
from tbl_1 as t1,
     tbl_2 as t2
where t1._id = t2._id;