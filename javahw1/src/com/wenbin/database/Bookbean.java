package com.wenbin.database;

import com.wenbin.datastructure.Book;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bookbean {
    private static int count = 0;
    private int id = 0;
    private String name;
    private String author;
    private String cat;
    private double price;
    private int pageNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Bookbean() {
    }

    public Bookbean(String name, String author, String cat, int pageNumber, double price) {
        this.name = name;
        this.author = author;
        this.cat = cat;
        this.price = price;
        this.pageNumber = pageNumber;
        this.id = this.hashCode();
    }

    public static void main(String[] args) {
        Map<Integer, Bookbean> map = new HashMap<>();
        boolean continue_flag = true;
        System.out.println("Input some books: ");
        Scanner scanner = new Scanner(System.in);

        try {

            while (continue_flag) {

                System.out.print("name ");
                String name = scanner.next();
                System.out.print("author: ");
                String author = scanner.next();
                System.out.print("cat: ");
                String cat = scanner.next();
                System.out.print("page number: ");
                int pageNumber = Integer.parseInt(scanner.next());
                System.out.print("price ");
                double price = Double.parseDouble(scanner.next());

                Bookbean bookbean = new Bookbean(name, author, cat, pageNumber, price);

                map.put(bookbean.id, bookbean);

                System.out.println("continue? Yes? or No");
                String input = scanner.next();
                if ( input.trim().toLowerCase().equals("n") ||  input.trim().toLowerCase().equals("no")) {
                   continue_flag = false;
                }


            }

            Class.forName(Menu.DRIVER);

            Connection connection = DriverManager.getConnection(Menu.URL, Menu.USERNAME, Menu.PASSWORD);


            String query_insert = "INSERT INTO Book VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement_insert = connection.prepareStatement(query_insert);

            map.forEach((k, v) -> {
                try {
                    preparedStatement_insert.setInt(1,k);
                    preparedStatement_insert.setString(2, v.getName());
                    preparedStatement_insert.setString(3, v.getAuthor());
                    preparedStatement_insert.setString(4, v.getCat());
                    preparedStatement_insert.setInt(5, v.getPageNumber());
                    preparedStatement_insert.setDouble(6, v.getPrice());
                    preparedStatement_insert.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Book;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String author = resultSet.getString(3);
                String cat = resultSet.getString(4);
                int pageNumber = resultSet.getInt(5);
                double price = resultSet.getDouble(6);
                System.out.println(id + " : " + name + " : " + author + " : " + cat + " : " + pageNumber + " : " + price);

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("input is not good");
            return;
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {

        }

    }

//    public static void inputStoreToMap(Map<Integer, Bookbean> map, ) {
//
//    }

    @Override
    public int hashCode() {
        return name.hashCode() + author.hashCode() + cat.hashCode() + (int)price + pageNumber;
    }
}
