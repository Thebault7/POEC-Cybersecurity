<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Ajout d'une commande</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Product.css">
</head>
<body>

<%--  HEADER  --%>

<section class="py-3">
    <div class="container px-4 px-lg-5 my-1">
        <jsp:include page="menu.jsp" />
        <a href="manageOrders">
            <i class="fa fa-arrow-circle-left fa-2x" aria-hidden="true"></i>
        </a>
    </div>
</section>

<%--  MAIN BODY  --%>

<section class="py-3">
    <div class="container px-4 px-lg-5 my-3">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <h1 class="display-5 fw-bolder">Ajout d'une commande</h1>
            <div class="col-md-12">

                <form:form id="formAddOrder" action="checkAddOrder" method="POST" modelAttribute="order">
                    <%@ include file="/WEB-INF/jsp/addOrderForm.jsp"%>
                </form:form>
            </div>
        </div>
    </div>
</section>

</body>
</html>
