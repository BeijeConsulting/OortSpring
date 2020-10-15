<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico" />

    <script src="${pageContext.request.contextPath}/resources/js/search.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="home">
    <a href="${pageContext.request.contextPath}/login"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class = "small-center-container">
        <div class="header">
            <h1><i>Login</i></h1>
        </div>
        <div class = "rubrica-form">
            <form action="${pageContext.request.contextPath}/login" method="post">
                ${error}
                <div class="single-input">
                    <label for="cf-mail">Email o Codice Fiscale: </label>
                    <input type="text" name="cf-mail" id="cf-mail" required>
                </div>

                <div class="single-input">
                    <label for="password">Password: </label>
                    <input type="password" name="password" id="password" required>
                    <input type="checkbox" onclick="showPass()">Mostra Password
                </div>
                <div class="submit">
                    <input type="submit" value="Login">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
