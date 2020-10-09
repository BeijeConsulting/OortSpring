<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Libro"%>
<%@page import="it.beije.oort.madonia.biblioteca.ebeans.Prestito"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tuoi prestiti</title>
<link rel="stylesheet" href="<c:url value="/resources/css/myCss.css" />">
</head>
<body>
	
	<c:if test="${ erroreMsg != null }" >
		<div class="isa_error">${ erroreMsg }</div>
	</c:if>
	<c:if test="${ successoMsg != null }" >
		<div class="isa_success">${ successoMsg }</div>
	</c:if>

	<div class="titolo">Tuoi prestiti</div>
	<div class="descrizione">I prestiti che hai effettuato nella
		biblioteca</div>
	<div class="rTable">
		<div class="rTableRow">
			<div class="rTableHead">
				<strong>Libro</strong>
			</div>
			<div class="rTableHead">
				<strong>Data inizio</strong>
			</div>
			<div class="rTableHead">
				<strong>Data fine</strong>
			</div>
		</div>
		
		<c:forEach items="${ listaPrestiti }" var="prestito">
			<div class="rTableRow">
				<div class="rTableCell">${ mappaTitoli[prestito.idLibro] }</div>
				<div class="rTableCell">${ prestito.dataInizio == null ? "" : prestito.dataInizio }</div>
				<div class="rTableCell">${ prestito.dataFine == null ? "" : prestito.dataFine }</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>