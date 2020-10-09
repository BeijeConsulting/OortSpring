<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.entity.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Web Library</title>
		<link rel = "stylesheet" type = "text/css" href = "library_style.css">
	</head>
	<body>
		<div id = "head">
			<h1>Welcome to Brando's Magical Library</h1>
		</div>
		<div id = "navbar">
			<ul>
				<li>
					<form action="./" method="post">
						<input type="hidden" name="res" value="books">
						<input type="submit" value="Books"/>
					</form>
				</li>
				<li>
					<form action="./" method="post">
						<input type="hidden" name="res" value="authors">
						<input type="submit" value="Authors"/>
					</form>
				</li>
				<li>
					<form action="./" method="post">
						<input type="hidden" name="res" value="publish">
						<input type="submit" value="Publishers"/>
					</form>
				</li>
				<li>
					<form action="./" method="post">
						<input type="hidden" name="res" value="loans">
						<input type="submit" value="Loans"/>
					</form>
				</li>
				<% User user = (User) session.getAttribute("user");
				if(user != null && user.isAdmin()){%>
					<li>
						<form action="./" method="post">
							<input type="hidden" name="res" value="users">
							<input type="submit" value="Users"/>
						</form>
					</li>
				<%} %>
				<li class = "rightli">
					<form action="./" method="post">
						<input type="hidden" name="res" value="login">
						<input type="submit" value="Login"/>
					</form>
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
					case "login":%>
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