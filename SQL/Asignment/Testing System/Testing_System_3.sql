use Testing_System_Asignment_1;

-- insert data
insert into Department(DepartmentName)
values ('marketing'),
       ('sale'),
       ('bao ve'),
       ('nhan su'),
       ('ky thuat'),
       ('tai chinh'),
       ('giam doc'),
       ('pho giam doc'),
       ('pho giam doc 2'),
       ('thu ky');

insert into `Position`(PositionName)
values ('nhan vien'),
       ('giam doc'),
       ('bao ve'),
       ('thuc tap'),
       ('thuc tap 1'),
       ('thuc tap 2'),
       ('thuc tap 3'),
       ('thuc tap 4'),
       ('thuc tap 5'),
       ('pho giam doc');

insert into `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
values ('a@gmail.com', 'usera', 'nguyen van a', '1', '1', curdate()),
       ('b@gmail.com', 'userb', 'nguyen van b', '1', '1', curdate()),
       ('cc@gmail.com', 'userc', 'nguyen van cc', '1', '1', curdate()),
       ('d@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('d1@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('d2@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('d3@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('d4@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('d5@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('d6@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('d7@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('e@gmail.com', 'usere', 'nguyen van e', '1', '1', curdate());

insert into `Group`(GroupName, CreatorID, CreateDate)
values ('gr1', 1, curdate()),
       ('gr2', 2, curdate()),
       ('gr3', 1, curdate()),
       ('gr4', 3, curdate()),
       ('gr6', 3, curdate()),
       ('gr7', 3, curdate()),
       ('gr8', 3, curdate()),
       ('gr9', 3, curdate()),
       ('gr10', 3, curdate()),
       ('gr5', 4, curdate());

insert into GroupAccount(groupid, accountid, joindate)
values (1, 1, curdate()),
       (1, 2, curdate()),
       (1, 3, curdate()),
       (1, 4, curdate()),
       (1, 5, curdate()),
       (2, 1, curdate()),
       (2, 2, curdate()),
       (2, 3, curdate()),
       (2, 4, curdate()),
       (2, 5, curdate());

insert into TypeQuestion(TypeName)
values ('trac ngiem'),
       ('tu luan'),
       ('type 1'),
       ('type 2'),
       ('type 8'),
       ('type 7'),
       ('type 6'),
       ('type 5'),
       ('type 4'),
       ('type 9'),
       ('type 10'),
       ('type 3');

insert into CategoryQuestion(CategoryName)
values ('toan'),
       ('ly'),
       ('hoa'),
       ('van'),
       ('su'),
       ('su 2'),
       ('su 3'),
       ('su 4'),
       ('su'),
       ('su 6'),
       ('su 2'),
       ('su 7'),
       ('su 10'),
       ('dia');

insert into Question(Content, CategoryID, TypeID, CreatorID, CreateDate)
values ('cau 1', 1, 1, 1, curdate()),
       ('cau 2', 1, 1, 1, curdate()),
       ('cau 3', 1, 1, 1, curdate()),
       ('cau 4', 1, 1, 1, curdate()),
       ('cau 5', 1, 1, 1, curdate()),
       ('cau 6', 1, 1, 1, curdate()),
       ('cau 1', 2, 1, 1, curdate()),
       ('cau 2', 2, 1, 1, curdate()),
       ('cau 3', 2, 1, 1, curdate()),
       ('cau 4', 2, 1, 1, curdate()),
       ('cau 5', 2, 1, 1, curdate()),
       ('cau 6', 2, 1, 1, curdate());

insert into Answer(content, questionid, iscorrect)
values ('tl 1', 1, false),
       ('tl 2', 1, false),
       ('tl 3', 1, false),
       ('tl 4', 1, true),
       ('tl 1', 2, false),
       ('tl 2', 2, false),
       ('tl 3', 2, true),
       ('tl 4', 2, false),
       ('tl 1', 3, false),
       ('tl 2', 3, false),
       ('tl 3', 3, true),
       ('tl 4', 3, false);

insert into Exam(Code, Title, CategoryID, Duration, CreatorID, CreateDate)
values ('e01', 'bai exam 1', 1, now(), 1, curdate()),
       ('e02', 'bai exam 2', 1, now(), 1, curdate()),
       ('e03', 'bai exam 3', 1, now(), 1, curdate()),
       ('e04', 'bai exam 4', 1, now(), 1, curdate()),
       ('e05', 'bai exam 5', 1, now(), 1, curdate()),
       ('e011', 'bai exam 1', 1, now(), 1, curdate()),
       ('e021', 'bai exam 2', 1, now(), 1, curdate()),
       ('e031', 'bai exam 3', 1, now(), 1, curdate()),
       ('e041', 'bai exam 4', 1, now(), 1, curdate()),
       ('e051', 'bai exam 5', 1, now(), 1, curdate());

insert into ExamQuestion(ExamID, QuestionID)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5);

-- show all department
select *
from Department;

-- get id which has department's name is "Sale"
select DepartmentID
from Department
where DepartmentName = 'Sale';

-- get account info that having longest full name
select *
from Account
where character_length(FullName) = (select max(character_length(FullName)) from Account);


-- update data to do next question
update Account
set DepartmentID=3
where AccountID = 3;
-- Q5 get account info that having longest full name and departmentID = 3
select *
from Account
         inner join Department D on Account.DepartmentID = D.DepartmentID
where character_length(FullName) = (select max(character_length(FullName)) from Account)
  and D.DepartmentID = 3;

-- Q6 get group's name created before 20/12/2019
select GroupName
from `Group`
where CreateDate < '2019-12-20';

-- Q7 get question's id which having more than or equal 4 answer
select Q.QuestionID
from Question Q
         inner join Answer A on Q.QuestionID = A.QuestionID
group by QuestionID
having count(AnswerID) >= 4;

-- Q8 get  made thi co th thi >=60p va dc tao truoc 20/12/2019
-- reconfig
update Exam
set Duration = null;
alter table Exam
    drop column Duration;
alter table Exam
    add column Duration tinyint unsigned after CategoryID;
update Exam
set Exam.Duration=90;
-- q8 exam thoi gian >=60p and ngay tao truowc 20/12/2019
select *
from Exam
where Exam.Duration >= 60
  and CreateDate < '2019-12-20'

-- Q9 lay 5group tao gam nhat
select *
from `Group`
order by CreateDate desc
limit 5;


-- Q10 dem so nhan vien co departmentid=2
select count(AccountID)
from Account
where DepartmentID = 2;

-- Q11 lay nhan vien ten bat dau =D ket thuc =o
select *
from Account
where FullName like 'D%o';

-- Q12 xoa exam tao truoc 23/12/2019
delete
from Exam
where CreateDate < '2019-12-23';

-- Q13 xoas queation noi dung bat dau = cau hoi
delete
from Question
where Content like 'câu hỏi%';

-- Q14 update
update Account
set Email    = 'loc.nguyenba@vti.com.vn',
    FullName = N'Nguyễn Bá Lộc'
where AccountID = 5;

-- Q15
update GroupAccount set GroupID=4 where AccountID=5;
