<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/resources/css/biblio.css" />">
<meta charset="ISO-8859-1">
<title>Prova immagine</title>

</head>
<body>

	<h1 style="text-align:center;"><em>Benvenuto nella Oort Biblioteca</em></h1>
	<p style="text-align:center;">
		<a href="./login_biblio" >Login</a></br>
		<a href="./visualizza_libri" >Libri in biblioteca</a>
	</p>
	
	<h2 style="text-align:center;"><em>Non ti sei ancora iscritto al portale?</em></h2>
	<p style="text-align:center;">
		<a href="./registrazione_nuovo_utente">Registrati!</a>
	</p>

</body>
</html>