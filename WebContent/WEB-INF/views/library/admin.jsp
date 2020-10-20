<%@page import="it.beije.oort.bassanelli.library_application.entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Application</title>
</head>
<body>

	<h3>Library Application</h3>

	<jsp:useBean id="user" class="it.beije.oort.bassanelli.library_application.entity.User" scope="session"></jsp:useBean>
	
	<h5>Hello <%= user.getName() %> <%= user.getSurname() %>, are you admin?  <%= user.getAdmin() ? "Yes" : "No" %> </h5>
	
	<ul>
		<li><a href="/OortSpring/library/profile">Profile</a></li>
		<li><a href="/OortSpring/library/manage/users">Manage users</a></li>
		<li><a href="/OortSpring/library/manage/books">Manage books</a></li>
		<li><a href="/OortSpring/library/manage/authors">Manage authors</a></li>
		<li><a href="/OortSpring/library/manage/publishers">Manage publisher</a></li>
		<li><a href="/OortSpring/library//manage/borrows">Manage borrows</a></li>
	</ul>
	
	<form method="POST" action="/OortSpring/library/logout-user">
		<input type="submit" value="LOGOUT"/>
	</form>

</body>
</html>