<%@page import="it.beije.oort.lauria.biblioteca.Autore"%>
<%@page import="it.beije.oort.lauria.biblioteca.Utente"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

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
<meta charset="ISO-8859-1">
<title>Oort Biblioteca</title>
</head>


<%
Utente userBean = (Utente)session.getAttribute("userBean");
if (userBean == null) {
%>
	<a href="./Login_biblio">HOME</a><br>
<%
} else {
	%>
	<a href="./conferma_login">HOME</a><br>
	<%
}
%>


<body>
<table>

	<h2>Sono stati registrati ${prestiti.size()} prestiti.</h2>
	<tr>
		<th>Mod.</th>
		<th>Canc.</th>
		<th>Id</th>
		<th>Id_libro</th>
		<th>Id_utente</th>		
		<th>Data_inizio</th>
		<th>Data_fine</th>
		<th>Note</th>
	</tr> 
		
	<c:forEach items="${prestiti}" var="prestito">
		<tr>
			<td>&#9999;</td>
			<td><a href="">&#128465;</a></td>
			<td>${prestito.getId()}</td> 
			<td>${prestito.getId_libro()} (${libri.get(prestito.getId_libro()-1).getTitolo()})</td>
			<td>${prestito.getId_utente()} (${utenti.get(prestito.getId_utente()-1).getNome()} ${utenti.get(prestito.getId_utente()-1).getCognome()})</td>
			<td>${prestito.getData_inizio().toString()}</td>
			<td>${prestito.getData_fine().toString()}</td>
			<td>${prestito.getNote() != null ? prestito.getNote() : ""}</td> 
		</tr>
		</c:forEach>
	
		</table>	
</body>
</html>