<%--
  Created by IntelliJ IDEA.
  User: tranquanghuy
  Date: 26/05/2022
  Time: 08:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1>danh sách</h1>
<a href="/customers?action=create">Tạo Mới</a>
<c:forEach var="customer" items="${dsKH}">
    <h2>${customer.id},${customer.name}, ${customer.age}
        <a href="/customers?action=update&id=${customer.id}">Sửa</a>
        <a href="customers?action=delete&id=${customer.id}"> Xóa</a>
    </h2>
</c:forEach>
</body>
</html>
