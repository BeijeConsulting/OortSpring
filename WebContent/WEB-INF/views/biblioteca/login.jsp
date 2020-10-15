<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
<script src="<c:url value="/resources/js/functions.js" />" type="Application/Javascript"></script>
</head>
<body>
	<c:if test="${ erroreMsg != null }">
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }">
		<div class="isa_success">${ successoMsg }</div>
	</c:if>
	<div class="titolo">Login</div>
	<div class="descrizione">Effettua il login per utilizzare le
		funzionalità del sito.</div>
	<div class="form">
		<form name="loginForm" action="" method="POST">
			<div id="formError"></div>
			<fieldset>
				<div class="campi">
					<label for="emailId">Email:</label><input id="emailId"
						type="email" name="email"> <label for="passwordId">Password:</label><input
						id="passwordId" type="password" name="password">
				</div>
				<div class="formButtons">
					<button class="buttonReset" type="reset">Resetta campi</button>
					<button name="submitContatto" class="buttonSubmit" type="submit" onclick="return validateForm(document.forms['loginForm'])">Login</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>