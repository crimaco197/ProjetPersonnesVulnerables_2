package org.Model;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SignUP extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField lastname;
    private JTextField name;
    private JTextField phone;
    private JTextField email;
    private JTextField password;
    
    public SignUP() {
        initComponents();
	}
    
    private void initComponents(){
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 511);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        /*
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon(SignUP.class.getResource("/images/healthcare.png")));
        lblNewLabel.setBounds(160, 105, 61, 16);
        contentPane_Left.add(lblNewLabel);
        */
        
        // RIGHT PANEL
        JPanel contentPane_Right = new JPanel();
        contentPane_Right.setLayout(null);
        contentPane_Right.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_Right.setBackground(Color.LIGHT_GRAY);
        contentPane_Right.setBounds(400, 0, 400, 483);
        contentPane.add(contentPane_Right);
        
        JLabel label_signup = new JLabel("SIGN UP");
        label_signup.setHorizontalAlignment(SwingConstants.CENTER);
        label_signup.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        label_signup.setBounds(125, 30, 150, 50);
        contentPane_Right.add(label_signup);
        
        lastname = new JTextField();
        lastname.setColumns(10);
        lastname.setBounds(80, 136, 267, 28);
        contentPane_Right.add(lastname);
        
        JLabel lastname = new JLabel("LastName");
        lastname.setBounds(80, 124, 78, 13);
        contentPane_Right.add(lastname);
        
        name = new JTextField();
        name.setColumns(10);
        name.setBounds(80, 186, 267, 28);
        contentPane_Right.add(name);
        
        JLabel name = new JLabel("Name");
        name.setBounds(80, 174, 78, 13);
        contentPane_Right.add(name);
        
        phone = new JTextField();
        phone.setColumns(10);
        phone.setBounds(80, 236, 267, 28);
        contentPane_Right.add(phone);
        
        JLabel phone = new JLabel("Phone");
        phone.setBounds(80, 224, 78, 13);
        contentPane_Right.add(phone);
        
        email = new JTextField();
        email.setColumns(10);
        email.setBounds(80, 286, 267, 28);
        contentPane_Right.add(email);
        
        JLabel email = new JLabel("Email");
        email.setBounds(80, 274, 78, 13);
        contentPane_Right.add(email);
        
        password = new JTextField();
        password.setColumns(10);
        password.setBounds(80, 336, 267, 28);
        contentPane_Right.add(password);
        
        JLabel password = new JLabel("Password");
        password.setBounds(80, 324, 78, 13);
        contentPane_Right.add(password);
        
        JLabel label_tologin = new JLabel("Have you already an account ?");
        label_tologin.setBounds(80, 376, 199, 16);
        contentPane_Right.add(label_tologin);
        
        
        
        //BUTTON TO LOGIN
        JButton btn_toLogin = new JButton("Login");
        btn_toLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Login loginFrame = new Login();
        		loginFrame.setVisible(true);
        		SignUP.this.dispose();
        		System.out.println("You have change To Login");
        	}
        });
        btn_toLogin.setForeground(new Color(0, 128, 128));
        btn_toLogin.setBackground(Color.LIGHT_GRAY);
        btn_toLogin.setBounds(270, 371, 80, 29);
        contentPane_Right.add(btn_toLogin);
        
        //BUTTON SIGN UP
        JButton btn_SignUp = new JButton("Sign Up");
        btn_SignUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				DatabaseConnector connexion = new DatabaseConnector();
				User newUser = new User(name.getText(), lastname.getText(), email.getText(), phone.getText(), password.getText());
				connexion.CreateUser(newUser);
        		System.out.println("You have signed up");
        	}
        });
        btn_SignUp.setForeground(new Color(0, 128, 128));
        btn_SignUp.setBackground(new Color(0, 128, 128));
        btn_SignUp.setBounds(150, 415, 100, 40);
        contentPane_Right.add(btn_SignUp);
        
        
        
        
     // LEFT PANEL
        JPanel contentPane_Left = new JPanel();
        contentPane_Left.setLayout(null);
        contentPane_Left.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_Left.setBackground(new Color(0, 128, 128));
        contentPane_Left.setBounds(0, 0, 400, 483);
        contentPane.add(contentPane_Left);
        
        ImageIcon icon = new ImageIcon(Login.class.getResource("/images/healthcare.png"));
        Image image = icon.getImage();
        int width = 150;
        int height = 150;
        Image newimg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);

     
        JLabel logo = new JLabel(icon);
        logo.setBounds(100, 50, 200, 200);
        contentPane_Left.add(logo);
        
        JLabel label_NameAPP = new JLabel("VULNERABLES");
        label_NameAPP.setForeground(new Color(255, 255, 255));
        label_NameAPP.setHorizontalAlignment(SwingConstants.CENTER);
        label_NameAPP.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        label_NameAPP.setBounds(50, 310, 300, 50);
        contentPane_Left.add(label_NameAPP);
        contentPane_Left.revalidate();
        contentPane_Left.repaint();
        
        
        
    }
    
}