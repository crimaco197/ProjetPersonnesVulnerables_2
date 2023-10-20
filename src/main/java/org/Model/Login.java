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

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 782);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(217, 10, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(64, 128, 128));
		panel_1.setBounds(0, 0, 382, 735);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		
		Button button = new Button("LOGIN");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("Arial Black", Font.PLAIN, 12));
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(531, 516, 155, 36);
		contentPane.add(button);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(476, 334, 267, 28);
		contentPane.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(479, 361, 264, 1);
		contentPane.add(separator_1);
		
		JLabel lblMotDePasse = new JLabel("Email");
		lblMotDePasse.setBounds(476, 322, 78, 13);
		contentPane.add(lblMotDePasse);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(476, 406, 267, 28);
		contentPane.add(textField_2);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(479, 433, 264, 1);
		contentPane.add(separator_1_1);
		
		JLabel lblMotDePasse_1 = new JLabel("Mot de passe");
		lblMotDePasse_1.setBounds(476, 394, 78, 13);
		contentPane.add(lblMotDePasse_1);
	}
}

