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
			<a href="manageCustomers"> <i
				class="fa fa-arrow-circle-left fa-2x" aria-hidden="true"></i>
			</a>
		</div>
	</section>

	<%--  MAIN BODY  --%>

	<section class="py-3">
		<div class="container px-4 px-lg-5 my-3">
			<div class="row gx-4 gx-lg-5 align-items-center">
				<h1 class="display-5 fw-bolder">Visualisation du client avec la
					référence ${customer.reference}</h1>
				<div class="col-md-5">
					<h2 class="display-10">
						<span class="fw-bolder">Référence : </span>${customer.reference}</h2>
					<h2 class="display-10">
						<span class="fw-bolder">Prénom : </span>${customer.firstName}</h2>
					<h2 class="display-10">
						<span class="fw-bolder">Nom : </span>${customer.lastName}</h2>
					<h2 class="display-10">
						<span class="fw-bolder">Email : </span>${customer.email}</h2>
					<h2 class="display-10">
						<span class="fw-bolder">Numéro de téléphone : </span>${customer.phoneNumber}</h2>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-5 row">
					<h2 class="display-10">
						<span class="fw-bolder">Adresse : </span>${customer.addressLine1}</h2>
					<div class="col-md-2"></div>
					<div class="col-md-10">
						<h2 class="display-10">${customer.addressLine2}</h2>
						<h2 class="display-10">${customer.addressLine3}</h2>
					</div>
					<h2 class="display-10">
						<span class="fw-bolder">Postal code : </span>${customer.postalCode.number}</h2>
					<h2 class="display-10">
						<span class="fw-bolder">City name : </span>${cityName}</h2>
					<c:if test="${!empty customer.postalCode.listCities}">
						<h2 class="display-10">
							<span class="fw-bolder">Country : </span>${customer.postalCode.listCities.get(0).countryEnum}</h2>
					</c:if>
					<h2 class="display-10">
						<span class="fw-bolder">birthdate : </span>${customer.birthdate}</h2>
				</div>
			</div>
			<hr>
			<div>
				<h2>Liste des employés en charge de ce client :</h2>
				<table class="table table-bordered table-hover table-sm">
					<thead>
						<tr>
							<th scope="col">Prénom</th>
							<th scope="col">Nom</th>
							<th scope="col">Référence</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customer.listEmployee}" var="e"
							varStatus="eStatus">
							<tr>
								<td>${e.firstName}</td>
								<td>${e.lastName}</td>
								<td>${e.reference}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>

	<%--  FOOTER  --%>

	<section class="py-3">
		<div class="container px-4 px-lg-5 my-5">
			<div class="d-flex justify-content-between">
				<div>
					<a href="searchCustomer?customerId=${customer.id}"> <i
						class="fa fa-search fa-lg" aria-hidden="true"></i> Voir le client
					</a>
				</div>
				<div>
					<a href="archiveCustomer?customerId=${customer.id}"
						class="btn-delete"> <i class="fa fa-archive fa-lg"
						aria-hidden="true"></i> Archiver le client
					</a>
				</div>
			</div>
		</div>
	</section>
</body>
</html>