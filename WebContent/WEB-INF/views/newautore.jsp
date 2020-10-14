<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Autore</title>
</head>
<body>
<form action="./newautore" method="post">
	NOME <input type="text" value="" name="nome" placeholder="Dante"/><br>
	COGNOME <input type="text" value="" name="cognome" placeholder="Alighieri"/><br>
	DATA DI NASCITA <input type="text" value="" name="dataDiNascita" placeholder="yyyy-MM-dd"/><br>
	DATA DI MORTE <input type="text" value=""  name="dataDiMorte" placeholder="yyyy-MM-dd"/>
	BIOGRAFIA <input type="text" value="" name="biografia" placeholder="info"/><br>
	<input type="submit" value="INVIO"/> <input type="reset" value="ANNULLA"/>
</form>
<a href="./">HOME</a>
</body>
</html>