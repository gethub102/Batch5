package com.wenbin.Immuable;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld{
    public static void main(String args[]){
        //Make employee class immutable

        Street street = new Street("iinde", "Glde");

        Address address= new Address(10, "meerut", street, 250002);
        List<Address> list= new ArrayList();
        list.add(address);
        Employee obj= new Employee(1, "Payal", list);
        List<Address> list1=obj.getList();
        list1.add(new Address(20, "meerut", street, 764343));
        System.out.println(obj.getList().size());
        //Noone should be able to change the state of
        //employee object once created


    }
}

final class Employee{
    private int id;
    private String name;
    private List<Address> list;
    public Employee(int id, String name, List<Address> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Address> getList() {
        return new ArrayList<>(list);
    }

}

final class Address{
    int houseNo;
    String city;
    Street street;
    int pincode;

    public Address(int houseNo, String city, Street street, int pincode) {
        this.houseNo = houseNo;
        this.city = city;
        this.street = street;
        this.pincode = pincode;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public String getCity() {
        return city;
    }

    public Street getStreet() {
        try {
            return (Street)street.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getPincode() {
        return pincode;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

class Street implements Cloneable {
    public Street(String colony, String landmark) {
        this.colony = colony;
        this.landmark = landmark;
    }

    private String colony ;
    private String landmark;


    public String getColony() {
        return colony;
    }

    public String getLandmark() {
        return landmark;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Street street = (Street)super.clone();
        return street;
    }
}