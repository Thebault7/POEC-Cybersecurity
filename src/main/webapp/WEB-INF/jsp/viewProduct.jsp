<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View Product</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/Product.css">
</head>
<body>
<%--  HEADER  --%>

<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <jsp:include page="menu.jsp" />
        <a href="manageProducts">
            <img src="<%=request.getContextPath()%>/icon/left_arrow.png"  alt="left arrow icon"/>
        </a>
    </div>
</section>


<%--  MAIN BODY  --%>

<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6">
                <img class="card-img-top mb-5 mb-md-0" src="<%=request.getContextPath()%>/img/placeholder-image.png" alt="product" />
            </div>
            <div class="col-md-6">
                <div class="small mb-1">ref.: ${product.reference}</div>
                <h1 class="display-5 fw-bolder">Product ${product.label}</h1>

                <div class="row gx-4 gx-lg-5 mb-5 align-items-center">
                    <div class="col-md-6">
                        <div>${product.price}€</div>
                        <div class="small">T.V.A.: ${vat_percent}</div>
                    </div>
                    <div class="col-md-6">
                        <div class="small">statut: ${status.label}</div>
                        <div class="small">stock: ${product.stock}</div>
                    </div>
                </div>

                <p class="lead">${product.description}</p>

                <div class="small mb-1 fw-bold">***TODO CATEGORIES***</div>
            </div>
        </div>
    </div>
</section>

<%--  FOOTER  --%>

<section class="py-5">
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6">
                <a href="modifyProduct?productId=${product.id}">
                    <img src="<%=request.getContextPath()%>/icon/update.png"  alt="update icon"/>
                    Modifier le produit
                </a>
            </div>
            <div class="col-md-6">
                <a href=#>
                    <img src="<%=request.getContextPath()%>/icon/delete.png"  alt="delete icon"/>
                    Archiver le produit
                </a>
            </div>
        </div>
    </div>
</section>

</body>
</html>
