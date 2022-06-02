<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
  <input type="text" name="name">
  <input type="number" name="price">
  <input type="number" name="quantity">
  <input type="text" name="color">
  <select name="categoryId">
  <c:forEach items="${category}" var="ca">
    <option value="${ca.id}">${ca.name}</option>
  </c:forEach>
  </select>
</form>
</body>
</html>


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
        </div>
      </nav>
    </div>
  </div>
  <div class="row">
    <div class="col-3 text-center">
      <h2 class="mb-3">Danh mục sản phẩm</h2>
      <c:forEach items="${categories}" var="ca">
        <h5><a href="">${ca.name}</a></h5>
      </c:forEach>
    </div>
    <div class="col-9 text-center">
      <h2 style="text-align: center" > Thêm sản phẩm</h2>
<%--      <table class="table table-striped">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--          <th scope="col">Product ID</th>--%>
<%--          <th scope="col">Product Name</th>--%>
<%--          <th scope="col">Price</th>--%>
<%--          <th scope="col">Quantity</th>--%>
<%--          &lt;%&ndash;                        <th scope="col">Description</th>&ndash;%&gt;--%>
<%--          <th scope="col">Color</th>--%>
<%--          <th scope="col">Category Name</th>--%>

<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach items="${products}" var="pr">--%>
<%--          <tr>--%>
<%--            <td>${pr.id}</td>--%>
<%--            <td>${pr.name}</td>--%>
<%--            <td>${pr.price}</td>--%>
<%--            <td>${pr.quantity}</td>--%>
<%--              &lt;%&ndash;                            <td>${pr.categoryId}</td>&ndash;%&gt;--%>
<%--              &lt;%&ndash;                            <td>${pr.description}</td>&ndash;%&gt;--%>
<%--            <td>${pr.color}</td>--%>
<%--            <td>${pr.category.name}</td>--%>

<%--          </tr>--%>
<%--          </a></h5>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--      </table>--%>
<form method="post">
  <h5>Tên Sp: </h5>
  <input class="form-control" type="text" name="name">
  <h5>Giá: </h5>
  <input class="form-control" type="double" name="price">
  <h5>Số lượng: </h5>
  <input class="form-control" type="int" name="quantity">
  <h5>Màu: </h5>
  <input class="form-control" type="int" name="color">
  <h5>Lớp: </h5>
  <select class="form-control" name="categoryId" >
    <c:forEach items="${categories}" var="ca">
      <option value="${ca.id}">${ca.name}</option>
    </c:forEach>
  </select>
  <button class="btn btn-primary mt-3">Thêm</button>
</form>
    </div>
  </div>
</div>
</div>
</body>
</html>