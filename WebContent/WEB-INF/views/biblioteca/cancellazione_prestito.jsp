<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancellazione prestito</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Cancellazione prestito</div>
<div class="descrizione">Prima di cancellare devi selezionare un id, assicurati che sia il prestito che vuoi cancellare e poi cancella</div>
<div></div>
<div class="form borderForm">
	<form action="./cancellazione_prestito" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idPrestitoId">ID:</label><input id="idPrestitoId" type="text" name="idPrestito" value="${ prestito != null ? prestito.id : '' }">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="id">Trova prestito</button>
			</div>
		</fieldset>
		<c:if test="${ prestito != null }">
		<fieldset>
			<div class="campi">
				<input id="idId" type="hidden" name="id" value="${ prestito.id }">
				<label for="idLibroId">Libro ID:</label>${ prestito.idLibro }<br>
				<label for="idUtenteId">Utente ID:</label>${ prestito.idUtente }<br>
				<label for="dataInizioId">Data inizio:</label>${ prestito.dataInizio }<br>
				<label for="dataFineId">Data fine:</label>${ prestito.dataFine }<br>
				<label for="noteId">Note:</label>${ prestito.note }
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