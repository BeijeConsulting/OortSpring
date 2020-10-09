<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Utenti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Utenti</title>
</head>
<body>
<h3>Utenti Biblioteca Oort</h3>
<c:forEach var = "i" items="${utenti}">
    <b>ID : </b><c:out value = " ${i.id}"/>
    <b>Nome : </b><c:out value = " ${i.nome}"/>
    <b>Cognome : </b><c:out value = " ${i.cognome}"/>
    <b>Telefono : </b><c:out value = " ${i.telefono}"/>
    <b>Email : </b><c:out value = " ${i.email}"/>
   <b>Codice fiscale : </b> <c:out value = " ${i.codice_fiscale}"/><br>
</c:forEach>
	<form action="./NewPrestito" method="get">
	<input type="submit" value="NewPrestito"/>
	</form>
	<form action="./" method="get">
	<input type="submit" value="HOME"/>
	</form>

</body>
</html>