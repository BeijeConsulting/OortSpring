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
		<title>Biblioteca - Inserimento utente</title>
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
				<h1>Inserimento utente</h1>
			</div>

		<!-- Main -->
			<section id="main" class="wrapper">
				<div class="inner">
					<div class="content">
						<!-- Form -->
						<h3>Utente</h3>
						<form>
							<div class="row gtr-uniform">
								<!--div class="col-6 col-12-xsmall"-->
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
									<!--  	<li><button value="Invia" onclick="inserisciUtente()" class="primary"/>Invia</li>-->
										<li><input onclick="inserisciUtente()" type='button' value="Invia"/></li>
										<li><input type="reset" value="Cancella" /></li>
									</ul>
								</div>
							</div>
						</form>
						<%
						/* String nome = (String)session.getAttribute("nome");
						String cognome = (String)session.getAttribute("cognome");
						String telefono = (String)session.getAttribute("telefono");
						String email = (String)session.getAttribute("email");
						 */%>
						 
					<c:if test = "${utente != null}">
							<h3>Utente inserito</h3>
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
				function inserisciUtente() {
					console.log("Here");
					let nome = document.getElementById("nome").value;
					let cognome = document.getElementById("cognome").value;
					let codiceFiscale = document.getElementById("codiceFiscale").value;
					let email = document.getElementById("email").value;
					let password = document.getElementById("password").value;
					let telefono = document.getElementById("telefono").value;
					let indirizzo = document.getElementById("indirizzo").value;
					
					let json = {
							"nome": nome,
							"cognome": cognome,
							"codiceFiscale": codiceFiscale,
							"email": email,
							"password": password,
							"telefono": telefono,
							"indirizzo": indirizzo
					}
								
					fetch('api/utenti', {
						  method: 'POST',
						  body: JSON.stringify(json),
						  headers: {
						    'Content-type': 'application/json; charset=UTF-8',
						  },
						})
						  .then((response) => response.json())
						  .then((json) => console.log(json)) 
				}
			</script>

		<!-- Scripts -->
			<script src="<c:url value="/assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="/assets/js/browser.min.js" />"></script>
			<script src="<c:url value="/assets/js/breakpoints.min.js" />"></script>
			<script src="<c:url value="/assets/js/util.js" />"></script>
			<script src="<c:url value="/assets/js/main.js" />"></script>
			<script src="<c:url value="/assets/js/inserimento-utente.js" />"></script>

	</body>
</html>