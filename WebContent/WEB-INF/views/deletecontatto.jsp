<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteContatto</title>
</head>
<body>
		<h1>Eliminare un contatto!</h1>
		<form action="del" method="POST">
			<fieldset>
			<legend><h3>Inserire ID del contatto da eliminare: </h3></legend><br>
			<label>ID: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="id" type="text"></label><br><br>
			</fieldset>
			<br>
			<button type ="submit"> Conferma e invia!</button> 
		</form>
		<br>
		<form action="h">
			<button type ="submit">Annulla e torna al menu!</button>
		</form>
		<br>
		<form action ="showall" method ="POST">
		<button type ="submit">Visualizza contatti!</button>		
		</form>
	</body>

</html>