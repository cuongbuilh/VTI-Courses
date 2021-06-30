DROP DATABASE IF EXISTS DB_2_1;
CREATE DATABASE DB_2_1;
USE DB_2_1;

CREATE TABLE Trainee (
    TraineeID 			INT PRIMARY KEY AUTO_INCREMENT,
    Full_Name 			VARCHAR(50) NOT NULL,
    Birth_Date		 	DATE,
    Gender 				ENUM('male', 'female', 'unknown'),
    ET_IQ 				TINYINT CHECK (0 <= ET_IQ AND ET_IQ <= 20),
    ET_Gmath 			TINYINT CHECK (0 <= ET_Gmath AND ET_Gmath <= 20),
    ET_English 			TINYINT CHECK (0 <= ET_English AND ET_English <= 50),
    Training_Class 		INT,
    Evalution_Notes 	TEXT
);

ALTER TABLE Trainee ADD COLUMN VTI_Acount INT UNIQUE NOT NULL;


-- EXCERCISE 2
CREATE TABLE EX2(
	ID  				INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Name`				VARCHAR(50) NOT NULL,
    `Code`				CHAR(5),
    ModificationDate 	DATE DEFAULT(curdate()) 
);

-- EXCERCISE 3
CREATE TABLE EX3(
	ID					INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
    `Name`				VARCHAR(50),
    Bird_Date			DATE,
    Gender				ENUM('Make','Female','NULL'),
    IsSelectedFlag		BIT
)