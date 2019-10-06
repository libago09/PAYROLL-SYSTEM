/*
 * Receives String Id on creation and deletes the owner of the id in the database 
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class DeleteSearchID {

	private JFrame frame;
	private JTextField textFieldFIRSTNAME;
	private JTextField textFieldMIDDLENAME;
	private JTextField textFieldLASTNAME;
	private JTextField textFieldEMPLOYEEID;
	private JTextField textFieldJOBTITLE;
	private String id;
	private Statement st;
	private Connection con;


	/**
	 * Create the application.
	 */
	public DeleteSearchID(String Id) {
		this.id=Id;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Deletes the id that was passed through the constructor inside the database
	 */
	private void initialize() {
		
		
		frame = new JFrame("Confirm Delete Employee");
		frame.setBounds(100, 100, 363, 363);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 347, 324);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 261, 327, 49);
		panel.add(btnNewButton);
		
		JButton btnDeleteThisEmployee = new JButton("DELETE THIS EMPLOYEE");
		btnDeleteThisEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement stmt=null;
				try {
				
					stmt=con.prepareStatement("delete from employee where idEmployee=?"); 
					stmt.setString(1,id);
					stmt.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "DELETED EMPLOYEE");
				frame.dispose();
			}
		});
		btnDeleteThisEmployee.setBounds(10, 201, 327, 49);
		panel.add(btnDeleteThisEmployee);
		
		JLabel lblFirstName = new JLabel("FIRST NAME:");
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFirstName.setBounds(10, 11, 117, 19);
		panel.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("MIDDLE NAME:");
		lblMiddleName.setForeground(Color.BLACK);
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMiddleName.setBounds(10, 43, 117, 19);
		panel.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("LAST NAME:");
		lblLastName.setForeground(Color.BLACK);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLastName.setBounds(10, 73, 117, 19);
		panel.add(lblLastName);
		
		JLabel lblJobTitle = new JLabel("JOB TITLE:");
		lblJobTitle.setForeground(Color.BLACK);
		lblJobTitle.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJobTitle.setBounds(10, 133, 117, 19);
		panel.add(lblJobTitle);
		
		JLabel lblEmployeeId = new JLabel("EMPLOYEE ID:");
		lblEmployeeId.setForeground(Color.BLACK);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeId.setBounds(10, 103, 117, 19);
		panel.add(lblEmployeeId);
		
		textFieldFIRSTNAME = new JTextField();
		textFieldFIRSTNAME.setEditable(false);
		textFieldFIRSTNAME.setBounds(188, 10, 149, 20);
		panel.add(textFieldFIRSTNAME);
		textFieldFIRSTNAME.setColumns(10);
		
		textFieldMIDDLENAME = new JTextField();
		textFieldMIDDLENAME.setEditable(false);
		textFieldMIDDLENAME.setColumns(10);
		textFieldMIDDLENAME.setBounds(188, 42, 149, 20);
		panel.add(textFieldMIDDLENAME);
		
		textFieldLASTNAME = new JTextField();
		textFieldLASTNAME.setEditable(false);
		textFieldLASTNAME.setColumns(10);
		textFieldLASTNAME.setBounds(188, 72, 149, 20);
		panel.add(textFieldLASTNAME);
		
		textFieldEMPLOYEEID = new JTextField();
		textFieldEMPLOYEEID.setEditable(false);
		textFieldEMPLOYEEID.setColumns(10);
		textFieldEMPLOYEEID.setBounds(188, 102, 149, 20);
		panel.add(textFieldEMPLOYEEID);
		
		textFieldJOBTITLE = new JTextField();
		textFieldJOBTITLE.setEditable(false);
		textFieldJOBTITLE.setColumns(10);
		textFieldJOBTITLE.setBounds(188, 132, 149, 20);
		panel.add(textFieldJOBTITLE);
		
		try {
			String x ="Select * from employee where idEmployee="+id;
			Statement st = con.createStatement();
			ResultSet rs =st.executeQuery(x);
			while(rs.next()) {
			textFieldFIRSTNAME.setText(rs.getString("firstname"));
			textFieldMIDDLENAME.setText(rs.getString("midinit"));
			textFieldLASTNAME.setText(rs.getString("lastname"));
			textFieldEMPLOYEEID.setText(id);
			textFieldJOBTITLE.setText(rs.getString("jobtitle"));
			}
			}
		catch(SQLException e){
			
		}
		
		
		frame.setVisible(true);
	}

}
