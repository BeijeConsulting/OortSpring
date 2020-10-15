<%@page import="it.beije.oort.lauria.biblioteca.JPADBtools"%>
<%@page import="it.beije.oort.lauria.biblioteca.Libro"%>
<%@page import="it.beije.oort.lauria.biblioteca.Autore"%>
<%@page import="it.beije.oort.lauria.biblioteca.Editore"%>
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
	<a href="./home_biblio">HOME</a><br>
<%
} else {
	%>
	<a href="./conferma_login">HOME</a><br>
	<%
}
%>

<body>

	<%-- <h3>${utente.nome} ${utente.cognome}</h3> --%>
<%-- <c:if test = "${utente == null}">
	<a href="./home_biblio">HOME</a><br>
</c:if>
<c:if test = "${utente != null}">
	<a href="./conferma_login">HOME</a><br>
</c:if>	 
 --%>
 
<table>
	<h2>Sono presenti ${libri.size()} libri in biblioteca</h2> 
	
<%-- <c:if test = "${!utente.isAdmin()}"> --%>
<%
if (userBean == null || !userBean.isAdmin() ) {
%>

		<tr>
			<th>Id</th>
			<th>Titolo</th>
			<th>Descrizione</th>
			<th>IdAutore</th>
			<th>IdEditore</th>
			<th>Anno</th>
		</tr>

	<c:forEach items="${libri}" var="libro">
		<tr>
			<td>${libro.getId()}</td>
			<td>${libro.getTitolo()}</td>
			<td>${libro.getDescrizione() != null ? libro.getDescrizione() : ""}</td>
			<td>${libro.getId_autore()} (${autori.get(libro.getId_autore()-1).getNome()} ${autori.get(libro.getId_autore()-1).getCognome()})</td>
			<td>${libro.getId_editore()} (${editori.get(libro.getId_editore()-1).getDenominazione()})</td>
			<td>${libro.getAnno()}</td>
		</tr>
	</c:forEach>

<%-- </c:if>

<c:if test = "${utente.isAdmin()}">	
<h2>${utente.nome} ${utente.cognome}</h2> --%>
<%
}else{
%>
		<tr>
			<th>Mod.</th>
			<th>Canc.</th>
			<th>Id</th>
			<th>Titolo</th>
			<th>Descrizione</th>
			<th>Id_autore</th>
			<th>Id_editore</th>
			<th>Anno</th>
		</tr>
		
	<c:forEach items="${libri}" var="libro">
		<tr>
			<td>&#9999;</td>
			<td><a href="./modifica_libro/${libro.getId()}">&#128465;</a></td>
			<td>${libro.getId()}</td>
			<td>${libro.getTitolo()}</td>
			<td>${libro.getDescrizione() != null ? libro.getDescrizione() : ""}</td>
			<td>${libro.getId_autore()} (${autori.get(libro.getId_autore()-1).getNome()} ${autori.get(libro.getId_autore()-1).getCognome()})</td>
			<td>${libro.getId_editore()} (${editori.get(libro.getId_editore()-1).getDenominazione()})</td>
			<td>${libro.getAnno()}</td>
		</tr>
	</c:forEach>
<%-- 	<%
		for (Libro libro : libri) {
		// potrei inserire autore ed editore come ho fatto nelle JPADBtools e scriverli fra parentesi affianco a numero id
	%>

		<tr>		
			<!--  <td><a href="./ModificaBiblio?page=<%=libro.getId()%>">&#9999;</a></td> -->
			<td>&#9999;</td>
			<td><a href="./EliminaLibro?page=<%=libro.getId()%>">&#128465;</a></td>
			<td><%=libro.getId()%></td>
			<td><%=libro.getTitolo()%></td>
			<td><%=libro.getDescrizione() != null ? libro.getDescrizione() : ""%></td>
			<td><%=libro.getId_autore()%> (<%=autori.get(libro.getId_autore()-1).getNome()%> <%=autori.get(libro.getId_autore()-1).getCognome()%>)</td>
			<td><%=libro.getId_editore()%> (<%=editori.get(libro.getId_editore()-1).getDenominazione()%>)</td>
			<td><%=libro.getAnno()%></td>
		</tr>
		<%
		}
	%> --%>
	
<%-- </c:if>
	 --%>
 <%
 }
 %>
		</table>	
		
</body>
</html>