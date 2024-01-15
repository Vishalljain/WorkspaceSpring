<!-- allProducts.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Products</title>
</head>
<body>
    <h1>All Products</h1>
    
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Cost</th>
            <th>Added By</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.cost}</td>
                <td>${product.username}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
