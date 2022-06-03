<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Danh sách SP
<%--<form action="/products">--%>
<form>
    <input type="text" name="name">
    <button>Tìm kiếm</button>
</form>
<c:forEach items="${ds}" var="pr" >
    <h2>${pr.id},${pr.name}</h2>
</c:forEach>

</body>
</html>
