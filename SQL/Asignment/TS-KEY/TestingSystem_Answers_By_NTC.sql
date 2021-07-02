/* Create database `TestingSystem` */
DROP DATABASE IF EXISTS `Testing_System`;
CREATE DATABASE IF NOT EXISTS `Testing_System`;
-- forcus database use
USE `Testing_System`;

/* Create table */

# CREATE TABLE Phòng Ban
DROP TABLE IF EXISTS `Department`;
CREATE TABLE IF NOT EXISTS `Department`
(
    `DepartmentID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `DepartmentName` VARCHAR(50) NOT NULL
);

# CREATE TABLE Chức vụ
DROP TABLE IF EXISTS `Position`;
CREATE TABLE IF NOT EXISTS `Position`
(
    `PositionID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `PositionName` ENUM ('Dev 1', 'Dev 2', 'Tester', 'PM', 'Mentor', 'Scrum Master', 'Giám đốc', 'Thư ký', 'Developer')
);

# CREATE TABLE Tài khoản
DROP TABLE IF EXISTS `Account`;
CREATE TABLE IF NOT EXISTS `Account`
(
    `AccountId`    TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Email`        VARCHAR(50) UNIQUE KEY,
    `UserName`     VARCHAR(50) NOT NULL UNIQUE KEY,
    `FullName`     VARCHAR(50),
    `DepartmentId` TINYINT,
    `PositionID`   TINYINT,
    `CreateDate`   DATETIME DEFAULT NOW()
#     CONSTRAINT pk PRIMARY KEY (AccountId)
);

# CREATE TABLE Nhóm
DROP TABLE IF EXISTS `Group`;
CREATE TABLE IF NOT EXISTS `Group`
(
    `GroupID`    TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `GroupName`  VARCHAR(50),
    `CreatorID`  TINYINT UNSIGNED,
    `CreateDate` DATETIME DEFAULT NOW()
);

# CREATE TABLE Nhóm Tài Khoản
DROP TABLE IF EXISTS `GroupAccount`;
CREATE TABLE IF NOT EXISTS `GroupAccount`
(
    `GroupID`   TINYINT UNSIGNED,
    `AccountID` TINYINT UNSIGNED,
    `JoinDate`  DATETIME DEFAULT NOW()
);

# CREATE TABLE Loại câu hỏi
DROP TABLE IF EXISTS `TypeQuestion`;
CREATE TABLE IF NOT EXISTS `TypeQuestion`
(
    `TypeID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `TypeName` VARCHAR(50)
);

# CREATE TABLE loại câu hỏi
DROP TABLE IF EXISTS `CategoryQuestion`;
CREATE TABLE IF NOT EXISTS `CategoryQuestion`
(
    `CategoryID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `CategoryName` VARCHAR(50) NOT NULL UNIQUE KEY
);

# CREATE TABLE Câu hỏi
DROP TABLE IF EXISTS `Question`;
CREATE TABLE IF NOT EXISTS `Question`
(
    `QuestionID` TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Content`    VARCHAR(100),
    `CategoryID` TINYINT UNSIGNED,
    `TypeID`     TINYINT UNSIGNED,
    `CreatorID`  TINYINT UNSIGNED NOT NULL,
    `CreateDate` DATETIME DEFAULT NOW()
);

# CREATE TABLE Câu trả lời
DROP TABLE IF EXISTS `Answer`;
CREATE TABLE IF NOT EXISTS `Answer`
(
    `AnswerID`   TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Content`    VARCHAR(100),
    `QuestionID` TINYINT UNSIGNED NOT NULL,
    `isCorrect`  BIT,
    CONSTRAINT fk_question FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

# CREATE TABLE Đề thi
DROP TABLE IF EXISTS `Exam`;
CREATE TABLE IF NOT EXISTS `Exam`
(
    `ExamID`     TINYINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Code`       VARCHAR(50) UNIQUE,
    `Title`      VARCHAR(50),
    `CategoryID` TINYINT UNSIGNED,
    `Duration`   TINYINT,
    `CreatorID`  TINYINT UNSIGNED,
    `CreateDate` DATETIME DEFAULT NOW()
#     ,CONSTRAINT fk_create_id FOREIGN KEY (CategoryID) REFERENCES Account (AccountId),
#     CONSTRAINT fk_category_id FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID)
);

