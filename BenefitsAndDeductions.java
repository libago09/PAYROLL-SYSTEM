/**
 * An object that sets the employee`s benefits and deductions to the database. 
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class BenefitsAndDeductions {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private Connection con;
	private String deductionsid;
	private String employeeId;
	private String deductionsamount;
	/**
	 * Create the application.
	 */
	public BenefitsAndDeductions(String id) {
		this.employeeId=id;
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
			}catch(Exception e) {
				
			}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 305, 385);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 289, 346);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 269, 323);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BENEFITS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 192, 26);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 58, 72, 20);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(140, 60, 109, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAmount.setBounds(20, 96, 72, 20);
		panel_1.add(lblAmount);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 98, 109, 20);
		panel_1.add(textField_1);
		
		JLabel lblDeductions = new JLabel("DEDUCTIONS");
		lblDeductions.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblDeductions.setBounds(10, 148, 192, 26);
		panel_1.add(lblDeductions);
		
		JLabel label_1 = new JLabel("Amount");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_1.setBounds(20, 196, 72, 20);
		panel_1.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 198, 109, 20);
		panel_1.add(textField_3);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDeductions();
				setBenefits();
				JOptionPane.showMessageDialog(frame, "ADDED");
				frame.dispose();
			}
		});
		btnNewButton.setBounds(10, 264, 249, 51);
		panel_1.add(btnNewButton);
		frame.setVisible(true);
	}
	/**
	 * Set the deductions of the employee in the database
	 * @return void
	 */
	private void setDeductions() {
		PreparedStatement ps;
		Statement s;
		this.deductionsamount=this.textField_3.getText();
		try {
			ps = con.prepareStatement("insert into deductions (amount) values(?);");
			ps.setString(1,this.textField_3.getText());
			ps.executeUpdate();
			
			s=con.createStatement();
			ResultSet rrs= s.executeQuery("SELECT LAST_INSERT_ID();");
			rrs.next();
			deductionsid=rrs.getString("LAST_INSERT_ID()");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/**
	 * Set the benefits of the employee in the database
	 * @return void
	 */
	private void setBenefits() {
		PreparedStatement ps;
		Statement s;
		try {
			Statement saa=con.createStatement();
			ResultSet rss=saa.executeQuery("select curdate();");
			rss.next();
			
			ps = con.prepareStatement("insert into benefits (type,amount,date,Employee_idEmployee,deductions_iddeductions) values(?,?,?,?,?);");
			ps.setString(1,this.textField.getText());
			ps.setString(2,this.textField_1.getText());
			ps.setString(3, rss.getString("curdate()"));
			ps.setString(4,this.employeeId);
			ps.setString(5, this.deductionsid);
			ps.executeUpdate();
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
