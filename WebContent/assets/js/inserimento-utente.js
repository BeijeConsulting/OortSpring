var email = "";
var password = "";

function loginCheck() {

	email = document.getElementById("email").value;
	password = document.getElementById("password").value;

	if(!email) {
		document.getElementById("erroreEmail").innerHTML = "Errore: inserire una mail";
	}
	else {
		document.getElementById("erroreEmail").innerHTML = "";
	}
	
	if(!password) {
		document.getElementById("errorePassword").innerHTML = "Errore: inserire una password";
	}
	else {
		document.getElementById("errorePassword").innerHTML = "";
	}


}

function checkSubmit() {
	email = document.getElementById("email").value;
	password = document.getElementById("password").value;
	
	if(email && password) {
		return true;
	}
	else {
		return false;
	}
}