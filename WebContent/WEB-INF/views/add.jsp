<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Aggiungi</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioAdd.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico"/>
</head>
<body>
<div class="home">
    <a href="${pageContext.request.contextPath}/"><i class="fas fa-home"></i></a>
</div>

<div class="container">
    <div class="small-center-container">
        <div class="header">
            <h1>Biblioteca</h1>
        </div>

        <c:if test="${added != null && added == true}">
            <h3>Aggiunto!</h3>
        </c:if>
        <c:if test="${added != null && added == false}">
            <h3>Non aggiunto</h3>
        </c:if>

        <form action="${pageContext.request.contextPath}/add" method="get">
            <div class="single-input selector">
                <label for="add" style="text-align: center">Cosa vuoi Aggiungere?</label>
                <select id="add" name="add" onchange="this.form.submit()">
                    <option value="" disabled selected>Seleziona cosa vuoi aggiungere</option>
                    <option value="Libro">Libro</option>
                    <option value="Autore">Autore</option>
                    <option value="Editore">Editore</option>
                    <option value="Utente">Utente</option>
                    <option value="Prestito">Prestito</option>
                </select>
            </div>
        </form>

    <div class = "rubrica-form">
        <form action="${pageContext.request.contextPath}/add" method="post">
        <c:if test="${sessionScope.add != null}">
            <c:set var="type" value="${sessionScope.add}"/>
            <c:choose>
                <c:when test="${type eq 'Libro'}">
                    <input type="hidden" hidden aria-hidden="true" value="Libro" name="type" id="type" />
                    <div class="single-input">
                        <label for="titolo">Titolo: </label>
                        <input type="text" name="titolo" id="titolo">
                    </div>
                    <div class="single-input">
                        <label for="desc">Descrizione: </label>
                        <textarea name="descrizione" id="desc" rows="4" cols="50"></textarea>
                    </div>
                    <div class="single-input">
                        <label for="anno">Anno di Pubblicazione: </label>
                        <input type="date" name="anno_pubblicazione" id="anno">
                    </div>
                    <div class="single-input">
                        <label for="autore">Autore: </label>
                        <select id="autore" name="id_autore">
                            <option disabled selected>Seleziona Autore</option>
                            <c:forEach var="autore" items="${sessionScope.autori}">
                                <option value="${autore.id}">${autore.nome} ${autore.cognome}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="single-input">
                        <label for="editore">Editore: </label>
                        <select id="editore" name="id_editore">
                            <option disabled selected>Seleziona Editore</option>
                            <c:forEach var="editore" items="${sessionScope.editori}">
                                <option value="${editore.id}">${editore.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:when>

                <c:when test="${type eq 'Autore'}">
                    <input type="hidden" hidden aria-hidden="true" value="Autore" name="type" id="type" />
                    <div class="single-input">
                        <label for="nomeAutore">Nome: </label>
                        <input type="text" name="nome" id="nomeAutore">
                    </div>
                    <div class="single-input">
                        <label for="cognomeAutore">Descrizione: </label>
                        <input type="text" name="cognome" id="cognomeAutore">
                    </div>

                    <div class="single-input">
                        <label for="autDataNasc">Anno di Nascita: </label>
                        <input type="date" name="data_nascita" id="autDataNasc">
                    </div>
                    <div class="single-input">
                        <label for="autDataMorte">Anno di Morte: </label>
                        <input type="date" name="data_morte" id="autDataMorte">
                    </div>
                    <div class="single-input">
                        <label for="bio">Biografia </label>
                        <input type="text" name="biografia" id="bio">
                    </div>
                </c:when>

                <c:when test="${type eq 'Editore'}">
                    <input type="hidden" hidden aria-hidden="true" value="Editore" name="type" id="type" />
                    <div class="single-input">
                        <label for="nome">Nome: </label>
                        <input type="text" name="nome" id="nome">
                    </div>
                    <div class="single-input">
                        <label for="descEditore">Descrizione: </label>
                        <input type="text" name="descrizione" id="descEditore">
                    </div>
                </c:when>

                <c:when test="${type eq 'Utente'}">
                    <input type="hidden" hidden aria-hidden="true" value="Utente" name="type" id="type" />
                    <div class="single-input">
                        <label for="uNome">Nome: </label>
                        <input type="text" name="nome" id="uNome">
                    </div>
                    <div class="single-input">
                        <label for="uCognome">Cognome: </label>
                        <input type="text" name="cognome" id="uCognome">
                    </div>
                    <div class="single-input">
                        <label for="cf">Codice Fiscale: </label>
                        <input type="text" name="codiceFiscale" id="cf" required>
                    </div>
                    <div class="single-input">
                        <label for="pass">Password: </label>
                        <input type="password" name="password" id="pass" required>
                    </div>
                    <div class="single-input">
                        <label for="email">Email: </label>
                        <input type="text" name="email" id="email" required>
                    </div>
                    <div class="single-input">
                        <label for="isAdmin">Admin? </label>
                        <input type="checkbox" name="isAdmin" id="isAdmin">
                    </div>
                </c:when>

                <c:when test="${type eq 'Prestito'}">
                    <input type="hidden" hidden aria-hidden="true" value="Prestito" name="type" id="type" />
                    <div class="single-input">
                        <label for="initPrestito">Inizio Prestito: </label>
                        <input type="date" name="dataInizio" id="initPrestito" required>
                    </div>
                    <div class="single-input">
                        <label for="finePrestito">Fine Prestito: </label>
                        <input type="date" name="dataFine" id="finePrestito">
                    </div>
                    <div class="single-input">
                        <label for="prestitoUtente">Utente: </label>
                        <select id="prestitoUtente" name="cfUtente">
                            <option selected disabled>Seleziona Utente</option>
                            <c:forEach var="utente" items="${sessionScope.utenti}">
                                <option value="${utente.codiceFiscale}">${utente.codiceFiscale}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="single-input">
                        <label for="prestitoLibro">Libro: </label>
                        <select id="prestitoLibro" name="idLibro">
                            <option selected disabled>Seleziona Libro</option>
                            <c:forEach var="libro" items="${sessionScope.libri}">
                                <option value="${libro.id}">${libro.titolo}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="single-input">
                        <label for="note">Note </label>
                        <textarea name="note" id="note"></textarea>
                    </div>
                </c:when>
            </c:choose>
            <input type="submit" value="Aggiungi">
        </form>
    </div>
        </c:if>
    </div>
</div>

</body>
</html>