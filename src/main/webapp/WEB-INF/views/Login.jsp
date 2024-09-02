<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/phBank-artstyle.css">
</head>

<body>
    <div class="introContainer">
        <img class="phBankImg" src="${pageContext.request.contextPath}/images/PHBank.jpg">
    <h1> Access Your PHBank Account </h1>
    <label>Welcome to PHBank, the heart of Filipino banking. Proudly created by the Filipino people, for the Filipino people.
        Your trusted partner in financial growth, where every transaction is handled with care and integrity.
        Secure your future with usâbecause at PHBank, your success is our mission.</label>
    </div>
    <div class="loginContainer">
        <label> Account </label>
        <input type="text" placeholder="Account Number">
        <label> Password </label>
        <input type="text" placeholder="Password">
        <input type="submit" value="Login">
        <label> No account? Sign Up <a href="#">here</a> </label>
    </div>
</body>

</html>