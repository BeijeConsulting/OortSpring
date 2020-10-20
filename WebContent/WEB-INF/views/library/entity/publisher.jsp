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
			<b>Publisher</b>
		</legend>
	
		<p>
			ID:  ${publisher.getId()}<br>
			Name: ${publisher.getName()}<br>
			Description: ${publisher.getDescription()}<br>
		</p>
	
	</fieldset>
	
	<a href="/OortSpring/library/view">Back</a>	
	
</body>
</html>