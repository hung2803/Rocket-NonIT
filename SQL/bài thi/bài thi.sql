-- a) Tạo table với các ràng buộc và kiểu dữ liệu
-- Thêm ít nhất 3 bản ghi vào table
DROP DATABASE IF EXISTS quanlydiem;
CREATE DATABASE IF NOT EXISTS quanlydiem;
USE quanlydiem;
DROP TABLE IF EXISTS 	Student;
CREATE TABLE	Student ( 
		RN				SMALLINT AUTO_INCREMENT PRIMARY KEY,
        `Name`			NVARCHAR(20) NOT NULL,
        Age				TINYINT NOT NULL,
        Gender			ENUM('1','0') 
		);
        
DROP TABLE IF EXISTS 	`Subject`;
CREATE TABLE	`Subject` (
		sID				CHAR(10) PRIMARY KEY,
        `sName`			CHAR(10) NOT NULL
		);
        
DROP TABLE IF EXISTS 	StudentSubject;
CREATE TABLE	StudentSubject (
		RN				SMALLINT NOT NULL,
        sID				CHAR(10) NOT NULL,
        Mark			TINYINT NOT NULL,
        `Date`			DATE NOT NULL,
        FOREIGN KEY ( RN) REFERENCES  Student(RN),
        FOREIGN KEY ( sID) REFERENCES  `Subject`(sID)
		);
        
INSERT INTO   Student ( 	`Name`,			Age,		Gender)
VALUES					('nguyễn văn hung',	17,			'1'	),
						('phạm văn nhân',	18,			'1'	),
						('nguyễn văn tuấn',	17,			null),
						('trần thịtrang',	20,			'0');
                        
                        
INSERT INTO   `Subject` (	sID, 	`sName`		)
VALUES					(	'MH1',	'Văn'		),
						(	'MH2',	'Toán'		),
						(	'MH3',	'Hóa'		),
						(	'MH4',	'Anh'		);
                       
INSERT INTO   StudentSubject(RN,	 	sID,			Mark,		 `Date`	)
VALUES						(3,			'MH2',			7,				'2019-10-01'	),
							(1,			'MH1',			6,				'2019-08-04'	),
							(4,			'MH4',			8,				'2019-08-04'	),
							(2,			'MH1',			9,				'2019-09-17'	);
-- b) Viết lệnh để
   
    -- a. Lấy tất cả các môn học không có bất kì điểm nào
    SELECT 				`sName`,Mark
	FROM  				`Subject` s
	LEFT JOIN 			StudentSubject sb ON (s.sID = sb.sID)
    WHERE				sb.Mark IS NULL;
    -- b. Lấy danh sách các môn học có ít nhất 2 điểm
	SELECT	 		`sName`, COUNT(`sName`) AS tongsodiemmon
	FROM  			`Subject` s
	JOIN 			StudentSubject sb ON (s.sID = sb.sID)
	GROUP BY 		`sName` 
    HAVING			COUNT(`sName`) >= '2';
    
-- c) Tạo "StudentInfo" view có các thông tin về học sinh bao gồm:
-- RN,sID,Name, Age, Gender, sName, Mark, Date. Với cột Gender show
-- Male để thay thế cho 0, C thay thế cho 1 và Unknow thay thế cho null.
	
	DROP VIEW IF EXISTS  StudentInfo;
	CREATE VIEW 	StudentInfo AS
	SELECT	 s.RN,su.sID,s.`Name`,s.Age,su.sName, sb.Mark, sb.`Date`,
			CASE 
				WHEN 			s.Gender = 'O' THEN 'Male'
				WHEN 			s.Gender = '1' THEN 'Female'
				ELSE			 'Unknow'
				END AS 			Gender
	FROM		StudentSubject sb
    JOIN 		Student s ON (sb.RN = s.RN)
    JOIN		`Subject` su ON (sb.sID = su.sID);
    
    
                        