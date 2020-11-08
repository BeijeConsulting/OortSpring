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
		<a href="./homepage">homepage</a><br><br>
		
		<form id="myForm" >
			<select name="select">
				<option id="Hermann Hesse" value="1">Hermann Hesse</option>
				<option id="Jean-Jacques Rousseau" value="2">Jean-Jacques Rousseau</option>
			</select>								
		</form>
		
		<button onclick="libriAutore()">Cerca Libri</button>
		
		<div id="id_autore"> </div> 
		<br>
		<!--  
		<table>
		   	<c:forEach var = "i" items="${libriAutore}">
				<tr>
					<br>  
					<div id="id"> <c:out value = "${i.id}"/><p> </div>
				  	<div id="titolo"> <c:out value = "${i.titolo}"/><p> </div>
				   	<div id="descrizione"> <c:out value = "${i.descrizione_libro}"/><p> </div>
			   		<div id="anno">  <c:out value = "${i.anno}"/><p> </div>
			   		<br>
				</tr>
		 	</c:forEach>
		</table>
		-->
	
	
		<script>
		let memory = "";
		let url = 'http://localhost:8080/OortSpring/rest/libri_autore/';
		var table = "";
		
/*		function FillTable(item,index) {
	  	  let text = document.createElement("p");
	  	  text.innerHTML = "id: " + item.id + ", titolo: " + item.titolo + ", anno: "
	  	  					+ item.anno + ", descrizione: " + item.descrizione_libro + "<br>";
	  	 
	  	  document.getElementById('id_autore').appendChild(text)
		}  */
		
		//prende i dati da un url
		function libriAutore() {
			//let valore = document.getElementById("myForm").elements[0].value;
			let valore = document.getElementById("myForm").elements.namedItem("select").value;
			fetch(url + valore)
			 .then(response => response.json())
			 .then(json => {
				console.log(json);

				//ciclo for each:
				//json.forEach(FillTable);
				
				document.getElementById('id_autore').innerHTML = "";
				let i;
				for (i = 0; i < json.length; i++) {
				  let text = document.createElement("p");
			  	  text.innerHTML = "id: " + json[i].id + "  -  titolo: " + json[i].titolo + "  -  anno: "
			  	  					+ json[i].anno + "  -  descrizione: " + json[i].descrizione_libro + "<br>";
			  	 
			  	  document.getElementById('id_autore').appendChild(text)
			  	
				}
		  		})
		  }
		</script>
		
	</body>
</html>