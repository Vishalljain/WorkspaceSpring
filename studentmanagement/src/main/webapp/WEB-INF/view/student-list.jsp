<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<html>
<body>
<h1 align = "center"> Student Records</h1>
<div align="center">
<form action = "addStudent">
<input type = "submit" value="ADD">
</form>
<table border="1">
<thead>
<tr>
<td>ID</td>
<td>NAME</td>
<td>MOBILE</td>
<td>COUNTRY</td>
</tr>
</thead>

<c:forEach var="student" items="${students}">
<tr>
			<td>${student.id}</td> <%-- what jsp internaly will do ...student.id will call getter method of id....note tr for table row n td 4 table col --%>
			<td>${student.name}</td>
			<td>${student.mobile}</td>
			<td>${student.country}</td>
			<td><a href="/studentmanagement/updateStudent?userId=${student.id}">Update</a></td>
			<td><a href="/studentmanagement/deleteStudent?userId=${student.id}" onClick="if(!(confirm('you want to delete it?'))) return false">Delete</a></td>
			
</tr>
</c:forEach>


</table>
</div>
</body>
</html>
