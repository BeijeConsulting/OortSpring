<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<!--
	Industrious by TEMPLATED
	templated.co @templatedco
	Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)
-->
<html>
	<head>
		<title>Biblioteca | Selezione tabella</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="<c:url value="/assets/css/main.css" />"/>
	</head>
	<body class="is-preload">

		<!-- Header -->
			<header id="header">
				<a class="logo" href="/OortSpring/">Biblioteca</a>
				<nav>
					<a href="#menu">Menu</a>
				</nav>
			</header>

		<!-- Nav -->
			<nav id="menu">
				<ul class="links">
					<li><a href="/OortSpring/">Home</a></li>
					<li><a href="/OortSpring/inserisci">Inserimento</a></li>
					<li><a href="/OortSpring/visualizza">Visualizzazione</a></li>
					<li><a href="/OortSpring/modifica">Modifica</a></li>
					<li><a href="/OortSpring/rimuovi">Rimozione</a></li>
					<li><a href="/OortSpring/ricerca">Ricerca</a></li>
					<!-- <li><a href="esportazione.html">Esportazione</a></li> -->
				</ul>
			</nav>

		<!-- Heading -->
			<div id="heading" >
				<h1>Home</h1>
			</div>

		<!-- Main -->
			<!-- Highlights -->
			<section class="wrapper">
				<div class="inner">
					<header class="special">
						<h2>Tabelle disponibili</h2>
						<p>Selezionare una tabella sulla quale svolgere l'operazione.</p>
					</header>
					<div class="highlights">
						<section>
							<div class="content">
								<header>
									<a href="/OortSpring/utente" class="icon fa-table"><span class="label">Icon</span></a>
									<h3>Utente</h3>
								</header>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="/OortSpring/autore" class="icon fa-table"><span class="label">Icon</span></a>
									<h3>Autore</h3>
								</header>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="/OortSpring/editore" class="icon fa-table"><span class="label">Icon</span></a>
									<h3>Editore</h3>
								</header>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="/OortSpring/libro" class="icon fa-table"><span class="label">Icon</span></a>
									<h3>Libro</h3>
								</header>
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<a href="/OortSpring/prestito" class="icon fa-table"><span class="label">Icon</span></a>
									<h3>Prestito</h3>
								</header>
							</div>
						</section>
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

		<!-- Scripts -->
			<script src="<c:url value="/assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="/assets/js/browser.min.js" />"></script>
			<script src="<c:url value="/assets/js/breakpoints.min.js" />"></script>
			<script src="<c:url value="/assets/js/util.js" />"></script>
			<script src="<c:url value="/assets/js/main.js" />"></script>

	</body>
</html>