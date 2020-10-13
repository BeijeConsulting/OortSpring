<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Effettua il login</title>
</head>
<body>
	<h3>INSERISCI LE TUE CREDENZIALI</h3>
	<form action="./login" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="utente@dominio"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form><br/>
<p><h4>${errore}</h4>
<h4>${confermaRegistrazione}</h4></p>
<%-- <p><h4>${confermaRegistrazione}</h4></p> --%>
</body>
</html>