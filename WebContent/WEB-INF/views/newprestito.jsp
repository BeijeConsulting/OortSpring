<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Prestito</title>
</head>
<body>
		<form action="./Catalogo" method="get">
		<input type="submit" value="CatalogoLibri" name ="Catalogo">
		</form>
		<form action="./CatalogoUtenti" method="get">
		<input type="submit" value="ListaUtenti" name ="CatalogoUtenti">
		</form>
<form action="./NewPrestito" method="post">
	ID UTENTE <input type="text" value="" name="utente" placeholder="1"/><br>
	ID LIBRO <input type="text" value="" name="libro" placeholder="1"/><br>
	NOTE <input type="text" value="" name="note" placeholder="info"/><br>
	DATA INIZIO <input type="text" value=""  name="DataInizio" placeholder="yyyy-MM-dd"/>
	DATA FINE <input type="text" value="" name="DataFine" placeholder="yyyy-MM-dd"/><br>
	<input type="submit" value="INVIO"/> <input type="reset" value="ANNULLA"/>
</form>
</body>
</html>