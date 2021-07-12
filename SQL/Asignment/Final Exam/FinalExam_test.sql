# create database
drop database if exists thuctap;
create database thuctap;
use thuctap;
# create tables
drop table if exists country;
create table country
(
    country_id   int primary key auto_increment,
    country_name varchar(50) not null
);

drop table if exists location;
create table location
(
    location_id    int primary key auto_increment,
    street_address varchar(50),
    postal_code    varchar(20),
    country_id     int
    # constraint fk_countryid foreign key (country_id) references country(country_id)
);

drop table if exists employee;
create table employee
(
    employee_id int primary key auto_increment,
    full_name   varchar(50),
    email       varchar(32) unique,
    location_id int
    # constraint fk_locationid foreign key (location_id) references location(location_id) on delete set null
);

#
insert into country(country_name)
values ('viet nam'),
       ('italy'),
       ('china');

insert into location(street_address, postal_code, country_id)
values ('ha noi', '100000', 1),
       ('ho chi minh', '200000', 1),
       ('da nang', '120000', 1);

insert into employee(full_name, email, location_id)
values ('bui cuong', 'buicuong@gmail.com', 1),
       ('thu trang', 'thutrang@gmail.com', 2),
       ('van hoa', 'vanhoa@gmail.com', 1);
#
-- 2.a : nhan vien thuoc viet nam
select e.employee_id, e.full_name, e.email, c.country_name
from employee e
         join location l on e.location_id = l.location_id
         join country c on l.country_id = c.country_id
where country_name = 'viet nam';

-- 2.b : lay ten quoc gia co nhan vien co mail nn03@gmail.com
select c.country_name
from country c
         join location l on c.country_id = l.country_id
         join employee e on l.location_id = e.location_id
where email = 'nn03@gmai.com';

-- 2.c : thong ke moi country, moi location co bao nhieu employee dang hoat dong
select c.country_id, l.location_id, count(employee_id) as soluong
from country c
         left join location l on c.country_id = l.country_id
         left join employee e on l.location_id = e.location_id
group by c.country_id, l.location_id;

-- 3 : trigger on employee chi cho moi quoc gia co toi da 10 employee
drop trigger if exists trg_limit_employee;
create trigger trg_limit_employee
    before insert
    on employee
    for each row
begin
    declare num_of_user int default (0);
    select count(employee_id)
    into num_of_user
    from country c
             left join location l on c.country_id = l.country_id
             left join employee e on l.location_id = e.location_id
    where new.location_id = l.location_id
    group by c.country_id, l.location_id;

    if num_of_user >= 10 then
        signal sqlstate '12345'
            set message_text = 'so luong (employee/location) da dat toi da';
    end if;
end;

insert into employee(full_name,location_id)
values ('1',1),
       ('2',1),
       ('3',1),
       ('4',1),
       ('5',1),
       ('6',1),
       ('7',1),
       ('8',1),
       ('9',1),
       ('10',1);

-- 4 : cau hinh khi xoa location -> location cua employee = null;
/*  cach 1 su dung foreign key
 alter table employee drop constraint fk_locationid;
 alter table employee add constraint fk_locationid foreign key (location_id) references location(location_id) on delete set null;
*/
-- cach 2
drop trigger if exists trg_set_default_location;
create trigger trg_set_default_location
    before delete
    on location
    for each row
begin
    update employee set location_id = null where location_id = OLD.location_id;
end;

begin work ;
-- employee truoc khi xoa location
select * from employee;
delete from location where location_id =1;
-- employee sau khi xoa location
select * from employee;
rollback ;
