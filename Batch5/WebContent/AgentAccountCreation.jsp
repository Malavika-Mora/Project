<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Account Creation</h1>
	<br>
	<form action = "AgentAccountCreation" method = "post">
		<p>User Name</p>
		<input type = "text" name = "userName"  required>
		<br><br><p>Insured Name</p>
		<input type = "text" name = "insuredName" required>
		<br><br><p>Insured Street</p>
		<input type = "text" name = "insuredStreet"required>
		<br><br><p>Insured City</p>
		<input type = "text" name = "insuredCity"   required>
		<br><br><p>Insured State</p>
		<input type = "text" name = "insuredState"  required>
		<br><br><p>Insured zip</p>
		<input type = "text" name = "insuredZip"  required>
		<br><br><p>Business Segment</p>
		<br>
		<select name = "busSegName">
			<option value = "Business Auto">Business Auto</option>
			<option value = "Restaurant">Restaurant</option>
			<option value = "Apartment">Apartment</option>
			<option value = "General Merchant">General Merchant</option>
		</select>
		<br><br><center><input type = "submit" name = "submit" value = "Create Account"></center>
	</form>

</body>
</html>