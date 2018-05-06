package ga.wenbin.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet4", value = "/Servlet4")
public class Servlet4 extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("this in the servlet 4");
//
//        String name = req.getParameter("name");
//        String passwd = req.getParameter("passwd");
//
//        PrintWriter out = resp.getWriter();
//        out.println("name = " + name);
//        out.println("password = " + passwd);
//
//        req.setAttribute("forward_name", name);
//        req.setAttribute("forward_passwd", passwd);
//
//        req.getRequestDispatcher("Servlet5").forward(req, resp);
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("this in the servlet 4");

        String name = request.getParameter("name");
        String passwd = request.getParameter("passwd");

        PrintWriter out = response.getWriter();
        out.println("name = " + name);
        out.println("password = " + passwd);

        request.setAttribute("forward_name", name);
        request.setAttribute("forward_passwd", passwd);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/post-test.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
