package com.wenbin.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {


    public static void main(String[] args) {
        Product product1 = new Product(1, 10, "1_name");
        Product product2 = new Product(2, 220, "2_name");
        Product product3 = new Product(3, 3220, "3_name");
        Product product4 = new Product(4, 4220, "4_name");
        Product product5 = new Product(5, 520, "5_name");
        Product product6 = new Product(6, 62220, "6_name");

        List<Product> list = Arrays.asList(product1, product2, product3, product4, product5, product6);

        System.out.println(list);

        // stream is like a pipeline
        list.stream().filter(o -> o.price < 1000)
                .map(o -> o.id)
                .forEach(id -> System.out.println(id));

        System.out.println();

        Stream.of(1,2,3,4,5,6,7,8).filter(i -> i % 2 == 0).forEach(i -> System.out.println(i));


        Employee employee1 = new Employee(1, "1_name", 31, 23);
        Employee employee2 = new Employee(2, "2_name", 23, 113);
        Employee employee3 = new Employee(3, "3_name", 23, 233);
        Employee employee4 = new Employee(4, "4_name", 41, 253);
        Employee employee5 = new Employee(5, "5_name", 15, 23);

        Stream.of(employee1, employee2, employee3, employee4, employee5)
                .filter(o -> o.mark > 90)
                .sorted(((o1, o2) -> o2.id - o1.id))
                .forEach(o -> System.out.println(o.id + " : " + o.name));

        System.out.println("\n\n");

        Stream.of(employee1, employee2, employee3, employee4, employee5)
                .filter(o -> {
                    if (o.mark < 40) {
                        o.mark = 5;
                    }
                    return true;
                })
                .sorted((o1, o2) -> {
                    return o2.mark - o1.mark;
                })
                .forEach( o -> System.out.println(o + " : " + o.mark));
    }
}


class Employee {
    int id;
    String name;
    int age;
    int mark;

    public Employee(int id, String name, int age, int mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mark = mark;
    }


    @Override
    public String toString() {
        return id + " : " + name;
    }
}

class Product {
    int id;
    double price;
    String name;

    public Product(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + price + " : " + name;
    }
}
