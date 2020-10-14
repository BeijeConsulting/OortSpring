<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ti sei registrato!</title>
    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioAdd.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico" />
</head>
<body>
<div class="home">
    <a href="${pageContext.request.contextPath}/register"><i class="fas fa-home"></i></a>
</div>
<div class="container">
    <div class = "small-center-container">
        <div class="header">
            <h1><i>Ti sei registrato!</i></h1>
        </div>

        <p>Ti sei registrato con successo!</p>
        <a href="${pageContext.request.contextPath}/login">Login</a>

    </div>
</div>
</body>
</html>
