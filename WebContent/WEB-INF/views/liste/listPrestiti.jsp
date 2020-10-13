<%@ taglib prefix="p" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elenco Prestiti</title>
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
            <h1><i>Biblioteca</i></h1>
            <h3>Elenco Prestiti</h3>
        </div>

        <form action="${pageContext.request.contextPath}/visualizza" method="post">
            <div class="single-input selector">
                <label for="type">Cosa vuoi visualizzare:</label>
                <select id="type" name="type" onchange="this.form.submit()">
                    <option value="Libri">Libri</option>
                    <option value="Autori">Autori</option>
                    <option value="Editori">Editori</option>
                    <option value="Utenti">Utenti</option>
                    <option selected disabled value="Prestiti">Prestiti</option>
                </select>
            </div>
        </form>

        <div class="contatti-list">
            <table>
                <tr>
                    <th>Data Inizio</th>
                    <th>Data Fine</th>
                    <th>Utente</th>
                    <th>Libro</th>
                    <th>Note</th>
                </tr>
                <c:forEach items="${prestiti}" var="obj">
                    <tr>
                        <td>${obj.dataInizio}</td>
                        <td>${obj.dataFine}</td>
                        <td>${obj.cfUtente}</td>
                        <td><a href="/libro/${obj.libro.id}">${obj.libro.titolo} - ${obj.libro.autore.nome} ${obj.libro.autore.cognome}</a></td>
                        <td>${obj.note}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
