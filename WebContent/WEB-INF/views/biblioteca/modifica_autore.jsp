<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica autore</title>
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

<div class="titolo">Modifica autore</div>
<div class="descrizione">Prima di modificare devi selezionare un id, poi potrai modificare i valori dell'autore</div>
<div></div>
<div class="form borderForm">
	<form name="autoreForm" action="./modifica_autore" method="POST">
		<div id="formError"></div>
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
				<label for="nomeId">Nome:</label><input id="nomeId" type="text" name="nome" value="${ autore.nome }"><br>
				<label for="cognomeId">Cognome:</label><input id="cognomeId" type="text" name="cognome" value="${ autore.cognome }"><br>
				<label for="dataNascitaId">Data di nascita:</label><input id="dataNascitaId" type="date" name="dataNascita" value="${ autore.dataNascita }"><br>
				<label for="dataMorteId">Data di morte:</label><input id="dataMorteId" type="date" name="dataMorte" value="${ autore.dataMorte }"><br>
				<label for="biografiaId">Biografia:</label><input id="biografiaId" type="text" name="biografia" value="${ autore.biografia }">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="modifica" onclick="return validateForm(document.forms['autoreForm'])">Modifica</button>
			</div>
		</fieldset>
		</c:if>
	</form>
</div>

</body>
</html>