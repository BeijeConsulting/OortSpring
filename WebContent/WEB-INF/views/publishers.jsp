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
			<%User u_pscope = (User)session.getAttribute("user"); 
				if(u_pscope == null){%>
					Please login first.
				<%} else { %>
					<table class="table">
							<tr>
								<th>Id</th>
								<th>Name</th>
								<th>Description</th>
							</tr>
							<c:forEach items="${data_list}" var="p">
								<tr>
									<td>${p.id}</td>
									<td>${p.name}</td>
									<td>${p.description}</td>
								</tr>
							</c:forEach>
					</table>
				<%}%>
		</body>
</html>