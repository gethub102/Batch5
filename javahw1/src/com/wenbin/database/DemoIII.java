package com.wenbin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/***
 * static is part of class should  not  in the method
 * private should also be in class not in method
 *
 * */

public class DemoIII {
    protected static final String DRIVER = "com.mysql.jdbc.Driver";
    protected static final String URL = "jdbc:mysql://localhost:3306/rjt";
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "root";


    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "create table dbusers (USERID int primary key, FirstName varchar(25))";
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            closeStatementAndConnection(statement, connection);
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
            System.out.println("resource release successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
