<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Admin page</title>
    <script>
    function toggle(elem) {
        var x = document.getElementById(elem);
        if (x.style.display === "none") {
          x.style.display = "block";
        } else {
          x.style.display = "none";
        }
      }</script>
</head>
<body>
    <header style="margin-left: 2em; display: flex;">
        <div style="width: 70%;"> 
            <h1>Operazioni su tabella "Utenti"</h1>
        <p>Clicca sulla scritta che ti interessa per visualizzare il form corrispondente.</p>
        </div>
       <div style="width: 30%;"> 
             <form action="/OortSpring/admin" method="GET">
                <button type="submit" name="req" value="homeadmin">Torna a Admin homepage</button>
            </form>
        </div>
    </header>
    <div style="margin-left: 2em;">
        
        <div>
            <h3 onclick="toggle('insert')">Inserimento nuovo utente:</h3>
            <form id="insert" action="/OortSpring/utenti/insert" method="POST" style="display: none;">
                <input type="text" placeholder="insert placeholder">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('delete')">Cancellazione utente:</h3>
            <form id="delete" action="/OortSpring/utenti/delete" method="POST" style="display: none;">
                <input type="number"name="id_utente">
                <input type="submit" value="Submit">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('update')">Modifica utente:</h3>
            <form id="update" action="/OortSpring/utenti/update" method="POST" style="display: none;">
                <input type="text" placeholder="update placeholder">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('select')">Visualizza lista utenti:</h3>
            <form id="select" action="/OortSpring/utenti/select" method="POST" style="display: none;">
                <input type="submit" value="Submit">
            </form>
        </div>
        ${utenti}
    </div>
</body>
</html>