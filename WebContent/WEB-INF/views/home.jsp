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
		<title>Biblioteca | Home</title>
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
<!-- 				<nav>
					<a href="#menu">Menu</a>
				</nav> -->
			</header>

 		<!-- Nav -->
<!--			<nav id="menu">
				<ul class="links">
					<li><a href="/OortSpring/">Home</a></li>
					<li><a href="/OortSpring/inserisci">Inserimento</a></li>
					<li><a href="/OortSpring/visualizza">Visualizzazione</a></li>
					<li><a href="/OortSpring/modifica">Modifica</a></li>
					<li><a href="/OortSpring/rimuovi">Rimozione</a></li>
					<li><a href="/OortSpring/ricerca">Ricerca</a></li>
					<li><a href="esportazione.html">Esportazione</a></li>
				</ul>
			</nav> -->

		<!-- Heading -->
			<div id="heading" >
				<h1>Home</h1>
			</div>

		<!-- Main -->
			<!-- Highlights -->
			<section class="wrapper">
				<div class="inner">
					<header class="special">
						<h2>Azioni disponibili</h2>
						<p>Selezionare un'azione da svolgere sulla biblioteca.</p>
					</header>
					<div class="highlights">
						<section>
							<div class="content">
								<header>
									<c:set var = "finalPath" value = "${ path }/inserisci" />
									<a href="${ finalPath }" class="icon fa-vcard-o"><span class="label">Icon</span></a>
									<h3>Inserisci</h3>
								</header>
								<!-- <p>Inserimento di un contatto all'interno della rubrica.</p> -->
							</div>
						</section>
						<section>
							<div class="content">
								<header>
									<c:set var = "finalPath" value = "${ path }/visualizza" />
									<div>${ finalPath }</div>
									<a href="${ finalPath }" class="icon fa-table"><span class="label">Icon</span></a>
									<h3>Visualizza</h3>
								</header>
								<!-- <p>Visualizzazione dei contatti presenti in rubrica.</p> -->
							</div>
						</section>
	  					<section>
							<div class="content">
								<header>
									<c:set var = "finalPath" value = "${ path }/modifica" />
									<a href="${ finalPath }" class="icon fa-edit"><span class="label">Icon</span></a>
									<h3>Modifica</h3>
								</header>
								<!-- <p>Modifica di un contatto all'interno della rubrica.</p> -->
							</div>
						</section>
 						<section>
							<div class="content">
								<header>
									<c:set var = "finalPath" value = "${ path }/ricerca" />
									<a href="${ finalPath }" class="icon fa-search"><span class="label">Icon</span></a>
									<h3>Ricerca</h3>
								</header>
								<!-- <p>Ricerca di un contatto all'interno della rubrica.</p> -->
							</div>
						</section>
<!-- 						<section>
							<div class="content">
								<header>
									<a href="esportazione.html" class="icon fa-files-o"><span class="label">Icon</span></a>
									<h3>Esporta</h3>
								</header>
								<p>Esportazione della rubrica.</p>
							</div>
						</section> -->
	
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