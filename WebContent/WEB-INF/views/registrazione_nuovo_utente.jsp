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

	<h1 style="text-align:center;"><em>Registrazione utente</em></h1>
	<h3>Inserisci le tue credenziali</h3>
	
	<form action="./registrazione_nuovo_utente" method="post" onsubmit="return Ciao(this)">
	  <label for="nome">Nome:</label>
	  <input type="text" id="nome" name="nome" value=""><br>
	  <label for="cognome">Cognome:</label>
	  <input type="text" name="cognome" value=""><br>
	  <label for="codice_fiscale">Codice fiscale:</label>
	  <input type="text" name="codice_fiscale" value=""><br>
	  <label for="telefono">Telefono:</label>
	  <input type="text" name="telefono" value=""><br>
	  <label for="indirizzo">Indirizzo:</label>
	  <input type="text" name="indirizzo" value=""><br>
	  <label for="email">E-mail:</label>
	  <input type="email" name="email" value=""><br>
	  <label for="password">Password:</label>
	  <input type="password" name="password" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	
	<div id="msgErr" class="msgErr"></div>
	</form>	

<input type="submit" onsubmit="return checkName(this)" value="ciao">

<p id="demo"></p>
</body>

</html>