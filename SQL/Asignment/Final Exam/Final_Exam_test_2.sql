# create database
drop database if exists thuctap;
create database thuctap;
use thuctap;

# create tables
drop table if exists giangvien;
create table giangvien
(
    magv  int primary key auto_increment,
    hoten varchar(50),
    luong bigint
);

drop table if exists sinhvien;
create table sinhvien
(
    masv    int primary key auto_increment,
    hoten   varchar(50),
    namsinh int,
    quequan varchar(100)
);

drop table if exists detai;
create table detai
(
    madt       int primary key auto_increment,
    tendt      varchar(50),
    kinhphi    bigint,
    noithuctap varchar(50)
);

drop table if exists huongdan;
create table huongdan
(
    id     int primary key auto_increment,
    masv   int,
    madt   int,
    magv   int,
    ketqua float
);

-- insert data
insert into giangvien(hoten)
VALUES ('an'),
       ('binh'),
       ('nguyen');

insert into sinhvien(hoten)
VALUES ('mai'),
       ('an'),
       ('duong');

insert into detai(tendt)
VALUES ('cong nghe sinh hoc'),
       ('toan'),
       ('ly');

insert into huongdan(masv, madt, magv)
VALUES (1, 1, 1),
       (2, 1, 2),
       (2, 2, 2);

-- 2.a : lay sv chua co de tai huong dan
select s.masv, hoten
from sinhvien s
         left join huongdan h on s.masv = h.masv
where id is null;

-- 2.b : lay sv lam de tai cong nghe sinh hoc
select count(s.masv) as so_luong
from sinhvien s
         join huongdan h on s.masv = h.masv
         join detai d on h.madt = d.madt
where tendt = 'cong nghe sinh hoc'
group by d.madt, tendt;

-- check ket qua -> dung view sinhvieninfo sau

-- 3 : view sinhvien info
create or replace view sinhvieninfo (ma_so, ho_ten, ten_de_tai) as
select s.masv, s.hoten, d.tendt
from sinhvien s
         join huongdan h on s.masv = h.masv
         join detai d on h.madt = d.madt;

select *
from sinhvieninfo;


-- 4 : trigger them sv, namsinh phai > 1900
drop trigger if exists trg_limit_namsinh;
create trigger trg_limit_namsinh
    before insert
    on sinhvien
    for each row
begin
    if new.namsinh <= 1900 then
        signal sqlstate '12345'
            set message_text = 'nam sinh phai lon hon 1900';
    end if;
end;

insert into sinhvien(namsinh)
values (1800);

-- 5 : xoa 1 sv -> xoa thong tin lien quan trong table huong dan;
/*
alter table huongdan
    add constraint foreign key fk_masinhvien (masv) references sinhvien (masv) on delete set null;
*/

create trigger trg_delete_sv
    before delete
    on sinhvien
    for each row
begin
    delete from huongdan where huongdan.masv = OLD.masv;
end;

# test trg_delete_sv
begin work;
select *
from huongdan;

delete
from sinhvien
where masv = 1;

select *
from huongdan;
rollback;