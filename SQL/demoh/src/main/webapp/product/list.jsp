<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List Product
<c:forEach items="${list}" var="pr">
    <h1>${pr.id},${pr.name},${pr.price},${pr.quantity}, ${pr.description},${pr.color},${pr.category.name}
        <c:if test="${pr.price > 200}">
            - Khuyễn mãi 10%
        </c:if>
        <c:if test="${pr.price < 200}">
        - Khuyễn mãi 20%
        </c:if></h1>
</c:forEach>
</body>
</html>
