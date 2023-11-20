package org.example;
import org.Model.Login;
//import org.Model.SignUP;

import java.awt.EventQueue;

import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        System.out.println("Hello world!");
       // JFrame frame = new frameGUI();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    Login loginFrame = new Login();
            		loginFrame.setVisible(true);
            		
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}


