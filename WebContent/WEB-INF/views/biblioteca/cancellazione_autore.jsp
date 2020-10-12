<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancellazione autore</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Cancellazione autore</div>
<div class="descrizione">Prima di cancellare devi selezionare un id, assicurati che sia l'autore che vuoi cancellare e poi cancella</div>
<div></div>
<div class="form borderForm">
	<form action="./cancellazione_autore" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idInput">ID:</label><input id="idInput" type="text" name="idAutore" value="${ autore != null ? autore.id : '' }">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="id">Trova autore</button>
			</div>
		</fieldset>
		<c:if test="${ autore != null }">
		<fieldset>
			<div class="campi">
				<input id="idInput" type="hidden" name="id" value="${ autore.id }">
				<label for="nomeInput">Nome:</label>${ autore.nome }<br>
				<label for="cognomeInput">Cognome:</label>${ autore.cognome }<br>
				<label for="dataNascitaInput">Data di nascita:</label>${ autore.dataNascita }<br>
				<label for="dataMorteInput">Data di morte:</label>${ autore.dataMorte }<br>
				<label for="biografiaInput">Biografia:</label>${ autore.biografia }
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