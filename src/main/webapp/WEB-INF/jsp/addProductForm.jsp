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
            <img class="card-img-top mb-5 mb-md-0" src="<%=request.getContextPath()%>/img/montre_demo.jpg" alt="product" />
            <div class="custom-file">
                <input type="file" class="image-input" id="customFile">
                <label class="custom-file-label" for="customFile">Choisir un fichier</label>
            </div>
        </div>

        <div class="col-md-6">

            <div class="form-group">
                <label for="reference">Référence</label>
                <input class="form-control" name="reference" id="reference" placeholder="Référence" value="${product.reference}" readonly>
            </div>

            <div class="form-group required">
                <label for="label" class="control-label">Titre</label>
                <input class="form-control" name="label" id="label" placeholder="Titre" value="${product.label}" required>

<%--                <div>--%>
<%--                    <label for="validationSuccess" class="form-label text-success">Input with success</label>--%>
<%--                    <input type="text" class="form-control is-valid" id="validationSuccess" required>--%>
<%--                    <div class="valid-feedback">--%>
<%--                        This is a success state form validation message!--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div>--%>
<%--                    <label for="validationError" class="form-label text-danger">Input with error</label>--%>
<%--                    <input type="text" class="form-control is-invalid" id="validationError" required>--%>
<%--                    <div class="invalid-feedback">--%>
<%--                        This is an error state form validation message!--%>
<%--                    </div>--%>
<%--                </div>--%>
            </div>

            <div class="form-group required">
                <label for="price" class="control-label">Prix (€)</label>
                <input type="number" class="form-control" name="price" id="price" placeholder="Titre" value="${product.price}" required>
            </div>

            <div class="form-group required">
                <label for="vat" class="control-label">T.V.A.</label>
                <select class="form-control" name="vatId" id="vat" required>
                    <c:forEach items="${listVats}" var="vatOption">
                        <option value="${vatOption.id}">${String.format("%5.1f%%", vatOption.percentage*100)}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group required">
                <label for="status" class="control-label">Statut</label>
                <select class="form-control" name="statusId" id="status" required>
                    <c:forEach items="${listStatuses}" var="statusOption">
                        <option value="${statusOption.id}">${statusOption.label}</option>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="stock">Stock</label>
                <input class="form-control" name="stock" id="stock" placeholder="0" value="${product.stock}">
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" name="description" id="description" rows="5" >${product.description}</textarea>
            </div>

            <div class="form-group">
                <label for="category">Categories (choix multiples)</label>
                <select multiple class="form-control" name="categoriesId" id="category">
                    <c:forEach items="${listCategories}" var="categoryOption">
                        <option value="${categoryOption.id}">${categoryOption.label}</option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="d-flex justify-content-center">
            <button name="checkAddProduct" class="btn btn-outline-dark flex-shrink-0" type="submit">
                Valider
            </button>
        </div>
    </div>


</body>
</html>
