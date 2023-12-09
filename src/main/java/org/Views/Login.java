package org.Views;

import org.Controller.DatabaseController;
import org.Controller.UserController;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField email;
    private JPasswordField passwordField;
    private String errorMessage;
    private boolean loginSuccessful;
    private boolean signUpButtonClicked;

    JButton btn_Login;
    JButton btn_toSignUp;



    public Login() {
		initComponents();
		setVisible(true);
	}

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public boolean isSignUpButtonClicked() {
        return signUpButtonClicked;
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

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(80, 239, 267, 28);
        contentPane_Right.add(passwordField);
        
        JLabel label_toSIGNUP = new JLabel("Create an account ?");
        label_toSIGNUP.setBounds(80, 279, 199, 16);
        contentPane_Right.add(label_toSIGNUP);
        
        //BUTTON TO SIGNUP
         btn_toSignUp = new JButton("Sign Up");
        btn_toSignUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SignUP signupFrame = new SignUP();
        		signupFrame.setVisible(true);
                signUpButtonClicked = true;
        		Login.this.dispose();
        		System.out.println("you have change To Sign Up");
        	}
        });
        
        btn_toSignUp.setForeground(new Color(0, 128, 128));
        btn_toSignUp.setBackground(Color.LIGHT_GRAY);
        btn_toSignUp.setBounds(270, 274, 80, 29);
        contentPane_Right.add(btn_toSignUp);
        
        //BUTTON LOGIN
         btn_Login = new JButton("Login");
        btn_Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] password = passwordField.getPassword();
                String passwordString = new String(password);

                if (
                        email.getText().trim().isEmpty() ||
                        passwordString.trim().isEmpty()) {
                    // Muestra un mensaje de error
                    errorMessage = "All fields must be filled out.";
                    JOptionPane.showMessageDialog(Login.this, "All fields must be filled out.", "Login Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Todos los campos están llenos, procede con el login
                    UserController connexion = new UserController();
                    int userID = connexion.VerifyUserCredentials(email.getText(), passwordString);
                    if(userID!=0){
                        VHelprequest reqFrame = new VHelprequest();
                        reqFrame.setVisible(true);
                        loginSuccessful = true;

                        Login.this.dispose();
                        System.out.println("You have login, user" + userID);

                    }else{
                        errorMessage = "Incorrect email or password. Please try again.";
                        JOptionPane.showMessageDialog(Login.this, "Incorrect email or password. Please try again.", "Identification Error", JOptionPane.ERROR_MESSAGE);
                        email.setText("");
                        passwordField.setText("");
                    }
                }
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
    public JTextField getEmail() {
        return email;
    }
    public JTextField getPasswordfield() {
        return passwordField;
    }
    public JButton getButlogin() {
        return btn_Login;
    }

    public JButton getButsignup() {
        return btn_toSignUp;
    }

}
