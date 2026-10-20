<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sql" uri="jakarta.tags.sql" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>ShopSphere SQL Tags Demo</title>
</head>
<body>
    <h2>JSP SQL Tags Demonstration</h2>

    <sql:setDataSource
        var="db"
        driver="com.mysql.cj.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/shopsphere"
        user="root"
        password="12345678" />

    <sql:query dataSource="${db}" var="products">
        SELECT product_id, name, price FROM products
    </sql:query>

    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Product</th>
            <th>Price</th>
        </tr>

        <c:forEach var="p" items="${products.rows}">
            <tr>
                <td>${p.product_id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>