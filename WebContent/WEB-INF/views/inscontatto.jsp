<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InsertContatto</title>
<link rel="stylesheet" href="<c:url value="/assets/css/ins.css" />">
<script type="text/javascript" src="./assets/js/ins.js"/></script>
</head>
<body>
		<h1>Inserire nuovo contatto</h1>
		<div  class="input">
		<form action="ins" method="POST">
			<h3>Dati contatto: </h3><br>
			<label>Nome: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="nome" name="nome" type="text"></label><br><br>
			<label>Cognome: <input id="cognome" name="cognome" type="text"></label><br><br>
			<label>Telefono:  &nbsp;<input id="telefono" name="telefono" type="text"></label><br><br>
			<label>Email: &nbsp;&nbsp;&nbsp;&nbsp; <input id="email" name="email" type="text"></label><br>
			<br>
			<button type ="submit"><span>Conferma e invia</span></button> 
			<button type="button" onclick="clean()"><span>Clean</span></button>
			</form>
		<form action="h">	
			<button type ="submit"><span> Menu principale</span></button>
		</form>
	</div>
</body>
</html>