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
            <h1>Operazioni su tabella "Autore"</h1>
        <p>Clicca sulla scritta che ti interessa per visualizzare il form corrispondente.</p>
        </div>
       <div style="width: 30%;"> 
            <form action="/OortSpring/admin" method="GET">
                <button type="submit" name="req" value="homeadmin">Torna a Admin homepage</button>
            </form>
        </div>
    </header>
    <div style="margin-left: 2em;">
        
        <div onclick="toggle('insert')">
            <h3>Inserimento nuovo autore:</h3>
            <form id="insert" action="/OortSpring/autori/insert" method="POST" style="display: none;">
                <label>Inserisci il nome dell'autore:</label>
                <input type="text" name="nome"><br>
                <label>Inserisci il cognome dell'autore:</label>
                <input type="text" name="cognome"><br>
                <label>Inserisci la data di nascita dell'autore:</label>
                <input type="date" name="data_nascita"><br>
                <label>Inserisci la data di morte dell'autore(o lascia vuoto):</label>
                <input type="date" name="data_morte"><br>
                <label>Inserisci una breve biografia dell'autore:</label>
                <input type="text" name="biografia"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div onclick="toggle('delete')">
            <h3>Cancellazione autore:</h3>
            <form id="delete" action="/OortSpring/autori/delete" method="POST" style="display: none;">
            	<label>Inserisci l'id dell'autore da cancellare:</label>
                <input type="number" name="id_autore" required>
            </form>
        </div>
        <div onclick="toggle('update')">
            <h3>Modifica autore:</h3>
            <form id="update" action="/OortSpring/autori/update" method="POST" style="display: none;">
                <label>Inserisci l'id (id_autore) dell'elemento da modificare</label>
            	<input type="number" name="id_autore"><br>
            	<label>Scegli il campo da modificare:</label>
            	<select name="field">
					<option value="nome">nome</option>
					<option value="cognome">cognome</option>
					<option value="data_nascita">data_nascita</option>
					<option value="data_morte">data_morte</option>
					<option value="biografia">biografia</option>
				</select><br>
            	<label>Inserisci il nuovo valore:</label>
                <input type="text" name="value"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div onclick="toggle('select')">
            <h3>Visualizza lista autore</h3>
            <form action="/OortSpring/autori/select" method="POST" id="select" style="display: none;">
                 <input type="submit" value="Submit">
            </form>
        </div>
        ${autori}
    </div>
</body>
</html>