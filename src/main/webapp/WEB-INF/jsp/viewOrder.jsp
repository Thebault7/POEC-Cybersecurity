<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="o"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<jsp:include page="menu.jsp" />
<h1>Référence de commande ${order.reference}</h1>
<h2>Date de création : ${order.creationDate}</h2>
<h2>Date de validation : ${order.validationDate}</h2>
<h2>CLient : ${order.customer}</h2>

<h2>Produits concernés :</h2>
<c:if
        test="${empty order.listSoldProduct || order.listSoldProduct == null}">
    <h2>Aucun produit n'est associé à cette commande</h2>
</c:if>
<c:if
        test="${!(empty order.listSoldProduct || order.listSoldProduct == null)}">
    <c:forEach items="${order.listSoldProduct}" var="sp"
               varStatus="oStatus">
        <h2>- Référence des produits ${sp.reference}
                ${sp.quantity}</h2>
    </c:forEach>
</c:if>

<a href=#><img src="<%=request.getContextPath()%>/icon/update.png" />Modify
    order</a>
<a href=#><img src="<%=request.getContextPath()%>/icon/delete.png" />Delete
    order</a>
</body>
</html>