<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title></title>
</head>
<body>


<div class="row gx-4 gx-lg-5 align-items-center">
    <div class="col-md-6">
        <div class="form-group">
            <label for="reference">Référence</label>
            <input class="form-control" id="reference" placeholder="Référence" value="${order.reference}" required>
        </div>

        <div class="form-group">
            <label for="creationDate">Date de création</label>
            <input class="form-control" id="creationDate" placeholder="Date de création" value="${order.creationDate}" required>
        </div>

        <div class="form-group">
            <label for="customer">Client</label>
            <input class="form-control" id="customer" placeholder="Client" value="${order.customer}" required>
        </div>

    </div>

    <div class="d-flex justify-content-center">
        <button class="btn btn-outline-dark flex-shrink-0" type="submit">
            Valider
        </button>
    </div>
</div>


</body>
</html>
