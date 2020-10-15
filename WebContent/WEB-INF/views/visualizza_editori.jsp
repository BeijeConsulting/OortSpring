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
<script type="application/Javascript" src="<c:url value="/resources/js/biblioJs.js" />"></script>

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

	<h2>Sono presenti ${editori.size()} editori di libri nel catalogo della biblioteca</h2>

<%
if (!userBean.isAdmin() ) {
%>
	
	<tr>
		<th>Id</th>
		<th>Denominazione</th>
		<th>Descrizione</th>
	</tr>
	
	<c:forEach items="${editori}" var="editore">
		<tr>
			<td>${editore.getId()}</td>
			<td>${editore.getDenominazione()}</td>
			<td>${editore.getDescrizione() != null ? editore.getDescrizione() : ""}</td>
		</tr>
	</c:forEach>
<%
}else{
%>
	<tr>
		<th>Mod.</th>
		<th>Canc.</th>
		<th>Id</th>
		<th>Denominazione</th>
		<th>Descrizione</th>
	</tr>
	<c:forEach items="${editori}" var="editore">
		<tr>
			<td>&#9999;</td>
			<td><a href="">&#128465;</a></td>
			<td>${editore.getId()}</td>
			<td>${editore.getDenominazione()}</td>
			<td>${editore.getDescrizione() != null ? editore.getDescrizione() : ""}</td>
		</tr>
		</c:forEach>
<%
 }
 %>		
		</table>	
</body>
</html>