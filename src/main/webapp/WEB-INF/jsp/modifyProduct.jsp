<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modification Produit</title>
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
            <h1 class="display-5 fw-bolder">Modification du produit ${product.reference}</h1>

                    <form:form id="formModifyProduct" action="checkModifyProduct" method="POST" modelAttribute="product">

                        <%@ include file="/WEB-INF/jsp/modifyProductForm.jsp"%>

                    </form:form>
        </div>
    </section>

<%--  FOOTER  --%>

    <section class="py-3">
        <div class="container px-4 px-lg-5 my-5">
            <div class="d-flex justify-content-between">
                <div>
                    <a href="viewProduct?productId=${product.id}">
                        <i class="fa fa-search fa-lg" aria-hidden="true"></i>
                        Voir le produit
                    </a>
                </div>
                <div>
                    <a href="archiveProduct?productId=${product.id}">
                        <i class="fa fa-archive fa-lg" aria-hidden="true"></i>
                        Archiver le produit
                    </a>
                </div>
            </div>
        </div>
    </section>

</body>
</html>
