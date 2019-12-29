-- =============================================
-- Create database
-- =============================================

-- Drop the database if it already exists
DROP DATABASE IF EXISTS StudentManagement;
-- Create database
CREATE DATABASE IF NOT EXISTS StudentManagement;
USE StudentManagement;

-- Drop the table if it already exists
DROP TABLE IF EXISTS 	`user`;
CREATE TABLE	`user` (
		ID				INT AUTO_INCREMENT PRIMARY KEY,
        FullName		VARCHAR(50) NOT NULL,
		Email			CHAR(40) NOT NULL,
        `Password`		NVARCHAR(20) NOT NULL,
        Age				CHAR(10) NOT NULL,
        PhoneNumber		CHAR(11) NOT NULL,
        Address			CHAR(50) NOT NULL,
        `Role`			CHAR(10) NOT NULL
);

INSERT INTO   `User` ( 	FullName,			Email,	 	 			`Password`,		Age,		PhoneNumber,		Address,		 `Role`)
VALUES				('Nguyen Văn Tuấn',		'Tuannv@gmail.com',		'tuannv', 		25,			0335583759,			'Nam Định',		'Admin'	),
					('Nguyen Văn Chung',	'Chungnv@gmail.com',	'chungnv', 		16,			0335553654,			'Hải Phòng',	'Student'),
					('Nguyen Thị Trang',	'Trangnt@gmail.com',	'trangnt', 		17,			0335582342,			'Hà Nội',		'Student'),
					('Nguyen Thế Hoàn',		'Hoannt@gmail.com',		'hoannt', 		16,			0335588678,			'Tp HCM',		'Student');
					
        

                        
                        
