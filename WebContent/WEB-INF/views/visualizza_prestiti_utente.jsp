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

	<h2>Sono stati registrati ${prestitiUtente.size()} prestiti.</h2>
	<tr>
		<th>Id</th>
		<th>Id_libro</th>	
		<th>Data_inizio</th>
		<th>Data_fine</th>
		<th>Note</th>
	</tr> 
		
	<c:forEach items="${prestitiUtente}" var="prestito">
		<tr>
			<td>${prestito.getId()}</td> 
			<td>${prestito.getId_libro()} (${libri.get(prestito.getId_libro()-1).getTitolo()})</td>
			<td>${prestito.getData_inizio().toString()}</td>
			<td>${prestito.getData_fine().toString()}</td>
			<td>${prestito.getNote() != null ? prestito.getNote() : ""}</td> 
		</tr>
		</c:forEach>
	
		</table>	
</body>
</html>