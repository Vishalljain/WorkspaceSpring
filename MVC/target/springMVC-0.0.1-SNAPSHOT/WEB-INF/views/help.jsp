<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*"%> 
 <%@ page import = "java.time.LocalDateTime"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Guru Registration Form</title>
</head>
<body>
<h1>This is in help page</h1>
<%
String name = (String)request.getAttribute("name");
LocalDateTime date = (LocalDateTime)request.getAttribute("date");
%>
<h1>Name is <%=name%></h1>
<h1>Current Date and Time is <%=date%><h1>

</body>
</html>