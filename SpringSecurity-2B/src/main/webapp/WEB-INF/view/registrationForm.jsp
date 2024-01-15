<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
</head>
<body>
    <h1>Registration Form</h1>
    <form action="/wow" method="post" modelAttribute="user">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" /><br/>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" /><br/>
        
        <input type="submit" value="Register" />
    </form>
</body>
</html>
