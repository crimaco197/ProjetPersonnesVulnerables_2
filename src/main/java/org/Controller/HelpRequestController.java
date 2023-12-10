package org.Controller;

import org.Model.Helprequest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelpRequestController extends DatabaseController{

    public HelpRequestController() throws SQLException, ClassNotFoundException {
    }

    public boolean CreateHelpRequest(Helprequest request){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery1 = String.format("INSERT INTO HelpRequests (Title,Description,Status,Date) VALUES ('%s', '%s', 'waiting' ,'%s');", request.getTitle(), request.getDescription(), request.getStringDate());
            return statement.execute(SQLQuery1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean CreateHelpRequest(Helprequest request, String userName){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery1 = String.format("INSERT INTO HelpRequests (Title,Description,Status,Date,RequestBy) VALUES ('%s', '%s', 'waiting' ,'%s', '%s');", request.getTitle(), request.getDescription(), request.getStringDate(), userName);
            return statement.execute(SQLQuery1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean UpdateHelpRequest(Helprequest helprequest) throws SQLException {
        Statement statement = connection.createStatement();
        String SQLQuery1 = String.format("UPDATE HelpRequests SET Title = '%s', Description = '%s' WHERE ID = '%s'", helprequest.getTitle(), helprequest.getDescription(), helprequest.getID());
        return statement.execute(SQLQuery1);
    }

    public boolean UpdateHelpRequest(String status, String title) throws SQLException {
        Statement statement = connection.createStatement();
        String SQLQuery1 = String.format("UPDATE HelpRequests SET Status = '%s' WHERE Title = '%s'", status, title);
        return statement.execute(SQLQuery1);
    }

    public List<Helprequest> getAllRequests() {
        List<Helprequest> requests = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql =  "SELECT ID, Title, Date, Description, Status, RequestBy, Volunteer FROM projet_gei_026.HelpRequests";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Date date = rs.getDate("Date");
                String requestby = rs.getString("RequestBy");
                String volunteer = rs.getString("Volunteer");

                Helprequest hr = new Helprequest(id,title, description, date, status, requestby, volunteer);
                requests.add(hr);
            }

            return  requests;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Helprequest> getWaitingRequests(String userName) {
        List<Helprequest> requests = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql =  String.format("SELECT ID, Title, Date, Description, Status, RequestBy, Volunteer FROM projet_gei_026.HelpRequests WHERE Status = 'waiting' AND RequestBy != '%s'", userName);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Date date = rs.getDate("Date");
                String requestby = rs.getString("RequestBy");
                String volunteer = rs.getString("Volunteer");

                Helprequest hr = new Helprequest(id,title, description, date, status, requestby, volunteer);
                requests.add(hr);
            }

            return  requests;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Helprequest> getRequestByUser(String userName) {
        List<Helprequest> requests = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql =  String.format("SELECT ID, Title, Date, Description, Status, RequestBy, Volunteer FROM projet_gei_026.HelpRequests WHERE RequestBy = '%s'", userName);
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Date date = rs.getDate("Date");
                String requestby = rs.getString("RequestBy");
                String volunteer = rs.getString("Volunteer");

                Helprequest hr = new Helprequest(id,title, description, date, status, requestby, volunteer);
                requests.add(hr);
            }

            return  requests;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean assignVolunteerToRequest(int requestId, String volunteerName) throws SQLException {
        // Implementa la lógica para asignar un voluntario a una solicitud de ayuda en la base de datos
        Statement statement = connection.createStatement();
        String SQLQuery1 = String.format("UPDATE HelpRequests SET Volunteer = '%s', Status = 'assigned' WHERE ID = '%d'", volunteerName, requestId);
        return statement.execute(SQLQuery1);
        /*String SQLQuery = "UPDATE HelpRequests SET Volunteer = ? WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(SQLQuery)) {
            pstmt.setString(1, volunteerName);
            pstmt.setInt(2, requestId);
            pstmt.executeUpdate();
        }*/
    }
    
    public boolean MarkRequestAsDone(int requestID) throws SQLException {
        Statement statement = connection.createStatement();
        String SQLQuery1 = String.format("UPDATE HelpRequests SET Status = 'done' WHERE ID = '%d'", requestID);
        return statement.execute(SQLQuery1);
    }
    
    public List<Helprequest> getVolunteerRequests(String volunteerName) {
        List<Helprequest> volunteerRequests = new ArrayList<>();
        String sql = "SELECT * FROM HelpRequests WHERE Volunteer = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, volunteerName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                // Asumiendo que tienes un constructor adecuado en tu clase Helprequest
                Helprequest request = new Helprequest(
                        rs.getInt("ID"),
                        rs.getString("Title"),
                        rs.getString("Description"),
                        rs.getDate("Date"),
                        rs.getString("Status"),
                        rs.getString("RequestBy"),
                        rs.getString("Volunteer")
                );
                volunteerRequests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Consider a more robust exception handling strategy for production code
        }

        return volunteerRequests;
    }

}
