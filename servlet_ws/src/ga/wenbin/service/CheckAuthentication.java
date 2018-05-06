package ga.wenbin.service;

import java.sql.*;

public class CheckAuthentication {
    public static void main(String[] args) {

        System.out.println(checkAuthentic("Wenbin", "test123"));
        System.out.println(checkAuthentic("Wenbin", "test1d23"));

    }

    public static boolean checkAuthentic(String name, String password) {
        try {
            Class.forName(DB.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM User WHERE name = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);


            try ( ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
                else {
                    return false;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}
