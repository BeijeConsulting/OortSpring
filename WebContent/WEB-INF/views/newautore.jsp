<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuovo Autore</title>
</head>
<body>
<form action="./newautore" method="post" onsubmit="return check()">
	NOME <input type="text" value="" name="nome" placeholder="Dante"/><br>
	COGNOME <input type="text" id="cognome" value="" name="cognome" placeholder="Alighieri"/><br>
	DATA DI NASCITA <input type="text" value="" id="dataDiNascita" name="dataDiNascita" placeholder="yyyy-MM-dd"/><br>
	DATA DI MORTE <input type="text" value=""  name="dataDiMorte" placeholder="yyyy-MM-dd"/>
	BIOGRAFIA <input type="text" value="" name="biografia" placeholder="info"/><br>
	<input type="submit" value="INVIO"/> <input type="reset" value="ANNULLA"/>
</form>
<div id="msg"></div>
<a href="./">HOME</a>
<script>
	function check(){
		var cognome = document.getElementById("cognome");
		var dataDiNascita = document.getElementById("dataDiNascita");
		if(!cognome.value){
			document.getElementById("msg").innerHTML="Il cognome non può non avere valore";
			return false
		}
		else if(!dataDiNascita.value){
			document.getElementById("msg").innerHTML="La data di nascita non può non avere valore";
			return false
		} else return true;
	}
</script>
</body>
</html>