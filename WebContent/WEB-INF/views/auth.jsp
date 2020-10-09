<%--
  Created by IntelliJ IDEA.
  User: Padawan09
  Date: 09/10/2020
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../style/main.css" rel="stylesheet">
    <link href="../style/biblioAdd.css" rel="stylesheet">
    <link href="../style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="../media/biblioteca.ico"/>
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
<%--        <%--%>
<%--            String login = request.getParameter("login");--%>
<%--            if (user.getEmail() == null){--%>
<%--        %>--%>

        <div class = "rubrica-form">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="single-input">
                    <label for="cf-mail">Email o Codice Fiscale: </label>
                    <input type="text" name="cf-mail" id="cf-mail" required>
                </div>

                <div class="single-input">
                    <label for="password">Password: </label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="submit">
                    <input type="submit" value="Login">
                </div>
            </form>
        </div>

<%--        <%--%>
<%--        } else if (login != null && login.equalsIgnoreCase("false")){--%>
<%--        %>--%>
<%--        <p>Login fallito.</p>--%>
<%--        <%--%>
<%--        } else if (user.getEmail() != null){--%>
<%--        %>--%>
<%--        <p>Loggato con successo.</p>--%>

<%--        Email: <jsp:getProperty name="user" property="email"/>--%>
<%--        ID: <jsp:getProperty name="user" property="id"/>--%>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>
    </div>
</div>
</body>
</html>
