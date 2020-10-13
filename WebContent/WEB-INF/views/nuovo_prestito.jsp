<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nuovo Prestito</title>
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
      <th>Titolo</th>
      <th>Descrizione</th>
      <th>Anno</th>
    </tr>
<c:forEach items = "${libri}" var = "i" begin = "0">
	<tr>
	<td><c:out value = "${i.titolo}"/></td>
	<td><c:out value = "${i.descrizione}"/></td>
	<td><c:out value = "${i.anno}"/></td>
	</tr>
</c:forEach>
  </table>
</body>
</html>