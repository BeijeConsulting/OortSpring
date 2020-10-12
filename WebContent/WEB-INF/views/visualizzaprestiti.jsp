<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Prestiti"%>
<%@page import="it.beije.oort.sb.biblioteca.Utenti"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Storico prestiti</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<%Utenti utente = ((Utenti)session.getAttribute("utente")); %>
<h3>Questi sono i prestiti di <%=utente.getNome()%> <%=utente.getCognome() %></h3>
	<table>
	<tr>
		<th>ID</th>
		<th>Libro</th>
		<th>Data Inizio</th>
		<th>Data Fine</th>
	</tr>	
<% List<Prestiti> list = JPDBtools.ricercaPrestitiId("utente",utente.getId());
	for(Prestiti p : list) { %>
	<tr>
		<td><%=p.getId() %></td>
		<td><%=JPDBtools.ricercaLibro(p.getLibro()).getTitolo() %></td>
		<td><%=p.getData_inizio() %></td>
		<td><%=p.getData_fine() %></td>
	</tr>
	<%}%>
	</table>
	<form action="./" method="get">
	<input type="submit" value="HOME" name="Menu">
	</form>

</body>
</html>