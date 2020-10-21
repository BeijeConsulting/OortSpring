<%@ taglib prefix="p" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elenco Libri</title>
    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico" />

    <script defer src = "${pageContext.request.contextPath}/resources/js/bookList.js"></script>
    <script defer src = "${pageContext.request.contextPath}/resources/js/newBookList.js"></script>
</head>
<body>

<div id="loader" style="display: block; background-color: white; width:100%; height: 100%">
    <img src="https://i.pinimg.com/originals/9b/53/d4/9b53d4eaf1ffb58eca857738ea925fbb.gif" alt="gif">
</div>

<div class="home">
    <a href="<c:url value="/"/>"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1><i>Biblioteca</i></h1>
            <h3>Elenco Libri</h3>
        </div>


            <div class="single-input selector">
                <label for="type">Cosa vuoi visualizzare:</label>
                <select id="type" name="type" onchange="reload()">
                    <option selected value="Libri">Libri</option>
                    <option value="Autori">Autori</option>
                    <option value="Editori">Editori</option>
                    <option disabled value="Utenti">Utenti</option>
                    <option value="Prestiti">Prestiti</option>
                </select>
            </div>

        <div class="contatti-list">
            <table id="listLibri">
                <thead></thead>
                <tbody></tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
