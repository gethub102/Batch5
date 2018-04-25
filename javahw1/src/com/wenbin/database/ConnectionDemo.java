package com.wenbin.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * mysql driver could be download from this url 'http://www.java2s.com/Code/Jar/c/Downloadcommysqljdbc515jar.htm'
 *
 * intellij could add this jar file to lib.
 *  1. get project structure
 *  2. find library
 *  3. add this jar to lib
 *  4. run the code of jdbc
 *
 *
 * */
public class ConnectionDemo {
    public static void main(String[] args) {
        // 1. Load the driver

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. Establish the Connection
        java.sql.Connection  connection = null;
        Statement stmt = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rjt", "root", "root");
            // 3. Create statement

            stmt = connection.createStatement();

            String query = "insert into products values(1002, 'iphoneX', 'Electronic', 999)";

            // 4. Execute
            stmt.executeUpdate(query);

            // 5. Close resource
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    }
}
