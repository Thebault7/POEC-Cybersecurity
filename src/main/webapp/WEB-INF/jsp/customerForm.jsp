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
			<form:label path="firstName">Customer firstname : </form:label>
			<form:input path="firstName" />
		</div>
		<div>
			<form:label path="lastName">Customer lastname : </form:label>
			<form:input path="lastName" />
		</div>
		<div>
			<form:label path="addressLine1">Customer address : </form:label>
			<form:input path="addressLine1" />
		</div>
		<div>
			<form:label path="addressLine2">address complement : </form:label>
			<form:input path="addressLine2" />
		</div>
		<div>
			<form:label path="addressLine3">address complement : </form:label>
			<form:input path="addressLine3" />
		</div>
		<div>
			<label>Customer postal code : </label>
			<input id="postalCodeID" type="text" />
		</div>
		<div id="showListCities"></div>
		<%--div being used to show the list of cities from the REST API --%>
		<div id="showSelectedCity"></div>
		<div>
			<form:label path="email">Customer email : </form:label>
			<form:input path="email" />
		</div>
		<div>
			<form:label path="phoneNumber">Customer phone number : </form:label>
			<form:input path="phoneNumber" />
		</div>
		<div>
			Customer birthdate: <select id="selectedMonth" name="month">
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
			</select>
			<select id="selectedDay" name="day">
				<c:forEach begin="1" end="31" var="day">
					<option><c:out value="${day}" /></option>
				</c:forEach>
			</select>
			<c:set var="currentYear" value="<%=LocalDate.now().getYear()%>" />
			<select id="selectedYear" name="year">
				<c:forEach begin="${currentYear - 130}" end="${currentYear}" var="i">
					<c:set var="year" value="${currentYear-i+currentYear-130}"></c:set>
					<option><c:out value="${year}" /></option>
				</c:forEach>
			</select>
		</div>
		<div>
			<form:input id="birthdateInputField" path="birthdate" hidden="true" />
			<form:input id="postalCodeIdField" path="postalCodeId" hidden="true" />
			<form:input id="cityIdField" path="cityId" hidden="true" />
			<form:input id="cityNameField" path="cityName" hidden="true" />
			<form:input id="countryField" path="country" hidden="true" />
		</div>
		<button type="submit" onclick='checkBirthdate()'>Add customer</button>
	</div>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/js/customerForm.js"></script>
</body>
</html>