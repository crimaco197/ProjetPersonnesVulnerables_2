package org.Model;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
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

public class SignUP extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_1;

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

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 382, 469);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("");
        //lblNewLabel_1.setIcon(new ImageIcon(SignUP.class.getResource("/images/appbenevol.jpg")));

        // Redimensionner l'image pour correspondre aux dimensions du panel_1
        /*ImageIcon imageIcon = new ImageIcon(SignUP.class.getResource("/images/appbenevol.jpg"));
        java.awt.Image image = imageIcon.getImage().getScaledInstance(panel_1.getWidth(), panel_1.getHeight(), java.awt.Image.SCALE_SMOOTH);
        lblNewLabel_1.setIcon(new ImageIcon(image));*/

        panel_1.add(lblNewLabel_1);

        Button button = new Button("Sign_up");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				DatabaseConnector connexion = new DatabaseConnector();
				User newUser = new User(textField_3.getText(), textField.getText(), textField_5.getText(),textField_4.getText(), textField_1.getText());
				connexion.CreateUser(newUser);
            }
        });
        button.setFont(new Font("Arial Black", Font.PLAIN, 12));
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(Color.GREEN);
        button.setBounds(518, 386, 155, 36);
        contentPane.add(button);

        // ... (Le reste de votre code reste inchangé)
    


		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(456, 136, 267, 28);
		contentPane.add(textField);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(459, 163, 264, 1);
		contentPane.add(separator_1_2);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(456, 124, 78, 13);
		contentPane.add(lblNom);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(456, 186, 267, 28);
		contentPane.add(textField_3);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setBounds(459, 213, 264, 1);
		contentPane.add(separator_1_3);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setBounds(456, 174, 78, 13);
		contentPane.add(lblPrenom);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(456, 236, 267, 28);
		contentPane.add(textField_4);
		
		JSeparator separator_1_4 = new JSeparator();
		separator_1_4.setBounds(459, 263, 264, 1);
		contentPane.add(separator_1_4);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setBounds(456, 224, 78, 13);
		contentPane.add(lblTelephone);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(456, 286, 267, 28);
		contentPane.add(textField_5);
		
		JSeparator separator_1_5 = new JSeparator();
		separator_1_5.setBounds(459, 313, 264, 1);
		contentPane.add(separator_1_5);
		
		JLabel lblMotDePasse_3 = new JLabel("Email");
		lblMotDePasse_3.setBounds(456, 274, 78, 13);
		contentPane.add(lblMotDePasse_3);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(456, 336, 267, 28);
		contentPane.add(textField_1);
		
		JSeparator separator_1_5_1 = new JSeparator();
		separator_1_5_1.setBounds(459, 363, 264, 1);
		contentPane.add(separator_1_5_1);
		
		JLabel lblMotDePasse_3_1 = new JLabel("Mot de passe");
		lblMotDePasse_3_1.setBounds(456, 324, 78, 13);
		contentPane.add(lblMotDePasse_3_1);
	}
}