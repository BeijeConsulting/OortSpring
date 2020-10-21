<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Libri per autore</title>
</head>
	<body>
		<a href="./homepage">homepage</a><br>
		
		<form method="post" name="invio" >
			<select name="autore">
				<option id="Hermann Hesse" value="1">Hermann Hesse</option>
				<option id="Jean-Jacques Rousseau" value="2">Jean-Jacques Rousseau</option>
			</select>
			
			<div id="passNo" style="color:rgb(255, 0, 0);"></div>
			
 			<input type="submit" value="CERCA" onclick="libriAutore()" />
		</form>
			
		<div id="nome_autore"></div>
	
		
		<script>
		let memory = "";
		let url = 'http://localhost:8080/OortSpring/rest/libri_autore/' 
		//prende i dati da un url
		function libriAutore() {
			let valore = document.getElementByName('autore').innerHTML
			fetch(url + valore)
			 .then(response => response.json())
			 .then(json => {
				console.log(json);
		  		
				memory = json.title;
				document.getElementById('nome_autore').innerHTML = memory;
		
		  })
		}
		</script>
		
	</body>
</html>