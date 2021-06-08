CREATE DATABASE IF NOT EXISTS DB_2_1;
USE DB_2_1;

CREATE TABLE IF NOT EXISTS Trainee (
    TraineeID 			INT PRIMARY KEY AUTO_INCREMENT,
    Full_Name 			VARCHAR(50) NOT NULL,
    Birth_Date		 	DATE,
    Gender 				ENUM('male', 'female', 'unknown'),
    ET_IQ 				TINYINT CHECK (0 <= ET_IQ 		AND ET_IQ <= 20),
    ET_Gmath 			TINYINT CHECK (0 <= ET_Gmath 	AND ET_Gmath <= 20),
    ET_English 			TINYINT CHECK (0 <= ET_English 	AND ET_English <= 50),
    Training_Class 		INT,
    Evalution_Notes 	TEXT,
    VTI_Acount 			INT UNIQUE NOT NULL
);

TRUNCATE TRAINEE;
INSERT INTO Trainee (	Full_Name,			Birth_Date,		Gender,		ET_IQ,	ET_Gmath,	ET_English,	Training_Class, VTI_Acount)
VALUE				(	'bui van cuong 0',	'2021-02-12',	'female',	1,		2,			3,			1,				0	),
					(	'bui van cuong 1',	'2021-02-12',	'female',	10,		10,			17,			1,				1	),
					(	'bui van cuong 2',	'2021-02-12',	'female',	10,		10,			20,			1,				2	),
                    (	'bui van cuong 3',	'2021-03-12',	'female',	10,		10,			22,			1,				3	),
                    (	'bui van cuong 4',	'2021-03-12',	'female',	2,		8,			14,			1,				4	),
                    (	'bui van cuong 5',	'2021-03-12',	'female',	10,		10,			6,			1,				5	),
                    (	'bui van cuong 6',	'2021-04-12',	'female',	10,		10,			20,			1,				6	),
                    (	'bui van cuong 7',	'2021-04-12',	'female',	10,		10,			45,			1,				7	),
                    (	'bui van cuong 8',	'2021-04-12',	'female',	10,		10,			32,			1,				8	),
                    (	'bui van cuong 9',	'2021-04-12',	'female',	10,		10,			17,			1,				9	);

SELECT *	
FROM TRAINEE
GROUP BY 	MONTH(Birth_Date);

SELECT * 	
FROM TRAINEE
WHERE LENGTH(FULL_NAME) > ALL(SELECT FULL_NAME FROM TRAINEE);

SELECT *
FROM TRAINEE
WHERE	ET_IQ + ET_GMATH 	>= 20
	AND 		ET_IQ	 	>= 8
    AND			ET_GMATH 	>= 8
    AND			ET_ENGLISH	>= 18;
 
DELETE FROM TRAINEE
WHERE TRAINEEID = 3;

UPDATE TRAINEE
SET		TRAINING_CLASS 	= 2
WHERE	TRAINEEID 		= 3;