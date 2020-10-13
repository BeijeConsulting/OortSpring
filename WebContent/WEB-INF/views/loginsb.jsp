<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
		${errore}
		<h3>Inserisci le tue credenziali</h3>
		<form action="./Login" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
		<h4>Se vuoi visualizzare il catalogo</h4>		
		<form action="./Catalogo" method="get">
		<input type="submit" value="CATALOGO">
		</form>
		
</body>
</html>