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
		
			<legend><b>Sign in</b></legend>

			<form method="POST" action="/OortSpring/library/signin-user">

				<label>Name: </label>
				<input type="text" name="name"/><br>
				<label>Surname</label> 
				<input type="text" name="surname"/><br>
				<label>Fiscal code</label> 
				<input type="text" name="fiscalCode"/><br>
				<label>Email: </label>
				<input type="text" name="email"/><br>
				<label>Mobile: </label>
				<input type="text" name="mobile"/><br>
				<label>Address: </label>
				<input type="text" name="address"/><br>
				<label>Password: </label> 
				<input type="password" name="password"/><br>

				<input type="submit" value="SIGN IN"/>
			
			</form>
		
		</fieldset>
		
		<h5>${message}</h5>
		
	<a href="/OortSpring/library/index">Back</a>

</body>
</html>