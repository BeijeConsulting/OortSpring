<%@page import="it.beije.oort.bassanelli.library_application.entity.User"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Library Application</title>

	<link href='<c:url value="/resources/theme/css/style.css" />' rel="stylesheet"/>
	<script src='<c:url value="/resources/theme/js/main.js" />' type="text/javascript"></script>

</head>

<body>

	<h3>Library Application</h3>

	<div class="main">

	
	<fieldset>

		<legend><b>Login</b></legend>

			<form method="GET" action="/OortSpring/library/login-user" onsubmit="checkInputBox(this)">

				<label>Email: </label>
				<input id="emailBox" type="text" name="email" /><br>
				<label>Password: </label>
				<input id="passwordBox" type="password" name="password" /><br>

				<input type="submit" value="LOGIN" />

			</form>

			<h5>${message}</h5>

			<div id="msgLogin" class="msg"></div>

	</fieldset>

	</div>

	<a href="/OortSpring/library/sign_in">Sign In</a><br>
	<a href="/OortSpring/home">Back</a>

</body>

</html>