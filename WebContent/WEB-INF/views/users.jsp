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
			<%User u_uscope = (User)session.getAttribute("user"); 
				if(u_uscope == null){%>
					Please login first.
				<%} else { %>
					<table class="table">
							<tr>
								<th>Id</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Fiscal Code</th>
								<th>Address</th>
								<th>Phone</th>
								<th>E-mail</th>
								<th>Admin?</th>
							</tr>
							<c:forEach items="${data_list}" var="u">
								<tr>
									<td>${u.id}</td>
									<td>${u.name}</td>
									<td>${u.surname}</td>
									<td>${u.fc}</td>
									<td>${u.address}</td>
									<td>${u.phone}</td>
									<td>${u.email}</td>
									<td>${u.admin}</td>
								</tr>
							</c:forEach>
					</table>
				<%}%>
		</body>
</html>