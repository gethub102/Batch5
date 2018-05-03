package com.wenbin.mock;

public final class Employee implements Cloneable {
    private Address address;
    private int id;
    private String name;
    private int age;

    public Employee(Address address, int id, String name, int age) {
        this.address = address;
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Address getAddress() {
        try {
            return (Address) address.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return id + " : " + name + " : " + age + " : " + address;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Address address = new Address("H", "C", "S", "P");
        Address address1 = (Address) address.clone();
        System.out.println(address == address1 ? true : false);
        System.out.println("add1 " + address1);

        Employee employee1 = new Employee(address, 1, "1_name", 23);

        Employee employee3 = (Employee) employee1.clone();
        System.out.println(employee1 == employee3 ? true : false);
        System.out.println(employee3);
    }

}

final class Address implements Cloneable {
    private String houseNum;
    private String city;
    private String state;
    private String pincode;

    public Address(String houseNum, String city, String state, String pincode) {
        this.houseNum = houseNum;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }


    public String getPincode() {
        return pincode;
    }

    @Override
    public int hashCode() {
        return this.city.hashCode() + this.houseNum.hashCode() + this.pincode.hashCode() + this.state.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return houseNum + " : " + city + " : " + state + " : " + pincode;
    }
}
