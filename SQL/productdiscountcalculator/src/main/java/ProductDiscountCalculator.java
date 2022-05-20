import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculator", value = "/productc")
public class ProductDiscountCalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productd = request.getParameter("productd");
        float listprice = Float.parseFloat(request.getParameter("listprice"));
        float discountpc = Float.parseFloat(request.getParameter("discountpc"));


        float discounta = (float) (listprice * discountpc * 0.01);
        float discountp = listprice - discounta;


        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product Description: " + productd + "</h1>");
        writer.println("<h1>List Price: " + listprice + "</h1>");
        writer.println("<h1>Discount Percent: " + discountpc + "</h1>");
        writer.println("<h1>Discount Amount: " + discounta + "</h1>");
        writer.println("<h1>Discount Price: " + discountp + "</h1>");
        writer.println("</html>");
    }
}
