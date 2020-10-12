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
            <h1>Operazioni su tabella "Editori"</h1>
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
            <h3  onclick="toggle('insert')">Inserimento nuovo editore:</h3>
            <form id="insert" style="display: none;">
                <input type="text" placeholder="insert placeholder">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('delete')">Cancellazione editore:</h3>
            <form id="delete" style="display: none;">
                <input type="text" placeholder="delete placeholder">
            </form>
        </div>
        <div>
            <h3  onclick="toggle('update')">Modifica editore:</h3>
            <form id="update" style="display: none;">
                <input type="text" placeholder="update placeholder">
            </form>
        </div>
        <div>
            <h3  onclick="toggle('select')">Visualizza lista editore</h3>
            <form id="select" style="display: none;">
                <input type="text" placeholder="select placeholder">
            </form>
        </div>
    </div>
</body>
</html>