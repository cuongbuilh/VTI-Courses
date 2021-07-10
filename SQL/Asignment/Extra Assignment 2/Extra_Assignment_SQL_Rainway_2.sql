drop database if exists qlgh;
create database qlgh;
use qlgh;
--
create table loaimathang
(
    maloaimathang  char(10) primary key,
    tenloaimathang varchar(50)
);

create table khachhang
(
    makhachhang    char(10) primary key,
    makhuvuc       char(10),
    tenkhachhang   varchar(50),
    tencuahang     varchar(50),
    sodtkhachhang  char(15),
    diachiemail    varchar(32),
    diachinhanhang varchar(100)
);

create table dichvu
(
    madichvu char(10) primary key ,
    tendichvu varchar(50)
);

create table khoangthoigian(
    makhoangthoigian char(10) primary key ,
    mota varchar(50)
);

create table khuvuc(
    makhuvuc char(10) primary key ,
    tenkhuvuc varchar(50)
);

create table dang