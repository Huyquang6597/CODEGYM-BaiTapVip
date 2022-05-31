package controller;

import model.Lop;
import model.Student;
import service.ClassService;
import service.ClassServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", urlPatterns = "/home")
public class HomeServlet extends HttpServlet {
    ClassService classService = new ClassServiceImpl();
    StudentService studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        String classId = request.getParameter("classId");
        List<Lop> classes = classService.findAll();
        request.setAttribute("classes", classes);
        List<Student> students = studentService.findAll();
        if (classId != null) {
            students = studentService.findAllByClass(Integer.parseInt(classId));
        }
        request.setAttribute("students", students);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
    }
}
