<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>visualizza</title>
</head>
<body>
	<h1>Lista contatti in rubrica:</h1>
		<p align="right">Clicca <a href="h"><mark>QUI</mark></a> per tornare al menu' principale.</p>	
	<c:forEach var="contatti" items="${showall}"> 
    <option value ="10"><c:out value="${contatti}"/></option>
    <br>
</c:forEach>
</body>
</html>