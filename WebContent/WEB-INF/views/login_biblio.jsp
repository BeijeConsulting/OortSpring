<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Oort Biblioteca</title>
</head>
<body>

<c:if test = "${errore != null}">
    <b>${errore}</b></br>
</c:if>
	<h2>Effettuare il login.</h2>
	
		<h3>Inserisci le tue credenziali</h3>
		<form action="./login_biblio" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>

</body>
</html>