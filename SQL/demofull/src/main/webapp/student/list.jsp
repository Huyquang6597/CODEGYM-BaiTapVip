<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>
List Student
<c:forEach items="${list}" var="st">
    <h1>${st.name},${st.age},${st.clazz.name}</h1>
</c:forEach>
</body>
</html>
