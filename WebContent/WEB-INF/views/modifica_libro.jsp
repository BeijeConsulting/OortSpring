<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Oort Biblioteca</title>
</head>
<body>
	<h1><em>Modifica libro: ${idLibro}</em></h1>
	
	<form action="./modifica_libro" method="post">
	  <label for="titolo">Titolo:</label>
	  <input type="text" name="titolo" value=""><br>
	  <label for="descrizione">Descrizione:</label>
	  <input type="text" name="descrizione" value=""><br>
	  <label for="id_autore">Id Autore:</label>
	  <input type="text" name="id_autore" value=""><br>
	  <label for="id_editore">Id Editore:</label>
	  <input type="text" name="id_editore" value=""><br>
	  <label for="anno">Anno:</label>
	  <input type="text" name="anno" placeholder="dd MM yyyy" value=""><br>
	  <input name="insert" type="submit" value="INVIO"/>
	</form>
</body>
</html>