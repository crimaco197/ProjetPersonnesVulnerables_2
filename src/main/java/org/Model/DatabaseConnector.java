package org.Model;
import java.sql.*;
import java.util.*;
public class DatabaseConnector {
    private String url = "jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_026";
    private String username = "projet_gei_026";

    private String password = "EiGhai4l";

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
    public boolean CreateUser(User user){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery = String.format("INSERT INTO Users (FirstName, LastName, Email, PhoneNumber, Password) VALUES ('%s', '%s', '%s', '%s', '%s');", user.FirstName, user.LastName, user.Email, user.PhoneNumber, user.Password);
            return statement.execute(SQLQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public boolean CreateHelpRequest(Helprequest request){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery1 = String.format("INSERT INTO HelpRequests (Title,Description,Date, Statut) VALUES ('%s', '%s', '%s' ,'%s');", request.Title, request.Description, request.Date ,request.Statut );
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
            String SQLQuery = String.format("UPDATE Users SET FirstName = '%s', LastName = '%s', Email = '%s', PhoneNumber = '%s', Password = '%s' WHERE userID = %d;",  user.FirstName, user.LastName, user.Email, user.PhoneNumber, user.Password, user.userID);
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
    
//    public List<Helprequest> getAllRequests() {
//    List<Helprequest> requests = new ArrayList<>();
//
//    try {
//        Statement statement = connection.createStatement();
//        String SQLQuery = "SELECT * FROM Request";
//        ResultSet resultSet = statement.executeQuery(SQLQuery);
//
//        while (resultSet.next()) {
//            Helprequest request = new Helprequest(
//                resultSet.getString("Title"),
//                resultSet.getString("Description"),
//                resultSet.getString("Date"),
//                resultSet.getInt("ID"),
//                resultSet.getInt("Needy"),
//                resultSet.getInt("Volunteer")
//            );
//            requests.add(request);
//        }
//
//    } catch (SQLException e) {
//        throw new RuntimeException(e);
//    }
//
//    return requests;
//}


}
