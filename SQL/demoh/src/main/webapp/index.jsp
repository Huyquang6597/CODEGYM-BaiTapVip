<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse"
                        data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/home">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/products?act=create">Add Product</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                               data-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="#">Action</a>
                                <a class="dropdown-item" href="#">Another action</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="#">Something else here</a>
                            </div>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled">Disabled</a>
                        </li>
                    </ul>
                    <form class="form-inline my-2 my-lg-0" action="/home">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="findName">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    <form class="form-inline my-2 my-lg-0" action="/home">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="start">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="end">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search By Price</button>
                    </form>
                </div>
            </nav>
        </div>
    </div>
    <div class="row">
        <div class="col-3 text-center">
            <h2 class="mb-3">Category List</h2>
            <c:forEach items="${categories}" var="ca">
                <h5><a href="/home?categoryId=${ca.id}">${ca.name}</a></h5>
            </c:forEach>
        </div>
        <div class="col-9 text-center">
            <h2 class="mb-3">Product List</h2>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Product ID</th>
                    <th scope="col">Product Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">Quantity</th>
                    <%--                        <th scope="col">Description</th>--%>
                    <th scope="col">Color</th>
                    <th scope="col">Category Name</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="pr">
                    <tr>
                        <td>${pr.id}</td>
                        <td>${pr.name}</td>
                        <td>${pr.price}</td>
                        <td>${pr.quantity}</td>
                            <%--<td>${pr.categoryId}</td>--%>
                            <%--<td>${pr.description}</td>--%>
                        <td>${pr.color}</td>
                        <td>${pr.category.name}</td>

                        <td> <c:if test="${pr.price > 200}">
                             Khuyến mãi 10%
                        </c:if>
                            <c:if test="${pr.price < 200}">
                                 Khuyến mãi 20%
                            </c:if></td>
                        <td>
                            <form action="/products" method="post" id="view${pr.id}" style="display: inline">
                                <input type="hidden" name="act" value="view">
                                <input type="hidden"  name="id" value="${pr.id}">
                                <a class="btn btn-primary" href="/products?act=view&id=${pr.id}">View</a>
                            </form>

                            <form action="/products" method="post" id="update${pr.id}" style="display: inline">
                                <input type="hidden" name="act" value="update">
                                <input type="hidden"  name="id" value="${pr.id}">
                                <a class="btn btn-secondary" href="/products?act=update&id=${pr.id}">Update</a>
                            </form>

                            <form action = "/products" method="post" id="delete${pr.id}" style="display: inline">
                                <input type="hidden" name="act" value="delete">
                                <input type="hidden" name="id" value="${pr.id}">
                                <a class="btn btn-danger" onclick="xacNhanDelete(${pr.id})">Delete</a>
                            </form>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>

            </table>

        </div>
    </div>
</div>
<script>
    function xacNhanDelete(id) {
        if (confirm("Are you sure want to delete?")) {
            document.getElementById("delete" + id).submit();
        }
    }
</script>
</body>
</html>