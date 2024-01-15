<!-- confidential.jsp -->
<!DOCTYPE html>
<html>
<head>
    <title>Confidential</title>
</head>
<body>
    <h1>Welcome to the Confidential Page</h1>
    <p>This page is accessible only to authenticated users.</p>
    
    <!-- Display Session ID -->
    <p>Session ID: ${pageContext.session.id}</p>
    
    <!-- Display User Name (if authenticated) -->
    <c:if test="${pageContext.request.userPrincipal != null}">
        <p>User Name: ${pageContext.request.userPrincipal.name}</p>
    </c:if>
    
    <!-- Add your content here -->
</body>
</html>
