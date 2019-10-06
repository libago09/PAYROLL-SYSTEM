/**
 * An object that creates a frame that searches the employee id
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class SearchEmployeeDesign {
	
	private Connection con;
	private JFrame frame;
	private JTextField textField;
	private Statement st;
	public String nameOfTheButton;
	/**
	 * Create the application. Receives a string name of the button.
	 */
	public SearchEmployeeDesign(String name) {
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
			st = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.nameOfTheButton=name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * If the button ok is clicked it will search the id in the textfield from the database if it exist
	 *  and if the id exist, It checks the name of the button that was passed to constructor and
	 * Creates an object according to the button that was clicked 
	 */
	private void initialize() {
		
		frame = new JFrame(nameOfTheButton);
		frame.setBounds(100, 100, 360, 210);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 344, 171);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 116, 190, 26);
		panel.add(lblNewLabel_1);
		frame.setVisible(true);
		
		JButton btnNewButton = new JButton("Search ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean find=false;
		        String user="SELECT idEmployee from employee";
		    	ResultSet rs = null;
		    	
				try {
					rs  = st.executeQuery(user);
					while(rs.next()) {
						if(textField.getText().equals(Integer.toString(rs.getInt("idEmployee")))) {
							find=true;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		     
				String passId=textField.getText();
				
			if(find==true) {	
				if(nameOfTheButton.equals("DELETE EMPLOYEE")) {
				DeleteSearchID dsid = new DeleteSearchID(passId);
				}
				else if(nameOfTheButton.equals("APPROVE LEAVE")) {
				ApproveLeaveButton alb = new ApproveLeaveButton(passId);
				}
				else if(nameOfTheButton.equals("CALCULATE SALARY")) {
					CalculateSalaryButton cs = new CalculateSalaryButton(passId);
				}
				else if(nameOfTheButton.equals("ADD BENEFITS AND DEDUCTIONS")) {
					BenefitsAndDeductions bad = new BenefitsAndDeductions(passId);
				}
						
			}
			else {
				
				lblNewLabel_1.setText("Id not found!");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			}
			}
		});
		btnNewButton.setBounds(204, 116, 130, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter Employee ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 160, 26);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(10, 47, 324, 57);
		panel.add(textField);
		textField.setColumns(10);
		
		

	}

}
