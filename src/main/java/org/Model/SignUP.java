package org.Model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.sound.midi.Soundbank;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SignUP extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField lastname;
    private JTextField name;
    private JTextField phone;
    private JTextField email;
    private JTextField password;

    public static void main(String[] args) {
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

    public SignUP() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 511);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel contentPane_Left = new JPanel();
        contentPane_Left.setLayout(null);
        contentPane_Left.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_Left.setBackground(new Color(0, 128, 128));
        contentPane_Left.setBounds(0, 0, 400, 483);
        contentPane.add(contentPane_Left);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon(SignUP.class.getResource("/images/healthcare.png")));
        lblNewLabel.setBounds(160, 105, 61, 16);
        contentPane_Left.add(lblNewLabel);
        
        JPanel contentPane_Right = new JPanel();
        contentPane_Right.setLayout(null);
        contentPane_Right.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_Right.setBackground(Color.LIGHT_GRAY);
        contentPane_Right.setBounds(0, 0, 800, 483);
        contentPane.add(contentPane_Right);
        
        lastname = new JTextField();
        lastname.setColumns(10);
        lastname.setBounds(456, 136, 267, 28);
        contentPane_Right.add(lastname);
        
        JLabel lastname_1 = new JLabel("LastName");
        lastname_1.setBounds(456, 124, 78, 13);
        contentPane_Right.add(lastname_1);
        
        name = new JTextField();
        name.setColumns(10);
        name.setBounds(456, 186, 267, 28);
        contentPane_Right.add(name);
        
        JLabel name_1 = new JLabel("Name");
        name_1.setBounds(456, 174, 78, 13);
        contentPane_Right.add(name_1);
        
        phone = new JTextField();
        phone.setColumns(10);
        phone.setBounds(456, 236, 267, 28);
        contentPane_Right.add(phone);
        
        JLabel phone_1 = new JLabel("Phone");
        phone_1.setBounds(456, 224, 78, 13);
        contentPane_Right.add(phone_1);
        
        email = new JTextField();
        email.setColumns(10);
        email.setBounds(456, 286, 267, 28);
        contentPane_Right.add(email);
        
        JLabel email_1 = new JLabel("Email");
        email_1.setBounds(456, 274, 78, 13);
        contentPane_Right.add(email_1);
        
        password = new JTextField();
        password.setColumns(10);
        password.setBounds(456, 336, 267, 28);
        contentPane_Right.add(password);
        
        JLabel password_1 = new JLabel("Password");
        password_1.setBounds(456, 324, 78, 13);
        contentPane_Right.add(password_1);
        
        JLabel label_tologin = new JLabel("Have you already an account ?");
        label_tologin.setBounds(456, 376, 199, 16);
        contentPane_Right.add(label_tologin);
        
        JLabel label_signup = new JLabel("SIGN UP");
        label_signup.setHorizontalAlignment(SwingConstants.CENTER);
        label_signup.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        label_signup.setBounds(549, 39, 108, 53);
        contentPane_Right.add(label_signup);
        
        //BUTTON TO LOGIN
        JButton btn_toLogin_1 = new JButton("Login");
        btn_toLogin_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Button To Login");
        	}
        });
        btn_toLogin_1.setForeground(new Color(0, 128, 128));
        btn_toLogin_1.setBackground(new Color(0, 128, 128));
        btn_toLogin_1.setBounds(666, 371, 69, 29);
        contentPane_Right.add(btn_toLogin_1);
        
        //BUTTON SIGN UP
        JButton btn_SignUp_1 = new JButton("Sign Up");
        btn_SignUp_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				DatabaseConnector connexion = new DatabaseConnector();
				User newUser = new User(name.getText(), lastname.getText(), email.getText(), phone.getText(), password.getText());
				connexion.CreateUser(newUser);
        		
        		System.out.println("You have signed up");
        	}
        });
        btn_SignUp_1.setForeground(new Color(0, 128, 128));
        btn_SignUp_1.setBackground(new Color(0, 128, 128));
        btn_SignUp_1.setBounds(549, 427, 95, 29);
        contentPane_Right.add(btn_SignUp_1);
	
		

	}
}