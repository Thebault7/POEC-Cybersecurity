<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="fr.bufalo.acme.bo.Customer" %>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Modify customer</title>
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
			<h1 class="display-5 fw-bolder">Modification des données du
				client ${customer.reference}</h1>

			<form:form action="checkModifyCustomer" method="POST"
				modelAttribute="customer">
				<div class="row">
					<div class="form-group required col-6">
						<div class="form-group required">
							<p class="control-label">Champs obligatoires</p>
						</div>
						<form:label path="reference" class="control-label">Reference</form:label>
						<form:input path="reference" class="form-control" required="true"
							readonly="true" />
					</div>
					<div class="col-6">
						<form:input path="id" value="${customer.id}" hidden="true" />
					</div>
				</div>

				<%@ include file="/WEB-INF/jsp/customerForm.jsp"%>

				<div>
					<p>Liste des employés en charge de ce client : </p>
					<table class="table table-bordered table-hover table-sm">
						<thead>
							<tr>
								<th scope="col">Prénom</th>
								<th scope="col">Nom</th>
								<th scope="col">Référence</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${customer.listEmployee}" var="e" varStatus="eStatus">
							<tr>
								<td>${e.firstName}</td>
								<td>${e.lastName}</td>
								<td>${e.reference}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</form:form>
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