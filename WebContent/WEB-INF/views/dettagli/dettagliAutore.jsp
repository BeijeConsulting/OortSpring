<%@ taglib prefix="p" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${autore.nome} ${autore.cognome}</title>
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
            <h1><i>${autore.nome} ${autore.cognome}</i></h1>
        </div>

        <h3>Nome: </h3> <p>${autore.nome}</p>
        <h3>Cognome: </h3> <p>${autore.cognome}</p>
        <h3>Data di Nascita: </h3> <p>${autore.data_nascita}</p>
        <h3>Data di Morte: </h3> <p>${autore.data_morte}</p>
        <h3>Biografia: </h3> <p>${autore.biografia}</p>
    </div>
</div>

</body>
</html>
