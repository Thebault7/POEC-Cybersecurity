<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login page</title>
</head>
<body>
	<h1>TEST</h1>
	
	<form:form action="app/checkLogin" method="POST" modelAttribute="Employee">
		<form:label path="firstName">Employee name : </form:label>
		<form:input path="firstName" />
		<button type="submit">Send name</button>
	</form:form>
	<h1>Saved employee name : ${ SavedEmployee.firstName }</h1>
	<h1>Saved employee id : ${ SavedEmployee.id }</h1>
</body>
</html>