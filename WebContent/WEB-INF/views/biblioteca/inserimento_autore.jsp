<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento autore</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
<script src="<c:url value="/resources/js/functions.js" />" type="Application/Javascript"></script>
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Inserimento Autore</div>
<div class="descrizione">Inserisci un autore</div>
<div></div>
<div class="form borderForm">
	<form name="autoreForm" action="./inserimento_autore" method="POST">
		<div id="formError"></div>
		<fieldset>
			<div class="campi">
				<label for="nomeId">Nome:</label><input id="nomeId" type="text" name="nome"><br>
				<label for="cognomeId">Cognome:</label><input id="cognomeId" type="text" name="cognome"><br>
				<label for="dataNascitaId">Data di nascita:</label><input id="dataNascitaId" type="date" name="dataNascita"><br>
				<label for="dataMorteId">Data di morte:</label><input id="dataMorteId" type="date" name="dataMorte"><br>
				<label for="biografiaId">Biografia:</label><input id="biografiaId" type="text" name="biografia">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submitInserimento" class="buttonSubmit" type="submit" value="true" onclick="return validateForm(document.forms['autoreForm'])">Inserisci</button>
			</div>
		</fieldset>
	</form>
</div>

</body>
</html>