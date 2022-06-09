<%--
  Created by IntelliJ IDEA.
  User: tranquanghuy
  Date: 24/05/2022
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${list}" var="product">
  <c:if test="${product} ${index}}">
    <h1>${product}</h1>
  </c:if>
</c:forEach>
</body>
</html>
