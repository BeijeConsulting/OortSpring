<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Padawan09
  Date: 09/10/2020
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bentornato ${user.nome}</title>
</head>
<body>
    <p>Ti chiami ${user.nome} ${user.nome}, vero?</p>
    <p>Ecco altri tuoi dati:</p>
    ${user.toString()}
    <img src="https://placekitten.com/300/300" alt="Gatto" class="rotate">
</body>
</html>
