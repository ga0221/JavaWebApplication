<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Logged out successfully</h1>
<%session.invalidate(); %>
<a href="http://localhost:8080/JavaWebApplication/">Home</a>
</body>
</html>