# CREATE TABLE Bộ câu hỏi
DROP TABLE IF EXISTS `ExamQuestion`;
CREATE TABLE IF NOT EXISTS `ExamQuestion`
(
    `ExamID`     TINYINT,
    `QuestionID` TINYINT
);


/*---------------- INSERT DATA ------------------*/
######Insert data bảng `Department`
# cách 1 điền đầy đủ cả thông tin
# cách này dễ bị lỗi [1062] nếu `DepartmentId` insert đã tồn tại trong bảng vì đây là khóa chính ko được trùng lập
INSERT INTO Department(DepartmentID, DepartmentName)
VALUES (1, 'Phòng marketing');

#Cách 2 chỉ điền tên phòng ban, để ID tự tăng
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Sale');
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Dev 1');
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Dev 2');

#Cách 3 insert nhiều data cùng 1 lúc
INSERT INTO Department(DepartmentName)
VALUES ('Phòng Bảo vệ'),
       ('Phòng Nhân sự'),
       ('Phòng Giám Đốc'),
       ('Phòng Kỹ thuật'),
       ('Phòng Thư ký'),
       ('Phòng Tạp vụ'),
       ('Phòng Phó Giám Đốc');

##### INSERT data bảng `position`
#Giá trị `PositionName` chỉ nhận các giá trị được gắn trong Enum vì đây là kiểu tự định nghĩa.
#`PositionName` ENUM ('Dev 1', 'Dev 2', 'Tester', 'PM', 'Mentor', 'Scrum Master', 'Giám đốc', 'Thư ký')
# ALTER TABLE `Position` CHANGE COLUMN `PositionName` `PositionName` ENUM ('Dev 1', 'Dev 2', 'Tester', 'PM', 'Mentor', 'Scrum Master', 'Giám đốc', 'Thư ký', 'Developer');

INSERT INTO `Position`(PositionName)
VALUES ('Dev 1'),
       ('Dev 2'),
       ('Giám đốc'),
       ('Tester'),
       ('PM'),
       ('Mentor'),
       ('Developer'),
       ('Scrum Master');

##### INSERT DATA bảng `Account`
DELETE
FROM `Account`;
INSERT INTO `Account`(Email, UserName, FullName, DepartmentId, PositionID, CreateDate)
VALUES ('email_vti1@gmail.com', 'acountvti1', 'Nguyễn Văn A', 4, 1, NOW()),
       ('email_vti2@gmail.com', 'acountvti2', 'Trinh Hoai Lam', 2, 1, '2021-02-26'),
       ('email_vti3@gmail.com', 'acountvti3', 'Nguyễn Thu Hoai', 4, 2, '2021-01-01'),
       ('email4@gmail.com', 'acountvti4', 'Trương Văn Bình', 2, 5, '2021-06-30'),
       ('email_vti5@gmail.com', 'acountvti5', 'Dương Chi Tai', 3, 3, '2021-01-01'),
       ('email6@gmail.com', 'acountvti6', 'Nguyễn Thế Hải', 9, 3, '2021-01-02'),
       ('email7@gmail.com', 'acountvti7', 'Dương Chí Dũng', 7, 1, NOW()),
       ('email8@gmail.com', 'acountvti8', 'Cao Hữu Đạt', 4, 2, NOW()),
       ('email9@gmail.com', 'acountvti9', 'Nguyễn văn B', 4, 4, '2021-05-01'),
       ('email10@gmail.com', 'acountvti10', 'Mai Anh Tài', 3, 5, '2021-06-06');
INSERT INTO `Account` (Email, UserName, FullName, DepartmentId, PositionID, CreateDate)
VALUES ('email11@gmail.com', 'acountvti11', 'Dao Van Bo', 1, 2, '2021-05-05');

INSERT INTO `Group` (GroupName, CreatorID, CreateDate)
VALUES ('Testing System', 1, '2019-03-05'),
       ('Development', 9, '2020-03-07'),
       ('VTI Sale 01', 2, '2020-03-09'),
       ('VTI Sale 02', 9, '2020-03-10'),
       ('VTI Development', 3, '2021-01-10'),
       ('VTI Sale 05', 1, '2021-03-10'),
       ('VTI Sale 03', 9, '2020-03-28'),
       ('VTI Creator', 6, '2020-04-06'),
       ('VTI Marketing 01', 5, '2020-04-07'),
       ('Management', 5, '2020-04-08'),
       ('Chat with love', 1, '2020-04-09'),
       ('Vi Ti Ai', 10, '2020-04-10');

