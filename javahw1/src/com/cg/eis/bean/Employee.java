package com.cg.eis.bean;

import com.cg.eis.exception.AgeNotProper;

public class Employee {
    final private int id;
    private String name;

    private double salary;
    private String designation;
    private String insuranceScheme;

    public Employee() {
        this.id = hashCode();
    }

    public Employee(String name, double salary, String designation, String insuranceScheme) {
        this.id = hashCode();
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.insuranceScheme = insuranceScheme;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) throws AgeNotProper {
        if (salary < 3000) {
            throw new AgeNotProper("salary should not be less than 3000");
        }
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getInsuranceScheme() {
        return insuranceScheme;
    }

    public void setInsuranceScheme(String insuranceScheme) {
        this.insuranceScheme = insuranceScheme;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() + " name: " + this.getName();
    }
}
