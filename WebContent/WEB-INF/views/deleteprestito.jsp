<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancella Prestito</title>
</head>
<body>
	<h4> ${messaggio} </h4>
	<a href="./prestiti">Prestiti OortBiblioteca</a>	
	<h4>Inserisci l'id del prestito da cancellare</h4>
	<form action="./deleteprestito" method="POST">
	ID PRESTITO<input type="text" name="id" value="" placeholder="1"/>
	<input type="submit" value="CONFERMA"/><input type="reset" value="ANNULLA">
	</form>
	<a href="./">HOME</a>
</body>
</html>