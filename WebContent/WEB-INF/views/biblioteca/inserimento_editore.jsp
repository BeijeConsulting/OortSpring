<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserimento editore</title>
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

<div class="titolo">Inserimento Editore</div>
<div class="descrizione">Inserisci un editore</div>
<div></div>
<div class="form borderForm">
	<form name="editoreForm" action="./inserimento_editore" method="POST">
		<div id="formError"></div>
		<fieldset>
			<div class="campi">
				<label for="denominazioneId">Denominazione:</label><input id="denominazioneId" type="text" name="denominazione"><br>
				<label for="descrizioneId">Descrizione:</label><input id="descrizioneId" type="text" name="descrizione">
			</div>
			<div class="formButtons">
				<button class="buttonReset" type="reset">Resetta campi</button>
				<button name="submit" class="buttonSubmit" type="submit" value="true" onclick="return validateForm(document.forms['editoreForm'])">Inserisci</button>
			</div>
		</fieldset>
	</form>
</div>

</body>
</html>