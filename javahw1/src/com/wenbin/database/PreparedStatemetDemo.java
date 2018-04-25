package com.wenbin.database;

import java.sql.*;

public class PreparedStatemetDemo {
    static final String DRIVER = "com.mysql.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://localhost:3307/rjt";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName(DRIVER);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO products VALUES (?, ?, ?, ?); ";
        String query_select = "SELECT * FROM products WHERE pid = ? ;";
        try (Connection connetction = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connetction.prepareStatement(query);
             PreparedStatement preparedStatement1 = connetction.prepareStatement(query_select)
        ) {
            preparedStatement.setInt(1, 1005);
            preparedStatement.setString(2, "MotoXII");
            preparedStatement.setString(3, "Electronic");
            preparedStatement.setDouble(4, 251);
            preparedStatement.execute();

            preparedStatement1.setInt(1,1002);
            ResultSet resultSet =  preparedStatement1.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getDouble(4));
            }

            PreparedStatemetDemo.closeResultAndStatement(resultSet, preparedStatement1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disPlay(String select_query, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(select_query);
            ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String cat = resultSet.getString(3);
                double price = resultSet.getDouble(4);
                System.out.println(id + " : " + name + " : " + cat + " : " + price);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean insertionData (int pid, String name, String cat, double price, Connection connection) {
        String query = "INSERT INTO products VALUES (?, ?, ?, ? );";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, pid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, cat);
            preparedStatement.setDouble(4, price);
            if (preparedStatement.execute()) {
                System.out.println("Success: " + query);
                return true;
            }
            return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean closeResultAndStatement(ResultSet resultSet, PreparedStatement preparedStatement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
