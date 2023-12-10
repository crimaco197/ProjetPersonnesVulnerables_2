package org.Views;

import org.Controller.HelpRequestController;
import org.Model.Helprequest;

import com.google.protobuf.DescriptorProtos.MethodOptions.IdempotencyLevel;

import org.Controller.CustomDialog;
import org.Controller.DatabaseController;
import org.Controller.UserController;

import java.awt.Color;
import java.sql.SQLException;
import java.util.List;

import java.util.Date;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class MyRequests extends JFrame {

	/*
	 */

	private JPanel getContentPane;

	private JPanel panel_menu;
	private JLabel label_NameAPP;
	private JLabel Label_Welcome;
	private boolean missionsButtonClicked;


	// PANEL LEFT
	private JPanel panel_left;

	private JTable TableRequest;
	private JButton btn_show_table_data;
	private JButton btn_MakeReview;

	// PANEL RIGHT
	private JPanel panel_right;


	private JLabel Label_BigTittle;

	private JLabel Title;

	private JLabel Label_status;

	private JLabel Label_Date;

	private JLabel Label_Description;
	private JTextField Text_Description;

	private JButton btn_Valider;
	private JButton btn_update;
	private JPanel panel_profil;
	private JTextField textField_Tittle;
	private JTextField textField_Status;
	private JTextField textField_Date;
	
	private JLabel lbl_ID_Request;
	private Integer id_Request;
	private String status_Request;

	private String userName;
	private JButton btn_MyRequest;
	private JButton btn_update_Done;


	public MyRequests(String user) {
		initComponents(user);
		setVisible(true);
		userName = user;
		// errorOptionPane = new JOptionPane();
	}
	


	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents(String user) {

		// Creacion Main Panel
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		getContentPane = new JPanel();
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(getContentPane);
		getContentPane.setLayout(null);

		// PANEL MENU
		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0, 128, 128));
		panel_menu.setLayout(null);
		panel_menu.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane_Left.setBackground(new Color(0, 128, 128));
		panel_menu.setBounds(0, 0, 1200, 150);
		getContentPane().add(panel_menu);
		
		label_NameAPP = new JLabel("VULNERABLES");
        label_NameAPP.setForeground(new Color(255, 255, 255));
        label_NameAPP.setHorizontalAlignment(SwingConstants.CENTER);
        label_NameAPP.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        label_NameAPP.setBounds(450, 50, 300, 50);
        panel_menu.add(label_NameAPP);
        
        //String FirstName = connexion.getName(email.getText(), passwordString);
        Label_Welcome = new JLabel("Welcome, " + user);
        Label_Welcome.setForeground(Color.WHITE);
        Label_Welcome.setBounds(45, 90, 200, 50);
        Label_Welcome.setFont(new Font("Lucida Grande", Font.BOLD, 15));
        panel_menu.add(Label_Welcome);
        
        JButton btn_Home = new JButton();
        btn_Home.setForeground(new Color(0, 128, 128));
        btn_Home.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		VHelprequest homePage = new VHelprequest(user);
        		homePage.setVisible(true);
        		missionsButtonClicked = true;
        		MyRequests.this.dispose();
           		System.out.println("you have change To MyMissions");
        	}
        });
        btn_Home.setBounds(740, 96, 100, 40);
        panel_menu.add(btn_Home);
        btn_Home.setText("Home");
        btn_Home.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btn_Home.setBackground(Color.LIGHT_GRAY);
        

        JButton btn_Missions = new JButton();
        btn_Missions.setForeground(new Color(0, 128, 128));
        btn_Missions.setText("Missions");
        btn_Missions.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btn_Missions.setBackground(Color.LIGHT_GRAY);
        btn_Missions.setBounds(1000, 96, 100, 40);
        btn_Missions.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
    		MyMissions homePage = null;
			try {
				homePage = new MyMissions(user);
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		homePage.setVisible(true);
    		missionsButtonClicked = true;
    		MyRequests.this.dispose();
       		System.out.println("you have change To Home");
    	}
    });
        panel_menu.add(btn_Missions);
        
        btn_MyRequest = new JButton();
        btn_MyRequest.setText("My Requests");
        btn_MyRequest.setForeground(new Color(0, 128, 128));
        btn_MyRequest.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        btn_MyRequest.setBackground(Color.LIGHT_GRAY);
        btn_MyRequest.setBounds(870, 96, 100, 40);
        panel_menu.add(btn_MyRequest);


		// LEFT PANEL
		panel_left = new JPanel();
		panel_left.setBackground(Color.LIGHT_GRAY);
		panel_left.setLayout(null);
		panel_left.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_left.setBounds(0, 150, 600, 500);
		getContentPane().add(panel_left);
		
		
		// Column names
        String[] columnNames = {"ID" ,"Title", "Date", "Description", "Status", "Volunteer"};
        
        // Data for the table in a 2D array
        Object[][] data = {
            // ... you can add more rows as needed
        }; 
        
		// Create a table with the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
		TableRequest = new JTable(model);
		TableRequest.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(TableRequest);
		scrollPane.setBounds(40, 20, 520, 300);
		panel_left.add(scrollPane);
		
		TableRequest.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jTable1MouseClicked(evt);
			}
		});
		
		btn_show_table_data = new JButton();
		btn_show_table_data.setForeground(new Color(0, 128, 128));
		btn_show_table_data.setBackground(new Color(128, 128, 128));
		btn_show_table_data.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
		btn_show_table_data.setText("Show My Requests");
		btn_show_table_data.setBounds(200, 375, 200, 50);
		panel_left.add(btn_show_table_data);
		btn_show_table_data.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					show_table_dataActionPerformed(evt);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		});
		
		
		// PanelRequests.setViewportView(TableRequest);
		

		/*
		btn_MakeReview = new JButton();
		btn_MakeReview.setForeground(new Color(0, 128, 128));
		btn_MakeReview.setBackground(new Color(128, 128, 128));
		btn_MakeReview.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
		btn_MakeReview.setText("Make Review");
		btn_MakeReview.setBounds(350, 375, 150, 50);
		panel_left.add(btn_MakeReview);
		*/

		// RIGHT PANEL
		panel_right = new JPanel();
		panel_right.setBackground(Color.LIGHT_GRAY);
		panel_right.setLayout(null);
		panel_right.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane_Right.setBackground(Color.LIGHT_GRAY);
		panel_right.setBounds(600, 150, 600, 500);
		getContentPane().add(panel_right);

		panel_profil = new JPanel();
		panel_profil.setLayout(null);
		panel_profil.setBounds(40, 20, 520, 460);
		panel_right.add(panel_profil);


		Label_BigTittle = new JLabel();
		Label_BigTittle.setSize(310, 50);
		Label_BigTittle.setLocation(105, 20);
		panel_profil.add(Label_BigTittle);
		Label_BigTittle.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
		Label_BigTittle.setForeground(new Color(0, 128, 128));
		Label_BigTittle.setText("Make Your Help Request");
		// TablaProfile.setBackground(Color.LIGHT_GRAY);
		// txt_title.setBounds(18, 120, 20, 20);

		Text_Description = new JTextField();
		panel_profil.add(Text_Description);
		Text_Description.setBackground(Color.LIGHT_GRAY);
		Text_Description.setBounds(60, 150, 400, 150);
		// txtdate.setBounds(18, 40, 20, 20);


		Label_Date = new JLabel();
		Label_Date.setLocation(282, 120);
		Label_Date.setSize(50, 30);
		panel_profil.add(Label_Date);
		Label_Date.setText("Date :");
		Label_Date.setBackground(Color.LIGHT_GRAY);

		Label_Description = new JLabel();
		panel_profil.add(Label_Description);
		Label_Description.setText("Description :");
		Label_Description.setBackground(Color.LIGHT_GRAY);
		Label_Description.setBounds(60, 125, 100, 20);

		Title = new JLabel();
		panel_profil.add(Title);
		Title.setText("Title :");
		Title.setBackground(Color.LIGHT_GRAY);
		Title.setBounds(160, 79, 50, 20);
		

		btn_update = new JButton();
		btn_update.setForeground(new Color(0, 128, 128));
		btn_update.setLocation(160, 320);
		btn_update.setSize(200, 40);
		panel_profil.add(btn_update);
		btn_update.setBackground(Color.GRAY);
		btn_update.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
		btn_update.setText("Update Request");
		btn_update.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnupdateActionPerformed(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

		textField_Tittle = new JTextField();
		textField_Tittle.setBounds(210, 76, 150, 30);
		panel_profil.add(textField_Tittle);
		textField_Tittle.setColumns(10);
		
		textField_Date = new JTextField();
		textField_Date.setColumns(10);
		textField_Date.setBounds(330, 122, 130, 26);
		panel_profil.add(textField_Date);
		
		JLabel lbl_ID_Request = new JLabel();
		lbl_ID_Request.setBounds(60, 336, 61, 16);
		panel_profil.add(lbl_ID_Request);
		
		btn_update_Done = new JButton();
		btn_update_Done.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (status_Request.equals("assigned")) {
				HelpRequestController setUPtoDone;
				try {
					setUPtoDone = new HelpRequestController();
					setUPtoDone.MarkRequestAsDone(id_Request);
					JOptionPane.showMessageDialog(MyRequests.this, "Request Done", "Updated succesfully", JOptionPane.OK_OPTION);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else if (status_Request.equals("done")) {
					JOptionPane.showMessageDialog(MyRequests.this, "The request has been done", "Request Done", JOptionPane.OK_OPTION);
				}else {
					JOptionPane.showMessageDialog(MyRequests.this, "The request has not been assigned", "Missing Volunteer", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btn_update_Done.setText("Request Done");
		btn_update_Done.setForeground(new Color(0, 128, 128));
		btn_update_Done.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		btn_update_Done.setBackground(Color.GRAY);
		btn_update_Done.setBounds(160, 375, 200, 40);
		panel_profil.add(btn_update_Done);
		

		// FIN TABLA PERFILES
	}


	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTable1MouseClicked
		// TODO add your handling code here:
		DefaultTableModel tb1Model = (DefaultTableModel) TableRequest.getModel();
		
		String tblID = tb1Model.getValueAt(TableRequest.getSelectedRow(), 0).toString();
		String tbltitle = tb1Model.getValueAt(TableRequest.getSelectedRow(), 1).toString();
		String tbldate = tb1Model.getValueAt(TableRequest.getSelectedRow(), 2).toString();
		String tbldescription = tb1Model.getValueAt(TableRequest.getSelectedRow(), 3).toString();
		String tblStatus = tb1Model.getValueAt(TableRequest.getSelectedRow(), 4).toString();
		

		System.out.println(tblID);
		id_Request = Integer.parseInt(tblID);
		textField_Tittle.setText(tbltitle);
		Text_Description.setText(tbldescription);
		textField_Date.setText(tbldate);
		status_Request = tblStatus;

	}

	private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) throws SQLException, ClassNotFoundException {
		// TODO add your handling code here:
		DefaultTableModel tb1Model = (DefaultTableModel) TableRequest.getModel();

		if (TableRequest.getSelectedRowCount() == 1) {
			String title = textField_Tittle.getText();
			String description = Text_Description.getText();
			HelpRequestController connexion = new HelpRequestController();
			Helprequest hr_uptaded = new Helprequest(id_Request, title, description);
			
			try {
				connexion.UpdateHelpRequest(hr_uptaded);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			JOptionPane.showMessageDialog(this, "Update succesfully");
			textField_Tittle.setText("");
			Text_Description.setText("");
			textField_Date.setText("");
		} else {
			if (TableRequest.getRowCount() == 0) {
				JOptionPane.showMessageDialog(this, "Table is empty", "Missing Data", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "Please select Single Row for update", "Missing Data", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	
	// SHOW ALL REQUEST 
	private void show_table_dataActionPerformed(java.awt.event.ActionEvent evt)
			throws SQLException, ClassNotFoundException {// GEN-FIRST:event_show_table_dataActionPerformed
		// TODO add your handling code here:
		HelpRequestController connexion = new HelpRequestController();
		DefaultTableModel tb1Model = (DefaultTableModel) TableRequest.getModel();
		// Vider la table avant d'exécuter la mise à jour
		tb1Model.setRowCount(0);
		List<Helprequest> helprequestList = connexion.getRequestByUser(userName);

		for (Helprequest hr : helprequestList) {
			String tdData[] = {String.valueOf(hr.getID()), hr.getTitle(), hr.getStringDate(),  hr.getDescription(),  hr.getStatus(), hr.getVolunteer() };
			tb1Model.addRow(tdData);
		}
	}
}