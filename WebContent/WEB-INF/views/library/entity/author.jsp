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
			<b>Author</b>
		</legend>
	
		<p>
			ID:  ${author.getId()}<br>
			Name: ${author.getName()}<br>
			Surname: ${author.getSurname()}<br>
			Date of birth: ${author.getDateOfBirth() != null ? author.getDateOfBirth() : '/'}<br>
			Date of death: ${author.getDateOfDeath() != null ? author.getDateOfDeath() : '/'}<br>
			Biography: ${author.getBiography()}<br>
		</p>
	
	</fieldset>
	
	<a href="/OortSpring/library/view">Back</a>	
	
</body>
</html>