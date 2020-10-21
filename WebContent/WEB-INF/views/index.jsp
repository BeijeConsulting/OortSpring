<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
    <link href="${pageContext.request.contextPath}/resources/style/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioAdd.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/style/biblioView.css" rel="stylesheet">

    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <script src="https://kit.fontawesome.com/e8e37b0541.js" crossorigin="anonymous"></script>
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/media/biblioteca.ico" />
</head>
<body>
    <a href="${pageContext.request.contextPath}/login">Login</a>
    <br>
    <a href="${pageContext.request.contextPath}/loginSkip">Skip Login</a>
    <br>
    <a href="${pageContext.request.contextPath}/register">Register</a>
    <br>
    <a href="${pageContext.request.contextPath}/newList">Nuova Lista AJAX</a>
</body>
</html>
