<%--
  Created by IntelliJ IDEA.
  User: tranquanghuy
  Date: 26/05/2022
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="number" name="id" value="${customerUpdate.id}">
    <input type="text" name="name" value="${customerUpdate.name}">
    <input type="number" name="age" value="${customerUpdate.age}">
    <button>Sửa</button>


</form>
</body>
</html>
