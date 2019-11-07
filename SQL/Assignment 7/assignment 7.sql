-- Ex 1: Tiếp tục với Database ở buổi 6 Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ 
-- (Project_Modules.ProjectModulesDate < Projects.ProjectStartDate, Project_Modules.ProjectModulesCompletedOn > Projects.ProjectCompletedOn )
USE `projectsmanager`;
DROP TRIGGER IF EXISTS ThongTinNguoiDung;
DELIMITER $$
CREATE TRIGGER ThongTinNguoiDung
BEFORE INSERT ON Project_Modules
FOR EACH ROW
BEGIN 	 
			DECLARE 	ngaybatdau, ngayhoanthanh DATE;
			SELECT 		p.ProjectStartDate, p.ProjectCompletedOn INTO ngaybatdau, ngayhoanthanh
            FROM 		Projects p
            WHERE  		NEW.ProjectID = p.ProjectID;
			
            IF NEW.ProjectModulesDate < ngaybatdau
			OR NEW.ProjectModulesCompledOn  > ngayhoanthanh	THEN 
			SIGNAL SQLSTATE '12345'
			SET MESSAGE_TEXT = 'khong update ';
			END IF; 
END $$
DELIMITER ;
INSERT INTO Project_Modules (ModuleID,	 ProjectID,		EmployeeID,		ProjectModulesDate,		ProjectModulesCompledOn,		ProjectModulesDescription)
VALUES	  					(	'MD7',		'DA5',			2,			'1999-03-15',			'2019-04-17',				'ProjectModulesDescription 6');



-- Trong database phần Assignment 3 
-- Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
-- ET_IQ + ET_Gmath>=20  ET_IQ>=8  ET_Gmath>=8  ET_English>=18 
DROP VIEW emp_Trainee;
CREATE VIEW emp_Trainee AS 
	SELECT	 Full_name, ET_IQ,ET_Gmath,ET_English 
	FROM		Trainee
    WHERE	 	ET_IQ + ET_Gmath>=20 AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18;




