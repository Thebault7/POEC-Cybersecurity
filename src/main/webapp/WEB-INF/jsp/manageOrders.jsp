<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Gestion des commandes</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Product.css">
</head>
<body>

<%--  HEADER  --%>

<section class="py-3">
	<div class="container px-4 px-lg-5 my-1">
		<jsp:include page="menu.jsp" />
	</div>
</section>

<%--  MAIN BODY  --%>

<section class="py-3">
	<div class="container px-4 px-lg-5 my-3">
		<div class="row gx-4 gx-lg-5 align-items-center">
			<div class="col-md-12">
				<h1 class="display-5 fw-bolder">Gestion des commandes</h1>
				<div>
					<h2>Liste des commandes</h2>

					<div class="row align-items-center">
						<div class="col-md-1">
							<a href="addOrder"><i class="fa fa-plus fa-2x" aria-hidden="true"></i></a>
						</div>
						<div class="col-md-7">

						</div>
						<div class="col-md-4">
							<jsp:include page="searchBar.jsp" />
						</div>
					</div>
					<%--						TODO datatable pour la pagination--%>
					<table id="table" class="table table-bordered table-hover table-sm">
						<thead>
						<tr>
							<th scope="col">Référence</th>
							<th scope="col">Date de création</th>
							<th scope="col">Date de validation</th>
							<th scope="col">Client</th>
							<th scope="col">Statut</th>
							<th scope="col" >Action</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${listOrders}" var="row">
							<tr>
								<td>${row.reference}</td>
								<td>${row.creationDate}</td>
								<td>${row.validationDate}</td>
								<td>${row.customer.firstName} ${row.customer.lastName}</td>
								<td>
									<c:choose>
										<c:when test="${row.isValidated}">
											validé
										</c:when>
										<c:otherwise>
											en attente
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									<div class="d-flex justify-content-around">
										<div>
											<a href="viewOrder?orderId=${row.id}">
												<i class="fa fa-search fa-lg" aria-hidden="true"></i>
											</a>
										</div>
										<div>
											<a href="modifyOrder?orderId=${row.id}">
												<i class="fa fa-pencil fa-lg" aria-hidden="true"></i>
											</a>
										</div>
										<div>
											<a href="archiveOrder?orderId=${row.id}" class="btn-delete">
												<i class="fa fa-archive fa-lg" aria-hidden="true"></i>
											</a>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>

</body>


</html>