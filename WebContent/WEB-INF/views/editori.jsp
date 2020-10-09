<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Editori"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Autori</title>
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
	<h2>Editori</h2>
	<table>
	 <tr>
		<th>ID</th>
		<th>Denominazione</th>
		<th>Descrizione</th>
	</tr>		
<c:forEach var = "i" items="${editori}">
<tr>
    <th><c:out value = " ${i.id}"/></th>
    <th></b><c:out value = " ${i.denominazione}"/></th>
    <th></b><c:out value = " ${i.descrizione}"/></th>
 </tr>
</c:forEach>
	<form action="./Catalogo" method="get">
	<input type="submit" value="CATALOGO" name="Catalogo"/>
	</form>
</body>
</html>