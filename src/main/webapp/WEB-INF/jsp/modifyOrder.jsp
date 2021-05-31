<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modification de la commande</title>
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
        <h1 class="display-5 fw-bolder">Modification de la commande ${order.reference}</h1>

        <form:form id="formModifyOrder" action="checkModifyOrder" method="POST" modelAttribute="order">

            <%@ include file="/WEB-INF/jsp/modifyOrderForm.jsp"%>

        </form:form>
    </div>
</section>

<%--  FOOTER  --%>

<section class="py-3">
    <div class="container px-4 px-lg-5 my-5">
        <div class="d-flex justify-content-between">
            <div>
                <a href="viewOrder?orderId=${order.id}">
                    <i class="fa fa-search fa-lg" aria-hidden="true"></i>
                    Voir la commande
                </a>
            </div>
            <div>
                <a href=#>
                    <i class="fa fa-archive fa-lg" aria-hidden="true"></i>
                    Archiver la commande
                </a>
            </div>
        </div>
    </div>
</section>

</body>
</html>
