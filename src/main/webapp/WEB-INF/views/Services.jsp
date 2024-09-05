<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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

    <!-- Pop-up for Edit Account Info -->
    <div id="editAccountPopup" class="popupContainer">
        <div class="popupContent">
            <h2>Edit Account Info</h2>
            <form:form>
                <label for="editName">Name</label>
                <input type="text" id="editName" name="editName" placeholder="Name" required>

                <label for="editAddress">Address</label>
                <input type="text" id="editAddress" name="editAddress" placeholder="Address" required>

				<label for="editContact">Contact Number</label>
                <input type="number" id="editContact" name="editContact" placeholder="Contact Number" required>

                <input type="submit" value="Save Changes">
            </form:form>
            <button onclick="closePopup('editAccountPopup')">Close</button>
        </div>
    </div>

    <!-- Pop-up for Deposit -->
    <div id="depositPopup" class="popupContainer">
        <div class="popupContent">
            <h2>Deposit</h2>
            <form>
                <label for="depositAccountNumber">Account Number</label>
                <input type="text" id="depositAccountNumber" name="depositAccountNumber" placeholder="Account Number" required>

                <label for="depositAmount">Deposit Amount</label>
                <input type="number" id="depositAmount" name="depositAmount" placeholder="Deposit Amount" required>

                <input type="submit" value="Deposit">
            </form>
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
            <form>
                <label for="historyAccountNumber">Account Number</label>
                <input type="text" id="historyAccountNumber" name="historyAccountNumber" placeholder="Account Number" required>

                <label for="historyDateRange">Date Range</label>
                <input type="text" id="historyDateRange" name="historyDateRange" placeholder="Date Range" required>

                <input type="submit" value="View History">
            </form>
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
