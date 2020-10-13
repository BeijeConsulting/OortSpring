<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bentornato ${user.nome}</title>
</head>
<body>
    <p>Ti chiami ${user.nome} ${user.cognome}, vero?</p>
    <p>Ecco altri tuoi dati:</p>
    <p>Codice Fiscale: ${user.codiceFiscale}</p>
    <p>Email: ${user.email}</p>
    <p>Sei admin: ${user.admin ? "Sì" : "No"}</p>

</body>
</html>
