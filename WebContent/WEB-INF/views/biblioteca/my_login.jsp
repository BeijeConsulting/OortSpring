<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<jsp:useBean id="arraylist" class="java.util.ArrayList" scope="session"/>
		<h2><em>"Una biblioteca � un luogo dove si impara ci� che gli insegnanti hanno 
		paura di insegnare." <br> Alan M. Dershowitz</em></h2>
	 	
	 	<p>Oggi:  ${today} - ${country} - ${lingua}</p>
	 	
		<h4 style="color:rgb(255, 0, 0);"> ${errore} </h4>
	 
		<br><h3>Inserisci le tue credenziali</h3>
		<form action="./homepage" method="post">
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"/><br/>
 			PASSWORD&nbsp;<input type="password" name="password" value=""/><br>
			<input type="submit" value="INVIO"/>
		</form>
	</body>
</html>