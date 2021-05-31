<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.time.LocalDate"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>
<div>
    <div>
        <form:label path="reference">Référence de la commande : </form:label>
        <form:input path="reference" />
    </div>
    <div>
        <form:label path="creationDate">Date de création : </form:label>
        <form:input path="creationDate" />
    </div>
    <div>
        <form:label path="validatinoDate">Date de validation : </form:label>
        <form:input path="validationDate" />
    </div>
    <div>
        <form:label path="customer">Client : </form:label>
        <form:input path="customer" />
    </div>

    <button type="submit">Ajouter la commande</button>
</div>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/orderForm.js"></script>
</body>
</html>