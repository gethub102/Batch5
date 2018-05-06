package ga.wenbin.service;

import ga.wenbin.Domain.EmployeeBean;
import ga.wenbin.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {


    @Override
    public boolean insertEmployee(int id, String name, double salary, String email) {
        EmployeeBean ebean = new EmployeeBean(id, name, salary, email);
        return insertEmployee(ebean);
    }

    @Override
    public boolean insertEmployee(EmployeeBean employeeBean) {
        PreparedStatement statement = null;
        String query = "INSERT INTO Employee VALUES (?, ?, ?, ?); ";
        Connection connection = DBUtil.connectionLoader();

        try {
            statement = connection.prepareStatement(query);
            statement.setInt(1, employeeBean.getId());
            statement.setString(2, employeeBean.getName());
            statement.setDouble(3, employeeBean.getSalary());
            statement.setString(4, employeeBean.getEmail());
            if (statement.execute()) {
                System.out.println("Insertion Done");
            } else {
                System.out.println("error happens");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
                statement.close();
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
