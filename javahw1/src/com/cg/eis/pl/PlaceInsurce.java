package com.cg.eis.pl;

import com.cg.eis.bean.Employee;

import java.util.Scanner;

public class PlaceInsurce {
    public static void main(String[] args) {
        Employee employee1 = createEmp();
        Employee employee2 = createEmp();


    }


    public static Employee createEmp() {
        Scanner input = new Scanner(System.in);
        System.out.println("intput name: ");
        String name = input.next();
        System.out.println("intput designation: ");
        String designation = input.next();
        System.out.println("intput salary: ");

        double salary = input.nextDouble();
        String insuranceScheme = "goodInsurance";
        if (salary > 55000 || designation.toLowerCase().trim().equals("manager")) {
            insuranceScheme = "wonderInsurance";
        }
        input.close();
        return new Employee(name, salary, designation, insuranceScheme);

    }


    public static void displayDetailsOfEmployee(Employee employee) {
        System.out.print("id: " + employee.getId() + "Name: " + employee.getName());
        System.out.println("designation: " + employee.getDesignation() + "salary: " + employee.getSalary() + " InsuranceScheme: " + employee.getInsuranceScheme());
    }
}
