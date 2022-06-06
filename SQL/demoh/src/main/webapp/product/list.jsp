<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
List Student
<c:forEach items="${list}" var="pr">
    <h1>${pr.id},${pr.name},${pr.price},${pr.quantity}, ${pr.description},${pr.color},${pr.category.name}</h1>
</c:forEach>
</body>
</html>
