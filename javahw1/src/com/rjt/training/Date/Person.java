package com.rjt.training.Date;

import java.time.LocalDate;

public class Person {
    private int age;
    private LocalDate birthDay;
    private String firstName;
    private String lastName;

    private Person() {

    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("set a birthday");
        this.setBirthDay();
        DateCalculation dateCalculation = new DateCalculation();
        this.age = dateCalculation.durationForToday(this.getBirthDay());
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public String toString() {
        return " full name: " + this.getFullName() + " age: " + this.getAge();
    }

    public int getAge() {
        return age;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay() {
        DateCalculation dateCalculation = new DateCalculation();
        this.birthDay = dateCalculation.getADate();
    }
}
