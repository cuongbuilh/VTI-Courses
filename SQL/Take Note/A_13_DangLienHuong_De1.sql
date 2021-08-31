-- tao database
use master;
drop database if exists A_13_DangLienHuong_De1;
create database A_13_DangLienHuong_De1;
use A_13_DangLienHuong_De1;
-- tao table
drop table if exists KH;
create table KH
(
    makh      int identity primary key, -- identity để khóa tự động tăng, không cần insert khóa
    hotenkh   nvarchar(50)    not null,
    socccd    char(15) unique not null,
    dc_lienhe nvarchar(100),
    email     varchar(50)     not null unique
);

drop table if exists HH;
create table HH
(
    mahh             int identity primary key,
    tenhh            nvarchar(50) not null,
    giatri           bigint,
    sotienlan1       bigint,
    sotiencaclantiep bigint,
    makh             int references KH (makh)
);

drop table if exists PT;
create table PT
(
    sopt      int identity primary key,
    mahh      int references hh (mahh),
    makh      int references kh (makh),
    ngaythang date,
    sotientra bigint,
    loaipt    binary,
    ghichu    nvarchar(200)
);

/*
    đầu tiên xóa các database nếu đã tồn tại,sau đó tạo databse
    tạo bảng KH, lưu ý để makh có identity để khóa tăng tự động không cần insert
    tương tự với khóa của 2 bảng còn lại

    câu 2 -
        khai báo biến để kiểm tra nếu thỏa mãn 2 điều kiện thì ste biến = 1 còn lại 0;
        nếu biến khác 1 thì in ra thông báo, còn lại thì insert

    câu 3 -
        tạo view có trường makh,tekh,tổng số tiền
        với tổng số tiền = tổng các giá trị

    câu 4 -
        kiểm tra biến đầu vào
        nếu  =1 thì đếm số phiếu thu của từng người
        nếu =2 thì tính tổng số tiền trả

    câu 5 -
        tạo trigger sau khi insert vào bảng Hàng hóa
        trigger cài số tiền các lần sau = giá trị - lần 1 của hàng hóa mới thêm

*/




-- insert data
insert into KH(hotenkh, socccd, dc_lienhe, email)
values ('dang lien huong', '121212121', 'ha noi', 'dlh@gmail.com'),
       ('dang thi huong', '23232323', 'ha tinh', 'dth@gmail.com'),
       ('nguen thi huong', '12434343', 'nghe an', 'nth@gmail.com'),
       ('nguyen hoan huong', '2343242', 'ho chi minh', 'nhh@gmail.com'),
       ('dang ba huong', '16786721', 'ha nam', 'dbh@gmail.com');

insert into hh(tenhh, giatri, makh)
values ('sua rua mat', 100000, 1),
       ('kem chong nang', 200000, 1),
       ('duong am', 250000, 2),
       ('duong da', 150000, 2),
       ('duong mat', 120000, 3);

insert into pt(mahh, makh, ngaythang, sotientra, loaipt)
values (1, 1, '2020-04-04', 100000, 0),
       (2, 1, '2020-04-05', 100000, 1),
       (2, 2, '2020-04-04', 200000, 0);

-- cau 2
go
drop proc if exists sp_add_pt;
go;

go
create proc sp_add_pt @mahh int, @makh int, @ngaythang date, @sotientra bigint, @loaipt binary, @ghichu nvarchar(200)
as
begin
    declare @can_insert int;
    set @can_insert = 0;
    if exists(select * from hh where mahh = @mahh) -- kiem tra co hang hoa khong
        if exists(select * from kh where makh = @makh) -- kiemer tra co khach hang khong
            set @can_insert = 1; -- neu co thi co the insert

    if (@can_insert <> 1) -- th khong the insert
        print 'cannot insert'
    else
        insert into PT(mahh, makh, ngaythang, sotientra, loaipt, ghichu)
        values (@mahh, @mahh, @ngaythang, @sotientra, @loaipt, @ghichu);
end;
go;

exec sp_add_pt 12, 12, '2020-12-12', 0, 1, '';
exec sp_add_pt 1, 1, '2020-12-02', 0, 1, '';


-- cau 3
go
create or alter view v_bill(makh, tenkh, sotien)
as
select kh.makh, hotenkh, sum(giatri)
from hh,
     kh
where hh.makh = kh.makh
group by kh.makh, hotenkh;
go;

select *
from v_bill;

-- cau 4
go
create proc sp_stats @option int
as
begin
    if (@option = 1)
        select kh.makh, hotenkh, count(distinct sopt)
        from pt,
             kh
        where kh.makh = pt.makh
        group by kh.makh, hotenkh;
    else
        if (@option = 2)
            select hh.mahh, tenhh, sum(sotientra)
            from pt,
                 hh
            where pt.makh = hh.mahh
              and loaipt = 1
            group by hh.mahh, tenhh;
end;
go;

exec sp_stats 1;
exec sp_stats 2;


-- cau 5
drop trigger if exists trg_cau5;

go
create trigger trg_cau5
    on hh
    after insert as
begin
    update hh
    set sotiencaclantiep = hh.giatri - HH.sotienlan1
    from inserted
    where inserted.mahh = hh.mahh
      and inserted.makh = hh.makh;
end;
go;

select *
from hh;
insert into hh(tenhh,makh,giatri,sotienlan1)
values ('new',1,10000,1000);
select *
from hh;