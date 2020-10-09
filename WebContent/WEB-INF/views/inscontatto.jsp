<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>InsertContatto</title>
</head>
<body background="sfondo.jgp">
		<h1>Inserire nuovo contatto!</h1>
		<form action="ins" method="POST">
			<fieldset>
			<legend><h3>Dati contatto: </h3></legend><br>
			<label>Nome: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="nome" type="text"></label><br><br>
			<label>Cognome: <input name="cognome" type="text"></label><br><br>
			<label>Telefono:  &nbsp;<input name="telefono" type="text"></label><br><br>
			<label>Email: &nbsp;&nbsp;&nbsp;&nbsp; <input name="email" type="text"></label><br>
			</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
		</form>
		<br>
		<form action="h">	
			<button type ="submit"> Annulla e torna al menu'!</button>
		</form>
			
</body>
</html>