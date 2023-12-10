package org.Model;
import java.text.SimpleDateFormat;
import java.util.*;
public class Helprequest {
    private int ID ;
    private String Title;
    private String Description;
    private Date Date ;
    private String Status;
    private int RequestBy ;
    private String Volunteer ;

    public Helprequest(String title, String description, Date date, String status ) {
        Title = title;
        Description = description;
        Date = date;
        Status = status;
    }

    public Helprequest(int ID, String title, String description, java.util.Date date, String status, int requestBy, String volunteer) {
        this.ID = ID;
        Title = title;
        Description = description;
        Date = date;
        Status = status;
        RequestBy = requestBy;
        Volunteer = volunteer;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public Date getDate() {
        return Date;
    }

    public String getStringDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        // Format the Date object to a String
        String strDate = formatter.format(Date);
        return strDate;
    }

    public String getStatus() {
        return Status;
    }

    public int getRequestBy() {
        return RequestBy;
    }

    public String getVolunteer() {
        return Volunteer;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setRequestBy(int requestBy) {
        RequestBy = requestBy;
    }

    public void setVolunteer(String volunteer) {
        Volunteer = volunteer;
    }
}
