<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>I tuoi prestiti</title>
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
<table>
<tr>
	<th>Libro</th>
	<th>Data inizio prestito</th>
	<th>Data restituzione</th>
</tr>
<c:forEach items = "${prestiti}" var = "i" begin = "0">
<c:forEach items = "${libri}" var = "j" begin = "0">
<tr>
	<td><c:out value = "${j.titolo}"/></td>
	<td><c:out value = "${i.data_inizio}"/></td>
	<td><c:out value = "${i.data_fine}"/></td>
</tr>
</c:forEach>
</c:forEach>
</table>
</body>
</html>