<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oort Spring Home</title>
<link rel="stylesheet" href="<c:url value="/assets/css/main.css" />">
</head>
<body >
 	
	<h1>Menu' Rubrica:</h1>
	<div class="main">
		<form action="ins" method="GET" >
			<button type="submit"> <span>Inserisci contatto</span></button>
		</form>	
		<br><br>	
		<form action="del" method="GET"> 
			<button type ="submit"><span> Elimina contatto</span></button> 
		</form>
		<br><br>
		<form action="show" method="GET">
			<button type="submit"><span>Visualizza contatti</span></button>
		</form>
		<br><br>
		<form action="modifica" method="GET">
			<button type="submit"><span>Modifica contatto</span></button>
		</form>
	</div>		
</body>
</html>