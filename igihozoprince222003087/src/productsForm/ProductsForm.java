package productsForm;

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

import Myproducts.products;
import Mystation.station;
import customersForm.CustomersForm;
import stationForm.StationForm;

public class ProductsForm implements ActionListener {
	JFrame frame;
	JLabel products_id_lb=new JLabel("products_id");
	JLabel product_name_lb=new JLabel("product_name");
	JLabel unit_price_lb=new JLabel("unit_price");
	
	JTextField products_id_txf=new JTextField();
	JTextField product_name_txf=new JTextField();
	JTextField unit_price_txf=new JTextField();
	
	
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
	public ProductsForm() {
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
		frame.setTitle("PRODUCT FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		products_id_lb.setBounds(10, 10, 130, 30);
		product_name_lb.setBounds(10, 50, 180, 30);
		unit_price_lb.setBounds(10, 90, 100, 30);
		
		
		
		products_id_txf.setBounds(200, 10, 170, 30);
		product_name_txf.setBounds(200, 50, 170, 30);
		unit_price_txf.setBounds(200, 90, 170, 30);
		
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		products_id_lb.setFont(font);
		product_name_lb.setFont(font);
		unit_price_lb.setFont(font);
		
		

		products_id_txf.setFont(font);
		product_name_txf.setFont(font);
		unit_price_txf.setFont(font);
		
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);
		

	}
	private void addComponentToFrame() {
		frame.add(products_id_lb);
		frame.add(product_name_lb);
		frame.add(unit_price_lb);
		
		
		
		frame.add(products_id_txf);
		frame.add(product_name_txf);
		frame.add(unit_price_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
	public void actionPerformed(ActionEvent e) {
		
		 products som=new products();
			if(e.getSource()==insert_btn) {
				som.setProduct_name(product_name_txf.getText());
				som.setUnit_price(unit_price_txf.getText());
				
				
				
				som.insertData();
				
			}else if (e.getSource() == Read_btn) {
				model.setColumnCount(0);
				model.setRowCount(1);
				model.addColumn("product_id");
	            model.addColumn("product_name");
	            model.addColumn("unit_price");
	         
	            
	           
	            ResultSet resultSet =products.viewData();
	            if (resultSet != null) {
	                try {
	                    while (resultSet.next()) {
	                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
	                                resultSet.getString(3)});
	                    }
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }
		    else if (e.getSource()==update_tbtn) {
		    	int id=Integer.parseInt(products_id_txf.getText());
		    	som.setProduct_name(product_name_txf.getText());
				som.setUnit_price(unit_price_txf.getText());
				
				
		    	
		    }
		  else {
				int id=Integer.parseInt(products_id_txf.getText());
				som.delete(id);}

		  }		
			public static void main(String[] args) {
				ProductsForm  ef=new ProductsForm();
				System.out.println(ef);
			
				
			}

		}


