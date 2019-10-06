/**
 * A object that creates a frame that has a button of choices for the head
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

public class HeadDesign{

	private JFrame frame;

	/**
	 * Receives a string and Creates the frame and sets the connection to the database
	 */
	public HeadDesign() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * This method creates an Object searchId whenever a button is clicked (except the addemployee button and exit)
	 */
	private void initialize() {
		frame = new JFrame("OPTIONS");
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 300, 473);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 151, 274, 282);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNewButton = new JButton("CALCULATE SALARY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmployeeDesign  calculatesalary = new SearchEmployeeDesign("CALCULATE SALARY");
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("APPROVE LEAVE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmployeeDesign approvedeb = new SearchEmployeeDesign("APPROVE LEAVE");
			}
		});
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("DELETE EMPLOYEE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmployeeDesign deb = new SearchEmployeeDesign("DELETE EMPLOYEE");
			}
		});
		btnNewButton_4.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_1 = new JButton("ADD EMPLOYEE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployeeButton aeb = new AddEmployeeButton();
			}
		});
		
		JButton btnAddBenefitsAnd = new JButton("ADD BENEFITS AND DEDUCTIONS");
		btnAddBenefitsAnd.setBackground(Color.LIGHT_GRAY);
		btnAddBenefitsAnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchEmployeeDesign ss = new SearchEmployeeDesign("ADD BENEFITS AND DEDUCTIONS");
			}
		});
		panel.add(btnAddBenefitsAnd);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("EXIT!");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		panel.add(btnNewButton_3);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to do?");
		lblWhatWouldYou.setBounds(48, 89, 200, 51);
		lblWhatWouldYou.setFont(new Font("Nirmala UI", Font.BOLD, 15));
		frame.getContentPane().add(lblWhatWouldYou);
		
		JLabel lblHelloNameSa = new JLabel("HELLO! ADMIN!");
		lblHelloNameSa.setBounds(59, 11, 179, 92);
		lblHelloNameSa.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 24));
		frame.getContentPane().add(lblHelloNameSa);
		frame.setVisible(true);
	}
	

	
}
