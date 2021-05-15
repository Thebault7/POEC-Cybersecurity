<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit customer</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>Customer refernce ${customer.reference}</h1>
	<h2>Customer reference : ${customer.reference}</h2>
	<h2>Email : ${customer.email}</h2>
	<h2>First name : ${customer.firstName}</h2>
	<h2>Last name : ${customer.lastName}</h2>
	<h2>Phone number : ${customer.phoneNumber}</h2>
	<h2>birthdate : ///////// (not implemented yet)</h2>
	<h2>
		Address : ${customer.addressLine1}<br> ${customer.addressLine2}<br>${customer.addressLine3}</h2>
	<h2>Postal code : ${customer.postalCode}</h2>
	<h2>Country : ///////// (not implemented yet)</h2>
	<h2>Employees in charge : ///////// (not implemented yet)</h2>
	<a href=#><img src="<%=request.getContextPath()%>/icon/update.png" />Modify
		customer</a>
	<a href=#><img src="<%=request.getContextPath()%>/icon/delete.png" />Delete customer</a>
</body>
</html>