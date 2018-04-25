package com.wenbin.database;

import java.sql.*;

public class RetriveData {
    public static void main(String[] args) {


        try {
            Class.forName(DemoIII.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "select * from products";

        try (Connection connection = DriverManager.getConnection(DemoIII.URL, DemoIII.USERNAME, DemoIII.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " : " + resultSet.getString(2) + " : " + resultSet.getString(3) + " : " + resultSet.getDouble(4));
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

    }
}
