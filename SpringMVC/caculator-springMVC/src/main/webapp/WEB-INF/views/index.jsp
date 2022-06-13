<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>Caculator
</h1>
<form action="/result" method="get">
    <input type="text" name="first">
    <select name="operator">
        <option value="+" name="addition">+</option>
        <option value="-" name="minus">-</option>
        <option value="*" name="multiplication">*</option>
        <option value="/" name="division">/</option>
    </select>
    <input type="text" name="second">
   <button>Click</button>

</form>
<p>Result: ${result}</p>
</body>
</html>