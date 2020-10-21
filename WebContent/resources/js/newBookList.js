let table = document.getElementById('listLibri');
let tBody = table.getElementsByTagName('tbody')[0];

// On page load, it will show all books
window.onload = () => {
    loadLibri()
    // Removes the loader
    let loader = document.getElementById('loader');
    loader.parentNode.removeChild(loader);
}

// Main method to handle the change of list
function reload(){
    clean();
    let choice = document.getElementById('type').value;
    switch (choice){
        case 'Libri':
            loadLibri();
            break;
        case 'Autori':
            loadAutori();
            break;
        case 'Editori':
            loadEditori();
            break;
        case 'Prestiti':
            loadPrestiti();
            break;
    }
}

// GENERIC METHODS
// Clean tBody and remove the tHead
function clean(){
    while(tBody.rows.length > 0) {
        tBody.deleteRow(0);
    }
    table.deleteTHead();
}
// Util method to parse a date in long
function parseDate(dateLong){
    let date = new Date(dateLong).toLocaleDateString();
    return date === "Invalid Date" ? "" : date
}

// SEZIONE PRESTITI
function loadPrestiti(){
    fetch("/OortSpring/api/getPrestiti")
        .then(r => r.json())
        .then(printPrestiti)
        .catch(e => console.error("Errore: " + e))
}

function printPrestiti(prestiti){
    // Creo l'intestazione per la tabella. inner function per evitare conflitti con variabili nel main method
    {
        let fields = ['ID', 'CF Utente', 'Titolo', 'Data Inizio', 'Data Fine', 'Note']
        let tHead = table.createTHead();
        let headRow = document.createElement("tr");
        fields.forEach((field) => {
            let th = document.createElement("th");
            th.innerHTML = field;
            headRow.appendChild(th);
        });
        tHead.appendChild(headRow);
    }
    // Stampo le rows
    for (let i = 0; i < prestiti.length; i++) {
        let prestito = prestiti[i];
        let row = table.insertRow();
        row.insertCell().appendChild(document.createTextNode(prestito.id));
        row.insertCell().appendChild(document.createTextNode(prestito.cf_utente));
        row.insertCell().appendChild(document.createTextNode(prestito.libro.titolo));
        row.insertCell().appendChild(document.createTextNode(parseDate(prestito.data_inizio)));
        row.insertCell().appendChild(document.createTextNode(parseDate(prestito.data_fine)));
        row.insertCell().appendChild(document.createTextNode(prestito.note));
    }
}

// SEZIONE EDITORI
function loadEditori(){
    fetch("/OortSpring/api/getEditori")
        .then(r => r.json())
        .then(printEditori)
        .catch(e => console.error("Errore: " + e))
}

function printEditori(editori){
    // Creo l'intestazione per la tabella. inner function per evitare conflitti con variabili nel main method
    {
        let fields = ['ID', 'Nome', 'Descrizione']
        let tHead = table.createTHead();
        let headRow = document.createElement("tr");
        fields.forEach((field) => {
            let th = document.createElement("th");
            th.innerHTML = field;
            headRow.appendChild(th);
        });
        tHead.appendChild(headRow);
    }
    // Stampo le rows
    for (let i = 0; i < editori.length; i++) {
        let editore = editori[i];
        let row = table.insertRow();
        row.insertCell().appendChild(document.createTextNode(editore.id));
        row.insertCell().appendChild(document.createTextNode(editore.nome));
        row.insertCell().appendChild(document.createTextNode(editore.descrizione));
    }
}

// SEZIONE LIBRI
function loadLibri(){
    fetch("/OortSpring/api/getBooks")
        .then(r => r.json())
        .then(printLibri)
        .catch(e => console.error("Errore: " + e))
}

function printLibri(libri){
    // Creo l'intestazione per la tabella. inner function per evitare conflitti con variabili nel main method
    {
        let fields = ['ID', 'Titolo', 'Autore', 'Editore', 'Data Pubblicazione', 'Sinossi']
        let tHead = table.createTHead();
        let headRow = document.createElement("tr");
        fields.forEach((field) => {
            let th = document.createElement("th");
            th.innerHTML = field;
            headRow.appendChild(th);
        });
        tHead.appendChild(headRow);
    }
    // Stampo le rows
    for (let i = 0; i < libri.length; i++) {
        let libro = libri[i];
        let row = table.insertRow();
        row.insertCell().appendChild(document.createTextNode(libro.id));
        row.insertCell().appendChild(document.createTextNode(libro.titolo));
        row.insertCell().appendChild(document.createTextNode(libro.autore.nome + " " + libro.autore.cognome));
        row.insertCell().appendChild(document.createTextNode(libro.editore.nome));
        row.insertCell().appendChild(document.createTextNode(parseDate(libro.anno_pubblicazione)));
        row.insertCell().appendChild(document.createTextNode(libro.descrizione));
    }
}

// SEZIONE AUTORI
function loadAutori(){
    fetch("/OortSpring/api/getAuthors")
        .then(r => r.json())
        .then(printAuthors)
        .catch(e => console.error("Errore: " + e))
}

function printAuthors(autori){
    // Creo l'intestazione per la tabella. inner function per evitare conflitti con variabili nel main method
    {
        let fields = ['ID', 'Nome', 'Cognome', 'Data di Nascita', 'Data di Morte', 'Biografia']
        let tHead = table.createTHead();
        let headRow = document.createElement("tr");
        fields.forEach((field) => {
            let th = document.createElement("th");
            th.innerHTML = field;
            headRow.appendChild(th);
        });
        tHead.appendChild(headRow);
    }
    // Stampo le rows
    for (let i = 0; i < autori.length; i++) {
        let autore = autori[i];
        let row = table.insertRow();
        row.insertCell().appendChild(document.createTextNode(autore.id));
        row.insertCell().appendChild(document.createTextNode(autore.nome));
        row.insertCell().appendChild(document.createTextNode(autore.cognome));
        row.insertCell().appendChild(document.createTextNode(parseDate(autore.data_nascita)));
        row.insertCell().appendChild(document.createTextNode(parseDate(autore.data_morte)));
        row.insertCell().appendChild(document.createTextNode(autore.biografia));
    }
}