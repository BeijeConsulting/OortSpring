<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="it.beije.oort.brugaletta.entity.*"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER HOMEPAGE</title>
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
<body>
	<table>
    <tr>
      <th>BENVENUTO ${loggedUser.nome}</th>
    </tr>
    <tr>
      <td><a href = "prestiti">Visualizza i tuoi prestiti</a></td>
    </tr>
    <tr>
      <td><a href = "nuovoPrestito" >Prendi in prestito un nuovo libro</a></td>
    </tr>
     <tr>
      <td><a href = "logout">Esci</a></td>
    </tr>
  </table>
</body>
</html>