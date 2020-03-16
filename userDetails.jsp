<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<marquee>
<h1 align="center">Welcome To Select Options</h1>
</marquee>
<form action="Music">
<input type="text" name="song" placeholder="Enter the song" />
<input type="submit" value="Song" name="gaana">
<input type="submit" value="History" name="submit_history_music">
</form>
<form action="Music" method="POST">
<input type="submit" value="clear_history" onclick="alert('Are you Sure?')"/>
</form>
<br/>
<form action="Google">
<input type="text" name="google" placeholder="Enter the song" />
<input type="submit" value="Google" name="searchgoogle" >
<input type="submit" value="History" name="submit_history_google">
</form>
<form action="Google" method="POST">
<input type="submit" value="clear_history" onclick="alert('Are you Sure?')"/>
</form>
<br/>
<form action="Youtube">
<input type="text" name="youtube" placeholder="Enter the song" />
<input type="submit" value="Youtube" name="searchyoutube">
<input type="submit" value="History" name="submit_history_youtube">
</form>
<form action="Youtube" method="POST">
<input type="submit" value="clear_history" onclick="alert('Are you Sure?')"/>
</form>
<br/>

<form action="register.jsp">
<input type="submit" value="logout" onlclick="alert('Are you Sure To Logout')">


</form>


</body>
</html>