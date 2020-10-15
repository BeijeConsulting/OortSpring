<%@ page import="it.beije.oort.lauria.biblioteca.Utente"%>
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
<body>

<%-- 
<c:if test = "${utente == null}">
    <b>DEVI EFFETTUARE L'AUTENTICAZIONE</b></br>
	<a href="./login_biblio" >Login</a>
</c:if>
<c:if test = "${utente != null}">
	<c:if test = "${!utente.isAdmin()}">
	 --%>
	
<%
Utente userBean = (Utente)session.getAttribute("userBean");

if (userBean == null) {
%>
	<b>DEVI EFFETTUARE L'AUTENTICAZIONE</b></br>
	<a href="./login_biblio" >Login</a>
<%
} else if(userBean != null && !userBean.isAdmin()) {
%>
	<%-- <h1>Benvenuto ${utente.nome} ${utente.cognome}</h1>  --%>
	<h1>Benvenuto <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></h1>
		
		<p><a href="./logout">Esci</a></p>
		
		<h2>Visualizzazione</h2>
		
		<ul>
			<a href="./visualizza_libri" ><li>Libri in biblioteca</li></a>
			<a href="./visualizza_autori" ><li>Catalogo autori</li></a>
			<a href="./visualizza_editori" ><li>Catalogo editori</li></a>
			<a href="./visualizza_prestitiUtente" ><li>I tuoi prestiti</li></a>
		</ul>
		
		<h2>Ricerca per id</h2>
		
		<ul>
			<a href="./Ricerca?page=libro" ><li>Ricerca libro per id</li></a>
		</ul>
		
		<!-- RICERCA -->
		
		
<%
}else {
%>

<%-- </c:if>
<c:if test = "${utente.isAdmin()}"> --%>

		<%-- <h1>Benvenuto ${utente.nome} ${utente.cognome}</h1> --%>
		<h1>Benvenuto <%= (userBean.getNome() != null) ? userBean.getNome() : "" %> <%= (userBean.getCognome() != null) ? userBean.getCognome() : "" %></h1>
		
		<p><a href="./logout">Esci</a></p>
		
		<h2>Visualizzazione</h2>
		
		<ul>
			<a href="./visualizza_libri" ><li>Libri in biblioteca</li></a>
			<a href="./visualizza_autori" ><li>Catalogo autori</li></a>
			<a href="./visualizza_editori" ><li>Catalogo editori</li></a>
			<a href="./visualizza_utenti" ><li>Elenco utenti registrati</li></a>
			<a href="./visualizza_prestiti" ><li>Elenco prestiti</li></a>
		</ul>
		
		<h2>Inserimento</h2>
		
		<ul>
			<a href="./Inserimento?page=libro" ><li>Registra libro</li></a>
			<a href="./Inserimento?page=autore" ><li>Registra autore</li></a>
			<a href="./Inserimento?page=editore" ><li>Registra editore</li></a>
			<a href="./Inserimento?page=utente" ><li>Registra utente</li></a>
			<a href="./Inserimento?page=prestito" ><li>Registra prestito</li></a>
		</ul>
		
		<h2>Ricerca per id</h2>
		
		<ul>
			<a href="./Ricerca?page=libro" ><li>Ricerca libro per id</li></a>
		</ul>
		<!-- ELIMINAZIONE E RICERCA -->
		
<%-- 	</c:if>
 </c:if> --%>
 
<%		
}
%>
 
</body>
</html>