package org.Model;
import java.text.SimpleDateFormat;
import java.util.*;
public class Helprequest {
    private int ID ;
    private String Title;
    private String Description;
    private Date Date ;
    private String Status;
//    int Needy ;
//    int Volunter ;

    public Helprequest(String title, String description, Date date, String status ) {
        Title = title;
        Description = description;
        Date = date;
        Status = status;
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
}
