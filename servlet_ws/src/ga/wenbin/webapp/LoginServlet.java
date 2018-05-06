package ga.wenbin.webapp;

import ga.wenbin.service.CheckAuthentication;
import ga.wenbin.service.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String userName = req.getParameter("uname");
        String userPassword = req.getParameter("password");

        PrintWriter out = resp.getWriter();
        if (CheckAuthentication.checkAuthentic(userName, userPassword)) {
            System.out.println(userName + " : " + userPassword);
            out.print("Welcome " + userName);
        }
        else {
            out.print("Invalid username and password");
        }
    }
}
