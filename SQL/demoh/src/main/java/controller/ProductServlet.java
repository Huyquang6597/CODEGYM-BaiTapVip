package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }

        switch (act){
            case "create":
                showCreateForm(request,response);
                break;
            default:
                showList(request,response);
                break;

        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories",categories);
        request.getRequestDispatcher("product/create.jsp").forward(request,response);
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("list",products);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }

        switch (act){
            case "create":
                try {
                    create(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showList(request,response);
                break;
        }

    }
    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException {
        String name = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        String description = request.getParameter("description");
        String color = request.getParameter("color");
        Category category = categoryService.findById(categoryId);
        productService.add(new Product(0,name,price,quantity,description,color,category));
        response.sendRedirect("/home");

    }
}
