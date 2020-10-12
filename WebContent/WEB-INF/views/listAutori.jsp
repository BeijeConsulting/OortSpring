<%@ taglib prefix="p" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Elenco Autori</title>
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
            <h3>Elenco Autori</h3>
        </div>

        <form action="${pageContext.request.contextPath}/visualizza" method="post">
            <div class="single-input selector">
                <label for="type">Cosa vuoi visualizzare:</label>
                <select id="type" name="type" onchange="this.form.submit()">
                    <option value="Libri">Libri</option>
                    <option selected disabled value="Autori">Autori</option>
                    <option value="Editori">Editori</option>
                    <option value="Utenti">Utenti</option>
                    <option value="Prestiti">Prestiti</option>
                </select>
            </div>
        </form>

        <div class="contatti-list">
            <table>
                <tr>
                    <th>Nome</th>
                    <th>Cognome</th>
                    <th>Data di Nascita</th>
                    <th>Data di Morte</th>
                    <th>Biografia</th>
                </tr>
                <c:forEach items="${lista}" var="obj">
                    <tr>
                        <td>${obj.nome}</td>
                        <td>${obj.cognome}</td>
                        <td>${obj.data_nascita}</td>
                        <td>${obj.data_morte}</td>
                        <td>${obj.biografia}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
</body>
</html>
