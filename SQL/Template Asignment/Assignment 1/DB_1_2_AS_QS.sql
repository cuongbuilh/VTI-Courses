DROP DATABASE IF EXISTS DB_1_2;
CREATE DATABASE DB_1_2;
USE DB_1_2;

CREATE TABLE Countries(
	Country_id			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Country_name 		VARCHAR(255) NOT NULL
);
CREATE TABLE Locations(
	Location_id			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `Name`				VARCHAR(255) NOT NULL,
    Country_id 			INT NOT NULL,
    Postal_Code 		VARCHAR(255),
    FOREIGN KEY	(Country_id)	REFERENCES Countries(Country_id)
);
CREATE TABLE Houses(
	House_id			INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    Adress				TEXT(1000) NOT NULL,
    Location_id 		INT NOT NULL,
    House_Number		VARCHAR(255),
    TimeBuiding 		DATE,
    FOREIGN KEY	(Location_id)	REFERENCES	Locations(Location_id)
);
CREATE TABLE Rooms(
	Room_id 			INT PRIMARY KEY NOT	NULL AUTO_INCREMENT,
    Room_color			VARCHAR(255),
    House_id			INT NOT NULL,
    FOREIGN KEY	(House_id)	REFERENCES	Houses(House_id)
);

ALTER TABLE Countries ADD COLUMN Number_Of_Provinces INT AFTER Country_id;
RENAME TABLE Rooms TO PersonalRoom;
ALTER TABLE Locations CHANGE `Name` Location_name VARCHAR(200) NOT NULL;

ALTER TABLE PersonalRoom MODIFY Room_Color CHAR(25);
ALTER TABLE PersonalRoom DROP COLUMN Room_Color;
DROP TABLE PersonalRoom;

