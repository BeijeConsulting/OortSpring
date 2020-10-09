<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Biblioteca Login</title>
</head>
<body>
		<h3>Inserisci le tue credenziali<br>${localDateTime} - ${country} - ${lingua}</h3>
		<form action="./login" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
		${localDateTime}
		
		<p>${errore}</p>
</body>
</html>