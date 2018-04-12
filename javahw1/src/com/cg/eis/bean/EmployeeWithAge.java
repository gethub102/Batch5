package com.cg.eis.bean;

import com.cg.eis.exception.AgeNotProper;

public class EmployeeWithAge extends Employee {
    private int age;

    public EmployeeWithAge(int age) {
        this.age = age;
    }

    public EmployeeWithAge(String name, double salary, String designation, String insuranceScheme, int age) {
        super(name, salary, designation, insuranceScheme);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeNotProper {
        if (age > 15) throw new AgeNotProper("age should be greater than 15");
        this.age = age;
    }
}
