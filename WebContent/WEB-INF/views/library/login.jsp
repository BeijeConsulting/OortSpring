<%@page import="it.beije.oort.bassanelli.library_application.entity.User"%>
<%@page import="java.util.List"%>
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

		<fieldset>
		
			<legend><b>Login</b></legend>

			<form method="GET" action="./login-user">

				<label>Email: </label>
				<input type="text" name="email"/><br>
				<label>Password: </label> 
				<input type="password" name="password"/><br>

				<input type="submit" value="LOGIN"/>
			
			</form>
		
		</fieldset>


	<a href="./sign_in">Sign In</a><br>
	<a href="../home.jsp">Back</a>

</body>
</html>