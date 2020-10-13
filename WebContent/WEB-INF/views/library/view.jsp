<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Application</title>
</head>
<body>

	<h3>Library Application</h3>

	<fieldset>

		<legend>
			<b>View books</b>
		</legend>

		<form method="GET" action="/OortSpring/library/view-records">

			<input type="radio" name="radioValue" value="books" checked="checked" />
			<label>Books</label><br> 
			<input type="radio" name="radioValue" value="authors" /> 
			<label>Authors</label><br> 
			<input type="radio" name="radioValue" value="publishers" /> 
			<label>Publishers</label><br>

			<input type="submit" value="SEARCH" />

		</form>

	</fieldset>
	
	<a href="/OortSpring/library/index">Back</a>

	<!--  
	<c:forEach var="emp" items="${records}">
		<li>${emp}</li>
	</c:forEach>
	-->
	<ul>
		<c:forEach items="${records}" var="item">
    		<li>${item}</li>
		</c:forEach>
	</ul>
	
</body>
</html>