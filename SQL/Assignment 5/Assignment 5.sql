-- Exercise 1: Subquery 
-- Question 1: Viết 1 query lấy thông tin "Name" từ bảng Production.Product có name của ProductSubcategory là 'Saddles'. 

SELECT 		p.Name
FROM		Product p
JOIN		ProductSubcategory ps ON p.ProductSubcategoryID = ps.ProductSubcategoryID
WHERE		ps.name = 'Saddles';

-- c2
SELECT		p.Name
FROM		Product p
WHERE		p.ProductSubcategoryID IN (SELECT 	ps.ProductSubcategoryID 
									   FROM 	ProductSubcategory ps
                                       WHERE 	ps.name ='Saddles');

-- Question 2: Thay đổi câu Query 1 để lấy được kết quả sau.

SELECT		p.Name
FROM		Product p
WHERE		p.ProductSubcategoryID IN (SELECT 	ps.ProductSubcategoryID 
									   FROM 	ProductSubcategory ps
                                       WHERE 	ps.name LIKE 'Bo%');
 
-- Question 3: Viết câu query trả về tất cả các sản phẩm có giá rẻ nhất (lowest ListPrice) và Touring Bike (nghĩa là ProductSubcategoryID = 3) 

SELECT 
    Name
FROM
    product
WHERE
    ProductSubcategoryID = 3
        AND ListPrice IN (
        SELECT 
            MIN(ListPrice)
        FROM
            product
        WHERE
            ProductSubcategoryID = 3);

-- Exercise 2: JOIN nhiều bảng  
-- Question 1: Viết query lấy danh sách tên country và province được lưu  trong AdventureWorks2008sample database. 

SELECT			S.name AS provice,		c.name AS country
FROM  			countryregion C
JOIN 			stateprovince S ON (C.CountryRegionCode=S.CountryRegionCode);

-- Question 2: Tiếp tục với câu query trước và thêm điều kiện là chỉ lấy country Germany và Canada

SELECT			S.name AS provice,		C.name AS country
FROM  			countryregion C
JOIN 			stateprovince S ON (C.CountryRegionCode=S.CountryRegionCode)
-- WHERE		C.name IN ('Germany','Canada')
WHERE  			C.name = 'Germany' OR C.name = 'Canada';

-- Question 3: SalesOrderID, OrderDate and SalesPersonID. 
-- Từ bảng SalesPerson, chúng ta lấy cột BusinessEntityID (là định danh của người sales),
-- Bonus and the SalesYTD (là đã sale được bao nhiêu người trong năm nay) 
 SELECT 		sod.salesorderID, 	sod.orderdate,	s.SalesPersonID, 	s.Bonus,	s.SalesYTD  
 FROM 			salesperson s
 JOIN			salesorderheader sod ON (s.SalesPersonID = sod.SalesPersonID );
 
-- Question 4:  Sử dụng câu query, thêm cột JobTitle and xóa cột SalesPersonID và BusinessEntityID.
 SELECT 		sod.salesorderID, 	sod.orderdate,	e.Title AS  Jobtitle,	s.Bonus,	s.SalesYTD 
 FROM 			salesperson s
 JOIN			salesorderheader sod ON (s.SalesPersonID = sod.SalesPersonID )	
 JOIN 			employee e ON (s.SalesPersonID =  e.EmployeeID);
 
 

