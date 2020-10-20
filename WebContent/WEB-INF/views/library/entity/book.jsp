<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Application</title>
</head>
<body>

	<h3>Library Application</h3>
		
	<fieldset>

		<legend>
			<b>Book</b>
		</legend>
	
		<p>
			ID:  ${book.getId()}<br>
			Title: ${book.getTitle()}<br>
			Description: ${book.getDescription()}<br>
			Author: ${author}<br>
			Publisher: ${publisher}<br>
			Year: ${book.getYear()}<br>
		</p>
	
	</fieldset>
	
	<a href="/OortSpring/library/borrow">Back</a>	
	
</body>
</html>