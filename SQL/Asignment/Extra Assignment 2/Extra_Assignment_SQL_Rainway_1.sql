drop database if exists thuctap;
create database thuctap;
use thuctap;

create table khoa
(
    makhoa    char(10) primary key,
    tenkhoa   char(30),
    dienthoai char(10)
);

create table giangvien
(
    magv    int primary key,
    hotengv char(30),
    luong   decimal(5, 2),
    makhoa  char(10)
);

create table sinhvien
(
    masv    int primary key,
    hotensv char(30),
    makhoa  char(10),
    namsinh int,
    quequan char(30)
);

create table detai
(
    madt       char(10) primary key,
    tendt      char(30),
    kinhphi    int,
    noithuctap char(30)
);

create table huongdan
(
    masv   int,
    madt   char(10),
    magv   int,
    ketqua decimal(5, 2)
);

/* -------------- */
# 1
insert into khoa(makhoa, tenkhoa, dienthoai)
VALUES ('kh001', 'khoa thu 1', '1'),
       ('kh002', 'khoa thu 2', '2'),
       ('kh003', 'khoa thu 3', '3'),
       ('kh004', 'khoa thu 4', '4'),
       ('kh005', 'khoa thu 5', '5');

insert into giangvien(magv, hotengv, luong, makhoa)
values (1, 'gv 1', 10, 'kh001'),
       (2, 'gv 2', 10, 'kh001'),
       (3, 'gv 3', 10, 'kh001'),
       (4, 'gv 4', 12, 'kh002'),
       (5, 'gv 5', 12, 'kh002');

insert into sinhvien(masv, hotensv, makhoa, namsinh, quequan)
VALUES (1, 'sv 1', 'kh001', 2001, 'BG'),
       (2, 'sv 2', 'kh001', 2001, 'BG'),
       (3, 'sv 3', 'kh001', 2001, 'BG'),
       (4, 'sv 4', 'kh002', 2001, 'BG'),
       (5, 'sv 5', 'kh002', 2001, 'BG');

insert into detai(madt, tendt, kinhphi, noithuctap)
VALUES ('dt001', 'dt 1', 1000, 'bg'),
       ('dt002', 'dt 2', 1000, 'bg'),
       ('dt003', 'dt 3', 1000, 'bg'),
       ('dt004', 'dt 4', 1000, 'bg'),
       ('dt005', 'dt 5', 1000, 'bg');

insert into huongdan(masv, madt, magv, ketqua)
VALUES (1, 'dt001', 1, null),
       (2, 'dt002', 1, null),
       (3, 'dt003', 1, null),
       (4, 'dt004', 2, null),
       (5, 'dt005', 2, null);
# 2
select magv, hotengv, tenkhoa
from giangvien
         join khoa k on giangvien.makhoa = k.makhoa;

# 3
select magv, hotengv, tenkhoa
from giangvien g
         join khoa k on g.makhoa = k.makhoa
where tenkhoa in ('dia ly', 'qltn');

# 4
select count(masv) as 'so sinh vien'
from sinhvien
         join khoa k on sinhvien.makhoa = k.makhoa
where tenkhoa = 'cong nghe sinh hoc'
group by masv;

# 5
select masv, hotensv, tenkhoa
from sinhvien s
         join khoa k on s.makhoa = k.makhoa
where tenkhoa = 'toan';

# 6
select count(magv) as 'so giang vien'
from giangvien g
         join khoa k on g.makhoa = k.makhoa
where tenkhoa = 'cong nghe sinh hoc';

# 7
select sinhvien.masv, hotensv
from sinhvien
         left join huongdan h on sinhvien.masv = h.masv
where madt is null;

# 8
select k.makhoa, tenkhoa, count(magv) as 'sl giang vien'
from khoa k
         left join giangvien g on k.makhoa = g.makhoa
group by k.makhoa, tenkhoa;

# 9
select dienthoai
from sinhvien
         join khoa k on sinhvien.makhoa = k.makhoa
where hotensv = 'Le van son';

# 10
select d.madt, tendt
from giangvien g
         join huongdan h on g.magv = h.magv
         join detai d on h.madt = d.madt
where hotengv = 'Tran son';

# 11
select detai.madt, tendt
from detai
         left join huongdan h on detai.madt = h.madt
where magv is null;

# 12
select g.magv, hotengv, count(masv) as sllv
from giangvien g
         join huongdan h on g.magv = h.magv
         join khoa k on g.makhoa = k.makhoa
group by g.magv, hotengv
having sllv >= 3;

# 13
select *
from detai
where kinhphi >= (select max(kinhphi) from detai limit 1);

# 14
select h.madt, tendt, count(*) as slsv
from detai
         join huongdan h on detai.madt = h.madt
group by detai.madt, tendt
having slsv >= 2;

# 15
select masv, hotensv
from sinhvien s
         join khoa k on s.makhoa = k.makhoa
where tenkhoa in ('dialy', 'qltn');

# 16
select tenkhoa, count(*) as slsv
from khoa
         left join sinhvien s on khoa.makhoa = s.makhoa
group by khoa.makhoa, tenkhoa;

# 17
select s.*, noithuctap
from sinhvien s
         join huongdan h on s.masv = h.masv
         join detai d on h.madt = d.madt
where noithuctap like quequan;

# 18
select s.masv,hotensv,ketqua
from sinhvien s
         join huongdan h on s.masv = h.masv
where ketqua is null;

# 19
select s.masv,hotensv
from sinhvien s
         join huongdan h on s.masv = h.masv
where ketqua = 0;
