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
			<%User u_lscope = (User)session.getAttribute("user"); 
				if(u_lscope == null){%>
					Please login first.
				<%} else { %>
					<table>
							<tr>
								<th>Id</th>
								<th>User</th>
								<th>Book</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Notes</th>
							</tr>
							<c:forEach items="${data_list}" var="l">
								<tr>
									<td>${l.id}</td>
									<td>${l.user.id}</td>
									<td>${l.book.title}</td>
									<td>${l.start_date}</td>
									<td>${l.end_date}</td>
									<td>${l.notes}</td>
								</tr>
							</c:forEach>
					</table>
				<%}%>
		</body>
</html>