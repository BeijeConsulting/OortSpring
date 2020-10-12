<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica libro</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Modifica libro</div>
<div class="descrizione">Prima di modificare devi selezionare un id, poi potrai modificare i valori dell'libro</div>
<div></div>
<div class="form borderForm">
	<form action="./modifica_libro" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idLibroId">ID:</label><input id="idLibroId" type="text" name="idLibro" value="${ libro != null ? libro.id : '' }">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="id">Trova libro</button>
			</div>
		</fieldset>
		<c:if test="${ libro != null }">
		<fieldset>
			<div class="campi">
				<input id="idId" type="hidden" name="id" value="${ libro.id }">
				<label for="titoloId">Titolo:</label>
				<input id="titoloId" type="text" name="titolo" value="${ libro.titolo }"><br>
				<label for="descrizioneId">Descrizione:</label>
				<input id="descrizioneId" type="text" name="descrizione" value="${ libro.descrizione }"><br>
				<label for="idAutoreId">Autore ID:</label>
				<input id="idAutoreId" type="text" name="idAutore" value="${ libro.idAutore }"><br>
				<label for="idEditoreIdId">Editore ID:</label>
				<input id="idEditoreId" type="text" name="idEditore" value="${ libro.idEditore }"><br>
				<label for="annoId">Anno di pubblicazione:</label>
				<input id="annoId" type="text" name="anno" value="${ libro.anno }">
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