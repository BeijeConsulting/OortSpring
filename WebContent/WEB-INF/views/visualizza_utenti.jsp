<%@page import="it.beije.oort.lauria.biblioteca.Autore"%>
<%@page import="it.beije.oort.lauria.biblioteca.Utente"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/biblio.css" />">

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

	<h2>Sono presenti ${utenti.size()} autori di libri nel catalogo della biblioteca</h2>
	<tr>
		<th>Mod.</th>
		<th>Canc.</th>
		<th>Id</th>
		<th>Nome</th>
		<th>Cognome</th>		
		<th>Codice_fiscale</th>
		<th>Telefono</th>
		<th>Indirizzo</th>
		<th>Tipologia</th>
		<th>E-mail</th>
	</tr>
	<c:forEach items="${utenti}" var="utente">
		<tr>
			<td>&#9999;</td>
			<td><a href="">&#128465;</a></td>
			<td>${utente.getId()}</td>
			<td>${utente.getNome()}</td>
			<td>${utente.getCognome()}</td>
			<td>${utente.getCodice_fiscale()}</td>
			<td>${utente.getTelefono()}</td>
			<td>${utente.getIndirizzo() != null ? utente.getIndirizzo() : ""}</td>
			<td>${utente.isAdmin()}</td>
			<td>${utente.getEmail()}</td>
		</tr>
		</c:forEach>
	
		</table>	
</body>
</html>