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
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    ClassService classService = new ClassServiceImpl();
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
            case "view":
                showView(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> classes = classService.findAll();
        request.setAttribute("classes",classes);
        int id = Integer.parseInt((request.getParameter("id")));
        Student student = studentService.findById(id);
        request.setAttribute("student",student);
        request.getRequestDispatcher("student/edit.jsp").forward(request,response);
    }


    private void showView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> classes = classService.findAll();
        request.setAttribute("classes",classes);
        int id = Integer.parseInt((request.getParameter("id")));
        Student student = studentService.findById(id);
        request.setAttribute("student",student);
        request.getRequestDispatcher("student/view.jsp").forward(request,response);
    }



    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lop> classes = classService.findAll();
        request.setAttribute("classes",classes);
        request.getRequestDispatcher("student/create.jsp").forward(request,response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("student/list.jsp");
        List<Student> students = studentService.findAll();
        request.setAttribute("list",students);
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
            case "edit":
                try {
                    edit(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    delete(request,response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("/home");
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Lop clazz = classService.findById(classId);
        studentService.update(new Student(studentId,name,clazz,age));
        response.sendRedirect("/home");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        Lop clazz = classService.findById(classId);
        studentService.add(new Student(0,name,clazz,age));
        response.sendRedirect("/home");
    }
}
