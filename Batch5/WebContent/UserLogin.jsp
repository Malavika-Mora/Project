<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div style="text-align: center">
<h2>User Login</h2>

<form action="UserLogin" method="post">

    <label for="uname"><b>Login ID</b></label>
    <input type="text" placeholder="Enter Login ID" name="uname" maxlength="20" required><br><br>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" maxlength="12" required><br><br>
        
    <button type="submit">Login</button>
 
</form>
   </div>
</body>
</html>