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
		<title>Biblioteca | Modifica utente</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="<c:url value="/assets/css/main.css" />" />
	</head>
	<body class="is-preload" onload="view()">

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
				<h1>Modifica</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<!-- Form -->						
						<h3>Selezionare un utente</h3>
						<form>
							<div class="row gtr-uniform">
								<div class="col-12">
									<select name="selezione-tabella" id="selezione-tabella" onchange="loadValues()">
										<option value="">- Utenti -</option>										
									</select>
								</div>
								<!--div class="col-6 col-12-xsmall"-->
								<h3>Modifica l'utente</h3>
								<div class="col-12">
									<input type="text" name="nome" id="nome" value="" placeholder="Nome" />
								</div>
								<!-- Break -->
								<!--div class="col-6 col-12-xsmall"-->
								<div class="col-12">
									<input type="text" name="cognome" id="cognome" value="" placeholder="Cognome" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="text" name="codiceFiscale" id="codiceFiscale" value="" placeholder="Codice fiscale" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="email" name="email" id="email" value="" placeholder="Email" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="password" name="password" id="password" value="" placeholder="Password" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="text" name="telefono" id="telefono" value="" placeholder="Telefono" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<input type="text" name="indirizzo" id="indirizzo" value="" placeholder="Indirizzo" />
								</div>
								<!-- Break -->
								<div class="col-12">
									<ul class="actions">
										<li><input type="submit" value="Invia" class="primary"/></li>
										<li><input type="reset" value="Cancella" /></li>
									</ul>
								</div>
							</div>
						</form>
						<c:if test = "${utente != null}">
							<h3>Utente modificato</h3>
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
									<tbody>									
										<tr>
										<td>${utente.nome}</td>
										<td>${utente.cognome}</td>
										<td>${utente.telefono}</td>
										<td>${utente.email}</td>
										<td>${utente.codiceFiscale}</td>
										</tr>
									</tbody>		
								</table>
							</div>
					</c:if>
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
									
				function view() {
					fetch("api/utenti")
		            .then(function (response) {
		                return response.json();
		            })
		            .then(function (data) {
		                appendData(data);
		            })
		            .catch(function (err) {
		                console.log(err);
		            });
				}
				
				function appendData(data) {
		            var mainContainer = document.getElementById("selezione-tabella");
		            console.log("data length: " + data.length);
		            for (var i = 0; i < data.length; i++) {
		            	let option = document.createElement("option"); 
		            	option.value = data[i].id;
		            	console.log("option.value: " + option.value);
		            	option.innerHTML = JSON.stringify(data[i]);
		                mainContainer.appendChild(option);
		            }
		        }
				
				function loadValues() {
					let select = document.getElementById("selezione-tabella");
					let index = select.selectedIndex;
					console.log("index1: " + index);
					fetch("api/utenti")
		            .then(function (response) {
		                return response.json();
		            })
		            .then(function (data) {
		                load(data, index-1);
		            })
		            .catch(function (err) {
		                console.log(err);
		            });
				}
				
				function load(data, index) {
					document.getElementById("nome").value = data[index].nome;					
					document.getElementById("cognome").value = data[index].cognome;					
					document.getElementById("codiceFiscale").value = data[index].codiceFiscale;					
					document.getElementById("email").value = data[index].email;					
					document.getElementById("password").value = data[index].password;					
					document.getElementById("telefono").value = data[index].telefono;	
					document.getElementById("indirizzo").value = data[index].indirizzo;						
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