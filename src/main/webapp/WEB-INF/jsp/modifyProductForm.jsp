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
            <img class="card-img-top mb-5 mb-md-0" src="<%=request.getContextPath()%>/img/placeholder-image.png" alt="product" />
            <div class="custom-file">
                <input type="file" class="image-input" id="customFile">
                <label class="custom-file-label" for="customFile">Choisir un fichier</label>
            </div>
        </div>

        <div class="col-md-6">

<%--            TODO mettre warning pour la modification de la ref : attention il n'est pas conseillé de changer la reference--%>
<%--            TODO vérification de la reference (n'existe pas en base)--%>
            <div class="form-group required">
                <label for="reference" class="control-label">Référence</label>
                <input class="form-control" name="reference" id="reference" placeholder="Référence" value="${product.reference}" required>
            </div>

            <div class="form-group required">
                <label for="label" class="control-label">Titre</label>
                <input class="form-control" name="label" id="label" placeholder="Titre" value="${product.label}">
            </div>

            <div class="form-group required">
                <label for="price" class="control-label">Prix (€)</label>
                <input class="form-control" name="price" id="price" placeholder="Titre" value="${product.price}">
            </div>

            <div class="form-group required">
                <label for="vat" class="control-label">T.V.A.</label>
                <select class="form-control" name="vatId" id="vat">
                    <option value="${vat.id}" selected>${String.format("%5.1f%%", vat.percentage*100)}</option>
                    <c:forEach items="${listVats}" var="vatOption">
                        <c:if test="${vatOption.id != vat.id}">
                            <option value="${vatOption.id}">${String.format("%5.1f%%", vatOption.percentage*100)}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group required">
                <label for="status" class="control-label">Statut</label>
                <select class="form-control" name="statusId" id="status">
                    <option value="${status.id}" selected>${status.label}</option>
                    <c:forEach items="${listStatuses}" var="statusOption">
                        <c:if test="${statusOption.id != status.id}">
                            <option value="${statusOption.id}">${statusOption.label}</option>
                        </c:if>
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
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}" selected>${category.label}</option>
                        <c:forEach items="${listCategories}" var="categoryOption">
                            <c:if test="${categoryOption.id != category.id}">
                                <option value="${categoryOption.id}">${categoryOption.label}</option>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="d-flex justify-content-center">
            <button name="checkModifyProduct" class="btn btn-outline-dark flex-shrink-0" type="submit">
                Valider
            </button>
        </div>
    </div>


</body>
</html>
