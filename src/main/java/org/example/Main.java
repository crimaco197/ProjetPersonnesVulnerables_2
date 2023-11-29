package org.example;
import org.Model.*;
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
                    
//                    VHelprequest requestframe= new VHelprequest();
//                      requestframe.setVisible(true);
//                      
                    Login loginFrame = new Login();
            		loginFrame.setVisible(true);
                        
//                    Vlistrequest hi = new Vlistrequest();
//                       hi.setVisible(true);
                
            		
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}



