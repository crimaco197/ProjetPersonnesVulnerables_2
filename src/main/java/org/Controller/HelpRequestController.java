package org.Controller;

import org.Model.Helprequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HelpRequestController extends DatabaseController{

    public boolean CreateHelpRequest(Helprequest request){
        try {
            Statement statement = connection.createStatement();
            String SQLQuery1 = String.format("INSERT INTO HelpRequests (Title,Description,Status,Date) VALUES ('%s', '%s', '%s' ,'%s');", request.getTitle(), request.getDescription(), request.getStatus(), request.getStringDate());
            return statement.execute(SQLQuery1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean UpdateHelpRequest(String status, String title) throws SQLException {
        Statement statement = connection.createStatement();
        String SQLQuery1 = String.format("UPDATE HelpRequests SET Statut = '%s' WHERE Title = '%s'", status, title);
        return statement.execute(SQLQuery1);
    }

    public List<Helprequest> getAllRequests() {
        List<Helprequest> requests = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql =  "SELECT Title, Date, Description, Status FROM projet_gei_026.HelpRequests";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String status = rs.getString("Status");
                Date date = rs.getDate("Date");

                Helprequest hr = new Helprequest(title, description, date, status);
                requests.add(hr);
            }

            return  requests;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
