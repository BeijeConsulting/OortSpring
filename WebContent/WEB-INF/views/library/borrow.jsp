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
			<b>View your borrows</b>
		</legend>

		<form method="GET" action="/OortSpring/library/view-borrows">

			<input type="submit" value="VIEW" />
			
		</form>
		
		<table style="width:100%; text-align:'right'">
		<tr>
			<th>Book</th>
			<!--  <th>User</th> -->
			<th>Date of start</th>
			<th>Date of end</th>
			<th>Note</th>
		</tr>
		<c:forEach items="${records}" var="item">
			<tr>
				<td><a href="/OortSpring/library/book/${item.getBookId()}">${titles.get(item.getId())}</a></td>
				<!-- <td>${item.getUserId()}</td> -->
				<td>${item.getDateOfStart() != null ? item.getDateOfStart() : '/'}</td>
				<td>${item.getDateOfEnd() != null ? item.getDateOfEnd() : '/'}</td>
				<td>${item.getNote()}</td>
			</tr>
		</c:forEach>
	</table>
		
	</fieldset>
	
	<a href="/OortSpring/library/index">Back</a>	
</body>
</html>