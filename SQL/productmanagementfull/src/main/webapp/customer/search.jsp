<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranquanghuy
  Date: 27/05/2022
  Time: 08:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="name">
    <button>Tìm</button>

</form>
<c:forEach items="${search}" var="customer">
    <h2>${customer.id}, ${customer.name} , ${customer.age}</h2>
</c:forEach>
</body>
</html>
