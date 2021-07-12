show databases;
use classicmodels;

select c.customerName as csm
from customers c;

create or replace view v_name as
select *
from customers;

create temporary table tmp_name as
select *
from customers;
select *
from tmp_name;

with cte as (
    select *
    from customers
)
select *
from cte;

-- query

select o.orderNumber, orderDate, priceEach
from orderdetails o
         join orders o2 on o.orderNumber = o2.orderNumber;

select p.productCode, orderNumber
from products p
         left join orderdetails o on p.productCode = o.productCode
where orderNumber is null;


-- sp  - func
delimiter //
create procedure sp_tong(in a int, in b int)
begin
    select (a + b) as tong;
end;
//
delimiter ;

call sp_tong(1, 2);

--
create procedure sp_tong2(in a int, in b int, out c int)
begin
    set c = a + b;
end;


call sp_tong2(1, 2, @c);
select @c;
set @c = null;

--
SET GLOBAL log_bin_trust_function_creators = 1;


create function f_tong(a int, b int) returns int
begin
    return (a + b);
end;

select f_tong(1, 2) as tong;

--
create trigger trg_1
    after insert
    on customers
    for each row
begin
    if NEW.customerNumber = 10000 then
        signal sqlstate '12345'
            set message_text = 'cannot insert';
    end if;
end;

insert into customers(customerNumber, customerName, contactLastName, contactFirstName, phone, addressLine1, city,
                      country)
values (10000, '', '', '', '', '', '', '');


--
set @a = 0;
select case  when @a=1 then 'la so 1' else 'khong phai 1' end;


select if(@a=1,'day la 1','khong phai 1');


--
drop procedure if exists sp_tong_n;
create procedure sp_tong_n(in n int)
begin
    declare iter int;
    declare tong int default 0;
    set iter = 0;


    loop_1 : loop
        if iter > n then
            leave loop_1;
        end if;

        set tong = tong + iter;
        set iter = iter + 1;

    end loop;

    select tong;
end;

call sp_tong_n(3);

-- cursor
drop procedure sp_tong_payment;
create procedure sp_tong_payment()
begin
    declare tong decimal(20,2) default (0);
    declare done int default (false);

    declare  cus_num int;
    declare check_num varchar(50);
    declare _amount decimal(10,2);

    declare cur cursor for select customerNumber,checkNumber,amount from payments;
    declare continue handler for not found set done = true;

    open cur;
    loop_1:loop
        fetch cur into cus_num,check_num,_amount;
        set tong = tong+_amount;

        if done then
            leave loop_1;
        end if;
    end loop;
    close cur;

    select tong;
end;

call sp_tong_payment();