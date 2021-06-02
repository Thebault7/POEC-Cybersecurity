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
				<form:input class="form-control" path="lastName"
					placeholder="Nom" required="true" />
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
				Date de naissance : <select id="selectedMonth" name="month">
					<option value="none">--Select--</option>
					<option value="Jan">January</option>
					<option value="Feb">February</option>
					<option value="Mar">March</option>
					<option value="Apr">April</option>
					<option value="May">May</option>
					<option value="Jun">June</option>
					<option value="Jul">July</option>
					<option value="Aug">August</option>
					<option value="Sep">September</option>
					<option value="Oct">October</option>
					<option value="Nov">November</option>
					<option value="Dec">December</option>
				</select> <select id="selectedDay" name="day">
					<c:forEach begin="1" end="31" var="day">
						<option><c:out value="${day}" /></option>
					</c:forEach>
				</select>
				<c:set var="currentYear" value="<%=LocalDate.now().getYear()%>" />
				<select id="selectedYear" name="year">
					<c:forEach begin="${currentYear - 130}" end="${currentYear}"
						var="i">
						<c:set var="year" value="${currentYear-i+currentYear-130}"></c:set>
						<option><c:out value="${year}" /></option>
					</c:forEach>
				</select>
			</div>
			<div>
				<form:input id="birthdateInputField" path="birthdate" hidden="true" />
				<form:input id="postalCodeIdField" path="postalCodeId"
					value="${postalCode.id}" hidden="true" />
				<form:input id="cityIdField" path="cityId" hidden="true" />
				<form:input id="cityNameField" path="cityName" hidden="true" />
				<form:input id="countryField" path="country" hidden="true" />
			</div>
		</div>
		<div class="row">
			<div class="d-flex justify-content-center">
				<button class="btn btn-outline-dark flex-shrink-0" type="submit"
					onclick='checkBirthdate()'>Valider</button>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/customerForm.js"></script>
</body>
</html>