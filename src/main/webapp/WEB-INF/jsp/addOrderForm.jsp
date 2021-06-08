<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title></title>
    <script src="<%=request.getContextPath()%>/js/addOrderTable.js"></script>
</head>
<body>


<div class="row gx-4 gx-lg-5 align-items-center">

    <div class="row gx-4 gx-lg-5 align-items-center">

        <div class="py-4">
            <div class="row align-items-top">
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="reference" class="control-label">Référence</label>
                        <input class="form-control" name="reference" id="reference" placeholder="Référence" value="${order.reference}" readonly>
                    </div>
                </div>
            </div>
        </div>


        <div class="row gx-4 gx-lg-5 mb-5 align-items-top">
            <div class="col-md-9">
                <div class="fw-bolder py-2">Contenu de la commande</div>
                <table id="table" class="table table-bordered table-sm table order-list">
                    <thead>
                    <tr>
                        <th scope="col">Produit</th>
                        <th scope="col">Qté</th>
                        <th scope="col">T.V.A. (%)</th>
                        <th scope="col">Prix HT (€)</th>
                        <th scope="col">Total prix HT (€)</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="col-sm-4">
                            <label for="product" class="control-label"></label>
                            <select class="form-control productSelect" name="productsId" id="product">
                                <c:forEach items="${listProducts}" var="choiceProduct">
                                    <option value="${choiceProduct.id}">
                                        ${choiceProduct.label} (${choiceProduct.reference})
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td class="col-sm-2">
                            <div class="form-group">
                                <label for="quantity" class="control-label"></label>
                                <input class="form-control quantityInput" type="number" name="quantity" value="1" min="1" step="1" id="quantity">
                            </div>
                        </td>
                        <td class="col-sm-2">
                            <div class="form-group">
                                <label for="vat" class="control-label"></label>
                                <input class="form-control vatInput" name="vat" value="" id="vat" readonly>
                            </div>
                        </td>
                        <td class="col-sm-2">
                            <div class="form-group">
                                <label for="priceNoTaxes" class="control-label"></label>
                                <input class="form-control priceHTInput" name="quantity" value="" id="priceNoTaxes" readonly>
                            </div>
                        </td>
                        <td class="col-sm-2">
                            <div class="form-group">
                                <label for="totalPriceNoTaxes" class="control-label"></label>
                                <input class="form-control totalPriceHTInput" name="quantity" value="" id="totalPriceNoTaxes" readonly>
                            </div>
                        </td>
                        <td class="col-sm-1">
                            <a class="deleteRow"></a>
                        </td>
                    </tr>
                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="6" style="text-align: left;">
                            <input type="button" class="btn btn-lg btn-block fa fa-input" id="addrow" value="&#xf055 Ajouter un produit" />
                        </td>
                    </tr>
                    <tr>
                    </tr>
                    </tfoot>
                </table>
                <div class="fw-bold"> Total TTC : <span id="totalTTC">${orderTotalPriceDisplay}</span>€</div>
            </div>
            <div class="col-md-3">
                <div class="fw-bolder py-2">Informations client</div>
                <div class="border rounded p-2">
                    <div class="small">
                        <div class="form-group required">
                            <label for="customer" class="control-label">Réf. client</label>
                            <select class="form-control" name="customerId" id="customer">
                                <c:forEach items="${listCustomers}" var="customer">
                                    <option value="${customer.id}">${customer.firstName} ${customer.lastName} (${customer.reference})</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="d-flex justify-content-center">
        <button name="checkAddOrder" class="btn btn-outline-dark flex-shrink-0" type="submit">
            Valider
        </button>
    </div>
</div>


</body>
</html>
