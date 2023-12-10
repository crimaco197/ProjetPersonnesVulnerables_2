package org.Controller;

import org.Model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserController extends DatabaseController {

    public UserController() throws SQLException, ClassNotFoundException {
    }

    // Add new user to Users table
    public boolean CreateUser(User user, String password){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format("INSERT INTO Users (FirstName, LastName, Email, PhoneNumber, Password) VALUES ('%s', '%s', '%s', '%s', '%s');", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), password);
            return statement.execute(SQLQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Not tested yet 15/11/23
    public boolean UpdateUser(User user)
    {
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format("UPDATE Users SET FirstName = '%s', LastName = '%s', Email = '%s', PhoneNumber = '%s' WHERE userID = %d;", user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber(), user.getUserID());
            return statement.execute(SQLQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    // Verifies user and password in login, if password is correct returns the user ID otherwise returns 0
    public int VerifyUserCredentials(String email, String password)
    {
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format("SELECT * FROM Users WHERE Email = '%s' AND Password = '%s';", email, password);
            ResultSet rs = statement.executeQuery(SQLQuery);
            if (rs.next()) {
                return rs.getInt("UserID");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String getName(String email, String password) {
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format("SELECT FirstName FROM Users WHERE Email = '%s' AND Password = '%s';", email, password);
            ResultSet rs = statement.executeQuery(SQLQuery);
            if (rs.next()) {
                return rs.getString("FirstName"); // Cambiado para retornar el nombre del usuario
            }
            return null; // Cambiado para retornar null si no hay coincidencias
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
