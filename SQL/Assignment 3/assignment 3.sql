-- Question 1: Thêm ít nhất 10 bản ghi vào table 
USE fresher;
INSERT INTO Trainee
(Full_name, 		Birth_date,			Gender,		ET_IQ,		ET_Gmath,	ET_English,		Training_Class,	Evaluation_Notes,VTI_Account)
VALUES
('nguyễn văn A',	'2000-03-01',		'male',		10,			15,			25,				'01',			'',				'A@VTI.COM.VN'),
('nguyễn văn B',	'1999-01-05',		'male',		9,			20,			15,				'03',			'',				'BC@VTI.COM.VN'),
('nguyễn thị C',	'2000-04-07',		'female',	15,			13,			24,				'04',			null,			'CH@VTI.COM.VN'),
('nguyễn thị H',	'2000-03-07',		'female',	11,			12,			27,				'05',			null,			'HS@VTI.COM.VN'),
('nguyễn văn R',	'2000-05-29',		'male',		16,			15,			24,				'02',	 		null,			'RG@VTI.COM.VN'),
('nguyễn văn G',	'2000-04-20',		'male',		17,			8,			35,				'05',	 		null,			'GH@VTI.COM.VN'),
('nguyễn văn T',	'2000-05-25',		'male',		14,			10,			40,				'04',	 		null,			'TA@VTI.COM.VN'),
('nguyễn văn K',	'2000-06-08',		'female',	12,			17,			39,				'03',	 		null,			'KJ@VTI.COM.VN'),
('nguyễn văn L',	'2000-07-16',		'male',		11,			15,			20,				'01',	 		null,			'LT@VTI.COM.VN'),
('nguyễn văn B',	'2000-05-09',		'male',		15,			14,			35,				'06',	 		null,			'BA@VTI.COM.VN'),
('nguyễn văn S',	'2000-01-07',		'female',	17,			9,			26,				'05',	 		null,			'SK12@VTI.COM.VN');


-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau 
SELECT  		Month(Birth_date), COUNT(TraineeID)
FROM 			trainee
GROUP BY 		Month(Birth_date);


-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau: 
-- 	ET_IQ + ET_Gmath>=20  ET_IQ>=8  ET_Gmath>=8  ET_English>=18


SELECT 		*
FROM 		Trainee
WHERE	 	ET_IQ + ET_Gmath>=20 AND ET_IQ>=8 AND ET_Gmath>=8 AND ET_English>=18;

-- Question 5: xóa thực tập sinh có TraineeID = 3 
COMMIT;

DELETE 
FROM		Trainee 
WHERE		TraineeID = '3';

-- Question 6 : Thực tập sinh có TraineeID = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database 

UPDATE 		trainee 
SET 		Training_Class = '02'
WHERE 		TraineeID = '5';
