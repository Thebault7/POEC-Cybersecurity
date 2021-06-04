<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manage customers</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/Product.css">
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
					<h1 class="display-5 fw-bolder">Manage customers</h1>
					<div>
						<h2>List of your customers</h2>

						<div class="row align-items-center">
							<div class="col-md-1">
								<a href="addCustomer"><i class="fa fa-plus fa-2x"
									aria-hidden="true"></i></a>
							</div>
							<div class="col-md-7"></div>
							<div class="col-md-4">
								<jsp:include page="searchBar.jsp" />
							</div>
						</div>
						<table id="table" class="table table-bordered table-hover table-sm">
							<thead>
								<tr>
									<th scope="col">Name</th>
									<th scope="col">Email</th>
									<th scope="col">Address</th>
									<th scope="col">Reference</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${listCustomers}" var="c" varStatus="cStatus">
<%-- 							<c:if test="${c.isActive == true}">	--%>	
								<tr>
									<td>${c.firstName}${c.lastName}</td>
									<td>${c.email}</td>
									<td>${c.addressLine1}<br>${c.addressLine2}<br>${c.addressLine3}</td>
									<td>${c.reference}</td>
									<td>
										<div class="row align-items-center">
											<div class="col-md-4">
												<a href="searchCustomer?customerId=${c.id}"> <i
													class="fa fa-search fa-lg" aria-hidden="true"></i>
												</a>
											</div>
											<div class="col-md-4">
												<a href="modifyCustomer?customerId=${c.id}"> <i
													class="fa fa-pencil fa-lg" aria-hidden="true"></i>
												</a>
											</div>
											<div class="col-md-4">
												<a href="archiveCustomer?customerId=${c.id}" class="btn-delete">
												<i class="fa fa-archive fa-lg"
													aria-hidden="true"></i>
												</a>
											</div>
										</div>
									</td>
								</tr>
<%-- 							</c:if>	--%>
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