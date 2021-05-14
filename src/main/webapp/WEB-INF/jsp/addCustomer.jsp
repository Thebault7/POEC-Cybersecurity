<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add customers</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<a href="manageCustomers"><img src="<%=request.getContextPath()%>/icon/left_arrow.png" /></a>
	<h1>Add new customers</h1>
	<form:form action="checkAddCustomer" method="POST" modelAttribute="customer">
		<div>
			<form:label path="firstName">Customer firstname : </form:label>
			<form:input path="firstName" />
		</div>
		<button type="submit">Add customer</button>
	</form:form>
</body>
</html>