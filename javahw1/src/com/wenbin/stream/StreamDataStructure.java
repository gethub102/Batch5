package com.wenbin.stream;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDataStructure {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ram", "Dlio", "Feg", "Go", "Ram");
        Set<String> set = list.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set);

        ProductII productII1 = new ProductII(1, 23, "1_name");
        ProductII productII2 = new ProductII(2, 24, "2_name");
        ProductII productII3 = new ProductII(3, 25, "3_name");
        ProductII productII4 = new ProductII(4, 26, "4_name");
        ProductII productII5 = new ProductII(5, 27, "5_name");

        List<ProductII> list1 = Arrays.asList(productII1, productII2, productII3, productII4, productII5);

        // why it is wrong
        list1.stream().mapToDouble(o -> o.price).max().ifPresent(System.out::println);

        Stream.of(1,2 ,3,4 ,5 ).mapToDouble(o -> (double)o).max().ifPresent(System.out::println);

        list1.stream().max((o1, o2) -> o1.price > o2.price ? 1 : -1).ifPresent(System.out::println);

        Map<Integer, ProductII> map = list1.stream().collect(Collectors.toMap(ProductII::getId, o -> o));
        System.out.println(map);

        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10)).limit(5).forEach(o-> System.out.print(o + " "));
        System.out.println("\n" + IntStream.iterate(1, x -> ++x).limit(5).sum());

        System.out.println();
        System.out.println(Stream.of(1,2,3,4,5).filter(o -> o % 2 == 0).peek(System.out::println));

        Integer[][] intarr = {{1,2},{3,4},{5,6}};    // why it must be a obj rather than int
        Arrays.stream(intarr).flatMap(row -> Arrays.stream(row)).forEach(System.out::print);
        System.out.println();

        Arrays.stream(intarr).flatMap(o -> Arrays.stream(o)).skip(1).forEach(System.out::print);
        System.out.println();

    }
}


class ProductII {
    int id;
    double price;
    String name;

    public ProductII(int id, double price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + name + " : " + price;
    }

    public int getId() {
        return id;
    }
}