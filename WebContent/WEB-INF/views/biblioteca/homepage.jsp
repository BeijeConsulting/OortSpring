<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>

<!DOCTYPE html>
<html>
	<head>
		<title>LA TUA BIBLIOTECA</title>
		<style>
		</style>
	</head>
	<body>
		<h2>Ciao ${utente.nome} ${utente.cognome}!</h2>
		
		<h2><em>Benvenuto nel menu Biblioteca!</em></h2><br>

		<%
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd - MMMM - yyyy, hh:mm");
		LocalDateTime now = LocalDateTime.now();
		out.println("Oggi: " + now.format(f));
		%>
		
		<br>
		<h4>Selezionare l'operazione che si vuole eseguire:</h4>
		<a href="./libro_id">Cerca Libro tramite Id</a><br>
		<a href="./libro_titolo">Cerca Libro tramite Titolo</a><br>
		<a href="./visualizza_catalogo_autore">Cerca libri per Autore</a><br>
		<a href="./visualizza_catalogo">Visualizza catalogo libri</a>
		
	</body>
</html>