/* DELETE FROM GroupAccount; */
INSERT INTO `GroupAccount` (GroupID, AccountID, JoinDate)
VALUES (1, 1, '2019-03-05'),
       (1, 2, '2020-03-07'),
       (1, 10, '2020-03-07'),
       (1, 8, '2020-03-07'),
       (3, 3, '2020-03-09'),
       (3, 4, '2020-03-10'),
       (5, 5, '2020-03-28'),
       (1, 3, '2020-04-06'),
       (1, 9, NOW()),
       (8, 3, NOW()),
       (1, 7, '2020-04-09'),
       (10, 10, '2020-04-10');

INSERT INTO TypeQuestion (TypeName)
VALUES ('Essay'),
       ('Multiple-Choice');

INSERT INTO CategoryQuestion (CategoryName)
VALUES ('Java'),
       ('ASP.NET'),
       ('ADO.NET'),
       ('SQL'),
       ('Postman'),
       ('Ruby'),
       ('Python'),
       ('C++'),
       ('C Sharp'),
       ('PHP');

INSERT INTO Question (Content, CategoryID, TypeID, CreatorID, CreateDate)
VALUES (N'Câu hỏi về Java', 1, '1', '2', '2020-04-05'),
       (N'Câu Hỏi về PHP', 10, '2', '2', '2020-04-05'),
       (N'Hỏi về C#', 9, '2', '3', '2020-04-06'),
       (N'Hỏi về Ruby', 6, '1', '4', '2020-04-06'),
       (N'Hỏi về Postman', 5, '1', '5', '2020-04-06'),
       (N'Hỏi về ADO.NET', 3, '2', '6', '2020-04-06'),
       (N'Hỏi về ASP.NET', 2, '1', '7', '2020-04-06'),
       (N'Hỏi về C++', 8, '1', '8', '2020-04-07'),
       (N'Hỏi về SQL', 4, '2', '9', '2020-04-07'),
       (N'Hỏi về Python', 7, '1', '10', '2020-04-07');
/* DELETE FROM Answer; */
INSERT INTO Answer (Content, QuestionID, isCorrect)
VALUES (N'Trả lời 01', 1, 0),
       (N'Trả lời 02', 1, 1),
       (N'Trả lời 03', 1, 0),
       (N'Trả lời 04', 1, 1),
       (N'Trả lời 05', 2, 1),
       (N'Trả lời 06', 3, 1),
       (N'Trả lời 07', 4, 0),
       (N'Trả lời 08', 8, 0),
       (N'Trả lời 09', 9, 1),
       ('Trả lời 10', 10, 1),
       ('Trả lời 11', 2, 0),
       ('Trả lời 12', 2, 0),
       ('Trả lời 13', 2, 1),
       ('Trả lời 14', 3, 1),
       ('Trả lời 15', 3, 1);

INSERT INTO Exam (`Code`, Title, CategoryID, Duration, CreatorID, CreateDate)
VALUES ('VTIQ001', N'Đề thi C#', 1, 60, '5', '2019-04-05'),
       ('VTIQ002', N'Đề thi PHP', 10, 60, '2', '2019-04-05'),
       ('VTIQ003', N'Đề thi C++', 9, 120, '2', '2019-04-07'),
       ('VTIQ004', N'Đề thi Java', 6, 60, '3', '2020-04-08'),
       ('VTIQ005', N'Đề thi Ruby', 5, 120, '4', '2020-04-10'),
       ('VTIQ006', N'Đề thi Postman', 3, 60, '6', '2020-04-05'),
       ('VTIQ007', N'Đề thi SQL', 2, 60, '7', '2020-04-05'),
       ('VTIQ008', N'Đề thi Python', 8, 60, '8', '2020-04-07'),
       ('VTIQ009', N'Đề thi ADO.NET', 4, 90, '9', '2020-04-07'),
       ('VTIQ010', N'Đề thi ASP.NET', 7, 90, '10', '2020-04-08');


INSERT INTO ExamQuestion(ExamID, QuestionID)
VALUES (1, 5),
       (2, 10),
       (3, 4),
       (4, 3),
       (5, 7),
       (6, 10),
       (7, 2),
       (8, 10),
       (9, 9),
       (10, 8);

