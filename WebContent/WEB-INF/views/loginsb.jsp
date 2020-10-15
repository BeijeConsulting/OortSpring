<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login</title>
</head>

<body>
	${errore}
	<h3>Inserisci le tue credenziali</h3>
	<form action="./login" method="post" onsubmit="return check()"> 
		EMAIL&nbsp;<input type="email" id="email" name="email" value="" placeholder="user@domain.it"/><br />
		PASSWORD&nbsp;<input type="password" id="password" name="password" value="" /><br>
		<input type="submit" value="INVIO" />
	</form><br>
	<div id="msg"></div>
	<a href="./catalogo">Catalogo Libri</a>
<script>
	function check(){
		var email = document.getElementById("email");
		var password = document.getElementById("password");
		if(!email.value||!password.value){
				document.getElementById("msg").innerHTML= "la mail o la password non può essere nulla";
				return false;
		} else return true;
	}

</script>

</body>

</html>