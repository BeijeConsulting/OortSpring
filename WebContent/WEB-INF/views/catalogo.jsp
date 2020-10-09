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

		<%--controlla se la richiesta è stata fatta dalla servlet Smistatore o dalla servlet Catalogo --%>
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
				    <th>Disponibilità</th>    
				  </tr>		
		<%	 for(Libri l : (List<Libri>)session.getAttribute("catalogo")){ 
				Autori autore = JPDBtools.ricercaAutore(l.getAutore());
				Editori editore = JPDBtools.ricercaEditore(l.getEditore()); %>
				 <tr>
					<th><%=l.getId() %></th>
					<th><%=l.getTitolo() %></th>
					<th><%=autore.getNome() %> <%= autore.getCognome()%></th>
					<th><%=editore.getDenominazione() %></th>  		
					<th><%=l.getAnno() %></th>		
				<%String disponibilita = "Non disponibile";
					for(Prestiti p : JPDBtools.ricercaPrestitiId("libro", l.getId())){
						if(p.getData_fine()!=null &&p.getData_fine().isBefore(java.time.LocalDate.now()))
							disponibilita = "Disponibile";
						else disponibilita = "Non disponibile"; }%>
				<th> <%=disponibilita %></th>
			</tr>		
			<%} } %>

			<%-- se la richiesta è stata fatta dal menu, sulla pagina si vede solo quello che segue --%>
			<h3>Inserisci gli id per i quali vuoi cercare i libri</h3>
			<h4>Inserisci 0 per omettere il campo corrispondente nella ricerca</h4>	
			<a href="./CatalogoAutori">Autori</a>
			<a href="./CatalogoEditori">Editori</a>
			<form action="./Catalogo" method="post">
			ID AUTORE&nbsp;<input type ="text" name = "Autore" value ="0" placeholder="1">
			ID EDITORE&nbsp;<input type ="text" name = "Editore"  value ="0" placeholder="1">		
			<br><input type="submit" value="INVIO">
			</form>
			
			<form action="./" method="get">
			<input type="submit" value="HOME" name="Menu">
			</form>
			<% if(session.getAttribute("admin").equals("on")){ %>
			<form action="./NewPrestito" method="get">
			<input type="submit" value="NewPrestito">
			</form>
			<form action="./DeleteLibro" method="get">
			<input type="submit" value="DeleteLibro">
			</form>
			<% } %>
</body>
</html>