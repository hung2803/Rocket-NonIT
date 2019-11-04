-- Ex1 Tạo table với các ràng buộc và kiểu dữ liệu 
-- thêm ít nhất 3 bản ghi vào mỗi table trên 

DROP DATABASE IF EXISTS ProjectsManager;
CREATE DATABASE IF NOT EXISTS 		ProjectsManager;
USE Projectsmanager;

DROP TABLE IF EXISTS 	Employee;
CREATE TABLE		 Employee (
		EmployeeID				TINYINT AUTO_INCREMENT PRIMARY KEY,
        EmployeeLastName		NVARCHAR(20) NOT NULL,
        EmployeeFistName		NVARCHAR(10) NOT NULL,
        EmployeeHireDate		DATE NOT NULL,
        EmployeeStatus			VARCHAR(20),
        SupervisorID			TINYINT NOT NULL,
        SocialSecurityNumber	INT NOT NULL
);

DROP TABLE IF EXISTS 	Projects;
CREATE TABLE  		Projects (
		ProjectID 					CHAR(10) PRIMARY KEY,
        EmployeeID					TINYINT NOT NULL,
        Projectname					NVARCHAR(30) NOT NULL,
        ProjectStartDate			DATE NOT NULL,
        ProjectDescription			VARCHAR(50) NOT NULL,
        ProjectDetailt				VARCHAR(30) NOT NULL,
        ProjectCompletedOn			DATE NOT NULL,
		FOREIGN KEY ( EmployeeID) REFERENCES  Employee(EmployeeID)
        );
        
DROP TABLE IF EXISTS 	Project_Modules;
CREATE TABLE 		Project_Modules (
			ModuleID 						CHAR(20) PRIMARY KEY,
            ProjectID 						CHAR(10) NOT NULL,
			EmployeeID						TINYINT NOT NULL,
			ProjectModulesDate				DATE NOT NULL,
            ProjectModulesCompledOn			DATE NOT NULL,
            ProjectModulesDescription		VARCHAR(500),
		FOREIGN KEY ( EmployeeID) REFERENCES  Employee(EmployeeID),
		FOREIGN KEY ( ProjectID) REFERENCES  Projects( ProjectID)
        ON DELETE CASCADE 
);

DROP TABLE IF EXISTS	Work_Done;
CREATE TABLE		Work_Done (
			WorkDoneID				TINYINT AUTO_INCREMENT PRIMARY KEY,
            EmployeeID				TINYINT NOT NULL,
            ModuleID				CHAR(20) NOT NULL,
            WorkDoneDate			DATE ,
            WorkDoneDescription		VARCHAR(50),
            WorkDoneStatus			VARCHAR(50),
			FOREIGN KEY ( EmployeeID) REFERENCES  Employee(EmployeeID),
            FOREIGN KEY ( ModuleID) REFERENCES  Project_Modules(ModuleID) ON DELETE CASCADE
);

INSERT INTO   Employee (EmployeeLastName,  EmployeeFistName,  EmployeeHireDate, EmployeeStatus,  SupervisorID, SocialSecurityNumber)
VALUES					('nguyễn văn ',		'hung',			  '1999-02-04',		'đã nghỉ'	,			1,			12341),
						('phạm văn',		'nhân',			  '2000-04-01',		'đang làm việc',		1,			22345),
						('trần thị',		'trang',		  '1998-02-14',		'đang làm việc',		2,			14425),
						('trần thị',		'nhung',		  '1998-05-20',		'đang nghỉ',			3,			13132),
						('trần văn',		'thành',		  '1998-07-19',		'đang làm việc',		2,			16525);
						
INSERT INTO   Projects(ProjectID, EmployeeID, Projectname,  ProjectStartDate, ProjectDescription, ProjectDetailt, ProjectCompletedOn )
VALUES				( 'DA1', 		1,			'JAVA',		'2000-04-01',		'mô tả 1',			'chi tiết 1',		'2019-08-03'),	
					( 'DA2', 		3,			'MYSQL',	'1999-02-05',		'mô tả 2',			'chi tiết 2',		'1999-05-05'),	
					( 'DA3', 		2,			'ANDROID',	'2000-08-03',		'mô tả 3',			'chi tiết 3',		'2000-12-09'),	
					( 'DA4', 		5,			'HUGO',		'2000-07-19',		'mô tả 4',			'chi tiết 4',		'2020-01-19'),	
					( 'DA5', 		4,			'FACEBOOK',	'2000-03-02',		'mô tả 5',			'chi tiết 5',		'2002-03-20');
        
