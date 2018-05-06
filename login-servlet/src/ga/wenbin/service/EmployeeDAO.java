package ga.wenbin.service;

import ga.wenbin.Domain.EmployeeBean;

public interface EmployeeDAO {
    boolean insertEmployee(int id, String name, double salary, String email);
    boolean insertEmployee(EmployeeBean employeeBean);
}
