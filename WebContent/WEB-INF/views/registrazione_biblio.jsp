<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html>
	<head>
		<title>Registrazione</title>
		<style>
		</style>
	</head>
	<body>
		<h3>INSERISCI I DATI</h3>
		<form action="./signin" method="post">
			COGNOME&nbsp;<input type="text" name="cognome" value="" placeholder = "campo obbligatorio"/><br>
 			NOME&nbsp;<input type="text" name="nome" value="" placeholder = "campo obbligatorio"/><br>
 			EMAIL&nbsp;<input type="email" name="email" value="" placeholder = "campo obbligatorio"/><br>
 			TELEFONO&nbsp;<input type="text" name="telefono" value=""/><br>
 			CF&nbsp;<input type="text" name="codice_fiscale" value=""/><br>
 			INDIRIZZO&nbsp;<input type="text" name="indirizzo" value=""/><br>
 			PASSWORD&nbsp;<input type="password" name="password" value="" placeholder = "campo obbligatorio"/><br>
			<input type="submit" value="INVIO"/>
		</form>
		<h4>${errore}</h4>
	</body>
</html>