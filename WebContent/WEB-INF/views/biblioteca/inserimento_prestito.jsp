<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento prestito</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Inserimento Prestito</div>
<div class="descrizione">Inserisci un prestito</div>
<div></div>
<div class="form borderForm">
	<form action="./inserimento_prestito" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idLibroId">Libro ID:</label><input id="idLibroId" type="text" name="idLibro"><br>
				<label for="idUtenteId">Utente ID:</label><input id="idUtenteId" type="text" name="idUtente"><br>
				<label for="dataInizioId">Data inizio:</label><input id="dataInizioId" type="date" name="dataInizio"><br>
				<label for="dataFineId">Data fine:</label><input id="dataFineId" type="date" name="dataFine"><br>
				<label for="noteId">Note:</label><input id="noteId" type="text" name="note">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submit" class="buttonSubmit" type="submit" value="true">Inserisci</button>
			</div>
		</fieldset>
	</form>
</div>

</body>
</html>