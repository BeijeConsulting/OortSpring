<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Admin page</title>
</head>
<body>
    <header style="margin-left: 2em; display: flex;">
        <div style="width: 70%;">
			<h1>Operazioni avanzate su database "Biblioteca"</h1>
        	<p>Clicca sulla tabella desiderata.</p>
        </div>
       <div style="width: 30%;">
            <form action="/OortSpring/auth" method="GET">
                <input type="hidden" name="logout" value="true">
                <button type="submit" style="float: right;">Logout</button>
            </form>
        </div>
    </header>
    <div style="margin-left: 2em;">
    <p> Solo la pagina prestiti funziona </p>
        <form action="/OortWeb/admin" method="GET">
            <button type="submit" name="req" value="prestiti">Prestiti</button>
            <button type="submit" name="req" value="utenti">Utenti</button>
            <button type="submit" name="req" value="libri">Libri</button>
            <button type="submit" name="req" value="autori">Autori</button>
            <button type="submit" name="req" value="editori">Editori</button>
        </form>
    </div>
</body>
</html>