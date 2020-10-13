<%@page import="org.springframework.ui.Model"%>
<%@page import="java.time.LocalDate"%>
<%@page import="it.beije.oort.sb.jpa.JPDBtools"%>
<%@page import="it.beije.oort.sb.biblioteca.Autori"%>
<%@page import="it.beije.oort.sb.biblioteca.Libri"%>
<%@page import="it.beije.oort.sb.biblioteca.Editori"%>
<%@page import="it.beije.oort.sb.biblioteca.Prestiti"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogo Biblioteca Oort</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body >

		<%--controlla se la richiesta � stata fatta dalla servlet Smistatore o dalla servlet Catalogo --%>
		<% 	
		if(((String)(session.getAttribute("richiestaCatalogo"))).equals("off")){	
			%>
				<h2>Catalogo Libri</h2>
				<table>
				  <tr>
				    <th>ID</th>
				    <th>Titolo</th>
				    <th>Autore</th>
				    <th>Editore</th>
				    <th>Anno</th>
				    <th>Disponibilit�</th>    
				  </tr>		
		<%	 for(Libri l : (List<Libri>)session.getAttribute("catalogo")){ 
				Autori autore = JPDBtools.ricercaAutore(l.getAutore());
				Editori editore = JPDBtools.ricercaEditore(l.getEditore()); %>
				 <tr>
					<td><%=l.getId() %></td>
					<td><%=l.getTitolo() %></td>
					<td><%=autore.getNome() %> <%= autore.getCognome()%></td>
					<td><%=editore.getDenominazione() %></td>  		
					<td><%=l.getAnno() %></td>		
				<%String disponibilita = "Non disponibile";
					for(Prestiti p : JPDBtools.ricercaPrestitiId("libro", l.getId())){
						if(p.getData_fine()!=null &&p.getData_fine().isBefore(java.time.LocalDate.now()))
							disponibilita = "Disponibile";
						else disponibilita = "Non disponibile"; }%>
				<td> <%=disponibilita %></td>
			</tr>		
			<%} } %>

			<%-- se la richiesta � stata fatta dal menu, sulla pagina si vede solo quello che segue --%>
			<h3>Inserisci gli id per i quali vuoi cercare i libri</h3>
			<a href="./CatalogoAutori">Autori</a>
			<a href="./CatalogoEditori">Editori</a>
			<form action="./Catalogo" method="post">
			ID AUTORE&nbsp;<input type ="text" name = "autore" value ="" placeholder="1">
			ID EDITORE&nbsp;<input type ="text" name = "editore"  value ="" placeholder="1">		
			<br><input type="submit" value="INVIO">
			</form>
			
			<form action="./" method="get">
			<input type="submit" value="HOME" name="Menu">
			</form>
			<% if("on".equals(session.getAttribute("admin"))){ %>
			<form action="./NewPrestito" method="get">
			<input type="submit" value="NewPrestito">
			</form>
			<form action="./DeleteLibro" method="get">
			<input type="submit" value="DeleteLibro">
			</form>
			<% } %>
</body>
</html>