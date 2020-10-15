<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancellazione Utente</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Cancellazione Utente</div>
<div class="descrizione">Prima di cancellare devi selezionare un id, assicurati che sia l'utente che vuoi cancellare e poi cancella</div>
<div></div>
<div class="form borderForm">
	<form action="./cancellazione_utente" method="POST">
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
				<label for="nomeId">Nome:</label>${ utente.nome }<br>
				<label for="cognomeId">Cognome:</label>${ utente.cognome }<br>
				<label for="codiceFiscaleId">Codice fiscale:</label>${ utente.codiceFiscale }<br>
				<label for="emailId">Email:</label>${ utente.email }<br>
				<label for="telefonoId">Telefono:</label>${ utente.telefono }<br>
				<label for="indirizzoId">Indirizzo:</label>${ utente.indirizzo }
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="cancellazione">Cancella</button>
			</div>
		</fieldset>
		</c:if>
	</form>
</div>

</body>
</html>