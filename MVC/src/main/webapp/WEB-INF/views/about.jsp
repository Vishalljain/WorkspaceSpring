<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Guru Registration Form</title>
</head>
<body>
<h1>This is in About page</h1>
<%
String name = (String)request.getAttribute("name");
List<String> character = (List<String>)request.getAttribute("alphabets");
%>

<h1>Name is <%=name%></h1>
<%
 for(String c : character){
   out.println(c);
 }

%>

<%-- or use --%>

<%
 for(String c : character){
 %>
 <h1><%=c%></h1>
<%
 }

%>


</body>
</html>