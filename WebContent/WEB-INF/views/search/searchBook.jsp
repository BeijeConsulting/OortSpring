<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ricerca Libro</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico"/>

    <script src="${pageContext.request.contextPath}/resources/js/search.js"></script>
</head>
<body>
<div class="home">
    <a href="${pageContext.request.contextPath}/"><i class="fas fa-home"></i></a>
</div>

<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1>Ricerca Libro</h1>
        </div>

        <form action="${pageContext.request.contextPath}/search/libro"
              method="post" id="searchForm" onsubmit="return validateForm()">
            <div class="single-input selector">
                <select id="column" name="column" required onchange="getQueryField(this)">
                    <option value="" disabled selected>Campo da Cercare</option>
                    <option value="id">ID</option>
                    <option value="titolo">Titolo</option>
                    <option value="annoPubblicazione">Anno di Pubblicazione</option>
                    <option value="autore">Autore</option>
                    <option value="editore">Editore</option>
                </select>
            </div>
            <div class="single-input selector" id="queryDiv">
                <input type="text" name="query" id="query" placeholder="Cerca...">
            </div>
            <div class="single-input selector">
                <p id = 'queryErr'></p>
                <input id="submit" type="submit" name="Cerca" onclick="cleanErrors()">
            </div>
        </form>
    </div>
</div>

</body>
</html>