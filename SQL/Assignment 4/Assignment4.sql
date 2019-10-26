
CREATE DATABASE IF NOT EXISTS nhanvien;
USE nhanvien;
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu 
CREATE TABLE 		Department 
(
		Department_Number  		TINYINT AUTO_INCREMENT PRIMARY KEY ,
		Department_Name			NVARCHAR(30) NOT NULL 
);

CREATE TABLE  Employee_Table
 (
		Employee_Number			SMALLINT AUTO_INCREMENT PRIMARY KEY ,
        Employee_Name 			NVARCHAR(30) NOT NULL,
        Department_Number		TINYINT NOT NULL,
        FOREIGN KEY (Department_Number) REFERENCES Department(Department_Number)
	);
    
CREATE TABLE   Employee_Skill_Table 
(
		Employee_Number		SMALLINT AUTO_INCREMENT PRIMARY KEY, 
		Skill_Code			CHAR(10) NOT NULL, 
		Date_Registered		DATE NOT NULL
    ); 
    

-- Question 2: Thêm ít nhất 10 bản ghi vào table 
INSERT INTO		Department 
			( 	Department_Name)
VALUES 	
			(  	'GH1'	),
			(  	'GH2'	),
			(  	'GH3'	),
			(  	'GH4'	),
			(  	'GH5'	),
			(  	'GH6'	),
			(  	'GH7'	),
			(  	'GH8'	),
			(  	'GH9'	),
			(  	'GH10'	);
			
INSERT INTO		Employee_Table 
			(Employee_Name,		Department_Number)
VALUES 	
			( 'nguyễn văn abc',			1		),
			( 'vũ văn bắc', 			2		),
			( 'vũ văn hung', 			1		),
			( 'vũ thị linh', 			4		),
			( 'trần thi trang', 		1		),
			( 'vũ thi duyên', 			1		),
			( 'nguyễn văn nam', 		4		),
			( 'vũ thi phương2', 		10		),
			( 'vũ thi phương4', 		10		),
			( 'vũ thi phương5', 		10		);
            
INSERT INTO		Employee_Skill_Table 
			(	Skill_Code, 		Date_Registered)
VALUES 	
			( 		'JAVA',					'1996-01-04'	),
			( 		'AHK',					'1998-09-09'	),
			( 		'JAVA',					'2000-01-05'	),
			( 		'ABC',					'1999-05-08'	),
			( 		'DHC',					'1999-02-06'	),
			( 		'JAVA',					'1999-04-02'	),
			( 		'ABC',					'1999-03-03'	),
			( 		'DHC',					'1999-05-06'	),
			( 		'ABC',					'1999-06-03'	),
			( 		'DHC',					'1999-03-05'	);
		
-- Question 3: Viết lệnh để lấy ra danh sách nhân viên (name) có skill Java    

SELECT 			et.Employee_Number,	et.Employee_Name,	es.Skill_Code
FROM 			Employee_Table et
JOIN			Employee_Skill_Table es ON et.Employee_Number=es.Employee_Number
WHERE 			es.Skill_Code='JAVA';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên

SELECT		e.Department_Number,	d.Department_Name, COUNT(*) AS soluong
FROM 		department d
JOIN 		employee_table e ON e.Department_Number = d.Department_Number
GROUP BY	e.Department_Number
HAVING		COUNT(*) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách nhân viên của mỗi văn phòng ban.   
SELECT 			e.Employee_Number,		e.Employee_Name,		 d.Department_Name ,COUNT(*) AS soluong
FROM			Department d	
JOIN			Employee_Table e ON( d.Department_Number = e.Department_Number)
GROUP BY 		d.Department_Name;

-- Question 6: Viết lệnh để lấy ra danh sách nhân viên có > 1 skills.    
			
SELECT 			et.Employee_Number,		et.Employee_Name,	es.Skill_Code, COUNT(es.Employee_Number) AS dsnhavien
FROM 			Employee_Table et
JOIN			Employee_Skill_Table es ON et.Employee_Number=es.Employee_Number
GROUP BY		es.Employee_Number
HAVING			dsnhavien>1;