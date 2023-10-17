package org.Views;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class frameGUI extends JFrame {

    public frameGUI() {
        super("titre de l'application");

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };

        addWindowListener(l);

        ImageIcon img = new ImageIcon("start.png");
        JButton bouton = new JButton("Mon bouton",img);

        JPanel panneau = new JPanel();
        panneau.add(bouton);
        setContentPane(panneau);
        setSize(400,400);
        setVisible(true);
        }
}
