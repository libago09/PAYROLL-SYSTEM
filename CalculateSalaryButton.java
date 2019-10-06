/**
 * An object that creates a frame and calculates the salary of the employee
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.awt.event.ActionEvent;

public class CalculateSalaryButton {

	private JFrame frame;
	private String id;
	private String salary;
	private Connection con;
	private JLabel lblName;
	private JLabel lblNewLabel;
	private JLabel labeldeductions;
	private JLabel lblGetpayment;
	private JLabel labeltax;
	private long overallmins;
	private JLabel label_1;
	private JLabel label_netpay;

	/**
	 * Receives a string and Creates the frame and sets the connection to the database
	 */
	public CalculateSalaryButton(String id) {
		this.overallmins=0;
		try {
			this.con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id=id;
		initialize();
		setInfo();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Salary");
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 594, 471);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(10, 119, 278, 170);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPAYMENTS = new JLabel("PAYMENTS");
		lblPAYMENTS.setFont(new Font("Verdana", Font.BOLD, 20));
		lblPAYMENTS.setBounds(10, 11, 257, 45);
		panel_1.add(lblPAYMENTS);
		
		JLabel lblBasicSalary = new JLabel("BASIC SALARY:");
		lblBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBasicSalary.setBounds(20, 55, 109, 14);
		panel_1.add(lblBasicSalary);
		
		lblNewLabel = new JLabel("GETSALARY");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(181, 55, 86, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblTotal = new JLabel("TOTAL PAY:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(20, 139, 109, 14);
		panel_1.add(lblTotal);
		
		label_1 = new JLabel("GETSALARY");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(123, 140, 145, 14);
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(297, 119, 287, 170);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDeductions = new JLabel("DEDUCTIONS");
		lblDeductions.setFont(new Font("Verdana", Font.BOLD, 20));
		lblDeductions.setBounds(10, 11, 257, 45);
		panel_2.add(lblDeductions);
		
		JLabel lblTotalDeductions = new JLabel("TOTAL DEDUCTIONS:");
		lblTotalDeductions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotalDeductions.setBounds(10, 142, 135, 14);
		panel_2.add(lblTotalDeductions);
		
		labeldeductions= new JLabel("CALSSS");
		labeldeductions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labeldeductions.setBounds(181, 142, 86, 14);
		panel_2.add(labeldeductions);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 11, 574, 100);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lblName = new JLabel("NAME:");
		lblName.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblName.setBounds(10, 11, 290, 30);
		panel_3.add(lblName);
		
		JLabel lblEmployeeId = new JLabel("Employee id: "+this.id);
		lblEmployeeId.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblEmployeeId.setBounds(10, 59, 186, 30);
		panel_3.add(lblEmployeeId);
		
		LocalDate localTime = LocalDate.now();
		JLabel lblDate = new JLabel("DATE: "+localTime.getMonth()+"/"+localTime.getDayOfMonth()+"/"+localTime.getYear());
		lblDate.setFont(new Font("Yu Gothic Light", Font.BOLD, 18));
		lblDate.setBounds(323, 1, 241, 50);
		panel_3.add(lblDate);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 300, 278, 160);
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblBALANCE = new JLabel("BALANCE");
		lblBALANCE.setFont(new Font("Verdana", Font.BOLD, 20));
		lblBALANCE.setBounds(10, 11, 257, 45);
		panel_4.add(lblBALANCE);
		
		JLabel lblNetPay = new JLabel("NET PAY:");
		lblNetPay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNetPay.setBounds(10, 135, 109, 14);
		panel_4.add(lblNetPay);
		
		JLabel lblPaymentsdeductions = new JLabel("PAYMENTS-DEDUCTIONS:");
		lblPaymentsdeductions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPaymentsdeductions.setBounds(10, 67, 147, 25);
		panel_4.add(lblPaymentsdeductions);
		
		JLabel lblTax = new JLabel("TAX:");
		lblTax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTax.setBounds(10, 103, 109, 14);
		panel_4.add(lblTax);
		
		lblGetpayment = new JLabel("getpayment");
		lblGetpayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGetpayment.setBounds(167, 73, 111, 14);
		panel_4.add(lblGetpayment);
		
		labeltax= new JLabel("getpayment");
		labeltax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		labeltax.setBounds(167, 105, 111, 14);
		panel_4.add(labeltax);
		
		label_netpay = new JLabel("getpayment");
		label_netpay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_netpay.setBounds(167, 137, 111, 14);
		panel_4.add(label_netpay);
		
		JButton btnBalance = new JButton("Calculate Balance");
		btnBalance.setBackground(Color.WHITE);
		btnBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double calculatedsalary=Double.parseDouble(label_1.getText());
				double deductions=Double.parseDouble(labeldeductions.getText());
				double salary_deductions=calculatedsalary-deductions;
				lblGetpayment.setText(""+salary_deductions);
				double finaltax=salary_deductions*0.0119; //monthly per employee https://shieldgeo.com/payroll-and-tax-in-the-philippines/ ko nag base
				labeltax.setText(""+finaltax);
				double finalsalary= Double.parseDouble(lblGetpayment.getText());
				double finalnetpay=finalsalary-finaltax;
				label_netpay.setText(""+finalnetpay);
			}
		});
		btnBalance.setBounds(297, 385, 287, 75);
		panel.add(btnBalance);
		
		JButton btnPayments = new JButton("Calculate Payment And Deductions");
		btnPayments.setBackground(Color.WHITE);
		btnPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getTotalPay();
				setDeduction();
			}
		});
		btnPayments.setBounds(297, 300, 287, 75);
		panel.add(btnPayments);
		frame.setVisible(true);
	}
	/**
	 * Sets the personal info of the employee to the frame and the salary
	 * @return void
	 */
	private void setInfo() {
		try {
			Statement stmts = con.createStatement();
			ResultSet rs=stmts.executeQuery("select * from employee where idEmployee="+id+";");
			
			rs.next();
			lblName.setText("Name: "+rs.getString("firstname")+" "+rs.getString("midinit")+" "+rs.getString("lastname"));
			String salaryid=rs.getString("salary_idsalary1");
			
			rs=stmts.executeQuery("select amount from salary where idsalary="+salaryid+";");
			rs.next();
			this.salary=rs.getString("amount");
			this.lblNewLabel.setText(this.salary);
		}catch(Exception e){
			
		}
	}
	/**
	 * Calculates the overall working hours of an employee and display in the frame
	 * @return void
	 */
	private void getTotalPay() {
		try {
			Statement stmts1 = con.createStatement();
			ResultSet rw1=stmts1.executeQuery("select time_in, time_out from attendance where Employee_idEmployee="+id+" and Month(date) = Month(CURRENT_DATE()) and Year(date) = Year(CURRENT_DATE());");
			while(rw1.next()) {
				String time1=rw1.getString("time_in");
				String time2=rw1.getString("time_out");
				
				DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
				LocalTime date1 = LocalTime.parse(time1);
				LocalTime date2 = LocalTime.parse(time2);
				long minutes = ChronoUnit.MINUTES.between(date1, date2);
				
				this.overallmins=this.overallmins+minutes;
			}
			double sal = Double.parseDouble(this.salary);
			double getminutewage=sal/12000.0; //200hours=12000mins
			double total= getminutewage*(double)overallmins;
			label_1.setText(" "+total);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Sets the deductions of an employee and  display in the frame
	 * @return void
	 */
	private void setDeduction() {
		try {
			Statement stmts = con.createStatement();
			ResultSet rs=stmts.executeQuery("select deductions_iddeductions from benefits where Employee_idEmployee="+id+" and Month(date) = Month(CURRENT_DATE()) and Year(date) = Year(CURRENT_DATE());");
			int overalldeductions=0;
			while(rs.next()) {
			String deductid=rs.getString("deductions_idDeductions");
			
			Statement stmts1 = con.createStatement();
			ResultSet rs1=stmts1.executeQuery("select amount from deductions where iddeductions="+deductid+";");
			rs1.next();
			overalldeductions=overalldeductions+Integer.parseInt(rs1.getString("amount"));
			}
			labeldeductions.setText(""+overalldeductions);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
