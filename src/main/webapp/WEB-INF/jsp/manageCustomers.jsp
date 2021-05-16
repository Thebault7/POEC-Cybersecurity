<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manage customers</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>Manage customers</h1>
	<div>
		<h2>List of customers you are (or have been) following</h2>
		<jsp:include page="searchBar.jsp" />
		<a href="addCustomer"><img
			src="<%=request.getContextPath()%>/icon/plus.png" /></a>
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Reference</th>
				<th></th>
			</tr>
			<c:forEach items="${listCustomers}" var="c" varStatus="cStatus">
				<tr>
					<td>${c.firstName}${c.lastName}${c.id}</td>
					<td>${c.email}</td>
					<td>${c.addressLine1}<br>${c.addressLine2}<br>${c.addressLine3}</td>
					<td>${c.reference}</td>
					<td><a href="searchCustomer?customerId=${c.id}"><img
							src="<%=request.getContextPath()%>/icon/search.png" /></a> <a href=#><img
							src="<%=request.getContextPath()%>/icon/update.png" /></a> <a href=#><img
							src="<%=request.getContextPath()%>/icon/delete.png" /></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>