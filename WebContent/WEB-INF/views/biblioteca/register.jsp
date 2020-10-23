<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRATI</title>
</head>
	<body>
		<jsp:useBean id="arraylist" class="java.util.ArrayList" scope="session"/>
		<h2><em>"Una biblioteca è un luogo dove si impara ciò che gli insegnanti hanno 
		paura di insegnare." <br> Alan M. Dershowitz</em></h2>
	 	
	 	<h4>Entra a far parte della Biblioteca!</h4>
	 	
	 	<h4 style="color:rgb(255, 0, 0);"> ${errore} </h4>
	 	<h4 style="color:rgb(0, 255, 0);"> ${registrato} </h4>
	 	<a href="./my_login">passa al login</a>
	 	
		<h3>Riempi il seguente form:</h3>
		<form action="./register" method="post" name="invio" >
			NOME:&nbsp;<input type="text" name="nome" placeholder="Vinicio" required/><br/>
			COGNOME:&nbsp;<input type="text" name="cognome" placeholder="Marchioni" required/><br/>
			TELEFONO:&nbsp;<input type="text" name="telefono" value=""/><br>
			EMAIL&nbsp;<input type="email" name="email" value="" placeholder="user@domain.it"
								required/><br/>
			PASSWORD&nbsp;<input type="password" name="password" value="" required/><br>
			CONFERMA PASSWORD&nbsp;<input type="password" name="password2" value="" 
										required onchange="verificaPassword()"/><br>
			<div id="passNo" style="color:rgb(255, 0, 0);"></div>
			<div id="passOk" style="color:rgb(0, 255, 0);"></div>
			
 			<input type="submit" value="INVIO" />
		</form>

		<script type="text/javascript">
			function verificaPassword() {
				// document.nome_del_form.nome_campo.value;
				document.getElementById('passOk').innerHTML="";
				document.getElementById('passNo').innerHTML="";
				let pass1 = document.invio.password.value;
				let pass2 = document.invio.password2.value;
				if (pass1 === pass2)
					document.getElementById('passOk').innerHTML="Le password sono uguali";
				else
					document.getElementById('passNo').innerHTML="ALERT: password incoerenti";
			}
	/*		function valida() { //onclick="valida()"
				return verificaPassword();
			}	
			function verificaEmail() {
				// document.nome_del_form.nome_campo.value;
				//var email = document.invio.email.value;
			} */	
		
		</script>
	</body>
</html>