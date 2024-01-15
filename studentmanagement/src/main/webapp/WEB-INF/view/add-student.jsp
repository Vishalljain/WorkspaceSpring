<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<body>
<div align ="center">
<h1>ADD STUDENT</h1>
<form:form action="save-student" modelAttribute="student11" method="POST">
<label>Name</label>
<form:input path = "name"/><%-- <form:form modelAttribute="student11"> this student11 is model attribute the model attribute  is containing the
student dto so whenever student dto object created obviously it will hve default data so i can read the dafault
data using form:input path=mobile so path i m saying mobile so for this text box it is going to fetch the mobile data from studentdto object  --%>
<br/>
<form:hidden path ="id"/>
<label>Mobile</label>
<form:input path = "mobile"/>
<br/>
<label>Country</label>
<form:input path = "country"/>
<br/>
<input type ="submit" value ="Submit">
</form:form>
</div>
</body>
</html>
