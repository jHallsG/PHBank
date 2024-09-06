<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PHBank - Services</title>
    <link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/homepageStyle.css">
</head>

<body>
    <div id="header-placeholder"></div>

    <main class="servicesContainer">
        <h1>Our Services</h1>
        <div class="serviceItems">
        	 <div class="serviceItem" onclick="showPopup('viewBalancePopup')">
                <h2>View Balance</h2>
            </div>
        
            <div class="serviceItem" onclick="showPopup('editAccountPopup')">
                <h2>Edit Account Info</h2>
            </div>
            <div class="serviceItem" onclick="showPopup('depositPopup')">
                <h2>Deposit</h2>
            </div>
            <div class="serviceItem" onclick="showPopup('fundTransferPopup')">
                <h2>Fund Transfer</h2>
            </div>
            <div class="serviceItem" onclick="showPopup('transactionHistoryPopup')">
                <h2>Transaction History</h2>
            </div>
        </div>
    </main>

    <div id="footer-placeholder"></div>
    
    <!-- Pop-up for View Balance Info -->
    <div id="viewBalancePopup" class="popupContainer">
        <div class="popupContent">
            <h2>Current Balance</h2>
            <label>${balance}</label>
            <button onclick="closePopup('viewBalancePopup')">Close</button>
        </div>
    </div>
    
    <!-- Pop-up for Edit Account Info -->
    <div id="editAccountPopup" class="popupContainer">
        <div class="popupContent">
            <h2>Edit Account Info</h2>
            <form:form modelAttribute = "editInfo" action="processAccountInfo" method="POST">
                <label for="editName">Name</label>
                <form:input type="text" path="name" id="editName" name="editName" placeholder="Name" required="true"/>

                <label for="editAddress">Address</label>
                <form:input type="text" path="address" id="editAddress" name="editAddress" placeholder="Address" required="true"/>

				<label for="editContact">Contact Number</label>
                <form:input type="number" path="contact" id="editContact" name="editContact" placeholder="Contact Number" required="true"/>

                <input type="submit" value="Save Changes">
            </form:form>
            <button onclick="closePopup('editAccountPopup')">Close</button>
        </div>
    </div>

    <!-- Pop-up for Deposit -->
    <div id="depositPopup" class="popupContainer">
        <div class="popupContent">
            <h2>Deposit</h2>
            <form:form modelAttribute="deposit" action="processDeposit" method="POST">
                <label for="depositAccountNumber">Account Number</label>
                <form:input path = "acctNum" id="depositAccountNumber" name="depositAccountNumber" placeholder="Account Number" readOnly="true"/>

                <label for="depositAmount">Deposit Amount</label>
                <form:input type="number" path = "amount" id="depositAmount" name="depositAmount" placeholder="Deposit Amount" required="true"/>

                <input type="submit" value="Deposit">
            </form:form>
            <button onclick="closePopup('depositPopup')">Close</button>
        </div>
    </div>

    <!-- Pop-up for Fund Transfer -->
    <div id="fundTransferPopup" class="popupContainer">
        <div class="popupContent">
            <h2>Fund Transfer</h2>
            <form>
                <label for="transferFromAccount">From Account</label>
                <input type="text" id="transferFromAccount" name="transferFromAccount" placeholder="From Account" required>

                <label for="transferToAccount">To Account</label>
                <input type="text" id="transferToAccount" name="transferToAccount" placeholder="To Account" required>

                <label for="transferAmount">Transfer Amount</label>
                <input type="number" id="transferAmount" name="transferAmount" placeholder="Transfer Amount" required>

                <input type="submit" value="Transfer">
            </form>
            <button onclick="closePopup('fundTransferPopup')">Close</button>
        </div>
    </div>

    <!-- Pop-up for Transaction History -->
    <div id="transactionHistoryPopup" class="popupContainer">
        <div class="popupContent">
            <h2>Transaction History</h2>
            <hr>
            <table class="table table-hover">
			<tr>
				<th>Transaction Type</th>
				<th>Amount</th>
				<th>Transaction Date</th>
			</tr>

			<c:forEach var="transaction" items="${transaction}">
				<tr>
					<td>${transaction.type}</td>
					<td>${transaction.amount}</td>
					<td>${transaction.transactionDate}</td>
				</tr>
			</c:forEach>

		</table>
            
            
            
            <button onclick="closePopup('transactionHistoryPopup')">Close</button>
        </div>
    </div>

    <script>
        function showPopup(popupId) {
            document.getElementById(popupId).style.display = 'block';
        }

        function closePopup(popupId) {
            document.getElementById(popupId).style.display = 'none';
        }
    </script>

<script src="${pageContext.request.contextPath}/javascript/insertHeaderFooter.js"></script>
</body>

</html>
