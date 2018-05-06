package ga.wenbin.Servlet;

import ga.wenbin.service.EmployeeDAO;
import ga.wenbin.service.EmployeeDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddEmployee", value = "/AddEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String email = request.getParameter("email");
        System.out.println("name = " + name);

        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.insertEmployee(id, name, salary, email);
        System.out.println("GET method done the insertion");

        System.out.println("this is tst" + name);
    }
}
