<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oort Spring Home</title>
</head>
<body >


	<h1>Menu' Rubrica:</h1>
	
		<form action="ins" method="GET" >
			<button type="submit"> Inserisci contatto</button>
		</form>	
		<br><br>	
		<form action="del" method="GET"> 
			<button type ="submit"> Elimina contatto</button> 
		</form>
		<br><br>
		<form action="show" method="GET">
			<button type="submit">Visualizza contatti</button>
		</form>
		<br><br>
		<form action="modifica" method="GET">
			<button type="submit">Modifica contatto</button>
		</form>
</body>
</html>