/**
 * 
 */

function resetMessaggesForm() {
	let messageBox = document.getElementById("formError");
	messageBox.innerHTML = "";
	if (messageBox.classList.contains("isa_error")) {
		messageBox.classList.remove("isa_error");
	}
}

function appendErrorMessageForm(message) {
	let messageBox = document.getElementById("formError");
	let erroreMsg = messageBox.innerHTML;
	messageBox.innerHTML = erroreMsg.concat(message);
	if (! messageBox.classList.contains("isa_error")) {
		messageBox.classList.add("isa_error");
	}
}

function validateForm(form) {
	resetMessaggesForm();
	let isValid = false;
	if (form.name == "autoreForm") {
		isValid = validateAutoreForm();
	} else if (form.name == "editoreForm") {
		isValid = validateEditoreForm();
	} else if (form.name == "libroForm") {
		isValid = validateLibroForm();
	} else if (form.name == "prestitoForm") {
		isValid = validatePrestitoForm();
	} else if (form.name == "utenteForm") {
		isValid = validateUtenteForm();
	} else if (form.name == "loginForm") {
		isValid = validateLoginForm();
	}
	return isValid; 
}

function validateAutoreForm() {
	let cognome = document.getElementById("cognomeId").value;
	let isValid = true;
	
	if (stringIsEmpty(cognome)) {
		isValid = false;
		appendErrorMessageForm("Cognome non pu\u00F2 essere vuoto. ");
	}
	
	return isValid;
}

function validateEditoreForm() {
	let denominazione = document.getElementById("denominazioneId").value;
	let isValid = true;
	
	if (stringIsEmpty(denominazione)) {
		isValid = false;
		appendErrorMessageForm("Denominazione non pu\u00F2 essere vuoto. ");
	}
	
	return isValid;
}

function validateLibroForm() {
	let titolo = document.getElementById("titoloId").value;
	let idAutore = document.getElementById("idAutoreId").value;
	let idEditore = document.getElementById("idEditoreId").value;
	let anno = document.getElementById("annoId").value;
	let isValid = true;
	
	if (stringIsEmpty(titolo)) {
		isValid = false;
		appendErrorMessageForm("Titolo non pu\u00F2 essere vuoto. ");
	}
	
	if (!stringIsEmpty(idAutore) && !stringIsNumber(idAutore)) {
		isValid = false;
		appendErrorMessageForm("Autore ID non \u00E8 un numero. ");
	}
	
	if (!stringIsEmpty(idEditore) && !stringIsNumber(idEditore)) {
		isValid = false;
		appendErrorMessageForm("Editore ID non \u00E8 un numero. ");
	}
	
	if (!stringIsEmpty(anno) && !stringIsNumber(anno)) {
		isValid = false;
		appendErrorMessageForm("Anno pubblicazione non \u00E8 un numero. ");
	} else if (!stringIsEmpty(anno) && anno < 0) {
		isValid = false;
		appendErrorMessageForm("Anno pubblicazione non pu\u00F2 essere negativo. ");
	}
	
	return isValid;
}

function validatePrestitoForm() {
	let idLibro = document.getElementById("idLibroId").value;
	let idUtente = document.getElementById("idUtenteId").value;
	let isValid = true;
	
	if (stringIsEmpty(idLibro)) {
		isValid = false;
		appendErrorMessageForm("Libro ID non pu\u00F2 essere vuoto. ");
	} else if(!stringIsNumber(idLibro)) {
		isValid = false;
		appendErrorMessageForm("Libro ID non \u00E8 un numero. ");
	}
	
	if (stringIsEmpty(idUtente)) {
		isValid = false;
		appendErrorMessageForm("Utente ID non pu\u00F2 essere vuoto. ");
	} else if(!stringIsNumber(idUtente)) {
		isValid = false;
		appendErrorMessageForm("Utente ID non \u00E8 un numero. ");
	}
	
	return isValid;
}

function validateUtenteForm() {
	let cognome = document.getElementById("cognomeId").value;
	let email = document.getElementById("emailId").value;
	let isValid = true;
	
	if (stringIsEmpty(cognome)) {
		isValid = false;
		appendErrorMessageForm("Cognome non pu\u00F2 essere vuoto. ");
	}
	
	if (stringIsEmpty(email)) {
		isValid = false;
		appendErrorMessageForm("Email non pu\u00F2 essere vuoto. ");
	}
	
	return isValid;
}

function validateLoginForm() {
	let email = document.getElementById("emailId").value;
	let password = document.getElementById("passwordId").value;
	let isValid = true;
	
	if (stringIsEmpty(email)) {
		isValid = false;
		appendErrorMessageForm("Email non pu\u00F2 essere vuoto. ");
	}
	
	if (stringIsEmpty(password)) {
		isValid = false;
		appendErrorMessageForm("Password non pu\u00F2 essere vuoto. ");
	}
	
	return isValid;
}

function stringIsNumber(str) {
	return !isNaN(str);
}

function stringIsEmpty(str) {
	return str === "";
}