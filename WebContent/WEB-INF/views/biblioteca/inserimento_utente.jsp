<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento utente</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
<script src="<c:url value="/resources/js/functions.js" />" type="Application/Javascript"></script>
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div id="erroreMsg" class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div id="successoMsg" class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Inserimento utente</div>
<div class="descrizione">Inserisci un utente</div>
<div></div>
<div class="form borderForm">
	<form name="utenteForm" action="./inserimento_utente" method="POST">
		<div id="formError"></div>
		<fieldset>
			<div class="campi">
				<label for="nomeId">Nome:</label><input id="nomeId" type="text" name="nome"><br>
				<label for="cognomeId">Cognome:</label><input id="cognomeId" type="text" name="cognome"><br>
				<label for="codiceFiscaleId">Codice fiscale:</label><input id="codiceFiscaleId" type="text" name="codiceFiscale"><br>
				<label for="emailId">Email:</label><input id="emailId" type="email" name="email"><br>
				<label for="telefonoId">Telefono:</label><input id="telefonoId" type="text" name="telefono"><br>
				<label for="indirizzoId">Indirizzo:</label><input id="indirizzoId" type="text" name="indirizzo">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submit" class="buttonSubmit" type="submit" value="true" onclick="return validateForm(document.forms['utenteForm'])">Inserisci</button>
			</div>
		</fieldset>
	</form>
</div>

</body>
</html>