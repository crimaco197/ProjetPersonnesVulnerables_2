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
            String SQLQuery1 = String.format("INSERT INTO HelpRequests (Title,Description,Status,Date) VALUES ('%s', '%s', '%s' ,'%s');", request.getTitle(), request.getDescription(), request.getStatus(), request.getStringDate());
            return statement.execute(SQLQuery1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean CreateHelpRequest(Helprequest request, int userID){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery1 = String.format("INSERT INTO HelpRequests (Title,Description,Status,Date) VALUES ('%s', '%s', '%s' ,'%s');", request.getTitle(), request.getDescription(), request.getStatus(), request.getStringDate());
            return statement.execute(SQLQuery1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean UpdateHelpRequest(Helprequest helprequest) throws SQLException {
        Statement statement = connection.createStatement();
        String SQLQuery1 = String.format("UPDATE HelpRequests SET Title = '%s', Description = '%s', Status = '%s', Date = '%s', RequestBy = '%i', Volunteer = '%i' WHERE ID = '%s'", helprequest.getTitle(), helprequest.getDescription(),helprequest.getStatus(), helprequest.getStringDate(), helprequest.getRequestBy(), helprequest.getVolunteer(), helprequest.getID());
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
                int requestby = rs.getInt("RequestBy");
                String volunteer = rs.getString("Volunteer");

                Helprequest hr = new Helprequest(id,title, description, date, status, requestby, volunteer);
                requests.add(hr);
            }

            return  requests;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void assignVolunteerToRequest(int requestId, String volunteerName) throws SQLException {
        // Implementa la lógica para asignar un voluntario a una solicitud de ayuda en la base de datos
        String SQLQuery = "UPDATE HelpRequests SET Volunteer = ? WHERE ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(SQLQuery)) {
            pstmt.setString(1, volunteerName);
            pstmt.setInt(2, requestId);
            pstmt.executeUpdate();
        }
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
                        rs.getInt("RequestBy"),
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
