<%@ taglib prefix="p" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${libro.titolo} di ${libro.autore.nome} ${libro.autore.cognome}</title>
    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioAdd.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico" />
</head>
<body>
<div class="home">
    <a href="<c:url value="/"/>"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1><i>${libro.titolo} di ${libro.autore.nome} ${libro.autore.cognome}</i></h1>
        </div>

        <h3>Titolo: </h3> <p>${libro.titolo}</p>
        <h3>Autore: </h3> <p>${libro.autore.nome} ${libro.autore.cognome}</p>
        <h3>Anno di Pubblicazione: </h3> <p>${libro.annoPubblicazione}</p>
        <h3>Editore: </h3> <p>${libro.editore.nome}</p>
        <h3>Sinossi: </h3> <p>${libro.descrizione}</p>
    </div>
    <a href="${pageContext.request.contextPath}/libro/${libro.id}/modifica">MODIFICA</a>
</div>

</body>
</html>
