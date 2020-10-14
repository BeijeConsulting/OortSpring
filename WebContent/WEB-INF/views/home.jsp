<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.entity.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Web Library</title>
		<c:url value="/resources/library_style.css" var="libraryCss" />
		<link rel = "stylesheet" type = "text/css" href = "${libraryCss}">
	</head>
	<body>
		<div id = "head">
			<h1>Welcome to Brando's Magical Library</h1>
		</div>
		<div id = "navbar">
			<ul>
				<li>
					<a href="./books">Books</a>
				</li>
				<li>
					<a href="./authors">Authors</a>
				</li>
				<li>
					<a href="./publish">Publishers</a>
				</li>
				<li>
					<a href="./loans">Loans</a>
				</li>
				<% User user = (User) session.getAttribute("user");
				if(user != null && user.getAdmin()){%>
					<li>
						<a href="./users">Users</a>
					</li>
				<%} %>
				<li class = "rightli">
					<a href="./log-in">Login</a>
				</li>
			</ul>
		</div>
		<div id = "content">
			<% String status = (String) session.getAttribute("status");
			if(status != null){
				switch(status){
					case "books":%>
						<%@ include file="books.jsp" %>
						<% break; 
					case "authors":%>
						<%@ include file="authors.jsp" %>
						<% break;
					case "publish":%>
						<%@ include file="publishers.jsp" %>
						<% break;
					case "loans":%>
						<%@ include file="loans.jsp" %>
						<% break;
					case "log-in":%>
						<%@ include file="login.jsp" %>
						<% break;
					case "users":%>
						<%@ include file="users.jsp" %>
						<% break;
					case "register":%>
						<%@ include file="register.jsp" %>
						<% break;
					default:
				}
			}%>
		</div>
	</body>
</html>