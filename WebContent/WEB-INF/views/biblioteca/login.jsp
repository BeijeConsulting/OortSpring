<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
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
		<form action="" method="POST">
			<fieldset>
				<div class="campi">
					<label for="emailInput">Email:</label><input id="emailInput"
						type="email" name="email"> <label for="passwordInput">Password:</label><input
						id="passwordInput" type="password" name="password">
				</div>
				<div class="formButtons">
					<button class="buttonReset" type="reset">Resetta campi</button>
					<button name="submitContatto" class="buttonSubmit" type="submit">Login</button>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>