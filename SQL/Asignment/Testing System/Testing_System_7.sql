use Testing_System;
# trigger
-- q1
-- q2
-- q3
-- q4
-- q5
-- q7
-- q8
-- q9
-- q10

# case...when...
-- q11--none
-- q12
select ExamID,
       Code,
       Title,
       Duration,
       if(Duration <= 30, 'Short time',
          if(Duration <= 60, 'Medium time',
             if(Duration>60,'Long time',null))) as kind_of_exam
from Exam;

-- q13
select G.GroupID,
       GroupName,
       count(AccountID)                             as numOfUser,
       if(count(AccountID) <= 5, 'few',
          if(count(AccountID) <= 20, 'normal',
             if(count(AccountID)>20, 'higher', null))) as the_number_user_amount
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