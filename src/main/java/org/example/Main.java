package org.example;
import org.Model.SignUP;
import org.Views.frameGUI;

import java.awt.EventQueue;

import javax.swing.*;

public class Main extends JFrame {


    public static void main(String[] args) {
        System.out.println("Hello world!");
       // JFrame frame = new frameGUI();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUP frame = new SignUP();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}


