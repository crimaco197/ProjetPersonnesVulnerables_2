package org.Model;

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

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

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

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 511);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.LIGHT_GRAY);
        panel_1.setBounds(0, 0, 382, 469);
        contentPane.add(panel_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setBackground(Color.WHITE);
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);

        // Charger l'image et la redimensionner
        ImageIcon imageIcon = new ImageIcon(Login.class.getResource("/images/appbenevol.jpg"));
        java.awt.Image image = imageIcon.getImage().getScaledInstance(382, 469, java.awt.Image.SCALE_SMOOTH);

        // Mettre l'image redimensionnée dans le JLabel
        lblNewLabel_1.setIcon(new ImageIcon(image));

        panel_1.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        panel_1.add(lblNewLabel);

        Button button = new Button("Login");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button.setFont(new Font("Arial Black", Font.PLAIN, 12));
        button.setForeground(new Color(255, 255, 255));
        button.setBackground(Color.BLUE);
        button.setBounds(503, 311, 155, 36);
        contentPane.add(button);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(456, 187, 267, 28);
        contentPane.add(textField);

        JSeparator separator_1_2 = new JSeparator();
        separator_1_2.setBounds(459, 214, 264, 1);
        contentPane.add(separator_1_2);

        JLabel lblNom = new JLabel("Nom");
        lblNom.setBounds(456, 174, 78, 13);
        contentPane.add(lblNom);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(456, 252, 267, 36);
        contentPane.add(textField_1);

        JSeparator separator_1_5_1 = new JSeparator();
        separator_1_5_1.setBounds(456, 287, 264, 1);
        contentPane.add(separator_1_5_1);

        JLabel lblMotDePasse_3_1 = new JLabel("Mot de passe");
        lblMotDePasse_3_1.setBounds(456, 240, 78, 13);
        contentPane.add(lblMotDePasse_3_1);

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(124, 456, 45, 13);
        contentPane.add(lblNewLabel_2);
    }
}
