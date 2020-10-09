<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Autore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica autore</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
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
	<form action="./modifica_autore" method="POST">
		<fieldset>
			<div class="campi">
				<label for="idInput">ID:</label><input id="idInput" type="text" name="idAutore">
			</div>
			<div class="formButtons">
				<button name="submit" class="buttonSubmit" type="submit" value="id">Trova autore</button>
			</div>
		</fieldset>
		<c:if test="${ autore != null }">
		<fieldset>
			<div class="campi">
				<input id="idInput" type="hidden" name="id" value="">
				<label for="nomeInput">Nome:</label><input id="nomeInput" type="text" name="nome" value="${ autore.nome }"><br>
				<label for="cognomeInput">Cognome:</label><input id="cognomeInput" type="text" name="cognome" value="${ autore.cognome }"><br>
				<label for="dataNascitaInput">Data di nascita:</label><input id="dataNascitaInput" type="date" name="dataNascita" value="${ autore.dataNascita }"><br>
				<label for="dataMorteInput">Data di morte:</label><input id="dataMorteInput" type="date" name="dataMorte" value="${ autore.dataMorte }"><br>
				<label for="biografiaInput">Biografia:</label><input id="biografiaInput" type="text" name="biografia" value="${ autore.biografia }">
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