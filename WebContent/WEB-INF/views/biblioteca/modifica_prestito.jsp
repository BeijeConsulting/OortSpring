<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica prestito</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Modifica prestito</div>
<div class="descrizione">Prima di modificare devi selezionare un id, poi potrai modificare i valori dell'prestito</div>
<div></div>
<div class="form borderForm">
	<form action="./modifica_prestito" method="POST">
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
				<label for="idLibroId">Libro ID:</label>
				<input id="idLibroId" type="text" name="idLibro" value="${ prestito.idLibro }"><br>
				<label for="idUtenteId">Utente ID:</label>
				<input id="idUtenteId" type="text" name="idUtente" value="${ prestito.idUtente }"><br>
				<label for="dataInizioId">Data inizio:</label>
				<input id="dataInizioId" type="date" name="dataInizio" value="${ prestito.dataInizio }"><br>
				<label for="dataFineId">Data fine:</label>
				<input id="dataFineId" type="date" name="dataFine" value="${ prestito.dataFine }"><br>
				<label for="noteId">Note:</label>
				<input id="noteId" type="text" name="note" value="${ prestito.note }">
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