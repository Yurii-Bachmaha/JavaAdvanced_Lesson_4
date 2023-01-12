<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Magazine shop</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div style="text-align: center;">
		<h1>Welcome to the magazine shop!</h1>
	</div>
	<form style="text-align: center;">
		<button type="button" onclick="location.href='register.jsp'">Register</button>
		<button type="button" onclick="location.href='login.jsp'">Login</button>
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>