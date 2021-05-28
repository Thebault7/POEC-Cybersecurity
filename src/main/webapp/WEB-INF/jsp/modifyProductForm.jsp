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
            <div class="form-group">
                <label for="reference">Référence</label>
                <input class="form-control" id="reference" placeholder="Référence" value="${product.reference}" required>
            </div>

            <div class="form-group">
                <label for="label">Titre</label>
                <input class="form-control" id="label" placeholder="Titre" value="${product.label}" required>
            </div>

            <div class="form-group">
                <label for="price">Prix (€)</label>
                <input class="form-control" id="price" placeholder="Titre" value="${product.price}" required>
            </div>

            <div class="form-group">
                <label for="tva">T.V.A.</label>
                <select class="form-control" id="tva">
                    <option value="${vat.percentage}" selected>${String.format("%5.1f%%", vat.percentage*100)}</option>
                    <c:forEach items="${listVats}" var="vatOption">
                        <c:if test="${vatOption.percentage != vat.percentage}">
                            <option value="${vatOption.percentage}">${String.format("%5.1f%%", vatOption.percentage*100)}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="status">Statut</label>
                <select class="form-control" id="status">
                    <option value="${status.label}" selected>${status.label}</option>
                    <c:forEach items="${listStatuses}" var="statusOption">
                        <c:if test="${statusOption.label != status.label}">
                            <option value="${statusOption.label}">${statusOption.label}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">
                <label for="stock">Stock</label>
                <input class="form-control" id="stock" placeholder="0" value="${product.stock}">
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" id="description" rows="5" >${product.description}</textarea>
            </div>

            <div class="form-group">
                <label for="category">Categories (choix multiples)</label>
                <select multiple class="form-control" id="category">
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.label}" selected>${category.label}</option>
                        <c:forEach items="${listCategories}" var="categoryOption">
                            <c:if test="${categoryOption.label != category.label}">
                                <option value="${categoryOption.label}">${categoryOption.label}</option>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </select>
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
