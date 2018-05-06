package ga.wenbin.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registration {
    public static void main(String[] args) {
        try {
            Class.forName(DB.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO User (name, password) VALUES (?, ?) ";

        try (Connection connection = DriverManager.getConnection(DB.URL, DB.USERNAME, DB.PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {

            preparedStatement.setString(1, "Wenbin");
            preparedStatement.setString(2, "test123");
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
