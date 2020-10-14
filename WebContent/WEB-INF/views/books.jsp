<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.entity.*" %>
<%@ page import="java.util.List" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<%User u_bscope = (User)session.getAttribute("user"); 
		if(u_bscope == null){%>
			Please login first.
		<%} else { %>
			<table class="table">
					<tr>
						<th>Id</th>
						<th>Title</th>
						<th>Author</th>
						<th>Publisher</th>
						<th>Year</th>
						<th>Description</th>
					</tr>
					<c:forEach items="${data_list}" var="b">
						<tr>
							<td>${b.id}</td>
							<td>${b.title}</td>
							<td>${b.author.name} ${b.author.surname}</td>
							<td>${b.publisher.name}</td>
							<td>${b.year}</td>
							<td>${b.description}</td>
						</tr>
					</c:forEach>
			</table>
		<%if(u_bscope.getAdmin()){%>
			<form action="./book/insert" method="post">
				<fieldset>
					<label for="title">Title: </label><input type="text" name="title"><br>
					<label for="author_id">Author: </label><select name="author_id">
						<c:forEach items="${authors}" var="a">
							<option value="${a.id}">${a.name} ${a.surname}</option>
						</c:forEach>
					</select><br>
					<label for="publisher_id">Publisher: </label><select name="publisher_id">
						<c:forEach items="${publishers}" var="p">
							<option value="${p.id}">${p.name}</option>
						</c:forEach>
					</select><br>
					<label for="year">Year: </label><input type="text" name="year"><br>
					<label for="description">Description: </label><input type="text" name="description"><br>
					<input type="submit" value="Add Book">
				</fieldset>
				
			</form>
			<form action="./book/delete" method="post">
				<label for="del_id">Id: </label><select name="del_id">
					<c:forEach items="${data_list}" var="b">
						<option value="${b.id}">${b.title} - ${b.author.name} ${b.author.surname}</option>
					</c:forEach>
				</select><br>
				<input type="submit" value="Remove Book">
			</form>
		<%}
		} %>
	</body>
</html>