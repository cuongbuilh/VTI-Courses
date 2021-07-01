use Testing_System_Asignment_1;

-- ## ex1
-- q1
select *
from Account
         inner join Department D on Account.DepartmentID = D.DepartmentID;

-- q2
select *
from Account
where CreateDate > '2010-12-20';

-- q3
select *
from Account
         inner join Position P on Account.PositionID = P.PositionID
where PositionName = 'Developer';

-- q4
select D.DepartmentID, D.DepartmentName, count(AccountID) as 'số nhân viên'
from Department D
         inner join Account A on D.DepartmentID = A.DepartmentID
group by D.DepartmentID
having count(AccountID) > 3;

-- q5
-- tao bang tam
drop temporary table if exists tmp_table;
create temporary table tmp_table
select Q.QuestionID,
       count(ExamID) as numOfUse
from Question Q
         inner join ExamQuestion E
                    on Q.QuestionID = E.QuestionID
group by QuestionID;
-- tim so lan max
set @maxNumOfUse = (select max(numOfUse)
                    from tmp_table);
-- show
select *
from tmp_table
where numOfUse = @maxNumOfUse;
-- xoa
drop temporary table tmp_table;
set @maxNumOfUse = null;

-- q6
select C.CategoryID, CategoryName, count(QuestionID)
from CategoryQuestion C
         left outer join Question Q on C.CategoryID = Q.CategoryID
group by C.CategoryID;

-- q7
select Q.QuestionID, Content, count(ExamID) as 'so lan xuat hien'
from Question Q
         left join ExamQuestion EQ on Q.QuestionID = EQ.QuestionID
group by Q.QuestionID;

-- q8
drop temporary table if exists QuestionUsed;
create temporary table QuestionUsed
select Q.QuestionID, count(AnswerID) as num
from Question Q
         left join Answer A on Q.QuestionID = A.QuestionID
group by Q.QuestionID;
set @maxNumOfUse = (select max(num)
                    from QuestionUsed);
select *
from QuestionUsed
where num = @maxNumOfUse;
drop temporary table QuestionUsed;
set @maxNumOfUse = null;


-- q9
select G.GroupID, GroupName, count(AccountID) as 'so thanh vien'
from `Group` G
         left join GroupAccount GA on G.GroupID = GA.GroupID
group by G.GroupID;


-- q10
drop temporary table if exists temp_table;
create temporary table temp_table
select P.PositionID, PositionName, count(AccountID) as numOfMember
from Position P
         left join Account A on P.PositionID = A.PositionID
group by P.PositionID;
set @minNum = (select min(numOfMember)
               from temp_table);
select *
from temp_table
where numOfMember = @minNum;
drop temporary table temp_table;
set @minNum = null;

-- q11
select D.DepartmentID, PositionName, count(AccountID) as 'so luong'
from Department D
         left join Account A on D.DepartmentID = A.DepartmentID
         left join Position P on A.PositionID = P.PositionID
where PositionName in ('dev', 'test', 'scrum master', 'pm')
group by A.DepartmentID, PositionName;

-- q12
select Q.QuestionID,
       Q.Content,
       CategoryName,
       TypeName,
       FullName  as 'nguoi tao',
       Q.CreateDate,
       A.Content as 'cau tra loi'
from Question Q
         join Answer A on Q.QuestionID = A.QuestionID
         join CategoryQuestion CQ on Q.CategoryID = CQ.CategoryID
         join TypeQuestion TQ on Q.TypeID = TQ.TypeID
         join Account A2 on Q.CreatorID = A2.AccountID
where isCorrect = true;

-- q13
select TQ.TypeID, TypeName, count(QuestionID)
from TypeQuestion TQ
         left join Question Q on TQ.TypeID = Q.TypeID
where TypeName in ('tự luận', 'trắc nghiệm')
group by TQ.TypeID;

-- q14 15
select G.GroupID, GroupName, count(AccountID) as 'so luong'
from `Group` G
         left join GroupAccount GA on G.GroupID = GA.GroupID
where G.GroupID not in (select G1.GroupID
                        from `Group` G1
                                 join GroupAccount A on G1.GroupID = A.GroupID)
group by G.GroupID;

-- q16
select *
from Question
where QuestionID not in (select QuestionID from Answer);


-- ex2
-- q17
select A.AccountID, FullName
from Account A
         inner join GroupAccount GA on A.AccountID = GA.AccountID
where GroupID = 1
union
select A.AccountID, FullName
from Account A
         inner join GroupAccount GA on A.AccountID = GA.AccountID
where GroupID = 2;

-- q18
select G.GroupID, GroupName, count(AccountID) as 'so luong'
from `Group` G
         join GroupAccount GA on G.GroupID = GA.GroupID
group by G.GroupID
having count(AccountID) > 5
union
select G.GroupID, GroupName, count(AccountID) as 'so luong'
from `Group` G
         join GroupAccount GA on G.GroupID = GA.GroupID
group by G.GroupID
having count(AccountID) < 7;

