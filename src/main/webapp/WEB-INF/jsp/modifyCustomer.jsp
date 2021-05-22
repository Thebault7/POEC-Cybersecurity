<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modify customer</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<a href="manageCustomers"><img src="<%=request.getContextPath()%>/icon/left_arrow.png" /></a>
	<h1>Modify customer ${customer.reference}</h1>
	<form:form action="checkAddCustomer" method="POST" modelAttribute="customer">
		<jsp:include page="customerForm.jsp" />
	</form:form>
</body>
</html>