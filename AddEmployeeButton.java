/**
 * An object that creates a frame that can add an employee to the database;
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AddEmployeeButton {

	private JFrame frame;
	private JTextField textFieldFIRSTNAME;
	private JTextField textFieldMIDDLENAME;
	private JTextField textFieldLASTNAME;
	private JTextField textFieldCITY;
	private JTextField textFieldSTREET;
	private JTextField textFieldREGION;
	private JTextField textFieldDEPARTMENTNUM;
	private JTextField textFieldBASICSALARY;
	private JTextField textFieldJOBTITLE;
	private JLabel lblJobTitle;
	private JLabel lblEmployeePassword;
	private JLabel lblNewLabel_1;
	private JButton btnCancel;
	private JTextField textFieldsex;
	private JTextField textFieldBIRTHDATE;
	private JTextField textFieldLEAVECOUNT;
	private JTextField textField_password;
	private Statement st;
	private Connection con;

	/**
	 * Create the application.
	 */
	public AddEmployeeButton() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return void
	 * this method adds the inputted details of the employee to the database;
	 */
	
	private void initialize() {
		frame = new JFrame("ADD EMPLOYEE");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 800, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 414, 449);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 117, 19);
		panel.add(lblNewLabel);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME");
		lblMiddleName.setForeground(new Color(0, 0, 0));
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMiddleName.setBounds(10, 42, 117, 19);
		panel.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setForeground(new Color(0, 0, 0));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLastName.setBounds(10, 73, 117, 19);
		panel.add(lblLastName);
		
		textFieldFIRSTNAME = new JTextField();
		textFieldFIRSTNAME.setBounds(156, 10, 248, 20);
		panel.add(textFieldFIRSTNAME);
		textFieldFIRSTNAME.setColumns(10);
		
		textFieldMIDDLENAME = new JTextField();
		textFieldMIDDLENAME.setColumns(10);
		textFieldMIDDLENAME.setBounds(156, 41, 248, 20);
		panel.add(textFieldMIDDLENAME);
		
		textFieldLASTNAME = new JTextField();
		textFieldLASTNAME.setColumns(10);
		textFieldLASTNAME.setBounds(156, 72, 248, 20);
		panel.add(textFieldLASTNAME);
		
		JLabel lblRegion = new JLabel("REGION");
		lblRegion.setForeground(new Color(0, 0, 0));
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRegion.setBounds(10, 195, 117, 19);
		panel.add(lblRegion);
		
		JLabel lblCity = new JLabel("CITY");
		lblCity.setForeground(new Color(0, 0, 0));
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCity.setBounds(10, 165, 117, 19);
		panel.add(lblCity);
		
		JLabel lblStreet = new JLabel("STREET");
		lblStreet.setForeground(new Color(0, 0, 0));
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStreet.setBounds(10, 135, 117, 19);
		panel.add(lblStreet);
		
		textFieldSTREET = new JTextField();
		textFieldSTREET.setColumns(10);
		textFieldSTREET.setBounds(156, 134, 248, 20);
		panel.add(textFieldSTREET);
		
		textFieldCITY = new JTextField();
		textFieldCITY.setColumns(10);
		textFieldCITY.setBounds(156, 165, 248, 20);
		panel.add(textFieldCITY);
		
		textFieldREGION = new JTextField();
		textFieldREGION.setColumns(10);
		textFieldREGION.setBounds(156, 196, 248, 20);
		panel.add(textFieldREGION);
		
		textFieldDEPARTMENTNUM = new JTextField();
		textFieldDEPARTMENTNUM.setColumns(10);
		textFieldDEPARTMENTNUM.setBounds(156, 254, 248, 20);
		panel.add(textFieldDEPARTMENTNUM);
		
		JLabel lblEmail = new JLabel("DEPARTMENT NUMBER");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmail.setBounds(10, 255, 141, 19);
		panel.add(lblEmail);
		
		textFieldJOBTITLE = new JTextField();
		textFieldJOBTITLE.setColumns(10);
		textFieldJOBTITLE.setBounds(156, 376, 248, 20);
		panel.add(textFieldJOBTITLE);
		
		lblJobTitle = new JLabel("JOB TITLE");
		lblJobTitle.setForeground(new Color(0, 0, 0));
		lblJobTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJobTitle.setBounds(10, 376, 117, 19);
		panel.add(lblJobTitle);
		
		JLabel lblSex = new JLabel("SEX");
		lblSex.setForeground(Color.BLACK);
		lblSex.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSex.setBounds(10, 103, 117, 19);
		panel.add(lblSex);
		
		textFieldsex = new JTextField();
		textFieldsex.setColumns(10);
		textFieldsex.setBounds(156, 103, 248, 20);
		panel.add(textFieldsex);
		
		JLabel lblBirthdate = new JLabel("BIRTHDATE");
		lblBirthdate.setForeground(Color.BLACK);
		lblBirthdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBirthdate.setBounds(10, 225, 117, 19);
		panel.add(lblBirthdate);
		
		textFieldBIRTHDATE = new JTextField();
		textFieldBIRTHDATE.setColumns(10);
		textFieldBIRTHDATE.setBounds(156, 227, 248, 20);
		panel.add(textFieldBIRTHDATE);
		
		JLabel lblLeaveCount = new JLabel("LEAVE COUNT");
		lblLeaveCount.setForeground(Color.BLACK);
		lblLeaveCount.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLeaveCount.setBounds(10, 346, 117, 19);
		panel.add(lblLeaveCount);
		
		textFieldLEAVECOUNT = new JTextField();
		textFieldLEAVECOUNT.setColumns(10);
		textFieldLEAVECOUNT.setBounds(156, 345, 248, 20);
		panel.add(textFieldLEAVECOUNT);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setLayout(null);
		panel_2.setBounds(434, 11, 350, 141);
		frame.getContentPane().add(panel_2);
		
		JLabel lblBasicSalary = new JLabel("SALARY ID");
		lblBasicSalary.setForeground(new Color(0, 0, 0));
		lblBasicSalary.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBasicSalary.setBounds(10, 11, 117, 19);
		panel_2.add(lblBasicSalary);
		
		textFieldBASICSALARY = new JTextField();
		textFieldBASICSALARY.setColumns(10);
		textFieldBASICSALARY.setBounds(156, 10, 184, 20);
		panel_2.add(textFieldBASICSALARY);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID");
		lblEmployeeId.setForeground(new Color(0, 0, 0));
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmployeeId.setBounds(10, 72, 117, 19);
		panel_2.add(lblEmployeeId);
		
		lblEmployeePassword = new JLabel("EMPLOYEE PASSWORD");
		lblEmployeePassword.setForeground(new Color(0, 0, 0));
		lblEmployeePassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmployeePassword.setBounds(10, 102, 163, 19);
		panel_2.add(lblEmployeePassword);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(253, 73, 87, 17);
		panel_2.add(lblNewLabel_1);
		
		textField_password = new JTextField();
		textField_password.setColumns(10);
		textField_password.setBounds(245, 104, 95, 20);
		panel_2.add(textField_password);
		
		JButton btnNewButton = new JButton("ADD EMPLOYEE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement stmt=null;
				try {
					
					stmt=con.prepareStatement("insert into employee (firstname,midinit,lastname,sex,street,city,region,birthdate,jobtitle,leavecount,employeepassword,department_idDepartment,salary_idsalary1) values(?,?,?,?,?,?,?,?,?,?,?,?,?);"); 
					stmt.setString(1,textFieldFIRSTNAME.getText());
					stmt.setString(2,textFieldMIDDLENAME.getText());
					stmt.setString(3,textFieldLASTNAME.getText());
					stmt.setString(4,textFieldsex.getText());
					stmt.setString(5,textFieldSTREET.getText());
					stmt.setString(6,textFieldCITY.getText());
					stmt.setString(7,textFieldREGION.getText());
					stmt.setString(8,textFieldBIRTHDATE.getText());
					stmt.setString(9,textFieldJOBTITLE.getText());
					stmt.setInt(10,Integer.parseInt(textFieldLEAVECOUNT.getText()));
					stmt.setString(11,textField_password.getText());
					stmt.setInt(12,Integer.parseInt(textFieldDEPARTMENTNUM.getText()));
					stmt.setString(13, textFieldBASICSALARY.getText());
					stmt.executeUpdate();
					
					st= con.createStatement();
					ResultSet rs=st.executeQuery("SELECT LAST_INSERT_ID();");
					rs.next();
					lblNewLabel_1.setText(rs.getString("LAST_INSERT_ID()"));

				}catch(SQLException es){

					es.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(frame, "Added!");
			}
		});
		btnNewButton.setBounds(434, 173, 350, 135);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancel.setBounds(434, 333, 350, 127);
		frame.getContentPane().add(btnCancel);
		btnCancel.setForeground(Color.DARK_GRAY);
		btnCancel.setBackground(Color.LIGHT_GRAY);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.setVisible(true);
	}
}
