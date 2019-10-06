/** NAME: Jan Grace Llenarres 
 * 		  Tomas Jubile T. Libag
 * SECTION: BSIT - 2 CCD
 * PAYROLL SYSTEM
**/
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
public class MainFinal implements ActionListener{

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				try {
					MainFinal window = new MainFinal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	/**
	 * Create the application.
	 */
	public MainFinal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("LOG IN");
		frame.setResizable(false);
		frame.setBounds(100, 100, 269, 265);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 82, 200, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Log-in");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(25, 177, 200, 37);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setBounds(25, 57, 56, 26);
		frame.getContentPane().add(lblUserId);
		
		JLabel label = new JLabel("Password");
		label.setBounds(25, 119, 71, 23);
		frame.getContentPane().add(label);
		
		lblNewLabel = new JLabel("PLEASE LOG-IN YOUR ACCOUNT");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		lblNewLabel.setBounds(25, 11, 200, 46);
		frame.getContentPane().add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(25, 139, 200, 26);
		frame.getContentPane().add(passwordField);
	}
	

/**
 * This method authenticates the user`s password and id from the database
 * @param ActionEvent e
 */
	
	public void actionPerformed(ActionEvent e) {
		boolean find=false;
		 if(textField.getText().equals("Admin")&&passwordField.getText().equals("Admin")) {
	    		HeadDesign hd = new HeadDesign();
	    		frame.dispose();
	    		find=true;
	    		}
		 else {
				Connection con;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
			        String user="SELECT * from employee where idEmployee="+textField.getText()+";";
			    	Statement st = con.createStatement();
			        ResultSet rs = st.executeQuery(user);
			       
			        while(rs.next()){
			        	String passwordchecker=rs.getString("employeepassword");
			        	String passwordinput=passwordField.getText();
				       if(passwordchecker.equals(passwordinput)==true){
				    		EmployeeDesign ed1 = new EmployeeDesign(textField.getText());
				    		find=true;
				    		frame.dispose();
				    		}
				       
			        }
				} catch (SQLException e1) {
					
				}

		 }
		 if(find==false) {
	    			JOptionPane.showMessageDialog(frame, "Wrong password or wrong id");
		 }
		
	}
	
}
