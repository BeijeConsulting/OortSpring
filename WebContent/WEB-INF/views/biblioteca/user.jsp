<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="it.beije.oort.sala.controller.beans.PrestitoTransport" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User page</title>
</head>
<body> <% if(!(boolean)session.getAttribute("admin")) { %>
    <header style="margin-left: 2em; display: flex;">
	        <div style="width: 70%;">
		        <h1>Benvenuto <% out.print(session.getAttribute("nome")); %>!</h1>
            	<p>Seleziona l'azione che vuoi compiere tra quelle disponibili:</p>
	        </div>
	       <div style="width: 30%;"> 
                <form action="/OortSpring/" method="GET">
                	<input type="hidden" name="logout" value="true">
                	<button type="submit" style="float: right;">Logout</button>
            	</form>
            </div>
	    </header>
	<% } else if((boolean)session.getAttribute("admin")) { %>
	<header style="margin-left: 2em; display: flex;">
	        <div style="width: 70%;"> 
		        <h1>Benvenuto <% out.print(session.getAttribute("nome")); %>! (Sei Admin!)</h1>
            	<p>Seleziona l'azione che vuoi compiere tra quelle disponibili:</p>
	        </div>
	       <div style="width: 30%;"> 
                <form action="/OortSpring/" method="GET">
                	<input type="hidden" name="logout" value="true">
                	<button type="submit" style="float: right;">Logout</button>
            	</form>
            </div>
	    </header>
	    <p>......vai alla pagina <a href="/OortSpring/admin?req=homeadmin">pagina admin</a>......</p>
	<% } %>
	<div>
    	<ul>
    		${prestiti}
    	</ul>
    </div>
</body>
</html>