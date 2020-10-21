<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>prova ajax e json</title>
</head>
<body>

	<p>Ciao</p>	

	<div id="msg"></div>
	
	<form onsubmit="insertBook(this)">
	  <label for="titolo">Titolo:</label>
	  <input type="text" name="titolo" value=""><br>
	  <label for="descrizione">Descrizione:</label>
	  <input type="text" name="descrizione" value=""><br>
	  <label for="id_autore">Id Autore:</label>
	  <input type="text" name="id_autore" value=""><br>
	  <label for="id_editore">Id Editore:</label>
	  <input type="text" name="id_editore" value=""><br>
	  <label for="anno">Anno:</label>
	  <input type="text" name="anno" placeholder="dd MM yyyy" value=""><br>
	  <input type="submit" value="INVIA"><br>
	</form>
	
	<div id="msg"></div>
	
</body>

<script>

console.log("CI SONO");


//var idLibro = 1;
//fetch("http://localhost:8080/OortSpring/books_list"+idLibro)
	
	
	//.then(print => document.getElementById('msg').innerHTML+=JSON.stringify(print) )
	//.then((json) => console.log(json)) 
/* function printJson(json){
		let data = fetch("./books_list")
					.then((response) => response.json())
					.then(json => {return json;});
		let testo = JSON.stringify(data);
		console.log(testo);
		//let array = testo.split("},{");
		document.getElementById('msg').innerHTML=testo;
	} */
	
	function insertBook(formEl){
		fetch("./books_list",{ //let data = fetch("./books_list",{
			method: 'POST',
			body: JSON.stringify({
				titolo : formEl.titolo.value,
				descrizione: formEl.descrizione.value,
				id_autore: formEl.id_autore.value,
				id_editore: formEl.id_editore.value,
				anno: formEl.anno.value,
			}),
			headers: {
			    'Content-type': 'application/json; charset=UTF-8',
			  },
		})
		.then((response) => response.json());
		
		//console.log('data: ', data);// troppo veloce, non lo vedi

	}
		

/* 	fetch("./books_list",{
		method: 'POST',
		body: JSON.stringify({
			titolo : document.getElementsByName("titolo"),
			descrizione: document.getElementsByName("descrizione"),
			id_autore: document.getElementsByName("id_autore"),
			id_editore: document.getElementsByName("id_editore"),
			anno: document.getElementsByName("anno"),
		}),
		headers: {
		    'Content-type': 'application/json; charset=UTF-8',
		  },
	})
	.then((response) => response.json())
	.then(json => console.log(json)); */
</script>
</html>