INSERT INTO		Project_Modules(	ModuleID ,ProjectID,   EmployeeID,	ProjectModulesDate,  ProjectModulesCompledOn,  ProjectModulesDescription)
VALUES							(	'MD1',		'DA2',			3,			'2001-04-06',			'2002-04-07',			'ProjectModulesDescription 1'),
                                (	'MD3',		'DA1',			1,			'2003-01-02',			'2019-12-02',			'ProjectModulesDescription 2'),
                                (	'MD2',		'DA3',			2,			'2002-09-01',			'2002-01-06',			'ProjectModulesDescription 3'),
                                (	'MD4',		'DA5',			2,			'2002-03-15',			'2002-02-17',			'ProjectModulesDescription 4'),
                                (	'MD5',		'DA4',			4,			'2002-04-02',			'2022-04-12',			'ProjectModulesDescription 5');
                                

INSERT INTO   		Work_Done(EmployeeID,  ModuleID, WorkDoneDate, WorkDoneDescription, WorkDoneStatus)                     	
VALUES   						( 3,		'MD1',		'2010-01-01',	 'design 1', 	'hoan thanh 50% xong design'),
								( 2,		'MD2',			null,		 'design 2',	'hoan thanh 70% xong design'),
								( 1,		'MD3',		'2010-08-02',	 'design 3',	'hoan thanh 100% xong design'),
								( 4,		'MD1',		'2010-08-02',	 'design 5',	'hoan thanh 80% xong design'),
								( 5,		'MD5',			null,		 'design 4',	'hoan thanh 60% xong design');

-- EX 2 Viết stored procedure (không có parameter) 
-- để Remove tất cả thông tin project đã hoàn thành sau 3 tháng kể từ ngày hiện tại. 
-- In số lượng record đã remove từ các table liên quan trong khi removing (dùng lệnh print)
USE projectsmanager;
DROP PROCEDURE IF EXISTS get_Projects;
DELIMITER $$
CREATE PROCEDURE get_Projects()
BEGIN 
		-- B1: tìm ra các ProjectID cần xóa   
			-- khai báo 1 biến để lưu lại kết quả ProjectID cần xóa
            DROP TABLE IF EXISTS 	ProjectIDCanXoa;
			CREATE TEMPORARY TABLE 	ProjectIDCanXoa (
											ProjectID CHAR(10)
			); 
            -- gán data vào biến 
			INSERT INTO ProjectIDCanXoa (ProjectID)
				SELECT  ProjectID
				FROM 	Projects
				WHERE 	SUBDATE(CURDATE(), INTERVAL 90 DAY) > ProjectCompletedOn;
        -- B2: tìm các moduleID cần xóa
			-- khai báo 1 biến để lưu lại kết quả ProjectID cần xóa
				DROP TABLE IF EXISTS 		ModuleIDCanXoa;
				CREATE TEMPORARY TABLE		ModuleIDCanXoa (
														ModuleID CHAR(20)
				); 
						-- gán data vào biến                                         
				INSERT INTO 		ModuleIDCanXoa (ModuleID)
					SELECT 	  		ModuleID
					FROM			Project_Modules
					WHERE 			ProjectID IN (	SELECT	ProjectID 
													FROM 	ProjectIDCanXoa
													);
        -- START TRANSACTION
        START TRANSACTION;
			-- B3: xóa workdone dựa vào workdoneID
			DELETE 
			FROM  	Work_Done
			WHERE 	ModuleID IN (	SELECT 	ModuleID 
									FROM 	ModuleIDCanXoa
									); 
			
			-- B4: xóa Project_Modules dựa vào ModuleID
			DELETE   
			FROM 	 	Project_Modules
			WHERE		ModuleID IN (	SELECT 	ModuleID
										FROM 	ModuleIDCanXoa
									) ;
								
			-- B5: xóa project dựa vào ProjectID
			DELETE   
			FROM 	 	Projects
			WHERE 		ProjectID IN (	SELECT 	ProjectID
										FROM 	ProjectIDCanXoa
										);
		-- END TRANSACTION
        COMMIT;
END $$
DELIMITER ;
CALL get_Projects;


-- EX 3 Viết stored procedure (có parameter) để in ra các module đang được thực hiện)
DROP PROCEDURE IF EXISTS get_module;
DELIMITER $$
CREATE PROCEDURE get_module()
BEGIN
			SELECT 	ModuleID
            FROM 	Project_Modules 
            WHERE  ProjectModulesCompledOn > CURDATE();
			
		END$$
DELIMITER ;
CALL  get_module();
-- EX4 Viết hàm (có parameter) trả về thông tin 1 nhân viên đã tham gia làm mặc dù không ai giao việc cho nhân viên đó (trong bảng Works) 

DROP FUNCTION IF EXISTS get_employee;
DELIMITER $$
CREATE FUNCTION get_employee()  RETURNS TINYINT
BEGIN
		DECLARE 			out_EmployeeID TINYINT(20);
        
		SELECT 				W.EmployeeID  INTO out_EmployeeID
        FROM				Project_Modules PM
        RIGHT JOIN			Work_Done W ON (PM.EmployeeID = W.EmployeeID)
        WHERE				PM.EmployeeID IS NULL;
        
        RETURN out_EmployeeID;
	END$$
DELIMITER ;
SELECT 	get_employee();

