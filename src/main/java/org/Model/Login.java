package org.Model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField email;
    private JTextField password;


	
	public Login() {
		initComponents();
		setVisible(true);
	}
	
	
	/**
	 * Create the frame.
	 */
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 511);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        
        // RIGHT PANEL
        JPanel contentPane_Right = new JPanel();
        contentPane_Right.setLayout(null);
        contentPane_Right.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane_Right.setBackground(Color.LIGHT_GRAY);
        contentPane_Right.setBounds(400, 0, 400, 483);
        contentPane.add(contentPane_Right);
        
        JLabel label_login = new JLabel("LOGIN");
        label_login.setHorizontalAlignment(SwingConstants.CENTER);
        label_login.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        label_login.setBounds(150, 30, 100, 50);
        contentPane_Right.add(label_login);
        
        JLabel label_email = new JLabel("Email");
        label_email.setBounds(80, 177, 78, 13);
        contentPane_Right.add(label_email);
        
        email = new JTextField();
        email.setColumns(10);
        email.setBounds(80, 189, 267, 28);
        contentPane_Right.add(email);
        
        JLabel label_password = new JLabel("Password");
        label_password.setBounds(80, 227, 78, 13);
        contentPane_Right.add(label_password);
        
        password = new JTextField();
        password.setColumns(10);
        password.setBounds(80, 239, 267, 28);
        contentPane_Right.add(password);
        
        JLabel label_toSIGNUP = new JLabel("Create an account ?");
        label_toSIGNUP.setBounds(80, 279, 199, 16);
        contentPane_Right.add(label_toSIGNUP);
        
        //BUTTON TO SIGNUP
        JButton btn_toSignUp = new JButton("Sign Up");
        btn_toSignUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SignUP signupFrame = new SignUP();
        		signupFrame.setVisible(true);
        		Login.this.dispose();
        		System.out.println("you have change To Sign Up");
        	}
        });
        
        btn_toSignUp.setForeground(new Color(0, 128, 128));
        btn_toSignUp.setBackground(Color.LIGHT_GRAY);
        btn_toSignUp.setBounds(270, 274, 80, 29);
        contentPane_Right.add(btn_toSignUp);
        
        //BUTTON LOGIN
        JButton btn_Login = new JButton("Login");
        btn_Login.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
				DatabaseConnector connexion = new DatabaseConnector();
				int userID = connexion.VerifyUserCredentials(email.getText(), password.getText());
        		
        		System.out.println("You have login, user" + userID);
        	}
        });
        btn_Login.setForeground(new Color(0, 128, 128));
        btn_Login.setBackground(Color.LIGHT_GRAY);
        btn_Login.setBounds(150, 330, 100, 40);
        contentPane_Right.add(btn_Login);
        
        
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
