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
			<b>Visualization</b>
		</legend>

		<form method="GET" action="/OortSpring/library/view-records">

			<input type="radio" name="radioValueCategory" value="books" checked="checked" />
			<label>Books</label><br> 
			<input type="radio" name="radioValueCategory" value="authors" /> 
			<label>Authors</label><br> 
			<input type="radio" name="radioValueCategory" value="publishers" /> 
			<label>Publishers</label><br>

			<input type="submit" value="SEARCH" />

		</form>
		
		<c:if test="${category == 'book'}">
		<table style="width:100%; text-align:'right'">
			<tr>
				<th>Title</th>
				<th>Description</th>
				<th>Author</th>
				<th>Publisher</th>
				<th>Year</th>
			</tr>
			<c:forEach items="${records}" var="item">
				<tr>
					<td>${item.getTitle()}</td>
					<td>${item.getDescription()}</td>
					<td><a href="/OortSpring/library/author/${item.getAuthorId()}">${nominatives.get(item.getId())}</a></td>
					<td><a href="/OortSpring/library/publisher/${item.getPublisherId()}">${names.get(item.getId())}</a></td>
					<td>${item.getYear()}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${category == 'author'}">
		<table style="width:100%; text-align:'right'">
			<tr>
				<th>Name</th>
				<th>Surname</th>
				<th>Date of birth</th>
				<th>Date of death</th>
				<th>Biography</th>
			</tr>
			<c:forEach items="${records}" var="item">
				<tr>
					<td>${item.getName()}</td>
					<td>${item.getSurname()}</td>
					<td>${item.getDateOfBirth() != null ? item.getDateOfBirth() : '/'}</td>
					<td>${item.getDateOfDeath() != null ? item.getDateOfDeath() : '/'}</td>
					<td>${item.getBiography()}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	
	<c:if test="${category == 'publisher'}">
		<table style="width:100%; text-align:'right'">
			<tr>
				<th>Name</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${records}" var="item">
				<tr>
					<td>${item.getName()}</td>
					<td>${item.getDescription()}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	</fieldset>
	
	<a href="/OortSpring/library/index">Back</a>

	<!-- 
	<ul>
		<c:forEach items="${records}" var="item">
    		<li>${item}</li>
		</c:forEach>
	</ul>
	 -->
	
</body>
</html>