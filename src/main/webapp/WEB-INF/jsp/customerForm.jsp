<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.time.LocalDate"%>

<html>
<head>
<title></title>
</head>
<body>
	<div class="row gx-4 gx-lg-5 align-items-center">
		<div class="col-md-6">
			<div class="form-group required">
				<form:label class="control-label" path="firstName">Prénom : </form:label>
				<form:input class="form-control" path="firstName"
					placeholder="Prénom" required="true" />
			</div>
			<div class="form-group required">
				<form:label class="control-label" path="lastName">Nom : </form:label>
				<form:input class="form-control" path="lastName" placeholder="Nom"
					required="true" />
			</div>
			<div class="form-group">
				<form:label class="control-label" path="addressLine1">Adresse : </form:label>
				<form:input class="form-control" placeholder="Adresse"
					path="addressLine1" />
			</div>
			<div class="form-group">
				<form:label class="control-label" path="addressLine2">Complément d'adresse : </form:label>
				<form:input class="form-control" path="addressLine2"
					placeholder="N° de bâtiment, n° d'appartement..." />
			</div>
			<div class="form-group">
				<form:label class="control-label" path="addressLine3">Complément d'adresse : </form:label>
				<form:input class="form-control" path="addressLine3" />
			</div>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<label class="control-label">Code postal : </label> <input
					class="form-control" id="postalCodeID" type="text"
					placeholder="Code postal" value="${postalCode.number}" />
				<div id="showListCities" class="control-label"></div>
				<%--div being used to show the list of cities from the REST API --%>
				<div id="showSelectedCity" class="control-label"></div>
			</div>
			<div class="form-group">
				<form:label class="control-label" path="email">Email : </form:label>
				<form:input class="form-control" path="email" placeholder="Email" />
			</div>
			<div class="form-group">
				<form:label class="control-label" path="phoneNumber">Numéro de téléphone : </form:label>
				<form:input class="form-control" path="phoneNumber"
					placeholder="Numéro de téléphone" />
			</div>
			<div>
				<label for="birthdate">Anniversaire :</label> <input type="date"
					id="birthdate" name="birthdate" value="${customer.birthdate}"
					min=<%=LocalDate.now().plusYears(-130)%> max=<%=LocalDate.now()%> />
			</div>
			<div>
				<form:input id="postalCodeIdField" path="postalCodeId"
					value="${postalCode.id}" hidden="true" />
				<form:input id="cityIdField" path="cityId" hidden="true" />
				<form:input id="cityNameField" path="cityName" hidden="true" />
				<form:input id="countryField" path="country" hidden="true" />
			</div>
		</div>
		<div class="row">
			<div class="d-flex justify-content-center">
				<button id="myForm" class="btn btn-outline-dark flex-shrink-0"
					type="submit">Valider</button>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/customerForm.js"></script>
</body>
</html>