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

        <form method="post" action="${pageContext.request.contextPath}/libro/${libro.id}/modifica">
            <div class="single-input">
                <label for="titolo">Titolo: </label>
                <input type="text" name="titolo" id="titolo" value="${libro.titolo}" placeholder="${libro.titolo}">
            </div>
            <div class="single-input">
                <label for="desc">Sinossi: </label>
                <textarea name="descrizione" id="desc" rows="4" cols="50"
                          placeholder="${libro.descrizione}">${libro.descrizione}</textarea>
            </div>
            <div class="single-input">
                <label for="anno">Anno di Pubblicazione: </label>
                <input type="date" name="anno_pubblicazione" id="anno" value="${libro.annoPubblicazione}">
            </div>
            <div class="single-input">
                <label for="autore">Autore: </label>
                <select id="autore" name="id_autore">
                    <option value="${libro.autore.id}" selected>${libro.autore.nome} ${libro.autore.cognome}</option>
                    <c:forEach var="autore" items="${sessionScope.autori}">
                        <option value="${autore.id}">${autore.nome} ${autore.cognome}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="single-input">
                <label for="editore">Editore: </label>
                <select id="editore" name="id_editore">
                    <option value="${libro.editore.id}" selected>${libro.editore.nome}</option>
                    <c:forEach var="editore" items="${sessionScope.editori}">
                        <option value="${editore.id}">${editore.nome}</option>
                    </c:forEach>
                </select>
            </div>
            <input type="submit" value="Modifica">
        </form>
    </div>
</div>

</body>
</html>
