package ga.wenbin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet0", value = "/Servlet0")
public class Servlet0 extends HttpServlet {

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("This is  a post");
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("This is a get");
    }

//    @Override
//    public void init() throws ServletException {
//        super.init();
//        System.out.println("this is init");
//    }
//
//
//    @Override
//    public void destroy() {
//        super.destroy();
//        System.out.println("this is override for destroy");
//    }
}
