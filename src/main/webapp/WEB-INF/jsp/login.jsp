<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Acme login page</title>
</head>
<body>
	<h1>LOGIN</h1>
	<div>
		<form:form action="app/checkLogin" method="POST" modelAttribute="Employee">
			<div>
				<form:label path="email">Employee email : </form:label>
				<form:input path="email" placeholder="abc@acme.fr" />
			</div>
			<div>
				<form:label path="password">Employee password : </form:label>
				<form:input path="password" placeholder="*******" />
			</div>
			<button type="submit">Login</button>
		</form:form>
	</div>
	
	<div>
		<a href=#>Forgot password ?</a>
	</div>

</body>
</html>