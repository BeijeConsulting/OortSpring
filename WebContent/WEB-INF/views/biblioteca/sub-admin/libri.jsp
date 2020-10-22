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
    
    function get(){
		fetch('/OortSpring/api/libri')
			.then(response => response.json())
			.then(function(data) {
				data.forEach(function(item, index) {
					console.log(index, item.titolo);
					document.getElementById('dynamicList').innerHTML += '<li>'+item.titolo+'</li>'
				})
			});
    }
    
    function insert(form) {
    	//TODO async POST request to "/OortSpring/api/libro" that passes new Libro in json format.
    }
    
    function update(libro) {
    	//TODO async PUT request to "/OortSpring/api/libro/{id}" that passes updated Libro in json.
    }
    </script>
</head>
<body>
    <header style="margin-left: 2em; display: flex;">
        <div style="width: 70%;"> 
            <h1>Operazioni su tabella "Libri"</h1>
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
            <h3 onclick="toggle('insert')">Inserimento nuovo libro:</h3>
            <form id="insert" action="/OortSpring/libri/insert" method="POST" style="display: none;">
                <label>Inserisci l'id dell'autore del libro:</label>
                <input type="number" name="id_autore"><br>
                <label>Inserisci l'id dell'editore del libro:</label>
                <input type="number" name="id_editore"><br>
                <label>Inserisci il titolo del libro:</label>
                <input type="text" name="titolo"><br>
                <label>Inserisci l'anno di pubblicazione:</label>
                <input type="number" name="anno"><br>
                <label>Inserisci una breve descrizione del libro:</label>
                <input type="text" name="descrizione"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('delete')">Cancellazione libro:</h3>
            <form id="delete" action="/OortSpring/libri/delete" method="POST" style="display: none;">
                <input type="number" name="id_libro" required>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('update')">Modifica libro:</h3>
            <form id="update" action="/OortSpring/libri/update" method="POST" style="display: none;">
                <label>Inserisci l'id (id_libro) dell'elemento da modificare</label>
            	<input type="number" name="id_libro"><br>
            	<label>Scegli il campo da modificare:</label>
            	<select name="field">
					<option value="id_autore">id_autore</option>
					<option value="id_editore">id_editore</option>
					<option value="titolo">titolo</option>
					<option value="anno">anno</option>
					<option value="descrizione">descrizione</option>
				</select><br>
            	<label>Inserisci il nuovo valore:</label>
                <input type="text" name="value"><br>
                <input type="submit" value="Submit">
            </form>
        </div>
        <div>
            <h3 onclick="toggle('select')">Visualizza lista libri:</h3>
            <form id="select" action="/OortSpring/libri/select" method="POST" style="display: none;">
                <input type="submit" value="Submit">
            </form>
        </div>
        ${libri}
    </div>
    <div>
    	<button name="ajax" onclick="get()">Carica libri con ajax</button>
    	<ul id="dynamicList">
    	</ul>
    </div>
</body>
</html>