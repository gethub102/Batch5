package com.wenbin.datastructure;

import java.util.*;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book() {
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Book book1 = new Book("F_tile", "F_autor", 20);
        Book book2 = new Book("W_tile", "W_autor", 21);
        Book book3 = new Book("E_tile", "E_autor", 22);
        Book book4 = new Book("R_tile", "R_autor", 23);
        Book book5 = new Book("Y_tile", "Y_autor", 19);
        Book book6 = new Book("Z_tile", "Z_autor", 80);

        List<Book> list = new ArrayList<>();
        list.addAll(Arrays.asList(book1, book2, book3, book4, book5, book6));

        System.out.println(list);

        Collections.sort(list, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return (int) (o1.price - o2.price);
            }
        });


        System.out.println(list.toString());
    }

    @Override
    public String toString() {
        return "title: " + this.title +  " author:  "  + this.author + " price: " + this.price;
    }
}
