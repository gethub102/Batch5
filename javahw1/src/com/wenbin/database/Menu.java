package com.wenbin.database;

import java.sql.*;
import java.util.Scanner;

public class Menu {


    protected static final String DRIVER = "com.mysql.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://localhost:3307/rjt";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }


        Menu menu = new Menu();

        menu.displayMenu();

        System.out.println("\n==============\n");


        menu.addProducts();

        System.out.println("\n==============\n");
        menu.displayMenu();

        System.out.println("\n======= show by phone cat =======\n");
        menu.displayMenuByCat("phone");

        System.out.println("\n====== show by Electronic cat ========\n");
        menu.displayMenuByCat("Electronic");

    }

    public void addProducts() {
        try (Connection connection = DriverManager.getConnection(Menu.URL, Menu.USERNAME, Menu.PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            String query = "";


            try (Scanner scanner = new Scanner(System.in)) {
                String flag = "input";
                while (!flag.equals("exit")) {
                    System.out.println("add a product? yes? or exit?");
                    flag = scanner.next();
                    if (flag.equals("exit")) {
                        return;
                    }

                    System.out.print("product id: ");
                    int id = Integer.parseInt(scanner.next());

                    System.out.print("product name: ");
                    String name = scanner.next();

                    System.out.print("product cat: ");
                    String cat = scanner.next();

                    System.out.print("product price: ");
                    double price = Double.parseDouble(scanner.next());

                    String insertQuery = "INSERT INTO products VALUES (" + id + ", '"  + name + "', '" + cat + "', " + price+ " )";
                    System.out.println(insertQuery);
                    statement.executeUpdate(insertQuery);

                    System.out.print("Continue: yes?, exit? ");
                    flag = scanner.next();

                }
            }
            catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("exit because of number format");
                return;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayMenu() {
        String query = "select * from products";

        try (Connection connection = DriverManager.getConnection(Menu.URL, Menu.USERNAME, Menu.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void displayMenuByCat(String cat) {
        String query = "select * from products WHERE pcat = " + "'" + cat + "'" ;
        System.out.println(query);

        try (Connection connection = DriverManager.getConnection(Menu.URL, Menu.USERNAME, Menu.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getDouble(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean closeStatementAndConnection (Statement statement, Connection connection) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
            System.out.println("resource release successfully ");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
