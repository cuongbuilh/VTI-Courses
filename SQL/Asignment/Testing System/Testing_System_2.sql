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

insert into Position(PositionName)
values ('nhan vien'),
       ('giam doc'),
       ('bao ve'),
       ('thuc tap'),
       ('pho giam doc');

insert into Account(Email, Username, FullName, DepartmentID, PositionID, CreateDate)
values ();

insert into `Group`(GroupName, CreatorID, CreateDate)
values ();

insert into GroupAccount(groupid, accountid, joindate)
values ();

insert into TypeQuestion(TypeName)
values ();

insert into CategoryQuestion(CategoryName)
values ();

insert into Question(Content, CategoryID, TypeID, CreatorID, CreateDate)
values ();

insert into Answer(content, questionid, iscorrect)
values ();

insert into Exam(Code, Title, CategoryID, Duration, CreatorID, CreateDate)
values ();

insert into ExamQuestion(ExamID, QuestionID)
values ();