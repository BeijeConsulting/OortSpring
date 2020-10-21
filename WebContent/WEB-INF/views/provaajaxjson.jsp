<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>prova ajax e json</title>
</head>
<body>
	<p>Ciao</p>	
	
</body>

<script>
function Ciao(){
	return fetch("./books_list/1");
}

</script>

</html>