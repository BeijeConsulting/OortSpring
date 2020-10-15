<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica utente</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
<script src="<c:url value="/resources/js/myJavascript.js" />" type="Application/Javascript"></script>
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Modifica utente</div>
<div class="descrizione">Prima di modificare devi selezionare un id, poi potrai modificare i valori dell'utente</div>
<div></div>
<div class="form borderForm">
	<form action="./modifica_utente" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idUtenteId">ID:</label><input id="idUtenteId" type="text" name="idUtente" value="${ utente != null ? utente.id : '' }">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="id">Trova utente</button>
			</div>
		</fieldset>
		<c:if test="${ utente != null }">
		<fieldset>
			<div class="campi">
				<input id="idId" type="hidden" name="id" value="${ utente.id }">
				<label for="nomeId">Nome:</label>
				<input id="nomeId" type="text" name="nome" value="${ utente.nome }"><br>
				<label for="cognomeId">Cognome:</label>
				<input id="cognomeId" type="text" name="cognome" value="${ utente.cognome }"><br>
				<label for="codiceFiscaleId">Codice fiscale:</label>
				<input id="codiceFiscaleId" type="text" name="codiceFiscale" value="${ utente.codiceFiscale }"><br>
				<label for="emailId">Email:</label>
				<input id="emailId" type="text" name="email" value="${ utente.email }"><br>
				<label for="telefonoId">Telefono:</label>
				<input id="telefonoId" type="text" name="telefono" value="${ utente.telefono }"><br>
				<label for="indirizzoId">Indirizzo:</label>
				<input id="indirizzoId" type="text" name="indirizzo" value="${ utente.indirizzo }">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="modifica">Modifica</button>
			</div>
		</fieldset>
		</c:if>
	</form>
</div>
</body>
</html>