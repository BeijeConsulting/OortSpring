<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="it.beije.oort.bm.library.entity.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Web Library</title>
		<c:url value="/resources/library_style.css" var="libraryCss" />
		<c:url value="/resources/navigation.js" var="navJs"/>
		<link rel = "stylesheet" type = "text/css" href = "${libraryCss}">
		<script type="text/javascript" src="${navJs}"></script>
	</head>
	<body>
		<div id = "head">
			<h1>Welcome to Brando's Magical Library</h1>
		</div>
		<div id = "navbar">
			<ul>
				<li>
					<button class="navBtn" onClick='navTo("books")'>Books</button>
				</li>
				<li>
					<button class="navBtn" onClick='navTo("authors")'>Authors</button>
				</li>
				<li>
					<button class="navBtn" onClick='navTo("publishers")'>Publishers</button>
				</li>
				<li>
					<button class="navBtn" onClick='navTo("loans")'>Loans</button>
				</li>
				<% User user = (User) session.getAttribute("user");
				if(user != null && user.getAdmin()){%>
					<li>
						<button class="navBtn" onClick='navTo("users")'>Users</button>
					</li>
				<%} %>
				<li class = "rightli">
					<button class="navBtn" onClick='navTo("login")'>Login</button>
				</li>
			</ul>
		</div>
		<div id = "content">
		</div>
	</body>
</html>