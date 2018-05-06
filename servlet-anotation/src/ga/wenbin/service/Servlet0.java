package ga.wenbin.service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet0", value = "/Servlet0")
public class Servlet0 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        ServletConfig configuration = getServletConfig();

        ServletContext context = getServletContext();

        System.out.println("This is a const var " + context.getInitParameter("const1"));
        out.println("This is servlet 0");
        System.out.println("This is in servlet");
        req.getRequestDispatcher("Servlet2").forward(req, resp);
    }
}
