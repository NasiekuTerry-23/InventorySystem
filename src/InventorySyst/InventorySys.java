package InventorySyst;

import java.awt.EventQueue;
import java.sql.*;
import java.awt.print.*;
//import javafx.print.Printer;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InventorySys {

	private JFrame frame;
	private JTextField txtpname;
	private JTextField txtquantity;
	private JTextField txtdreceived;
	private JTextField txtsupname;
	private JTextField txtsupcontact;
	private JTextField txtpid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventorySys window = new InventorySys();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InventorySys() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pat;
	ResultSet rs;
	
	
	public void Connect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/inventorysystem", "root", "");
		}
		catch(ClassNotFoundException ex){
			
		}
		catch(SQLException ex) {
			
		}
		
	}
	
	public void table_load() {
		
		try {
			pat = con.prepareStatement("select * from inventory");
			rs = pat.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1047, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inventory Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(188, 11, 667, 52);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Product Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(25, 74, 478, 427);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(24, 49, 161, 36);
		panel.add(lblNewLabel_1);
		
		txtpname = new JTextField();
		txtpname.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpname.setBounds(222, 50, 222, 36);
		panel.add(txtpname);
		txtpname.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Quantity");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(24, 117, 161, 36);
		panel.add(lblNewLabel_1_1);
		
		txtquantity = new JTextField();
		txtquantity.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtquantity.setColumns(10);
		txtquantity.setBounds(222, 118, 222, 36);
		panel.add(txtquantity);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date Received");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(24, 191, 171, 36);
		panel.add(lblNewLabel_1_1_1);
		
		txtdreceived = new JTextField();
		txtdreceived.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtdreceived.setColumns(10);
		txtdreceived.setBounds(222, 192, 222, 36);
		panel.add(txtdreceived);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Supplier Name");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(24, 266, 161, 36);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtsupname = new JTextField();
		txtsupname.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtsupname.setColumns(10);
		txtsupname.setBounds(222, 267, 222, 36);
		panel.add(txtsupname);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Supplier Contact");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(24, 341, 196, 36);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		txtsupcontact = new JTextField();
		txtsupcontact.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtsupcontact.setColumns(10);
		txtsupcontact.setBounds(222, 342, 222, 36);
		panel.add(txtsupcontact);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(524, 83, 443, 88);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Product ID");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_2.setBounds(22, 26, 152, 36);
		panel_2.add(lblNewLabel_1_1_2);
		
		txtpid = new JTextField();
		txtpid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try{
					String id = txtpid.getText();
					
					pat = con.prepareStatement("select item,quantity,date,sup_name,sup_contact from inventory where id = ?");
					pat.setString(1, id);
					ResultSet rs = pat.executeQuery();
					
					if(rs.next()==true) {
						
					String item = rs.getString(1);
					String quantity = rs.getString(2);
					String date = rs.getString(3);
					String sup_name = rs.getString(4);
					String sup_contact = rs.getString(5);
					
					txtpname.setText(item);
					txtquantity.setText(quantity);
					txtdreceived.setText(date);
					txtsupname.setText(sup_name);
					txtsupcontact.setText(sup_contact);
						
				}
					else {
						
						txtpname.setText("");
						txtquantity.setText("");
						txtdreceived.setText("");
						txtsupname.setText("");
						txtsupcontact.setText("");
						
					}
			}
				catch(SQLException ex){
					
				}
				
			}
		});
		txtpid.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpid.setColumns(10);
		txtpid.setBounds(189, 27, 222, 36);
		panel_2.add(txtpid);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname,quantity,dreceived,supname,supcontact;
				
				pname = txtpname.getText();
				quantity = txtquantity.getText();
				dreceived = txtdreceived.getText();
				supname = txtsupname.getText();
				supcontact = txtsupcontact.getText();
				
				
				try{
					
					pat = con.prepareStatement("insert into inventory(item,quantity,date,sup_name,sup_contact)values(?,?,?,?,?)");
					pat.setString(1, pname);
					pat.setString(2, quantity);
					pat.setString(3, dreceived);
					pat.setString(4, supname);
					pat.setString(5, supcontact);
					
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added!!!!!");
					
					table_load();
					
					txtpname.setText("");
					txtquantity.setText("");
					txtdreceived.setText("");
					txtsupname.setText("");
					txtsupcontact.setText("");
					txtpname.requestFocus();
					
				}
				
				catch(SQLException el){
					el.printStackTrace();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(46, 519, 94, 57);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEdit = new JButton("Exit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEdit.setBounds(206, 519, 94, 57);
		frame.getContentPane().add(btnEdit);
		
		JButton btnNewButton_1_1 = new JButton("Clear");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtpname.setText("");
				txtquantity.setText("");
				txtdreceived.setText("");
				txtsupname.setText("");
				txtsupcontact.setText("");
				txtpname.requestFocus();
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(371, 519, 94, 57);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Update");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname,quantity,dreceived,supname,supcontact,pid;
				
				pname = txtpname.getText();
				quantity = txtquantity.getText();
				dreceived = txtdreceived.getText();
				supname = txtsupname.getText();
				supcontact = txtsupname.getText();
				pid = txtpid.getText();
				
				try{
					
					pat = con.prepareStatement("update inventory set item=?, quantity=?, date=?, sup_name=?, sup_contact=? where id=?");
					pat.setString(1, pname);
					pat.setString(2, quantity);
					pat.setString(3, dreceived);
					pat.setString(4, supname);
					pat.setString(5, supcontact);
					pat.setString(6, pid);
					
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated!!!!!");
					
					//table_load();
					
					txtpname.setText("");
					txtquantity.setText("");
					txtdreceived.setText("");
					txtsupname.setText("");
					txtsupcontact.setText("");
					txtpname.requestFocus();
					
				}
				
				catch(SQLException el){
					el.printStackTrace();
					
				}
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1_1.setBounds(536, 519, 125, 57);
		frame.getContentPane().add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Print");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					table.print();
				}
				catch(java.awt.print.PrinterException ex){
					
					System.err.format("No Printer Found", ex.getMessage());
					
				}
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1_1_1.setBounds(712, 519, 116, 57);
		frame.getContentPane().add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Delete");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String pid;
				
				pid = txtpid.getText();
				
				try{
					
					pat = con.prepareStatement("delete from inventory where id=?");
					
					pat.setString(1, pid);
					
					
					pat.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Deleted!!!!!");
					
					table_load();
					
					txtpname.setText("");
					txtquantity.setText("");
					txtdreceived.setText("");
					txtsupname.setText("");
					txtsupcontact.setText("");
					txtpname.requestFocus();
					
				}
				
				catch(SQLException el){
					el.printStackTrace();
					
				}
				
				
				
			}
		});
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1_1_1_1_1.setBounds(873, 519, 116, 57);
		frame.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(524, 182, 488, 309);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
