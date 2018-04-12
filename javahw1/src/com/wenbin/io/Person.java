package com.wenbin.io;

public class Person {
    private String firstName;
    private String lastName;
    private Gender gender;

    int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person (String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public Person(String firstName, String lastName, Gender gender, int weight, int age, String pw) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.weight = weight;
        this.age = age;
        this.pw = pw;
    }

    int age;

    protected String pw = "n";

    enum Gender {
        M, F
    }

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Person () {
        this.firstName = "";
        this.lastName = "";
        this.gender = Gender.M;
    }


    public Person(String firstName, String lastName, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = Gender.valueOf(gender);
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String toString() {
        return firstName + lastName + gender.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person p = (Person) obj;
            if (p.getFirstName().equals(this.getFirstName()) && p.getLastName().equals(this.getLastName())) {
                if (p.getAge() == this.getAge() && p.getWeight() == this.getWeight()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Person person = new Person("Wenbin", "Li", Gender.valueOf("M"));
        System.out.print(person);
    }
}
