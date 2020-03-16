<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<marquee>
<h1 style="color:green;">Register</h1>
</marquee>
<form action="Register">
Name:<input type="text" name="name"/>
</br>
Password:<input type="Password" name="pass"/>
</br>
Emailid:<input type="text" name="emailid"/>
</br>
<input type="submit" value="register">


</form>
<br/>
<br/>




<h1>Error User Datails</h1>

<marquee>
<h1 style="color:red;">Login</h1>
</marquee>
<form action="Login">
Emailid:<input type="text" name="emailid"/>
<br/>
Password:<input type="Password" name="pass"/>
</br>
<input type="submit" value="login">


</form>

</body>
</html>