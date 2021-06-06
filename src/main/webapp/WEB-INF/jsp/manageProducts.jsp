<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Manage products</title>
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
					<h1 class="display-5 fw-bolder">Gestionnaire de produit</h1>
					<div>
						<h2>Liste des produits</h2>

						<div class="row align-items-center">
							<div class="col-md-1">
								<a href="addProduct">
									<i class="fa fa-plus fa-2x" aria-hidden="true"></i>
								</a>
							</div>
							<div class="col-md-7"></div>
							<div class="col-md-4">
								<jsp:include page="searchBar.jsp" />
							</div>
						</div>
<%--						TODO datatable pour la pagination--%>
						<table id="table" class="table table-bordered table-hover table-sm">
							<thead>
								<tr>
									<th scope="col" style="width: 10%">Référence</th>
									<th scope="col" style="width: 10%">Image</th>
									<th scope="col" style="width: 13%">Label</th>
									<th scope="col" style="width: 40%">Description</th>
									<th scope="col" style="width: 8%">Prix</th>
									<th scope="col" style="width: 8%">Stock</th>
									<th scope="col" style="width: 11%">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${listProducts}" var="row">
									<tr>
										<td>${row.reference}</td>
<%--										<td>${row.picture}</td>--%>
										<td><img class="card-img-top mb-5 mb-md-0" src="<%=request.getContextPath()%>/img/montre_demo.jpg" alt="product" /></td>
										<td>${row.label}</td>
										<td>${row.description}</td>
										<td>${row.price}€</td>
										<td>${row.stock}</td>
										<td>
											<div class="d-flex justify-content-around">
												<div>
													<a href="viewProduct?productId=${row.id}">
														<i class="fa fa-search fa-lg" aria-hidden="true"></i>
													</a>
												</div>
												<div>
													<a href="modifyProduct?productId=${row.id}">
														<i class="fa fa-pencil fa-lg" aria-hidden="true"></i>
													</a>
												</div>
												<div>
													<a href="archiveProduct?productId=${row.id}" class="btn-delete">
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

	<jsp:include page="archiveWarningPopup.jsp" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/archiveWarningPopup.js"></script>

</body>
</html>