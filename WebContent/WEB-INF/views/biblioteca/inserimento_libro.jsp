<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento libro</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>

	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

<div class="titolo">Inserimento Libro</div>
<div class="descrizione">Inserisci un libro</div>
<div></div>
<div class="form borderForm">
	<form action="./inserimento_libro" method="POST">
		<fieldset>
			<div class="campi">
				<label for="titoloId">Titolo:</label><input id="titoloId" type="text" name="titolo"><br>
				<label for="descrizioneId">Descrizione:</label><input id="descrizioneId" type="text" name="descrizione"><br>
				<label for="idAutoreId">Autore ID:</label><input id="idAutoreId" type="text" name="idAutore"><br>
				<label for="idEditoreId">Editore ID:</label><input id="idEditoreId" type="text" name="idEditore"><br>
				<label for="annoId">Anno pubblicazione:</label><input id="annoId" type="text" name="anno">
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