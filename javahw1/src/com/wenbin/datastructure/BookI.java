package com.wenbin.datastructure;

import java.util.*;

public class BookI implements Comparable{
    private String name;
    private String author;

    public BookI(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(Object o) {
        BookI bookI = (BookI)o;
        return bookI.getName().compareTo(this.getName());
    }



    public static void main(String[] args) {
        Map map = new TreeMap();
        map.put(new BookI("A", "A_T"), "this is a book A");
        map.put(new BookI("B", "B_T"), "this is a book B");
        map.put(new BookI("C", "C_T"), "this is a book C");
        map.put(new BookI("D", "D_T"), "this is a book D");
        map.put(new BookI("E", "E_T"), "this is a book E");

        Map.Entry enty = null;
        Iterator<Map.Entry> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            enty = iterator.next();
            System.out.println(enty.getKey() + " : " + enty.getValue());
        }

        System.out.println("\n =============== \n");
        Map m = new TreeMap(new CompareWithAuthor());
        m.put(new BookI("A", "A_T"), "this is a book A");
        m.put(new BookI("B", "B_T"), "this is a book B");
        m.put(new BookI("C", "C_T"), "this is a book C");
        m.put(new BookI("D", "D_T"), "this is a book D");
        m.put(new BookI("E", "E_T"), "this is a book E");
        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            enty = iterator.next();
            System.out.println(enty.getKey() + " : " + enty.getValue());
        }
    }
}

class CompareWithAuthor implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        BookI bookI = (BookI) o1;
        BookI bookII = (BookI) o2;
        return bookI.getAuthor().compareTo(bookII.getAuthor());
    }
}
