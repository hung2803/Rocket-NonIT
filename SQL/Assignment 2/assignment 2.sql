-- EX1
DROP DATABASE IF EXISTS fresher;
CREATE DATABASE IF NOT EXISTS fresher;

DROP TABLE IF EXISTS Trainee;
CREATE TABLE Trainee (
    TraineeID		 		SMALLINT PRIMARY KEY AUTO_INCREMENT,
    Full_name		 		NVARCHAR(50) NOT NULL,
    Birth_date		 		DATE NOT NULL,
    Gender 		 			ENUM('male', 'famale', 'unknown') NOT NULL,
    ET_IQ 			 		TINYINT(20) NOT NULL,
    ET_Gmath 		 		TINYINT(20) NOT NULL,
    ET_English		 		TINYINT(50) NOT NULL,
    Training_Class	 		CHAR(10) NOT NULL,
    Evaluation_Notes 		NVARCHAR(500)
);

ALTER TABLE Trainee
ADD VTI_Account VARCHAR(50) NOT NULL UNIQUE;


-- Ex2
DROP TABLE IF EXISTS Student;
CREATE TABLE Student
(
	ID					 INT PRIMARY KEY AUTO_INCREMENT,
    `Name`				 VARCHAR(50) NOT NULL,
    `Code`				 CHAR(5) NOT NULL,
    ModifiedDate 		 DATETIME NOT NULL
);



-- EX3
DROP TABLE IF EXISTS Teacher;
CREATE TABLE Teacher
(
	ID 					INT PRIMARY KEY AUTO_INCREMENT,
    `Name`				VARCHAR(50) NOT NULL,
    BirthDate			DATE NOT NULL,
    Gender			 	ENUM('0', '1'),
    IsDeletedFlag		ENUM ('0','1')
);
