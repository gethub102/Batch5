package com.wenbin.stream;

import java.util.stream.Stream;

public class EmployeeII {
    int id;
    double salary;
    String name;

    public EmployeeII(int id, double salary, String name) {
        this.id = id;
        this.salary = salary;
        this.name = name;
    }

    public static void main(String[] args) {
        EmployeeII employeeII1 = new EmployeeII(1, 192335, "1_name");
        EmployeeII employeeII2 = new EmployeeII(2, 2000, "2_name");
        EmployeeII employeeII3 = new EmployeeII(3, 5000, "3_name");
        EmployeeII employeeII4 = new EmployeeII(4, 6000, "4_name");
        EmployeeII employeeII5 = new EmployeeII(5, 3000, "5_name");
        EmployeeII employeeII6 = new EmployeeII(6, 5000, "6_name");

        EmployeeII employeeII = Stream.of(employeeII1, employeeII2, employeeII3, employeeII4, employeeII5, employeeII6)
                .map(o -> {
                    if (o.salary < 3000) {
                        o.salary = o.salary % 0.9;
                    } else if (o.salary >= 3000 && o.salary < 5000) {
                        o.salary = o.salary * 0.8;
                    } else if (o.salary >= 5000) {
                        o.salary = o.salary * 0.7;
                    }
                    return o;
                })
                .max((o1, o2) -> {
                    if (o1.salary < o2.salary) {
                        return -1;
                    } else {
                        return 1;
                    }
                }).get();

        System.out.println(employeeII.id + " : " + employeeII.name + " : " + employeeII.salary);
    }
}
