package org.Model;
public class User {
    int userID;
    String FirstName;
    String LastName;
    String Email;
    String PhoneNumber;
    String Password;

    public User(String firstName, String lastName, String email, String phoneNumber, String password) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
    }
}