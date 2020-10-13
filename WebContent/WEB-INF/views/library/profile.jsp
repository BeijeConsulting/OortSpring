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
	
	<p><b>Profile:  <%= user.getName() %> <%= user.getSurname() %> </b></p>
		
	<form method="POST" action="/OortSpring/library/edit-user">
		
		<!-- <input type="hidden" name="id" value=<jsp:getProperty property="id" name="user"/>><br> -->
		<label>Name: </label>
		<input type="text" name="name" value=<%= user.getName() %> ><br>
		<label>Surname: </label> 
		<input type="text" name="surname" value=<%= user.getSurname() %> ><br>
		<label>Fiscal code: </label> 
		<input type="text" name="fiscal_code" value=<%= user.getFiscalCode() %> disabled><br>
		<!-- <input type="hidden" name="fiscal_code" value=<%= user.getFiscalCode() %>> -->
		<label>Mobile: </label> 
		<input type="text" name="mobile" value=<%= user.getMobile() %> ><br>
		<label>Email: </label> 
		<input type="text" name="email" value=<%= user.getEmail() %> disabled><br>
		<!-- <input type="hidden" name="email" value=<%= user.getEmail() %>> -->
		<label>Address: </label> 
		<input type="text" name="address" value=<%= user.getAddress() %> ><br>
		<label>Password: </label> 
		<input type="text" name="password" value=<%= user.getPassword() %>><br>
		<%
			if(user.getAdmin()) {
				%>
					<label>Admin: Yes</label><br>
				<%
			} else {
				%>
					<label>Admin: No</label><br>
				<%
			}
		%>
		
		<input type="submit" value="EDIT"/>
		
		<h5>${message}</h5>
		
	</form>

	<a href="/OortSpring/library/index">Back</a>

</body>
</html>