<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.entity.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h3>${loginError}</h3>
		<%if(session.getAttribute("user") == null) {%>
			<form action="./login" method="post">
				<label for="email">Insert email:</label><input type="email" name="email" placeholder="${tmpEmail}"/><br>
				<label for="password">Insert password:</label><input type="password" name="password" value=""/><br>
				<input type="submit" value="Login"/>
			</form>
			<p>You don't have an account yet? <a href="./register">Register!</a></p>
		<%} else { 
			User u_login_scope = (User)session.getAttribute("user");%>
			<p>Autentication successfull!</p><br>
			First name: <%= u_login_scope.getName() %> <br>
			Last name: <%= u_login_scope.getSurname() %> <br>
			Address: <%= u_login_scope.getAddress() %> <br>
			Phone n°: <%= u_login_scope.getPhone() %> <br>
			E-mail: <%= u_login_scope.getEmail() %> <br>
		<%} %>
	</body>
</html>