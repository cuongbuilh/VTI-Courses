use Testing_System_Asignment_1;

/* add foreign key constraints
   - sometime do not need this constraint
   - this constraint make database more relative

alter table Account
    add constraint foreign key (DepartmentID) references Department (DepartmentID);

alter table
*/

insert into Department(DepartmentName)
values ('marketing'),
       ('sale'),
       ('bao ve'),
       ('nhan su'),
       ('ky thuat'),
       ('tai chinh'),
       ('giam doc'),
       ('pho giam doc'),
       ('thu ky');

insert into `Position`(PositionName)
values ('nhan vien'),
       ('giam doc'),
       ('bao ve'),
       ('thuc tap'),
       ('pho giam doc');

insert into `Account`(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
values ('a@gmail.com', 'usera', 'nguyen van a', '1', '1', curdate()),
       ('b@gmail.com', 'userb', 'nguyen van b', '1', '1', curdate()),
       ('cc@gmail.com', 'userc', 'nguyen van cc', '1', '1', curdate()),
       ('d@gmail.com', 'userd', 'nguyen van d', '1', '1', curdate()),
       ('e@gmail.com', 'usere', 'nguyen van e', '1', '1', curdate());

insert into `Group`(GroupName, CreatorID, CreateDate)
values ('gr1', 1, curdate()),
       ('gr2', 2, curdate()),
       ('gr3', 1, curdate()),
       ('gr4', 3, curdate()),
       ('gr5', 4, curdate());

insert into GroupAccount(groupid, accountid, joindate)
values (1, 1, curdate()),
       (1, 2, curdate()),
       (1, 3, curdate()),
       (1, 4, curdate()),
       (1, 5, curdate());

insert into TypeQuestion(TypeName)
values ('trac ngiem'),
       ('tu luan'),
       ('type 1'),
       ('type 2'),
       ('type 3');

insert into CategoryQuestion(CategoryName)
values ('toan'),
       ('ly'),
       ('hoa'),
       ('van'),
       ('su'),
       ('dia');

insert into Question(Content, CategoryID, TypeID, CreatorID, CreateDate)
values ('cau 1', 1, 1, 1, curdate()),
       ('cau 2', 1, 1, 1, curdate()),
       ('cau 3', 1, 1, 1, curdate()),
       ('cau 4', 1, 1, 1, curdate()),
       ('cau 5', 1, 1, 1, curdate()),
       ('cau 6', 1, 1, 1, curdate());

insert into Answer(content, questionid, iscorrect)
values ('tl 1', 1, false),
       ('tl 2', 1, false),
       ('tl 3', 1, false),
       ('tl 4', 1, true),
       ('tl 1', 2, false),
       ('tl 2', 2, false),
       ('tl 3', 2, true),
       ('tl 4', 2, false);

insert into Exam(Code, Title, CategoryID, Duration, CreatorID, CreateDate)
values ('e01', 'bai exam 1', 1, now(),1,curdate()),
       ('e02', 'bai exam 2', 1, now(),1,curdate()),
       ('e03', 'bai exam 3', 1, now(),1,curdate()),
       ('e04', 'bai exam 4', 1, now(),1,curdate()),
       ('e05', 'bai exam 5', 1, now(),1,curdate());

insert into ExamQuestion(ExamID, QuestionID)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5);