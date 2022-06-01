package controller;

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
            default:
                showList(request,response);
                break;

        }
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
            default:
                showList(request,response);
                break;
        }
    }
}
