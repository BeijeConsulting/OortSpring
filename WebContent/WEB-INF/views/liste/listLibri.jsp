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

    <script src = "${pageContext.request.contextPath}/resources/js/bookList.js"></script>
</head>
<body>
<div class="home">
    <a href="<c:url value="/"/>"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1><i>Biblioteca</i></h1>
            <h3>Elenco Libri</h3>
        </div>

        <form action="${pageContext.request.contextPath}/visualizza" method="post">
            <div class="single-input selector">
                <label for="type">Cosa vuoi visualizzare:</label>
                <select id="type" name="type" onchange="this.form.submit()">
                    <option selected disabled value="Libri">Libri</option>
                    <option value="Autori">Autori</option>
                    <option value="Editori">Editori</option>
                    <option value="Utenti">Utenti</option>
                    <option value="Prestiti">Prestiti</option>
                </select>
            </div>
        </form>

        <div class="contatti-list">
            <table>
                <tr>
                    <th>Titolo</th>
                    <th>Autore</th>
                    <th>Anno di Pubblicazione</th>
                    <th>Editore</th>
                    <th>Sinossi</th>
                </tr>
                <tr>
                    <th>
                        <input type="text" id="filterTitle" onkeyup="filter('titolo', this)" placeholder="Filtra Titolo">
                    </th>
                    <th>
                        <input type="text" id="filterAuthor" onkeyup="filter('autore', this)" placeholder="Filtra Autore">
                    </th>
                    <th>

                    </th>
                    <th>
                        <input type="text" id="filterEditore" onkeyup="filter('editore', this)" placeholder="Filtra Editore">
                    </th>
                    <th>
                        <input type="text" id="filterSynopsis" onkeyup="filter('desc', this)" placeholder="Filtra Sinossi">
                    </th>
                </tr>
                <c:forEach items="${libri}" var="obj">
                    <tr>
                        <td class = "titolo"><a href="${pageContext.request.contextPath}/libro/${obj.id}">${obj.titolo}</a></td>
                        <td class = "autore"><a href="${pageContext.request.contextPath}/autore/${obj.idAutore}">${obj.autore.nome} ${obj.autore.cognome}</a></td>
                        <td>${obj.annoPubblicazione}</td>
                        <td class = "editore">${obj.editore.nome}</td>
                        <td class = "desc">${obj.descrizione}</td>
                        <td><a href="${pageContext.request.contextPath}/libro/${obj.id}/modifica">
                                <i class="fas fa-pen"></i>
                        </a></td>
<%--                        Todo delete qui--%>
                        <td><a href="#">
                                <i class="fas fa-minus-circle"></i>
                        </a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
