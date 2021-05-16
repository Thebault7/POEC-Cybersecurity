<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Acme login page</title>
<link rel="stylesheet" type="text/css" href="css/login.css">

</head>
<body>
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form:form class="login100-form validate-form"
					action="app/checkLogin" method="POST" modelAttribute="Employee">
					<span class="login100-form-title p-b-26"> Welcome </span>
					<span class="login100-form-title p-b-48"> <img
						src="<%=request.getContextPath()%>/img/Logo_BuFaLo.png" />
					</span>

					<div class="wrap-input100 validate-input"
						data-validate="Valid email is: a@b.c">
						<form:input class="input100" type="text" path="email" />
						<span class="focus-input100" id="email-text"
							data-placeholder="Email"></span>
					</div>

					<div class="wrap-input100 validate-input"
						data-validate="Enter password">
						<span class="btn-show-pass"> </span>
						<form:input class="input100" type="password" path="password" />
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" type="submit">Login</button>
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1"> Forgot password ? </span> <a class="txt2"
							href="#"> Click here </a>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function hideMovingText(id) {
			let textZone = document.getElementById(id);
			console.log(textZone);
		}
		hideMovingText("email-text");
	</script>
</body>
</html>