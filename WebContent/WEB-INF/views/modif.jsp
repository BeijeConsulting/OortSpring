<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:if test="${id==null}">
		<h1>Modificare un contatto!</h1>
		<form action="" >
			<fieldset>
			<legend><h3>Inserire ID del contatto da modificare: </h3></legend><br>
			<label>ID: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="id" type="text"></label><br><br>
			</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
		</form>
		<br>
		<form action="h">
			<button type ="submit">Annulla e torna al menu!</button>
		</form>
		<br>
		<form action ="showall" method ="POST">
		<button type ="submit">Visualizza contatti!</button>	
		</form>
		</c:if>
		<c:if test="${id!=null}">
			<h1>Inserire dati contatto da modificare!</h1>
			<form action="modifica" method="POST">
			
			<fieldset>
			<legend><h3>Dati contatto: </h3></legend><br>
			<input id="idInput" type="hidden" name="id" value="${id }">
			<label>Nome: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="nome" type="text"></label><br><br>
			<label>Cognome: <input name="cognome" type="text"></label><br><br>
			<label>Telefono:  &nbsp;<input name="telefono" type="text"></label><br><br>
			<label>Email: &nbsp;&nbsp;&nbsp;&nbsp; <input name="email" type="text"></label><br>
			</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
		</form>
		<br>
		<form action="h">
			<button type ="submit">Annulla e torna al menu!</button>
		</form>
		</c:if>
	</body>
</html>