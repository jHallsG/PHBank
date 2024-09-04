<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SignUp</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/phBank-artstyle.css">
</head>

<body>
	<div class="introContainer">
		<img class="phBankImg"
			src="${pageContext.request.contextPath}/images/PHBank.jpg">
		<h1>Create Your PHBank Account</h1>
		<label>Welcome to PHBank, the heart of Filipino banking.
			Proudly created by the Filipino people, for the Filipino people. Your
			trusted partner in financial growth, where every transaction is
			handled with care and integrity. Secure your future with us - because
			at PHBank, your success is our mission.</label>
	</div>
	<div class="loginContainer">
		<form:form action="processSignUp" modelAttribute="s_creds">
			<label for="acctNum"> Account </label>
			<form:input name= "acctNum" type="number" placeholder="Account Number" path="acctNum" required="true"/>
			<form:errors path="acctNum" cssClass="form-error"></form:errors>
			<label for="pass"> Password </label>
			<form:input name="pass" type="password" placeholder="Password" path="password" required="true"/>
			<form:errors path="password" cssClass="form-error"></form:errors>
			<label for="confirmPass"> Confirm Password </label>
			<form:input name = "confirmPass" type="password" placeholder="Confirm Password" path="confirmPassword" required="true"/>
			<form:errors path="confirmPassword" cssClass="form-error"></form:errors>
			<input type="submit" value="Sign Up">
			<label> Already have an account? Login <a href="../login/">here</a>
			</label>
		</form:form>
	</div>
</body>

</html>