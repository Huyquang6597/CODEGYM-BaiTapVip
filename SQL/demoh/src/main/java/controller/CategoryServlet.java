package controller;

import model.Category;
import service.CategoryService;
import service.CategoryServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/categories")
public class CategoryServlet extends HttpServlet {
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }

        switch (act) {
            default:
                showList(request,response);
                break;

        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("category/list.jsp");
        List<Category> categories = categoryService.findAll();
        request.setAttribute("ds", categories);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String act = request.getParameter("act");
        if (act == null) {
            act = "";
        }

        switch (act) {

        }
    }
}
