<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <header class="headerContainer">
        <div class="logoAndWelcome">
            <img class="phBankImg" src="${pageContext.request.contextPath}/images/PHBank.jpg" alt="PHBank Logo">
            <div class="welcomeMessage">
                <h3>Welcome to PHBank,</h3>
                <h4>${custName.name}(${acctNum})</h4>
            </div>
        </div>
        <nav>
            <ul class="navLinks">
                <li><a href="${pageContext.request.contextPath}/home/">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/home/aboutus">About Us</a></li>
                <li><a href="${pageContext.request.contextPath}/home/services/">Services</a></li>
                <li><a href="${pageContext.request.contextPath}/home/contactus">Contact</a></li>
                <li><a href="${pageContext.request.contextPath}/logout/">Logout</a></li>
            </ul>
        </nav>
    </header>
</body>
</html>