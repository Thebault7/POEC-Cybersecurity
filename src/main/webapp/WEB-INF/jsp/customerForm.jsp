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
			<form:label path="reference">Customer reference : </form:label>
			<form:input path="reference" />
		</div>
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
<%--  		<div>
			<form:label path="postalCode">Customer postal code : </form:label>
			<form:input path="postalCode" />
		</div>	--%>
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
				<c:forEach begin="${currentYear - 130}" end="${currentYear}" var="i">
					<c:set var="year" value="${currentYear-i+currentYear-130}"></c:set>
					<option><c:out value="${year}" /></option>
				</c:forEach>
			</select>
			<button type="button" onclick='checkBirthdate()'>Validate</button>
		</div>
		<div>
			<form:label path="birthdate">Customer birthdate : </form:label>
			<form:input id="birthdateText" path="birthdate" disabled="true" />	
		</div>
		<button type="submit">Add customer</button>
	</div>


	
	<script type="text/javascript">
		function checkBirthdate() {
			var day = document.getElementById("selectedDay").options[document
					.getElementById("selectedDay").selectedIndex].text;
			var month = document.getElementById("selectedMonth").options[document
					.getElementById("selectedMonth").selectedIndex].text;
			var year = document.getElementById("selectedYear").options[document
					.getElementById("selectedYear").selectedIndex].text;
			if (month == "January") {
				month = "01";
			}
			if (month == "February") {
				month = "02";
			}
			if (month == "March") {
				month = "03";
			}
			if (month == "April") {
				month = "04";
			}
			if (month == "May") {
				month = "05";
			}
			if (month == "June") {
				month = "06";
			}
			if (month == "July") {
				month = "07";
			}
			if (month == "August") {
				month = "08";
			}
			if (month == "September") {
				month = "09";
			}
			if (month == "October") {
				month = "10";
			}
			if (month == "November") {
				month = "11";
			}
			if (month == "December") {
				month = "12";
			}
			if (day.length == 1) {
				day = "0" + day;
			}
			document.getElementById('birthdateText').value = year + "-" + month + "-" + day;
		}
	</script>
</body>
</html>