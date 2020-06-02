<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
<%

response.setHeader("Cache-control","no-cache");
response.setHeader("Cache-control","no-store");
response.setHeader("pragma","no-cache");
response.setDateHeader("Expire",0);

String email = (String)session.getAttribute("uname");
System.out.println(email);
%>

<h1>Welcome <%out.println(email); %></h1>
<a href="http://localhost:8080/JavaWebApplication/jsp/logout.jsp">Logout</a>

</body>
</html>