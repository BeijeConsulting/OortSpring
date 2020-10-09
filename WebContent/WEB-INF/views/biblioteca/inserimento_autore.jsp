<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento autore</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
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
	<form action="./inserimento_autore" method="POST">
		<fieldset>
			<div class="campi">
				<label for="nomeInputInserimento">Nome:</label><input id="nomeInputInserimento" type="text" name="nome"><br>
				<label for="cognomeInputInserimento">Cognome:</label><input id="cognomeInputInserimento" type="text" name="cognome"><br>
				<label for="dataNascitaInputInserimento">Data di nascita:</label><input id="dataNascitaInputInserimento" type="date" name="dataNascita"><br>
				<label for="dataMorteInputInserimento">Data di morte:</label><input id="dataMorteInputInserimento" type="date" name="dataMorte"><br>
				<label for="biografiaInputInserimento">Biografia:</label><input id="biografiaInputInserimento" type="text" name="biografia">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submitInserimento" class="buttonSubmit" type="submit" value="true">Inserisci</button>
			</div>
		</fieldset>
	</form>
</div>

</body>
</html>