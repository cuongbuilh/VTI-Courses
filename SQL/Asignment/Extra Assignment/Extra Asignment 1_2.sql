drop database if exists `Extra_Asignment`;
create database `Extra_Asignment`;
use `Extra_Asignment`;

create table Trainee
(
    TraineeID       int unsigned auto_increment primary key,
    Full_Name       varchar(50),
    Bird_Date       Date,
    Gender          enum ('male','female','unknow'),
    ET_IQ           tinyint unsigned check ( 0 < ET_IQ and ET_IQ < 20 ),
    ET_English      tinyint unsigned check ( 0 < ET_English and ET_English < 50 ),
    Training_Class  int unsigned,
    Evaluation_Note text
);

alter table Trainee
    add column `VTI_Account` int not null unique;


-- ex2
create table


