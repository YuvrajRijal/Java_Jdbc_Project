<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Songs History</title>
</head>
<body>
<h1 align="center">List of Songs Visited</h1>
<%
out.println("<table border=3 align=center cellspacing=2 cellpadding=3>");
ArrayList<String> songs=(ArrayList)request.getAttribute("songs");
out.println("<tr>");
out.println("<td>Serial Number</td>");
out.println("<th> "+"<font size=5>" +"<b>" +"SONGS"+"</b>"+ "</th>");
out.println("</tr>");

for(int i=0;i<songs.size();i++)
{

	

	
	out.println("<tr>");
     out.println("<td>"+(int)(i+1)+ "</td>");
	out.println("<td>" +"<b><font size=2>" +songs.get(i)+"</b>"+ "</td>");
	out.println("</tr>");
	
}
out.println("</table>");

%>


</body>
</html>