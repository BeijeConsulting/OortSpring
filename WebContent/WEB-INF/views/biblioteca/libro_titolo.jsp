<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.beije.oort.entity.Libro"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libro</title>
</head>
	<body>
	<a href="./homepage">homepage</a><br>
	<h2><em>Ricerca libro tramite titolo:</em></h2>
	
		<h4 style="color:rgb(255, 0, 0);"> ${errore} </h4> 
	
		<form action="./libro_titolo" method = "POST">
			<label for="titolo">TITOLO:</label>
			<input type="text" id="titolo" name="titolo" placeholder="Titolo">
			
			<input type="submit" value="Conferma">
		</form> 
		<br>
		<%
		List<Libro> titoli = (ArrayList)session.getAttribute("titoli");
		if (titoli == null || titoli.size() == 0 ){
		}else {
			%><p>Ecco i titoli trovati:</p><%
			for (int i = 0; i < titoli.size(); i++) {
				out.print(titoli.get(i) + "\n");
			}
		}
		%>
		
	</body>
</html>