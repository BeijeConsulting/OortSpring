<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancellazione editore</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Cancellazione editore</div>
<div class="descrizione">Prima di cancellare devi selezionare un id, assicurati che sia l'editore che vuoi cancellare e poi cancella</div>
<div></div>
<div class="form borderForm">
	<form action="./cancellazione_editore" method="POST">
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
				<input id="idInput" type="hidden" name="id" value="${ editore.id }">
				<label>Denominazione:</label>${ editore.denominazione }<br>
				<label>Descrizione:</label>${ editore.descrizione }
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