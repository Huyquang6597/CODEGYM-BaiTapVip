<%--
  Created by IntelliJ IDEA.
  User: tranquanghuy
  Date: 26/05/2022
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Quản lý khách hàng</h1>
    <h2>
        <a href="/customers?action=customers">Danh sách khách hàng</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Cập nhập thông tin khách hàng</h2>
            </caption>
            <tr>
                <th>Nhập ID khách hàng:</th>
                <td>
                    <input type="number" name="id" id="id" size="45"/>
                </td>
            <tr>
                <th>Nhập tên khách hàng:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Nhập tuổi khách hàng:</th>
                <td>
                    <input type="number" name="age" id="age" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Lưu"/>
                </td>
<%--<form method="post">--%>
<%--    <input type="number" name="id" value="${customerUpdate.id}">--%>
<%--    <input type="text" name="name" value="${customerUpdate.name}">--%>
<%--    <input type="number" name="age" value="${customerUpdate.age}">--%>
<%--    <button>Sửa</button>--%>


</form>
</div>
</body>
</html>
