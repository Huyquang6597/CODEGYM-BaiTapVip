package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act) {
            case "create":
                showCreateForm(request, response);
                break;
            default:
                showList(request, response);
                break;

        }

    }


    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> productList ;
        if (name != null & name != "") {

            productList = productService.findByName(name);
        } else {
            productList = productService.findAll();
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        request.setAttribute("ds", productList);
        dispatcher.forward(request, response);

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("product/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
            switch (act) {
                case "create":
                    create(request, response);
            }

        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/products");
    }
}