/*----------------TestingSystem_3_Answer-----------------*/
/* Question 2 : lấy ra tất cả các phòng ban*/
# Cách 1
SELECT *
FROM Department;
# Cách 2
SELECT DepartmentID, DepartmentName
FROM Department;

/* Question 3: lấy ra id của phòng ban "Sale" */
#Cách 1
SELECT DepartmentID
FROM Department
WHERE DepartmentName = 'Phòng Sale';
#Cách 2
SELECT DepartmentID
FROM Department
WHERE DepartmentName LIKE '%sale%';
#Cách 3
SELECT DepartmentID
FROM Department
WHERE DepartmentName IN ('Phòng Sale');

/* Question 4: lấy ra thông tin account có full name dài nhất */
#Cách 1:
SELECT *
FROM `Account`
WHERE CHARACTER_LENGTH(FullName) =
      (SELECT MAX(CHARACTER_LENGTH(FullName)) FROM `Account`);
#Cách 2:
SELECT *
FROM `Account`
WHERE CHARACTER_LENGTH(FullName) =
      (SELECT CHARACTER_LENGTH(FullName) FROM `Account` ORDER BY CHARACTER_LENGTH(FullName) DESC LIMIT 1);
/* Show tất cả các tên trong bảng `Account` ra kiểm tra */
SELECT FullName, CHARACTER_LENGTH(FullName) AS 'Do dai ten'
FROM `Account`
ORDER BY `Do dai ten` DESC;

/*Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3 */
/*Show tất cả các tên trong bảng `Account` thuộc phòng ban có id = 3 ra để kiểm tra*/
SELECT `FullName`, `DepartmentId`, CHARACTER_LENGTH(`FullName`) AS 'Do dai ten'
FROM `Account`
WHERE `DepartmentId` = 3
ORDER BY `Do dai ten` DESC;
#Cách 1:
SELECT *
FROM `Account`
WHERE CHARACTER_LENGTH(FullName) =
      (SELECT MAX(CHARACTER_LENGTH(FullName)) FROM `Account` WHERE `DepartmentId` = 3)
  AND `DepartmentId` = 3;
#Cách 2: Tự làm nhé các em tương tự ví dụ câu 4 :))

/* Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019 */
SELECT GroupName, DATE(CreateDate)
FROM `Group`
WHERE CreateDate <= '2019-12-20';

/* Question 7: Lấy ra ID của question có >= 4 câu trả lời */
SELECT QuestionID, COUNT(QuestionID) AS 'So cau tra loi'
FROM Answer
GROUP BY QuestionID
HAVING `So cau tra loi` >= 4;

/* Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019 */
SELECT `Code`, `Title`, `Duration`, DATE(`CreateDate`) AS 'Ngay Tao'
FROM Exam
WHERE Duration >= 60
  AND DATE(CreateDate) < '2019-12-20';

/* Question 9: Lấy ra 5 group được tạo gần đây nhất */
SELECT *
FROM `Group`
ORDER BY CreateDate DESC
LIMIT 5;

/* Question 10: Đếm số nhân viên thuộc department có id = 2 */
SELECT DepartmentId, COUNT(DepartmentId) AS `So nhan vien`
FROM `Account`
GROUP BY `DepartmentId`
HAVING `DepartmentId` = 2;
/* Đếm số nhân viên tất cả các phòng ban */
SELECT DepartmentId, COUNT(DepartmentId) AS `So nhan vien`
FROM `Account`
GROUP BY `DepartmentId`;

/* Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o" */
SELECT *
FROM Account
WHERE FullName LIKE 'D%o';

/* Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019 */
DELETE
FROM `Exam`
WHERE CreateDate < '2019-12-20';

/* Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi" */
DELETE
FROM `Question`
WHERE `Content` LIKE 'câu hỏi%';

/* Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn*/
UPDATE `Account`
SET `FullName` = 'Nguyễn Bá Lộc',
    `Email`    = 'loc.nguyenba@vti.com.vn'
WHERE `AccountId` = 5;
/* Kiểm tra thông tin question 14 */
SELECT *
FROM `Account`
WHERE AccountId = 5;

/* Question 15: update account có id = 5 sẽ thuộc group có id = 4 */
UPDATE `GroupAccount`
SET `GroupID` = 4
WHERE `AccountID` = 5;
/* Kiểm tra thông tin question 15 */
SELECT *
FROM `GroupAccount`
WHERE `AccountID` = 5;







