<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="it.beije.oort.bm.library.entity.*" %>
<%@ page import="java.util.List" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
	<body>
		<%User u_ascope = (User)session.getAttribute("user"); 
			if(u_ascope == null){%>
				Please login first.
			<%} else { %>
				<table class="table">
						<tr>
							<th>Id</th>
							<th>Surname</th>
							<th>Name</th>
							<th>Date of birth</th>
							<th>Date of death</th>
							<th>Biography</th>
						</tr>
						<c:forEach items="${data_list}" var="a">
							<tr>
								<td>${a.id}</td>
								<td>${a.surname}</td>
								<td>${a.name}</td>
								<td>${a.dateOfBirth}</td>
								<td>${a.dateOfDeath}</td>
								<td>${a.biography}</td>
							</tr>
						</c:forEach>
				</table>
			<%} %>
	</body>
</html>