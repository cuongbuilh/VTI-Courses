use Testing_System;
# trigger
-- q1
drop trigger if exists trg_group_time_limit;
create trigger trg_group_time_limit
    before insert
    on `Group`
    for each row
begin
    if timestampdiff(year, NEW.CreateDate, curdate()) > 1 then
        signal sqlstate '12345' -- disallow insert this recort
            set message_text = 'createDate must less than 1 year before now';
    end if;
end;

insert into `Group`(CreateDate)
values ('2009-12-12');

-- q2
drop trigger if exists trg_not_allow_sale;
create trigger trg_not_allow_sale
    before insert
    on Account
    for each row
begin
    declare insert_department_name varchar(50);

    if ((select DepartmentName
         from Department
         where DepartmentId = NEW.DepartmentId) like '%Sale%')
    then
        signal sqlstate '12346'
            set message_text = 'department Sale cannot add more user';
    end if;
end;
insert into Account(UserName, DepartmentId)
values ('asdasd', 2);


-- q3
drop trigger if exists trg_limit_group_user;
create trigger trg_limit_group_user
    before insert
    on GroupAccount
    for each row
begin
    declare curr_num int;

    select count(AccountID)
    into curr_num
    from GroupAccount
    where GroupID = NEW.GroupID;

    if (curr_num = 5) then
        signal sqlstate '12347'
            set message_text = 'group has most 5 user';
    end if;

end;

-- q4
drop trigger if exists trg_limit_question;
create trigger trg_limit_question
    before insert
    on ExamQuestion
    for each row
begin
    declare curr_num int;

    select count(QuestionID)
    into curr_num
    from ExamQuestion
    where ExamID = new.ExamID;

    if (curr_num = 10) then
        signal sqlstate '12349'
            set message_text = 'An Exam has most 10 Questions';
    end if;

end;

-- q5
drop trigger if exists trg_denied_delete_admin;
create trigger trg_denied_delete_admin
    before delete
    on Account
    for each row
begin

    if (OLD.Email = 'admin@gnail.com') then
        signal sqlstate '12349'
            set message_text = 'cannot delete admin user';
    end if;

    delete from GroupAccount where GroupAccount.AccountID = OLD.AccountId;

end;

-- q6
drop trigger if exists trg_defautl_department;
create trigger trg_default_department
    before insert
    on Account
    for each row
begin
    if (NEW.DepartmentId is null) then
        set NEW.DepartmentId = (select DepartmentId
                                from Department
                                where DepartmentName = 'waiting Department'
                                limit 1);
    end if;

end;

-- q7
drop trigger if exists trg_limit_answer_per_question;
create trigger trg_limit_answer_per_question
    before insert
    on Answer
    for each row
begin

    declare num_of_answer int default (0);
    declare num_of_true_ans int default (0);
    declare done int default false;
    declare cur_question_id int;
    declare cur_answer_id int;
    declare cur_is_correct int;

    declare cur cursor for select distinct Q.QuestionID, AnswerID, isCorrect
                           from Question Q
                                    join Answer A on Q.QuestionID = A.QuestionID;

    declare continue handler for not found set done = true;

    open cur;
    ans_loop :
    loop
        fetch cur into cur_question_id,cur_answer_id,cur_is_correct;
        if (cur_question_id = new.QuestionID) then
            set num_of_answer = num_of_answer + 1;

            if (cur_is_correct = true) then
                set num_of_true_ans = num_of_true_ans + 1;
            end if;
        end if;

        if (num_of_answer >= 4 or num_of_true_ans >= 2) then
            signal sqlstate '13456'
                set message_text = 'insert will be limited';
        end if;
    end loop;

end;

-- q8
alter table Account
    add column Gender nvarchar(12);
drop trigger if exists trg_reset_gender;
create trigger trg_reset_gender
    before insert
    on Account
    for each row
begin
    if (NEW.Gender = 'nam') then
        set new.Gender = 'M';
    end if;

    if (NEW.Gender = 'nữ') then
        set new.Gender = 'F';
    end if;

    if (NEW.Gender = 'không xác định') then
        set new.Gender = 'U';
    end if;
end;

-- q9
drop trigger if exists trg_limit_time_for_delete;
create trigger trg_limit_time_for_delete
    before delete
    on Exam
    for each row
begin
    if (timestampdiff(day, OLD.CreateDate, curdate()) <= 2) then
        signal sqlstate '13457'
            set message_text = 'cannot delete exam before 2 days';
    end if;
end;

-- q10
create trigger trg_cau10
    before delete
    on Question
    for each row
begin
    declare canEdit int default true;

    set canEdit = not exists(select *
                             from ExamQuestion
                             where QuestionID = OLD.QuestionID);

    if (not canEdit) then
        signal sqlstate '13458'
        set message_text = 'cannot edit';
    end if;

end;
# case...when...
-- q11--none
-- q12
select ExamID,
       Code,
       Title,
       Duration,
       if(Duration <= 30, 'Short time',
          if(Duration <= 60, 'Medium time',
             if(Duration > 60, 'Long time', null))) as kind_of_exam
from Exam;

-- q13
select G.GroupID,
       GroupName,
       count(AccountID)                                  as numOfUser,
       if(count(AccountID) <= 5, 'few',
          if(count(AccountID) <= 20, 'normal',
             if(count(AccountID) > 20, 'higher', null))) as the_number_user_amount
from `Group` G
         left join GroupAccount GA on G.GroupID = GA.GroupID
group by G.GroupID;


-- q14
select D.DepartmentID,
       DepartmentName,
       case count(AccountId)
           when 0 then 'không có User'
           else count(AccountId)
           end as num_of_user
from Department D
         left join Account A
                   on D.DepartmentID = A.DepartmentId
group by D.DepartmentID;


