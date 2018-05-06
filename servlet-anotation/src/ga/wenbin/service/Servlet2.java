package ga.wenbin.service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Servlet2", name = "Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        System.out.println("in the servlet 2");
        out.print("This is a servlet 2");


//        RequestDispatcher rd = req.getRequestDispatcher("Servlet1");
//        rd.forward(req, resp);
//        rd.include(req, resp);

        resp.sendRedirect("Servlet1");
    }

}
