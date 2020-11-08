<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="it.beije.oort.entity.Libro"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Catalogo libri</title>
</head>
	<body>
		<a href="./homepage">homepage</a><br>
			
		<h4>Ecco il catalogo completo dei libri:</h4><br>
		<%
		List<Libro> libri = (ArrayList)session.getAttribute("catalogo");
		if (libri.size() == 0) {
			%><p>Non hai avuto accesso al catalogo libri corretamente</p><%
		} else {
			for (int i = 0; i < libri.size(); i++) {
				out.print(libri.get(i) + "\n <br><br>");
			}
		}
		%>
		
	</body>
</html>