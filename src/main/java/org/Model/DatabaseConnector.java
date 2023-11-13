package org.Model;
import java.sql.*;
public class DatabaseConnector {
    private String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_026";
    private String username = "projet_gei_026";

    private String password = "EiGhai4l";

    Connection connection;

    public DatabaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void CreateUser(User user){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format("INSERT INTO Users (FirstName, LastName, Email, PhoneNumber, Password) VALUES ('%s', '%s', '%s', '%s', '%s');", user.FirstName, user.LastName, user.Email, user.PhoneNumber, user.Password);
            boolean success = statement.execute(SQLQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
