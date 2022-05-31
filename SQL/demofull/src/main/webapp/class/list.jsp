<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranquanghuy
  Date: 30/05/2022
  Time: 08:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>
List Student
<c:forEach items="${ds}" var="cl">
    <h1>${cl.name}</h1>
</c:forEach>
</body>
</html>
