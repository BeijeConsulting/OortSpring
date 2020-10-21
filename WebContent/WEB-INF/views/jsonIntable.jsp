<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<c:url value="/resources/css/biblio.css" />">
<title>prova ajax e json</title>
</head>
<body>

	<table>
		<tr>
			<th>Id</th>
			<th>Titolo</th>
			<th>Autore</th>
			<th>Editore</th>
			<th>Anno</th>
		</tr>

		
		<tbody id="myTable">
		</tbody>
	</table>
</body>

<script>
 
	fetch("./books_list")
	.then(response => response.json())
	.then(json => buildTable(json))
	
	function buildTable(data){
		var table = document.getElementById('myTable')
		for(var i = 0; i < data.length; i++){
			console.log(data[i].id, data[i].titolo)
			var row = '<tr><td>'+data[i].id+'</td><td>'+data[i].titolo+'</td><td>'+data[i].id_autore+'</td><td>'+data[i].id_editore+'</td><td>'+data[i].anno+'</td></tr>'
			table.innerHTML += row
		}
	}
</script>

</html>