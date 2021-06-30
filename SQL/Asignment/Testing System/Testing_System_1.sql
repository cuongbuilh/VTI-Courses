drop database if exists Testing_System_Asignment_1;
create database Testing_System_Asignment_1;
use Testing_System_Asignment_1;

create table Department
(
    DepartmentID   int unsigned auto_increment primary key,
    DepartmentName varchar(50)
);

create table Position
(
    PositionID   int unsigned auto_increment primary key,
    PositionName varchar(20)
);

create table Account
(
    AccountID    int unsigned auto_increment primary key,
    Email        char(32) not null unique,
    Username     char(32) not null unique,
    FullName     char(12),
    DepartmentID int unsigned,
    PositionID   int unsigned,
    CreateDate   date default (curdate())
);

create table `Group`
(
    GroupID    int unsigned auto_increment primary key,
    GroupName  varchar(50),
    CreatorID  int unsigned,
    CreateDate date default (curdate())
);

create table GroupAccount
(
    GroupID   int unsigned,
    AccountID int unsigned,
    JoinDate  date default (curdate())
);

create table TypeQuestion
(
    TypeID   tinyint unsigned auto_increment primary key,
    TypeName varchar(32)
);

create table CategoryQuestion
(
    CategoryID   tinyint unsigned auto_increment primary key,
    CategoryName varchar(32)
);

create table Question
(
    QuestionID int unsigned auto_increment primary key,
    Content    text not null,
    CategoryID int unsigned,
    TypeID     int unsigned,
    CreatorID  int unsigned,
    CreateDate date default (curdate())
);

create table Answer
(
    AnswerID   int unsigned auto_increment primary key,
    Content    text,
    QuestionID int unsigned,
    isCorrect  bool
);

create table Exam
(
    ExamID     int unsigned auto_increment primary key,
    Code       char(8),
    Title      varchar(50),
    CategoryID int unsigned,
    Duration   datetime,
    CreatorID  int unsigned,
    CreateDate date default (curdate())
);

create table ExamQuestion
(
    ExamID     int unsigned,
    QuestionID int unsigned
)