/**
 * A class that creates a new frame that allows the manage to set the leave of an employee
 * 
 * 
 */


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JTextPane;
import java.sql.*;
public class ApproveLeaveButton {

	private JFrame frame;
	private JTextField txtDdmmyySTARTDATE;
	private JTextField txtDdmmyyENDDATE;
	private JTextField textFieldNUMBEROFDAYS;
	private String id;
	private Connection con;

	
	/**
	 * Create the application.
	 */
	public ApproveLeaveButton(String id) {
		try {
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
		}catch(Exception e) {
			
		}
		this.id=id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Set Leave of an Employee");
		frame.setBounds(100, 100, 461, 289);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 445, 250);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 445, 250);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblSetStartDate = new JLabel("Set Start Date");
		lblSetStartDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSetStartDate.setBounds(10, 44, 123, 19);
		panel_1.add(lblSetStartDate);
		
		txtDdmmyySTARTDATE = new JTextField();
		txtDdmmyySTARTDATE.setText("dd/mm/yy");
		txtDdmmyySTARTDATE.setColumns(10);
		txtDdmmyySTARTDATE.setBounds(169, 46, 170, 20);
		panel_1.add(txtDdmmyySTARTDATE);
		
		txtDdmmyyENDDATE = new JTextField();
		txtDdmmyyENDDATE.setText("dd/mm/yy");
		txtDdmmyyENDDATE.setColumns(10);
		txtDdmmyyENDDATE.setBounds(169, 77, 170, 20);
		panel_1.add(txtDdmmyyENDDATE);
		
		JLabel lblSetEndDate = new JLabel("Set End Date");
		lblSetEndDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSetEndDate.setBounds(10, 74, 123, 19);
		panel_1.add(lblSetEndDate);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days");
		lblNumberOfDays.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumberOfDays.setBounds(10, 104, 123, 19);
		panel_1.add(lblNumberOfDays);
		
		textFieldNUMBEROFDAYS = new JTextField();
		textFieldNUMBEROFDAYS.setColumns(10);
		textFieldNUMBEROFDAYS.setBounds(169, 106, 170, 20);
		panel_1.add(textFieldNUMBEROFDAYS);
		
		JTextPane txtpnAsdqweasdqweqw = new JTextPane();
		txtpnAsdqweasdqweqw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnAsdqweasdqweqw.setText("EMPLOYEE ID:");
		txtpnAsdqweasdqweqw.setBounds(10, 164, 123, 26);
		panel_1.add(txtpnAsdqweasdqweqw);
		
		JTextPane txtpnAmbot = new JTextPane();
		txtpnAmbot.setText(this.id);
		txtpnAmbot.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnAmbot.setBounds(169, 164, 170, 26);
		panel_1.add(txtpnAmbot);
		
		JLabel lblNewLabel = new JLabel("DAY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(179, 21, 29, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnSETLEAVE = new JButton("SET LEAVE");
		btnSETLEAVE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PreparedStatement ps=null;
				try {
					ps= con.prepareStatement("insert into leaves (startdate,enddate,numofdays,Employee_idEmployee) values (?,?,?,?);");
					ps.setString(1,txtDdmmyySTARTDATE.getText());
					ps.setString(2,txtDdmmyyENDDATE.getText());
					ps.setString(3,textFieldNUMBEROFDAYS.getText());
					ps.setInt(4,Integer.parseInt(id));
					ps.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frame, "Added!");
				
			}
		});
		btnSETLEAVE.setBounds(169, 201, 170, 35);
		panel_1.add(btnSETLEAVE);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBounds(10, 201, 123, 35);
		panel_1.add(btnCancel);
		
		JLabel lblMonth = new JLabel("MONTH");
		lblMonth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMonth.setBounds(234, 21, 40, 14);
		panel_1.add(lblMonth);
		
		JLabel lblYear = new JLabel("YEAR");
		lblYear.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblYear.setBounds(299, 21, 29, 14);
		panel_1.add(lblYear);
		
		JLabel lblNewLabel_1 = new JLabel("\"\"");
		lblNewLabel_1.setBounds(359, 49, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel label = new JLabel("\"\"");
		label.setBounds(359, 80, 46, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("\"\"");
		label_1.setBounds(359, 109, 46, 14);
		panel_1.add(label_1);
		this.frame.setVisible(true);
	}
}
