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
    <title>Quản lý khách hàng</title>

    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"--%>
    <%--          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"--%>
    <%--            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"--%>
    <%--            crossorigin="anonymous"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"--%>
    <%--            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"--%>
    <%--            crossorigin="anonymous"></script>--%>
</head>
<body>

<center>
    <h1>Quản lý khách hàng</h1>
    <h2>
        <a href="/customers?action=create">Thêm mới khách hàng</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sách khách hàng</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
        </tr>
        <%--<a href="/customers?action=create" style="margin-right: 20px">Tạo Mới</a> <br>--%>
        <%--<a href="/customers?action=search">Tìm Kiếm</a>--%>

        <c:forEach var="customer" items="${dsKH}">
            <tr>
                <td><c:out value="${customer.id}"/></td>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.age}"/></td>
                <td>
                    <a href="/customers?action=update&id=${customer.id}">Sửa</a>
                    <a href="customers?action=delete&id=${customer.id}"> Xóa</a>
                </td>
            </tr>
            <%--    <h2>${customer.id},${customer.name}, ${customer.age}--%>


        </c:forEach>
    </table>
</div>
</body>
</html>
