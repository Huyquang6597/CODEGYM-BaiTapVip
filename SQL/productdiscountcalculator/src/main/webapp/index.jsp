<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title> Product Discount Calculator</title>

    <link rel="stylesheet" type="text/css" href="css/style.css">
    <style>
        table {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<form action="/productc" method="post">
    <table>
        <tr>
            <th>Product Discount Calculator</th>
        </tr>
        <tr>
            <td>Product Description:</td>
            <td><input type="text" name ="productd" placeholder="Product Description" /></td>
        </tr>
        <tr>
            <td>List Price:</td>
            <td><input type="text" name ="listprice" placeholder="List Price" /></td>
        </tr>
        <tr>
            <td>Discount Percent:</td>
            <td><input type="text" name ="discountpc" placeholder="Discount Percent" /></td>
        </tr>
        <tr>
            <td><input type = "submit" id = "submit" value = "Submit"/></td>
        </tr>
    </table>


</form>
</body>
</html>