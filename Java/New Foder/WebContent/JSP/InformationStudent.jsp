<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.Students"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>List Student</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>
	

		
			<table class="table table-striped">
				<c:forEach items="<%=Students.getStudent()%>" var="test">
					<p>
						<c:out value="${test.getId()}" />
						<c:out value="${test.getName()}" />
						<c:out value="${test.getAge()}" />
						<c:out value="${test.getGender()}" />
						<c:out value="${test.getSchool()}" />
						<c:out value="${test.getPhone()}" />
						<c:out value="${test.getSchool()}" />
						<c:out value="${test.getAdress()}" />


					</p>
				</c:forEach>
			</table>
		
	
</body>
</html>