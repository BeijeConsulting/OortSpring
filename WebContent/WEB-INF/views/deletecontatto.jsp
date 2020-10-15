<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteContatto</title>
<link rel="stylesheet" href="<c:url value="/assets/css/del.css" />">
<script type="text/javascript" src="./assets/js/del.js"/></script>
</head>
<body>
		<h1>Eliminare un contatto!</h1>
		<div  class="input">
		<form action="del" method="POST">
			<h3>Inserire ID del contatto da eliminare: </h3><br>
			<label>ID: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input id="id" name="id" type="text"></label><br><br>
			<button type ="submit"><span>Conferma e invia</span></button> 
			<button type="button" onclick="clean()"><span>Clean</span></button>
		</form>
		<br>
			<form action="h" method="GET">
			<button type ="submit"><span>Menu principale</span></button>
		</form>
		<form action ="showall" method ="POST">
		<button type ="submit"><span>Visualizza contatti</span></button>		
		</form>
	</div>
	</body>
</html>