<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<!--
	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Biblioteca | Visualizzazione utenti</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="<c:url value="/assets/css/main.css" />"/>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="../">Utente</a>
				<nav>
					<a href="#menu">Menu</a>
				</nav>
			</header>

		<!-- Nav -->
		<nav id="menu">
			<ul class="links">
				<li><a href="../">Home</a></li>
				<li><a href="./inserisci">Inserimento</a></li>
				<li><a href="./visualizza">Visualizzazione</a></li>
				<li><a href="./modifica">Modifica</a></li>
				<li><a href="./ricerca">Ricerca</a></li>
			</ul>
		</nav>

		<!-- Heading -->
			<div id="heading" >
				<h1>Visualizzazione utenti</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<h3>Utenti</h3>
						<div class="table-wrapper">
							<table>
								<thead>
									<tr>
										<th>Nome</th>
										<th>Cognome</th>
										<th>Telefono</th>
										<th>Email</th>
										<th>Codice fiscale</th>
									</tr>
								</thead>
								<tbody id="myData">
									<!-- Generated view here -->
								</tbody>
							</table>
						</div>
						<button onclick="viewFive()">Load</button>
					</div>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">
				<div class="inner">
					<div class="copyright">
						&copy; Luca Gregori.
					</div>
				</div>
			</footer>
			
			<script type="text/javascript">
									
				function viewFive() {
					fetch("api/utenti")
		            .then(function (response) {
		                console.log("here 2");
		                return response.json();
		            })
		            .then(function (data) {
		                console.log("here 3");
		                appendData(data);
		            })
		            .catch(function (err) {
		                console.log("here 4");
		                console.log(err);
		            });
				}
				
				function appendData(data) {
		            console.log("here 5");
		            var mainContainer = document.getElementById("myData");
		            console.log("data length: " + data.length);
		            for (var i = 0; i < data.length; i++) {
		            	let row = document.createElement("tr");
		            	let nome = document.createElement("td");
		            	nome.innerHTML = data[i].nome;
		            	let cognome = document.createElement("td");
		            	cognome.innerHTML = data[i].cognome;
		            	let telefono = document.createElement("td");
		            	telefono.innerHTML = data[i].telefono;
		            	let email = document.createElement("td");
		            	email.innerHTML = data[i].email;
		            	let codiceFiscale = document.createElement("td");
		            	codiceFiscale.innerHTML = data[i].codiceFiscale;
		            	row.appendChild(nome);
		            	row.appendChild(cognome);
		            	row.appendChild(telefono);
		            	row.appendChild(email);
		            	row.appendChild(codiceFiscale);		            	
		                mainContainer.appendChild(row);
		            }
		        }
			
			</script>

		<!-- Scripts -->
			<script src="<c:url value="/assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="/assets/js/browser.min.js" />"></script>
			<script src="<c:url value="/assets/js/breakpoints.min.js" />"></script>
			<script src="<c:url value="/assets/js/util.js" />"></script>
			<script src="<c:url value="/assets/js/main.js" />"></script>

	</body>
</html>