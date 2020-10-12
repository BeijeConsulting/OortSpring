<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica editore</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Modifica editore</div>
<div class="descrizione">Prima di modificare devi selezionare un id, poi potrai modificare i valori dell'editore</div>
<div></div>
<div class="form borderForm">
	<form action="./modifica_editore" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idEditoreId">ID:</label><input id="idEditoreId" type="text" name="idEditore" value="${ editore != null ? editore.id : '' }">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="id">Trova editore</button>
			</div>
		</fieldset>
		<c:if test="${ editore != null }">
		<fieldset>
			<div class="campi">
				<input id="idId" type="hidden" name="id" value="${ editore.id }">
				<label for="denominazioneId">Denominazione:</label>
				<input id="denominazioneId" type="text" name="denominazione" value="${ editore.denominazione }"><br>
				<label for="descrizioneId">Descrizione:</label>
				<input id="descrizioneId" type="text" name="descrizione" value="${ editore.descrizione }">
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