<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/phBank-artstyle.css">
<link rel = "icon" type ="image/png" href = "${pageContext.request.contextPath}/images/PHBank_favicon.png">
</head>

<body>
	<div class="introContainer">
		<img class="phBankImg"
			src="${pageContext.request.contextPath}/images/PHBank.jpg">
		<h1>Access Your PHBank Account</h1>
		<label>Welcome to PHBank, the heart of Filipino banking.
			Proudly created by the Filipino people, for the Filipino people. Your
			trusted partner in financial growth, where every transaction is
			handled with care and integrity. Secure your future with us - because
			at PHBank, your success is our mission.</label>
	</div>
	<div class="loginContainer">
		<form:form action="processLogin" modelAttribute="creds">
			<c:if test="${param.error != null}">
				<i class="error-message">Bad Credentials</i>
			</c:if>
			
			<label for="acct"> Account </label>
			<form:input type="number" name = "acct" placeholder="Account Number" path="acctNum" required="true"></form:input>
			<form:errors path = "acctNum" cssClass="form-error"></form:errors>
			<label for="pass"> Password </label>
			<form:input type="password" name = "pass" placeholder="Password" path="password" required="true"></form:input>
			<form:errors path = "password" cssClass="form-error"></form:errors>
			<input type="submit" value="Login">
			<label> No account? Sign Up <a href="../signup/">here</a></label>
		</form:form>
	</div>
	
	<input type="hidden" id="registrationSuccess" value="${registrationMessage}" />
	<script src="${pageContext.request.contextPath}/javascript/messages.js"></script>
</body>

</html>