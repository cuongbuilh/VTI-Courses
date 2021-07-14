-- create database
drop database if exists quanlydiem;
create database quanlydiem;
use quanlydiem;
-- create tables
drop table if exists student;
create table student
(
    id     int unsigned primary key auto_increment,
    name   varchar(50) not null,
    age    tinyint unsigned,
    gender bit
);

drop table if exists `subject`;
create table `subject`
(
    id   smallint unsigned primary key auto_increment,
    name varchar(50) not null
);

drop table if exists studentsubject;
create table studentsubject
(
    studentID int unsigned,
    subjectID smallint unsigned,
    mark      float,
    `date`    date,
    constraint pk primary key (subjectID, studentID)
);
#alter table studentsubject add constraint fk_studentID foreign key (studentID) references student(id) on delete set null ;
#alter table studentsubject add constraint fk_subjectID foreign key (subjectID) references subject(id) on delete set null ;

-- insert data
insert into student(name, age, gender)
values ('cuong', 20, 1),
       ('trung', 20, 1),
       ('kien', 20, null),
       ('hoa', 20, 0),
       ('hong', 20, 0);

insert into `subject` (name)
values ('toan'),
       ('ly'),
       ('hoa'),
       ('anh');

insert into studentsubject (studentID, subjectID, mark, date)
values (1, 1, 10, curdate()),
       (2, 1, 9, curdate()),
       (3, 1, 6, curdate()),
       (1, 2, 4, curdate()),
       (2, 3, 5.5, curdate()),
       (1, 3, 7, curdate());

-- cau 2,a lay mon hoc khong co bat ki diem nao
select id, name
from `subject`
where id not in ( -- = [(tat ca) - (mon da co diem)]  // diem=null -> chua co diem
    select s.id
    from `subject` s
             left join studentsubject ss on s.id = ss.subjectID
    where ss.mark is not null
);

-- cau 2,b danh sach cac mon hoc co it nhat 2 diem
select s.id, s.name
from `subject` s
         join studentsubject ss on s.id = ss.subjectID
where mark is not null
group by s.id, s.name
having count(studentID) >= 2;

-- cau 3 tao view
create or replace view studentinfo
            (studentID, subjectID, student_name, student_age, student_gender, subject_name, mark,
             date)
as
select st.id,
       sj.id,
       st.name,
       st.age,
       case st.gender when 1 then 'Female' when 0 then 'Male' else 'Unknow' end,
       sj.name,
       ss.mark,
       ss.date
from student st
         join studentsubject ss on st.id = ss.studentID
         join subject sj on ss.subjectID = sj.id;

select *
from studentinfo;

-- cau 4,a trigger subject for update
drop trigger if exists SublectUpdateID;
create trigger SubjectUpdateID
    before update
    on subject
    for each row
begin
    update studentsubject set subjectID = NEW.id where subjectID = OLD.id;
end;
# test trigger
begin work;
select *
from studentsubject;
update subject
set id = 10
where id = 1;
select *
from studentsubject;
rollback;

-- cau 4,b trigger student for delete
drop trigger if exists StudentDeleteID;
create trigger StudentDeleteID
    before delete
    on student
    for each row
begin
    delete from studentsubject where studentID = OLD.id;
end;
# test trigger
begin work;
select *
from studentsubject;

delete
from student
where id = 1;

select *
from studentsubject;
rollback;

-- cau 5 viet sp_(st_name, ) xoa thong tin sv;
drop procedure if exists deleteStudentName;
create procedure deleteStudentName(in student_name varchar(50))
begin
    if (student_name = '*') then
        delete from studentsubject;
        delete from student;
    else
        delete
        from studentsubject sj
        where sj.studentID in (select id from student where name = student_name); -- id trong danh sach id co ten bi xoa

        delete from student where name = student_name;
    end if;
end;
# test
begin work;
-- case 1
call deleteStudentName('cuong');
select *
from student;
select *
from studentsubject;
-- case 2
call deleteStudentName('*');
select *
from student;
select *
from studentsubject;
rollback;