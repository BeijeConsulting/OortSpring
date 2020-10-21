<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>Biblioteca dati</title>
</head>
<body>

<h1 class="text-center">Biblioteca - Visualizzazione dati</h1>

<div class="text-center mt-2">
	<select id="table_select" onchange="onChangeTableSelect(this.value)">
		<option selected disabled value="">Scegli una opzione</option>
		<option value="autore">Autore</option>
		<option value="editore">Editore</option>
	</select>
</div>

<div id="table_pages" class="d-flex d-row justify-content-between mt-2 pl-2 pr-2">
	<div>
		<select id="numero_pagina_select" onchange="onChangeNumeroPaginaSelect(this.value)">
			<option disabled value="">Scegli</option>
			<option selected value="2">2</option>
			<option value="5">5</option>
			<option value="10">10</option>
			<option value="20">20</option>
		</select>
	</div>
	<div>Pagina <span id="nPagina">non presente</span><span id="nMaxPagina"></span></div>
	<div id="table_buttons">
		<button id="button_prev" type="button" class="btn-dark" onclick="onClickPrev()">Prec</button>
		<button id="button_next" type="button" class="btn-dark" onclick="onClickNext()">Succ</button>
	</div>
</div>

<div id="table_data" class="mt-2"></div>

<script>

var page = 1;
var maxPage = 1;
var numPerPage = 2;

function resetTable() {
	page = 1;
	maxPage = 1;
	document.getElementById("nPagina").innerHTML = 1;
}

function setMaxPage(list) {
	let division = list.length / numPerPage;
	maxPage = Math.trunc(division);
	if (maxPage < division) { maxPage++; }
	document.getElementById("nMaxPagina").innerHTML = "/" + maxPage;
}

function minIndex() {
	return (page - 1) * numPerPage;
}

function maxIndex(list) {
	let maxIndex = page * numPerPage;
	maxIndex = maxIndex < list.length ? maxIndex : list.length;
	return maxIndex;
}

function nextPage() {
	if(page < maxPage) {
		page++;
		nextButtonHide();
		prevButtonHide();
		document.getElementById("nPagina").innerHTML = page;
	}
}

function prevPage() {
	if(page > 1) {
		page--;
		nextButtonHide();
		prevButtonHide();
		document.getElementById("nPagina").innerHTML = page;
	}
}

function nextButtonHide() {
	let button = document.getElementById("button_next");
	if (page < maxPage) {
		button.style.visibility = "visible";
	} else {
		button.style.visibility = "hidden";
	}
}

function prevButtonHide() {
	let button = document.getElementById("button_prev");
	if (page > 1) {
		button.style.visibility = "visible";
	} else {
		button.style.visibility = "hidden";
	}
}

function buttonsTableHiding() {
	nextButtonHide();
	prevButtonHide();
}

function onChangeTableSelect(value) {
	resetTable();
	visualizeTable(value);
}
function onChangeNumeroPaginaSelect(numero) {
	let value = document.getElementById("table_select").value;
	numPerPage = numero;
	resetTable();
	visualizeTable(value);
}

function onClickNext() {
	let value = document.getElementById("table_select").value;
	nextPage();
	visualizeTable(value);
}
function onClickPrev() {
	let value = document.getElementById("table_select").value;
	prevPage();
	visualizeTable(value);
}

function visualizeTable(value) {
	let path = getContextPath();
	if (value == "autore") {
		fetch(path + "/api/autori")
		.then(response => response.json())
		.then(json => { setMaxPage(json); buttonsTableHiding(); buildTableAutore(json) });
	} else if (value == "editore") {
		fetch(path + "/api/editori")
		.then(response => response.json())
		.then(json => { setMaxPage(json); buttonsTableHiding(); buildTableEditore(json) });
	}
}

function buildTable(tableContainer) {
	let tableData = document.getElementById("table_data");
	removeTableContent();
	tableData.appendChild(tableContainer);
}

function buildTableAutore(autori) {
	let tableContainer = buildTableContainer();
	
	let tableHeader = buildTableHeader();
	tableHeader.appendChild(buildTableCol("Nome"));
	tableHeader.appendChild(buildTableCol("Cognome"));
	tableHeader.appendChild(buildTableCol("Data nascita"));
	tableHeader.appendChild(buildTableCol("Data morte"));
	tableHeader.appendChild(buildTableCol("Biografia"));
	tableContainer.appendChild(tableHeader);
	
	for (let i = minIndex(); i < maxIndex(autori); i++) {
		let tableRow = buildTableRow();
		tableRow.appendChild(buildTableCol(autori[i].nome));
		tableRow.appendChild(buildTableCol(autori[i].cognome));
		tableRow.appendChild(buildTableCol(autori[i].data_nascita));
		tableRow.appendChild(buildTableCol(autori[i].data_morte));
		tableRow.appendChild(buildTableCol(autori[i].biografia));
		tableContainer.appendChild(tableRow);
	}
	
	buildTable(tableContainer);
}

function buildTableEditore(editori) {
	let tableContainer = buildTableContainer();
	
	let tableHeader = buildTableHeader();
	tableHeader.appendChild(buildTableCol("Denominazione"));
	tableHeader.appendChild(buildTableCol("Descrizione"));
	tableContainer.appendChild(tableHeader);
	
	for (let i = minIndex(); i < maxIndex(editori); i++) {
		let tableRow = buildTableRow();
		tableRow.appendChild(buildTableCol(editori[i].denominazione));
		tableRow.appendChild(buildTableCol(editori[i].descrizione));
		tableContainer.appendChild(tableRow);
	}
	
	buildTable(tableContainer);
}


function buildTableContainer() {
	let tableContainer = document.createElement("div");
	tableContainer.classList.add("container");
	return tableContainer;
}

function buildTableHeader() {
	let tableHeader = document.createElement("div");
	tableHeader.classList.add("row");
	tableHeader.classList.add("bg-dark");
	tableHeader.classList.add("text-light");
	tableHeader.classList.add("font-weight-bold");
	return tableHeader;
}

function buildTableRow() {
	let tableRow = document.createElement("div");
	tableRow.classList.add("row");
	tableRow.classList.add("bg-light");
	tableRow.classList.add("text-dark");
	return tableRow;
}

function buildTableCol(content) {
	let tableCol = document.createElement("div");
	tableCol.classList.add("col");
	tableCol.innerHTML = content == null ? "" : content;
	return tableCol;
}

function removeTableContent() {
	let table = document.getElementById("table_data");
	while(table.firstChild) {
		table.removeChild(table.lastChild);
	}
}

function getContextPath() {
	   return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
}

</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>