package customersForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Mycustomers.customers;


public class CustomersForm implements ActionListener {
		JFrame frame;
		JLabel customer_id_lb=new JLabel("Customer_id");
		JLabel customer_name_lb=new JLabel("customer_name");
		JLabel email_lb=new JLabel("email");
		JLabel phone_number_lb=new JLabel("phone_number");
		
		JTextField customer_id_txf=new JTextField();
		JTextField customer_name_txf=new JTextField();
		JTextField email_txf=new JTextField();
		JTextField phone_number_txf=new JTextField();
		
		
		//Buttons CRUD
		JButton insert_btn=new JButton("Insert");
		JButton Read_btn=new JButton("View");
		JButton update_tbtn=new JButton("Update");
		JButton delete_btn=new JButton("Delete");
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
		
		Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
		int w=(int) screensize.getWidth();
		int h=(int) screensize.getHeight();
		public CustomersForm() {
			createForm();
			actionEvent();
			setFontforall();
			addComponentToFrame();
			setLocationandSize();
		}

		private void actionEvent() {
			insert_btn.addActionListener(this);
			Read_btn.addActionListener(this);
			update_tbtn.addActionListener(this);
			delete_btn.addActionListener(this);
			//genderBox.addActionListener(this);
		}
		private void createForm() {
			frame=new JFrame();
			frame.setTitle("CUSTOMER FORM");
			frame.setBounds(0, 0, w/2, h/2);
			frame.getContentPane().setLayout(null);
			frame.getContentPane().setBackground(Color.CYAN);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			}

		private void setLocationandSize() {
			customer_id_lb.setBounds(10, 10, 130, 30);
			customer_name_lb.setBounds(10, 50, 180, 30);
			email_lb.setBounds(10, 90, 100, 30);
			phone_number_lb.setBounds(10, 130, 150, 30);
			
			
			customer_id_txf.setBounds(200, 10, 170, 30);
			customer_name_txf.setBounds(200, 50, 170, 30);
			email_txf.setBounds(200, 90, 170, 30);
			phone_number_txf.setBounds(200, 130, 170, 30);
			
			//Buttons CRUD
			insert_btn.setBounds(10,250, 100, 60);
			Read_btn.setBounds(120,250, 100, 60);
			update_tbtn.setBounds(230,250, 100, 60);
			delete_btn.setBounds(340,250, 100, 60);
			table.setBounds(500, 10, 600, 240);
			
		}
		private void setFontforall() {
			Font font = new Font("Georgia", Font.BOLD, 18);

			customer_id_lb.setFont(font);
			customer_name_lb.setFont(font);
			email_lb.setFont(font);
			phone_number_lb.setFont(font);
			

			customer_id_txf.setFont(font);
			customer_name_txf.setFont(font);
			email_txf.setFont(font);
			phone_number_txf.setFont(font);
			
			//Buttons CRUD
			Font fonti = new Font("Courier New", Font.BOLD, 15);

			insert_btn.setFont(fonti);
			Read_btn.setFont(fonti);
			update_tbtn.setFont(fonti);
			delete_btn.setFont(fonti);

		}
		private void addComponentToFrame() {
			frame.add(customer_id_lb);
			frame.add(customer_name_lb);
			frame.add(email_lb);
			frame.add(phone_number_lb);
			
			
			frame.add(customer_id_txf);
			frame.add(customer_name_txf);
			frame.add(email_txf);
			frame.add(phone_number_txf);
			
			//Buttons CRUD
			frame.add(insert_btn);
			frame.add(Read_btn);
			frame.add(update_tbtn);
			frame.add(delete_btn);
			frame.add(table);
		}
		public void actionPerformed(ActionEvent e) {
			
			 customers som=new customers();
				if(e.getSource()==insert_btn) {
					som.setCustomer_name(customer_name_txf.getText());
					som.setEmail(email_txf.getText());
					som.setPhone_number(phone_number_txf.getText());
					
					
					
					som.insertData();
					
				}else if (e.getSource() == Read_btn) {
					model.setColumnCount(0);
					model.setRowCount(1);
					model.addColumn("customer_id");
		            model.addColumn("customer_name");
		            model.addColumn("email");
		            model.addColumn("phone_number");
		            
		           
		            ResultSet resultSet =customers.viewData();
		            if (resultSet != null) {
		                try {
		                    while (resultSet.next()) {
		                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
		                                resultSet.getString(3), resultSet.getString(4)});
		                    }
		                } catch (SQLException ex) {
		                    ex.printStackTrace();
		                }
		            }
		        }
			    else if (e.getSource()==update_tbtn) {
			    	int id=Integer.parseInt(customer_id_txf.getText());
			    	som.setCustomer_name(customer_name_txf.getText());
					som.setEmail(email_txf.getText());
					som.setPhone_number(phone_number_txf.getText());
					
			    	
			    }
			  else {
					int id=Integer.parseInt(customer_id_txf.getText());
					som.delete(id);}

			  }		
				public static void main(String[] args) {
					CustomersForm ef=new CustomersForm();
					System.out.println(ef);
				
					
				}

			}
