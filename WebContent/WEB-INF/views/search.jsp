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
        <div class = "rubrica-form">
            <form action="${pageContext.request.contextPath}/search" method="post">
                <div class="single-input selector">
                    <label for="table" style="text-align: center">Tabella da Cercare:</label>
                    <select id="table" name="table" required>
                        <option value="" disabled selected>Seleziona la tabella da cercare</option>
                        <option value="Libro">Libro</option>
                        <option value="Autore">Autore</option>
                        <option value="Editore">Editore</option>
                        <option value="Utente">Utente</option>
                        <option value="Prestito">Prestito</option>
                    </select>
                </div>

                <div class="single-input">
                    <label for="query">Cerca: </label>
                    <input type="text" name="query" id="query" required placeholder="Cerca...">
                </div>
                <div class="submit">
                    <input type="submit" value="Cerca">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
