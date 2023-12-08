package org.Controller;
import org.Model.Helprequest;
import org.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class DatabaseConnector {
    private final String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_026";
    private final String username = "projet_gei_026";

    private final String password = "EiGhai4l";

    Connection connection;

    //TODO: Handle exception when connections fails
    //TODO: Handle exception when email already exists in database
    //CONSTRUCTOR: Tries to make the database connection with the username and password
    public DatabaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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
    
    public boolean CreateHelpRequest(Helprequest request){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery1 = String.format("INSERT INTO HelpRequests (Title,Description,Status,Date) VALUES ('%s', '%s', '%s' ,'%s');", request.getTitle(), request.getDescription(), request.getStatus(), request.getStringDate());
            return statement.execute(SQLQuery1);
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
            while (rs.next()) {
                return rs.getInt("UserID");
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Helprequest> getAllRequests() {
    List<Helprequest> requests = new ArrayList<>();

    try {
        Statement statement = connection.createStatement();
        String sql =  "SELECT Title ,Date,Description,Statut FROM projet_gei_026.HelpRequests";
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()){
            String title = rs.getString("Title");
            String description = rs.getString("Description");
            Date date = rs.getDate("Date");
            String statut = rs.getString("Statut");

            Helprequest hr = new Helprequest(title, description,date, statut);
            requests.add(hr);
        }

        return  requests;

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

    public boolean UpdateHelpRequest(String status, String title) throws SQLException {
        Statement statement = connection.createStatement();
        String SQLQuery1 = String.format("UPDATE HelpRequests SET Statut = '%s' WHERE Title = '%s'", status, title);
        return statement.execute(SQLQuery1);
    }

}
