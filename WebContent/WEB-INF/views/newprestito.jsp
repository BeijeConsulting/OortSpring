<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Prestito</title>
</head>
<body>
		<form action="./catalogo" method="get">
		<input type="submit" value="CatalogoLibri" name ="Catalogo">
		</form>
		<form action="./catalogoutenti" method="get">
		<input type="submit" value="ListaUtenti">
		</form>
<form action="./newprestito" method="post">
	ID UTENTE <input type="text" value="" name="utente" placeholder="1"/><br>
	ID LIBRO <input type="text" value="" name="libro" placeholder="1"/><br>
	NOTE <input type="text" value="" name="note" placeholder="info"/><br>
	DATA INIZIO <input type="text" value=""  name="dataInizio" placeholder="yyyy-MM-dd"/>
	DATA FINE <input type="text" value="" name="dataFine" placeholder="yyyy-MM-dd"/><br>
	<input type="submit" value="INVIO"/> <input type="reset" value="ANNULLA"/>
</form>
<a href="./">HOME</a>
</body>
</html>