<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Ricerca</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioAdd.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico" />
</head>
<body>
<div class="home">
    <a href="${pageContext.request.contextPath}/login"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class = "small-center-container">
        <div class="header">
            <h1><i>Ricerca</i></h1>
        </div>
        <div class = "grid-buttons">
            <a href="${pageContext.request.contextPath}/search/libro"><button class="button-rubrica">
                Cerca Libro
            </button></a>
            <a href="${pageContext.request.contextPath}/search/autore"><button class="button-rubrica">
                Cerca Autore
            </button></a>
            <a href="${pageContext.request.contextPath}/search/editore"><button class="button-rubrica">
                Cerca Editore
            </button></a>
            <a href="${pageContext.request.contextPath}/search/utente"><button class="button-rubrica">
                Cerca Utente
            </button></a>
            <a href="${pageContext.request.contextPath}/search/prestito"><button class="button-rubrica">
                Cerca Prestito
            </button></a>
        </div>
    </div>
</div>
</body>
</html>
