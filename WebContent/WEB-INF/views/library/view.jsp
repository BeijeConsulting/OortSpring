<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> -->
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

		<form method="GET" action="./view-records">

			<input type="radio" name="radioValue" value="books" checked="checked" />
			
			<label>Books</label><br> <input type="radio" name="radioValue"
				value="authors" /> <label>Authors</label><br> <input
				type="radio" name="radioValue" value="publishers" /> <label>Publishers</label><br>

			<input type="submit" value="SEARCH" />

		</form>

	</fieldset>

	<!--  
	<c:forEach var="emp" items="${records}">
		<li>${emp}</li>
	</c:forEach>
	-->

</body>
</html>