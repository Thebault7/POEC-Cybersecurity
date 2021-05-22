<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
			<form:label path="postalCode">Customer postal code : </form:label>
			<form:input path="postalCode" />
		</div>
		<div>
			<form:label path="email">Customer email : </form:label>
			<form:input path="email" />
		</div>
		<div>
			<form:label path="phoneNumber">Customer phone number : </form:label>
			<form:input path="phoneNumber" />
		</div>
		<div>
			<form:label path="phoneNumber">Customer birthdate : </form:label>
			<fmt:formatDate value="${customer.birthdate}" type="date"
				pattern="yyyy-MM-dd" var="theFormattedDate" />
			<form:input path="birthdate" />
		</div>
		<button type="submit">Add customer</button>
	</div>
	
	
	
	<c:set var="now" value="<%=new java.util.Date()%>" />
	<p>
		Formatted Date (2):
		<fmt:formatDate type="date" value="${now}" />
	</p>
	<p>
		Formatted Date (7):
		<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />
	</p>
</body>
</html>