<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
<head>
    <meta charset="UTF-8">
    <title>BiblioIndex</title>
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
    <a href="<c:url value="/"/>"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class = "small-center-container">
        <div class="header">
            <h1><i>Bibli<span style="color: #008CBA;">Oort</span>eca</i></h1>
            <h3>Gestionale per Database Bibliotecario</h3>
<%--        </div>--%>

<%--        <%--%>
<%--            if (request.getSession().getAttribute("logged") == null--%>
<%--            || !(boolean) request.getSession().getAttribute("logged")) {--%>
<%--                response.sendRedirect("/login");--%>
<%--            }--%>
<%--        %>--%>
<%--        <jsp:useBean id="utente" class="it.beije.oort.model.Utente" scope="session" />--%>
<%--        <%--%>
<%--            if (utente.isAdmin()){--%>
<%--        %>--%>
        <!-- Index per amministratori -->

        <div class = "grid-buttons">
            <a href="./biblioSearch.jsp"><button class="button-rubrica">
                Ricerca
            </button></a>
            <a href="${pageContext.request.contextPath}/add"><button class="button-rubrica">
                Aggiungi
            </button></a>
            <a href="./biblioView.jsp"><button class="button-rubrica">
                Visualizza
            </button></a>
        </div>

<%--        <%--%>
<%--        } else {--%>
<%--        %>--%>
        <!-- Index per utenti -->
        <div class = "grid-buttons">
            <a href="./biblioSearch.jsp"><button class="button-rubrica">
                Ricerca
            </button></a>
            <a href="./biblioView.jsp"><button class="button-rubrica">
                Elenco Libri
            </button></a>
            <a href="./userPrestiti.jsp"><button class="button-rubrica">
                Prestiti
            </button></a>
        </div>

<%--        <%--%>
<%--            }--%>
<%--        %>--%>

    </div>
</div>
</div>
<ul class="circles">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>
</body>
</html>