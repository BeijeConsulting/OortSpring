<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.oort.entity.Libro"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libro</title>
</head>
	<body>
	<a href="./homepage">homepage</a><br>
	<h2><em>Ricerca libro tramite id:</em></h2>
	
		<h4 style="color:rgb(255, 0, 0);"> ${errore} </h4>
	
		<form action="./libro_id" method = "get">
			<label for="id">ID:</label>
			<input type="text" id="id" name="stringId" placeholder="id">
			
			<input type="submit" value="Conferma">
		</form> 
		<br>
		<%
		Libro libro = (Libro)session.getAttribute("libro");
		if (libro != null) {
		 %>
			<h3> Libro selezionato tramite id: </h3>
			<h4>${libro}</h4>
		<% 
		}
		%>
		
	</body>
</html>