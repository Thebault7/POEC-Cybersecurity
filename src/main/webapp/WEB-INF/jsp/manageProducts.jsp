<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Manage products</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<jsp:include page="menu.jsp" />
	<h1>Manage products</h1>
	<div>
		<h2>List of products</h2>
		<jsp:include page="searchBar.jsp" />
		<a href="addProduct"><img src="<%=request.getContextPath()%>/icon/plus.png" /></a>
		<table>
			<tr>
				<td>Reference</td>
				<td>Picture</td>
				<td>Label</td>
				<td>Description</td>
				<td>Price</td>
				<td>Stock</td>
			</tr>
			<c:forEach items="${listProducts}" var="row">
				<tr>
					<td>${row.reference}</td>
					<td>${row.picture}</td>
					<td>${row.label}</td>
					<td>${row.description}</td>
					<td>${row.price}</td>
					<td>${row.stock}</td>
					<td>
						<a href="viewProduct?productId=${row.id}">
							<img src="<%=request.getContextPath()%>/icon/search.png"  alt="search icon"/>
						</a>
						<a href="modifyProduct?productId=${row.id}">
							<img src="<%=request.getContextPath()%>/icon/update.png"  alt="update icon"/>
						</a>
						<a href=#>
							<img src="<%=request.getContextPath()%>/icon/delete.png"  alt="delete icon"/>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>