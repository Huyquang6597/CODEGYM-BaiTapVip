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
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String categoryId = request.getParameter("categoryId");
        String findName = request.getParameter("findName");
        String start   = request.getParameter("findPrice");
        String end   = request.getParameter("findPrice");
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        List<Product> products = productService.findAll();
        if (categoryId != null) {
            products = productService.findAllByCategory(Integer.parseInt(categoryId));
        }
        if (findName != null) {
            products = productService.findAllByNameContains(findName);
        }
        if (start != null && end != null) {
            double a = Double.parseDouble(start);
            double b = Double.parseDouble(end);
            products = productService.findAllByPrice(a , b);

        }
        request.setAttribute("products", products);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
    }
}
