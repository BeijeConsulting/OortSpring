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
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h2>Utenti Biblioteca Oort</h2>
<table>
	 <tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Cognome</th>
		<th>Telefono</th>
		<th>Email</th>
		<th>Codice fiscale</th>		
	</tr>		
<c:forEach var = "i" items="${utenti}">
<tr>
     <td><c:out value = " ${i.id}"/></td>
     <td><c:out value = " ${i.nome}"/></td>
     <td><c:out value = " ${i.cognome}"/></td>
     <td><c:out value = " ${i.telefono}"/></td>
	 <td><c:out value = " ${i.email}"/></td>
	 <td><c:out value = " ${i.codice_fiscale}"/></td>
 </tr>
</c:forEach>
 </table>
	<form action="./NewPrestito" method="get">
	<input type="submit" value="NewPrestito"/>
	</form>
	<form action="./" method="get">
	<input type="submit" value="HOME"/>
	</form>

</body>
</html>