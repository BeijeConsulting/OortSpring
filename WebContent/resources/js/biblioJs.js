
// utili per controllo su utente, autore ed editore(denominazione==name)
function checkName(name){
	if(name==="") return false;
	else return true;
} 
function checkCodFis(cf){
	if(cf==="") return false;
	else return true;
} 
function checkSurname(surname){
	if(surname==="") return false;
	else return true;
} 
function checkEmail(email){
	if(email==="") return false;
	else return true;
}
function checkPsw(psw){
	if(psw==="") return false;
	else return true;
} 

// per sapere se è stato inserito il titolo del libro
function checkTitle(title){
	if(title==="") return false;
	else return true;
} 

// per verificare gli id
function checkIdUser(id){
	if(id==="") return false;
	else return true;
}
function checkIdAuthor(id){
	if(id==="") return false;
	else return true;
}
function checkIdEditor(id){
	if(id==="") return false;
	else return true;
} 
function checkIdBook(id){
	if(id==="") return false;
	else return true;
}

// per i prestiti
function startDate(date){
	if(date==="") return false;
	else return true;
}
function endtDate(date){
	if(date==="") return false;
	else return true;
}

// data di nascita e morte dell'autore
function birthDate(date){
	if(date==="") return false;
	else return true;
}
function deathtDate(date){
	if(date==="") return false;
	else return true;
}

var firstname = checkName("ciao");
console.log('check: ', firstname);

function Ciao(formEl){
	
	var n = document.getElementById('nome').value;	
	if(name==="") console.log('nome: ',n);
		//if(nome){
			if (formEl.email.value && formEl.password.value){
				if(checkName(formEl.nome.value)) return true;
				else{
					document.getElementById('msgErr').innerHTML="MANCA IL NOME";
					return false;
				}
			} 
			else {
				document.getElementById('msgErr').innerHTML="CREDENZIALI INCOMPLETE";
				return false;	
			}
		/* }
		else{
			document.getElementById('msgErr').innerHTML="MANCA IL NOME";
			return false;
		} */
		
	}