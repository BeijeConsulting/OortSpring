<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>${registrationProblem}</h3>
		<%if(session.getAttribute("user") == null) {%>
			<form action="./register" method="post">
			<label for="name">First Name:</label><input type="text" name="name"><br>
			<label for="surname">Last Name:</label><input type="text" name="surname"><br>
			<label for="fc">Fiscal Code:</label><input type="text" name="fc"><br>
			<label for="address">Address:</label><input type="text" name="address"><br>
			<label for="phone">Phone n°:</label><input type="text" name="phone"><br>
			<label for="email">E-mail:</label><input type="email" name="email"><br>
			<label for="password">Password:</label><input type="password" name="password"><br>
			<label for="reg_pswd_conf">Confirm Password:</label><input type="password" name="reg_pswd_conf"><br>
			<input type="submit" value="Send Request">
		</form>
		<%} else { %>
			<h3>You are already logged in!</h3>
		<%} %>
	</body>
		
	</body>
</html>