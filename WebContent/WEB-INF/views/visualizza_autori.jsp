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

	<h2>Sono presenti ${autori.size()} autori di libri nel catalogo della biblioteca</h2>

<%
if (!userBean.isAdmin() ) {
%>
	
	<tr>
		<th>Id</th>
		<th>Cognome</th>
		<th>Nome</th>
		<th>Data_nascita</th>
		<th>Data_morte</th>
		<th>Biografia</th>
	</tr>
	
	<c:forEach items="${autori}" var="autore">
		<tr>
			<td>${autore.getId()}</td>
			<td>${autore.getCognome()}</td>
			<td>${autore.getNome()}</td>
			<td>${autore.getData_nascita().toString()}</td>
			<td>${autore.getData_morte().toString()}</td>
			<td>${autore.getBiografia() != null ? autore.getBiografia() : ""}</td>
		</tr>
	</c:forEach>
<%
}else{
%>
	<tr>
		<th>Mod.</th>
		<th>Canc.</th>
		<th>Id</th>
		<th>Cognome</th>
		<th>Nome</th>
		<th>Data_nascita</th>
		<th>Data_morte</th>
		<th>Biografia</th>
	</tr>
	<c:forEach items="${autori}" var="autore">
		<tr>
			<td>&#9999;</td>
			<td><a href="./EliminaLibro/${autore.getId()}">&#128465;</a></td>
			<td>${autore.getId()}</td>
			<td>${autore.getCognome()}</td>
			<td>${autore.getNome()}</td>
			<td>${autore.getData_nascita().toString()}</td>
			<td>${autore.getData_morte().toString()}</td>
			<td>${autore.getBiografia() != null ? autore.getBiografia() : ""}</td>
		</tr>
		</c:forEach>
<%
 }
 %>		
		</table>	
</body>
</html>