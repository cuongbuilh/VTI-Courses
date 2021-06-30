drop database if exists `Testing_System_Asignment_1`;
create database `Testing_System_Asignment_1`; 
use `testing_system_asignment_1`; 

drop table if exists `department`;
create table `department`(
		`department_id`			tinyint primary key auto_increment,
        `department_name`		varchar(50)
);

select * from departmnet;