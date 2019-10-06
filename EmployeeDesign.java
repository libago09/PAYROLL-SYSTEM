/**
 * This class creates a new frame that will show the daily time record and some of the personal information of the employee it also displays the current time and date in frame
 * 
 */
import java.awt.EventQueue;
import java.time.LocalTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class EmployeeDesign {

	private JFrame frame;
	private JLabel lblDateToday;
	private JLabel lblTime;
	private String id;
	private Connection con;
	private String dateToday;
	private String timeToday;
	private JTable table;


	/**
	 * Receives a string and Creates the frame and sets the connection to the database
	 */
	public EmployeeDesign(String id) {
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1432");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id=id;
		initialize();
		setTableforEmployee();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("EMPLOYEE");
		frame.setBounds(100, 100, 701, 501);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 685, 462);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(500, 11, 175, 439);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		

		
		JLabel lblHelloTjLibago = new JLabel("Hello! "+this.setNamehello());
		lblHelloTjLibago.setBackground(Color.WHITE);
		lblHelloTjLibago.setForeground(Color.BLACK);
		lblHelloTjLibago.setFont(new Font("Arial", Font.BOLD, 16));
		lblHelloTjLibago.setBounds(10, 0, 155, 110);
		panel_1.add(lblHelloTjLibago);
		
		JButton btnTimeInout = new JButton("TIME IN");
		btnTimeInout.setBackground(Color.WHITE);
		btnTimeInout.setForeground(Color.BLUE);
		btnTimeInout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				timeinMethod();
				setTableforEmployee();
			}
		});
		btnTimeInout.setBounds(10, 121, 155, 137);
		panel_1.add(btnTimeInout);
		
		JButton btnTimeOut = new JButton("TIME OUT");
		btnTimeOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					
					timeoutMethod();
					setTableforEmployee();
			}
		});
		btnTimeOut.setForeground(Color.BLUE);
		btnTimeOut.setBackground(Color.WHITE);
		btnTimeOut.setBounds(10, 279, 155, 149);
		panel_1.add(btnTimeOut);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 480, 109);
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setForeground(Color.WHITE);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblTime = new JLabel();
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTime.setBounds(254, 11, 216, 87);
		panel_2.add(lblTime);
		
		lblDateToday = new JLabel();
		lblDateToday.setBounds(10, 11, 216, 87);
		panel_2.add(lblDateToday);
		lblDateToday.setFont(new Font("Tahoma", Font.BOLD, 15));
	

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 480, 320);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Time in", "Time out", "Date"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollPane.setViewportView(table);
		frame.setVisible(true);
	}
	
/**
 * This method gets the Name of the user from the database and sets the label
 * @return a String name which is the users name
 */
	private String setNamehello() {
		Statement st;
		String helloname="";
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery("select * from employee where idEmployee="+this.id);
			rs.next();
			
			helloname=rs.getString("firstname")+" "+rs.getString("lastname");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return helloname;
	}
	/**
	 * This method inserts the time in date of the employee
	 * @return void
	 */
	private void timeinMethod() {
		try {
			PreparedStatement ps = con.prepareStatement("insert into attendance(time_in,Employee_idEmployee,date) values (?,?,?)");
			ps.setString(1, timeToday);
			ps.setString(2, this.id);
			ps.setString(3, dateToday);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(frame, "TIMED IN");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * This method inserts the time out date of the employee
	 * @return void
	 */	
	private void timeoutMethod() {
		try {
			PreparedStatement pspsps =con.prepareStatement("update attendance set time_out=? where Employee_idEmployee=? and time_out is null;");
			pspsps.setString(1, timeToday);
			pspsps.setString(2, id);
			pspsps.executeUpdate();
			JOptionPane.showMessageDialog(frame, "Timed out");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method sets the table of the daily time record and display on the frame
	 * @return void
	 */	
	private void setTableforEmployee() {
		try {
			PreparedStatement prepareds1 = con.prepareStatement("Select date,time_in,time_out from attendance where Employee_idEmployee="+this.id+";");
			ResultSet results1 = prepareds1.executeQuery();
			this.table.setModel(DbUtils.resultSetToTableModel(results1));
		}
		catch(Exception e){
			
		}
	}
	/**
	 * A method that uses a thread to set the exact date and time in the frame
	 * @return void
	 */	
	public void clock() {
		
		Thread clock = new Thread() {
			public void run(){
				while(true) {
					Calendar cal = new GregorianCalendar();
					int day=cal.get(Calendar.DAY_OF_MONTH);
					int month=cal.get(Calendar.MONTH);
					int year=cal.get(Calendar.YEAR);
					
					LocalTime localTime = LocalTime.now();
					
					lblTime.setText("Time: "+localTime.getHour()+":"+localTime.getMinute()+":"+localTime.getSecond());
					lblDateToday.setText("DATE: "+year+"/"+month+"/"+day);
					dateToday=year+"-"+month+"-"+day;
					timeToday=localTime.getHour()+":"+localTime.getMinute();
					
				}
			}
		};
		clock.start();
	}
}
