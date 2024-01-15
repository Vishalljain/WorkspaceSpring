<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Product Page</title>
</head>
<body>
    <h1>Product Page</h1>
    
    <form action="/product/save" method="post" modelAttribute="productForm">
        <div>
            <label for="name">Product Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="cost">Product Cost:</label>
            <input type="number" id="cost" name="cost" required>
        </div>
        <input type="submit" value="Save Product">
    </form>
    
    <!-- Display the logged-in username (if authenticated) -->
    <c:if test="${pageContext.request.userPrincipal != null}">
        <p>User Name: ${pageContext.request.userPrincipal.name}</p>
    </c:if>
</body>
</html>
