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
		<title>Biblioteca | Login</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<link rel="stylesheet" href="<c:url value="/assets/css/main.css" />"/>
	</head>
	<body class="is-preload">

 			<!-- Header -->
			<header id="header">
				<a class="logo" href=""></a>
				<!-- <nav>
					<a href="#menu">Menu</a>
				</nav>  -->
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
				<h1>Login</h1>
			</div>

		<!-- Main -->
			<!-- Highlights -->
			<section class="wrapper">
				<div class="inner">
					<form onsubmit="return checkSubmit()" method="post" action=""> 
						<div class="row gtr-uniform">
							<div class="col-12">
								<input type="email" name="email" id="email" value="" placeholder="Email" />
							</div>
							<!-- Break -->
							<div class="col-12">
								<input type="password" name="password" id="password" value="" placeholder="Password" />
							</div>
							<!-- Break -->
							<div class="col-12">
								<ul class="actions">
									<li><input type="submit" onclick="loginCheck()" value="Invia" class="primary"/></li>
									<li><input type="reset" value="Cancella" /></li>
								</ul>
							</div>
						</div>	
					</form>
					<div id="erroreEmail"></div>
					<div id="errorePassword"></div>
					<c:if test = "${ utente == null  && flag}">
					
						<div>Errore: utente o password non valide!</div>
					
					</c:if>
				</div>
			</section>

		<!-- Footer -->
<!-- 		<footer id="footer">
			<div class="inner">
				<div class="copyright">
					&copy; Luca Gregori.
				</div>
			</div>
		</footer> -->

		<!-- Scripts -->
			<script src="<c:url value="/assets/js/jquery.min.js" />"></script>
			<script src="<c:url value="/assets/js/browser.min.js" />"></script>
			<script src="<c:url value="/assets/js/breakpoints.min.js" />"></script>
			<script src="<c:url value="/assets/js/util.js" />"></script>
			<script src="<c:url value="/assets/js/login.js" />"></script>

	</body>
</html>