package servlet;

import model.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "CalculatorServlet", value = "/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Result: </h1>");
        try {
            float result = Calculator.calculate(firstOperand, secondOperand, operator);
            printWriter.println(firstOperand + " " + operator + " " + secondOperand + "=" + result);
        }catch (Exception e){
            printWriter.println("Error");
        }
    printWriter.println("</html>");
    }

}
