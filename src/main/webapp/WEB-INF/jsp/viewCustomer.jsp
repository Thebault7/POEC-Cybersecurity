<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualisation du client</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/Product.css">
</head>
<body>

	<%--  HEADER  --%>

	<section class="py-3">
		<div class="container px-4 px-lg-5 my-1">
			<jsp:include page="menu.jsp" />
			<a href="manageProducts"> <i
				class="fa fa-arrow-circle-left fa-2x" aria-hidden="true"></i>
			</a>
		</div>
	</section>

	<%--  MAIN BODY  --%>

	<section class="py-3">
		<div class="container px-4 px-lg-5 my-3">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<h1 class="display-5 fw-bolder">Visualisation du client avec la référence ${customer.reference}</h1>
				<div class="col-md-6">
					<h2 class="display-5">Référence : <span class="fw-bolder">${customer.reference}</span></h2>
					<h2 class="display-5">Prénom : <span class="fw-bolder">${customer.firstName}</span></h2>
					<h2 class="display-5">Nom : <span class="fw-bolder">${customer.lastName}</span></h2>
					<h2 class="display-5">Email : <span class="fw-bolder">${customer.email}</span></h2>
					<h2 class="display-5">Phone number : <span class="fw-bolder">${customer.phoneNumber}</span></h2>
				</div>
				<div class="col-md-6">
					<h2 class="display-5">Address : <span class="fw-bolder">${customer.addressLine1}</span></h2>
					<h2>${customer.addressLine2}</h2>
					<h2>${customer.addressLine3}</h2>
				</div>
			</div>
		</div>
	</section>

	
	
	<h2>birthdate : ${customer.birthdate}</h2>
	
	<h2>Postal code : ${customer.postalCode.number}</h2>
	<h2>City name : ${cityName}</h2>
	<c:if test="${!empty customer.postalCode.listCities}">
		<h2>Country :
			${customer.postalCode.listCities.get(0).countryEnum}</h2>
	</c:if>
	<h2>Employees in charge :</h2>
	<c:if
		test="${empty customer.listEmployee || customer.listEmployee == null}">
		<h2>No employee attributed to this customer yet.</h2>
	</c:if>
	<c:if
		test="${!(empty customer.listEmployee || customer.listEmployee == null)}">
		<c:forEach items="${customer.listEmployee}" var="c"
			varStatus="cStatus">
			<h2>- employee reference ${c.reference}, name ${c.firstName}
				${lastName}</h2>
		</c:forEach>
	</c:if>

	<a href="modifyCustomer?customerId=${customer.id}"><img
		src="<%=request.getContextPath()%>/icon/update.png" />Modify customer</a>
	<a href=#><img src="<%=request.getContextPath()%>/icon/delete.png" />Delete
		customer</a>
</body>
</html>