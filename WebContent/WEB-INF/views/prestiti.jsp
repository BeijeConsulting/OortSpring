<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.oort.sb.biblioteca.Prestiti"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Prestiti Biblioteca</title>
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
<h3>Storico Prestiti Oort Biblioteca</h3>
	<table>
	<tr>
		<th>ID</th>
		<th>Libro</th>
		<th>Utente</th>
		<th>Data Inizio</th>
		<th>Data Fine</th>
		<th>Note</th>
	</tr>	
	
<c:forEach var = "i" items="${prestiti}">
	<tr>
		<td><c:out value= "${i.id}"/></td>
		<td><c:out value= "${libri.get(prestiti.indexOf(i)).getTitolo()}"/></td>
		<td><c:out value= "${utenti.get(prestiti.indexOf(i)).getNome()}"/>
			<c:out value= "${utenti.get(prestiti.indexOf(i)).getCognome()}"/></td>		
		<td><c:out value= "${i.dataInizio}"/></td>
		<td><c:out value= "${i.dataFine}"/></td>
		<td><c:out value= "${i.note}"/></td>
	</tr>
</c:forEach>
	</table>
	<a href="./deleteprestito">DeletePrestito</a>

</body>
</html>