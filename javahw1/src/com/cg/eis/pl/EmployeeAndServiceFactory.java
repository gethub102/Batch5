package com.cg.eis.pl;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.NameIncompleteException;

import java.util.Scanner;

public class EmployeeAndServiceFactory {
    public static void displayDetailsOfEmployee(Employee employee) {
        System.out.print("id: " + employee.getId() + "Name: " + employee.getName());
        System.out.println("designation: " + employee.getDesignation() + "salary: " + employee.getSalary() + " InsuranceScheme: " + employee.getInsuranceScheme());
    }

    public static Employee createEmp() throws NameIncompleteException {
        Scanner input = new Scanner(System.in);
        System.out.println("input full name: ");
        String name = input.nextLine();
        if (name.split(" ").length != 2) {
            throw new NameIncompleteException("This name should include first name and last name");
        }
        System.out.println("input designation: ");
        String designation = input.next();
        System.out.println("input salary: ");

        double salary = input.nextDouble();
        String insuranceScheme = "goodInsurance";
        if (salary > 55000 || designation.toLowerCase().trim().equals("manager")) {
            insuranceScheme = "wonderInsurance";
        }
        input.close();
        return new Employee(name, salary, designation, insuranceScheme);

    }
}
