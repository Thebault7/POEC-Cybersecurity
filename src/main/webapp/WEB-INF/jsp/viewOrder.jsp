<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="o"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualisation de la commande</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Product.css">
</head>


<body>

<%--  HEADER  --%>

<section class="py-3">
    <div class="container px-4 px-lg-5 my-1">
        <jsp:include page="menu.jsp" />
        <a href="manageProducts">
            <i class="fa fa-arrow-circle-left fa-2x" aria-hidden="true"></i>
        </a>
    </div>
</section>

<%--  MAIN BODY  --%>

<section class="py-3">
    <div class="container px-4 px-lg-5 my-3">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6">
<h1>Référence de commande</h1><h1 class="display-5 fw-bolder">${order.reference}</h1>
<h2>Date de création : ${order.creationDate}</h2>
<h2>Date de validation : ${order.validationDate}</h2>
<h2>Client : ${order.customer}</h2>

<h2 >Produits concernés :</h2>
<c:forEach items="${listProducts}" var="p">
    <h2 class="display-5 fw-bolder">${p.label}</h2>
</c:forEach>
<%--<c:if--%>
<%--        test="${empty listProducts || order.listSoldProduct == null}">--%>
<%--    <h2>Aucun produit n'est associé à cette commande</h2>--%>
<%--</c:if>--%>
<%--<c:if--%>
<%--        test="${!(empty order.listSoldProduct || order.listSoldProduct == null)}">--%>
<%--    <c:forEach items="${order.listSoldProduct}" var="sp"--%>
<%--               varStatus="oStatus">--%>
<%--        <h2>- Référence des produits ${sp.reference}--%>
<%--                ${sp.quantity}</h2>--%>
<%--    </c:forEach>--%>
<%--</c:if>--%>
            </div>
</section>

<%--  FOOTER  --%>

<section class="py-3">
    <div class="container px-4 px-lg-5 my-5">
        <div class="d-flex justify-content-between">
            <div>
                <a href="modifyProduct?productId=${order.id}">
                    <i class="fa fa-pencil fa-lg" aria-hidden="true"></i>
                    Modifier la commande
                </a>
            </div>
            <div>
                <a href="archiveProduct?productId=${order.id}" class="btn-delete">
                    <i class="fa fa-archive fa-lg" aria-hidden="true"></i>
                    Archiver la commande
                </a>
            </div>
        </div>
    </div>
</section>

<jsp:include page="archiveWarningPopup.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/archiveWarningPopup.js"></script>

</body>
</html>