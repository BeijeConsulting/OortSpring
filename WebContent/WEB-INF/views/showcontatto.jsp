<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<title></title>
	</head>
	<body>
		<div id="list"></div>
		<div id="id"><h2>Lista contatti: </h2></div>
			<script>
				function jhere(){							
								fetch('./utenti')   
								.then(response => response.json())
								.then(json => ciclo(json));
				}
				function ciclo(json){
									console.log(json);
									let list = document.getElementById("list");
									console.log(list);
									let length = json.length;
									for(let i=0; i<=length; i++){
									let div = document.createElement("div");
									div.innerHTML = "{ ID: " + json[i].id + "} - { Nome: " + json[i].nome + "} - { Cognome: " + json[i].cognome + 
										"} - { Email: " + json[i].email + "} - { Telefono: " + json[i].telefono + "}";
									// (per stampare tutto il contenuto del json in formato json) -- > [div.innerHTML = JSON.stringify(json[i]);]
									list.appendChild(div);
									document.getElementById("id").style.display = "none";
									document.getElementById("id2").style.display = "none";
									}
			    }
			</script>
			<br>
			<button id="id2" onclick="jhere()">Load utenti</button>
			<p align="right">Clicca <a href="h"><mark>QUI</mark></a> per tornare al menu' principale.</p>
	</body>
</html>