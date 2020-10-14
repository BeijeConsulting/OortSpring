<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
      }
    </script>
</head>
<body>
    <header style="margin-left: 2em; display: flex;">
        <div style="width: 70%;"> 
            <h1>Operazioni su tabella "Prestiti"</h1>
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
            <h3 onclick="toggle('insert')">Inserimento nuovo prestito:</h3>
            <form id="insert" action="/OortSpring/prestiti/insert" method="POST" style="display: none;">
            	<label>Inserisci l'id dell'utente che sta effettuando il prestito:</label>
                <input type="number" name="id_utente"><br>
                <label>Inserisci l'id del libro che si sta prestando:</label>
                <input type="number" name="id_libro"><br>
                <label>Inserisci la data di inizio del prestito:</label>
                <input type="date" name="data_inizio"><br>
                <label>Inserisci la data di fine del prestito(se terminato):</label>
                <input type="date" name="data_fine"><br>
                <label>Inserisci eventuali note:</label>
                <input type="text" name="note"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('delete')">Cancellazione prestito:</h3>
            <form id="delete" action="/OortSpring/prestiti/delete" method="POST" style="display: none;">
            	<label>Inserisci l'id (id_prestito) dell'elemento da cancellare:</label>
                <input type="number" name="id_prestito" required>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('update')">Modifica prestito:</h3>
            <form id="update" action="/OortSpring/prestiti/update" method="POST" style="display: none;">
            	<label>Inserisci l'id (idPrestito) dell'elemento da modificare</label>
            	<input type="number" name="idPrestito"><br>
            	<label>Scegli il campo da modificare:</label>
            	<select name="field">
					<option value="idUtente">idUtente</option>
					<option value="idLibro">idLibro</option>
					<option value="dataInizio">dataInizio</option>
					<option value="dataFine">dataFine</option>
					<option value="note">note</option>
				</select><br>
            	<label>Inserisci il nuovo valore:</label>
                <input type="text" name="value"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>