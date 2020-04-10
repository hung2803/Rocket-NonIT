-- =============================================
-- Create database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS QuanLyDiem;
-- Create database
CREATE DATABASE IF NOT EXISTS QuanLyDiem;
USE QuanLyDiem;

-- Drop the table if it already exists
DROP TABLE IF EXISTS 	`User`;
CREATE TABLE	`User` (
		`ID`				SMALLINT AUTO_INCREMENT PRIMARY KEY,
		`Account`			CHAR(30) NOT NULL,
        `Password`			NVARCHAR(50) NOT NULL,
        `FullName`			NVARCHAR(50) NOT NULL,
        `Role`				CHAR(10) NOT NULL
);

-- Drop the table if it already exists
DROP TABLE IF EXISTS 	Student;
CREATE TABLE	Student ( 
		RN				SMALLINT AUTO_INCREMENT PRIMARY KEY,
        `Name`			NVARCHAR(50) NOT NULL,
        Age				TINYINT NOT NULL,
        Gender			BIT NOT NULL,
        `Password`		VARCHAR(50) NOT NULL,
        `BirthDate`		DATE
);

-- Drop the table if it already exists
DROP TABLE IF EXISTS 	`Subject`;
CREATE TABLE	`Subject` (
		ID				SMALLINT AUTO_INCREMENT PRIMARY KEY,
        `Name`			CHAR(50) NOT NULL
		);

-- Drop the table if it already exists
DROP TABLE IF EXISTS 	StudentSubject;
CREATE TABLE	StudentSubject (
		RN				SMALLINT NOT NULL,
        ID				SMALLINT NOT NULL,
        Mark			TINYINT NOT NULL,
        `Date`			DATE NOT NULL,
        FOREIGN KEY ( RN) REFERENCES  Student(RN) ON DELETE CASCADE,
        FOREIGN KEY ( ID) REFERENCES  `Subject`(ID)
		);
        
INSERT INTO   `User` ( 	`Account`,						`Password`,	 	`FullName`,				`Role`)
VALUES					('duy.nguyenngoc1@vti.com.vn',		'duynn',	'Nguyễn Ngọc Duy',		'Admin'),
						('hung.nguyenthanh@vti.com.vn',		'hungnt',	'Nguyễn Thành Hưng',	'Student'),
						('toan.nguyenanh@vti.com.vn',		'toanna',	'Nguyễn Anh Toàn',		'Teacher');
        
INSERT INTO   Student ( 	`Name`,			Age,		Gender,		`Password`,		`BirthDate`)
VALUES					('nguyá»…n vÄƒn hung',	17,			1,		'123456', 		'2019-10-01'),
						('pháº¡m vÄƒn nhÃ¢n',	18,			1,		'12345678',		'2019-10-02'),
						('nguyá»…n vÄƒn tuáº¥n',	17,			0,		'1234567890',	'2019-10-03'),
						('tráº§n thá»‹trang',	20,			0,		'123456a',		'2019-10-04');
                        
                        
INSERT INTO   `Subject` (	`Name`		)
VALUES					(	'VÄƒn'		),
						(	'ToÃ¡n'		),
						(	'HÃ³a'		),
						(	'Anh'		);
                       
INSERT INTO   StudentSubject(RN,	 	ID,			Mark,		 `Date`	)
VALUES						(3,			2,			7,				'2019-10-01'	),
							(1,			1,			6,				'2019-08-04'	),
							(4,			4,			8,				'2019-08-04'	),
							(2,			1,			9,				'2019-09-17'	);
                            
CREATE VIEW UserView AS 
	SELECT `Account`,	`FullName`,	`Role`
    FROM 	`User`;
    
DROP PROCEDURE IF EXISTS getUserById;
DELIMITER $$
CREATE PROCEDURE getUserById(
	IN `IN_ID` SMALLINT, 
    OUT `OUT_Account` CHAR(30), 
    OUT `OUT_FullName` NVARCHAR(50), 
    OUT `OUT_Role` CHAR(10))
BEGIN 
		SELECT `Account`, `FullName`, `Role` INTO `OUT_Account`, `OUT_FullName`, `OUT_Role`
		FROM 	`User`
        WHERE 	`ID` = IN_ID;
END $$
DELIMITER ;

-- call procedure
SET @v_Account = '';
SET @v_FullName = '';
SET @v_Role = '';
CALL getUserById(2, @v_Account, @v_FullName, @v_Role);
SELECT @v_Account, @v_FullName, @v_Role;

SELECT 1
FROM `User`
WHERE `Account`  IN ('duy.nguyenngoc1@vti.com.vn', 'hung.nguyenthanh@vti.com.vn')