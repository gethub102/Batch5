package com.wenbin.io;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Wenbin", "Li", Person.Gender.valueOf("M"));
        Person person1 = new Person("Wenbin", "Li", "M");

        checkPositiveNumber();


    }

    public static boolean checkPositiveNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input a number");
        int number = scanner.nextInt();
        if (number > 0) {
            System.out.println(number + " is a positive number");
            return true;
        } else {
            System.out.println(number + " is not a positive number");
            return false;
        }
    }
}
