package com.wenbin.database;

import java.sql.*;

public class CallableStatemetDemo {
    public static void main(String[] args) {
        try {
            Class.forName(Menu.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "{call getDetialsById(?)}";
        try (Connection connection = DriverManager.getConnection(Menu.URL, Menu.USERNAME, Menu.PASSWORD);
            CallableStatement cstmt = connection.prepareCall(query);
        ) {
            cstmt.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
