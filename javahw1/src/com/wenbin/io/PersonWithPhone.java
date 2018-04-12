package com.wenbin.io;

import java.util.Calendar;

public class PersonWithPhone extends Person {


    private String phoneNumber;

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    private int birthYear;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public PersonWithPhone() {
        super();
    }

    public PersonWithPhone(String phoneNumber) {
        super();
        this.phoneNumber = phoneNumber;
        this.birthYear = 2000;
    }

    public PersonWithPhone(String firstName, String lastName, String gender, String phoneNumber) {
        super(firstName, lastName, gender);
        this.phoneNumber = phoneNumber;
    }

    public void displayPersonInformation() {
        System.out.println(this.getFirstName() + " " + this.getLastName() + " " + this.getGender() + " " + this.phoneNumber);
    }

    public int calculateAge () {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        return year - this.birthYear;
    }

    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public void displayFullNameAndAge() {
        int age = calculateAge();
        System.out.println("Name: " + getFullName() + "Age: " + age);
    }
}
