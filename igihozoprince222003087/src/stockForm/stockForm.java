package stockForm;

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

import Mystock.stock;


public class stockForm implements ActionListener {
	JFrame frame;
	JLabel stock_id_lb=new JLabel("stock_id");
	JLabel station_id_lb=new JLabel("station_id");
	JLabel product_id_lb=new JLabel("product_id");
	JLabel quantity_lb=new JLabel(" quantity");
	JLabel last_updated_lb=new JLabel("last_updated");
	
	JTextField stock_id_txf=new JTextField();
	JTextField station_id_txf=new JTextField();
	JTextField  product_id_txf=new JTextField();
	JTextField quantity_txf=new JTextField();
	JTextField last_updated_txf=new JTextField();
	
	
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
	public stockForm() {
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
		frame.setTitle("STOCK FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		stock_id_lb.setBounds(10, 10, 130, 30);
		station_id_lb.setBounds(10, 50, 180, 30);
		product_id_lb.setBounds(10, 90, 100, 30);
		quantity_lb.setBounds(10, 170, 180, 30);
		last_updated_lb.setBounds(10, 210, 100, 30);
		
		
		
		stock_id_txf.setBounds(200, 10, 170, 30);
		 station_id_txf.setBounds(200, 50, 170, 30);
		 product_id_txf.setBounds(200, 90, 170, 30);
		 quantity_txf.setBounds(200, 170, 170, 30);
		 last_updated_txf.setBounds(200, 210, 170, 30);
		 
		
		//Buttons CRUD
		insert_btn.setBounds(10,300, 100, 60);
		Read_btn.setBounds(120,300, 100, 60);
		update_tbtn.setBounds(230,300, 100, 60);
		delete_btn.setBounds(340,300, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		stock_id_lb.setFont(font);
		station_id_lb.setFont(font);
		 product_id_lb.setFont(font);
		 quantity_lb.setFont(font);
		 last_updated_lb.setFont(font);
		
		

		 stock_id_txf.setFont(font);
		 station_id_txf.setFont(font);
		 product_id_txf.setFont(font);
		 quantity_txf.setFont(font);
		 last_updated_txf.setFont(font);
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(stock_id_lb);
		frame.add(station_id_lb);
		frame.add( product_id_lb);
		frame.add(quantity_lb);
		frame.add(last_updated_lb);
	

		
		
		frame.add( stock_id_txf);
		frame.add( station_id_txf);
		frame.add( product_id_txf);
		frame.add(quantity_txf);
		frame.add(  last_updated_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
public void actionPerformed(ActionEvent e) {
		
		stock som=new stock();
		if(e.getSource()==insert_btn) {
			som.setStation_id(station_id_txf.getText());
			som.setProduct_id(product_id_txf.getText());
			
			som.setQuantity(quantity_txf.getText());
			som.setLast_updated(last_updated_txf.getText());
			
			som.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("stock_id");
            model.addColumn("station_id");
            model.addColumn("product_id");
            model.addColumn("quantity");
            model.addColumn("last_updated");
           
            
           
            ResultSet resultSet =stock.viewData();
            if (resultSet != null) {
                try {
                    while (resultSet.next()) {
                        model.addRow(new Object[] { resultSet.getInt(1), resultSet.getString(2),
                                resultSet.getString(3), resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getString(7)});
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
	    else if (e.getSource()==update_tbtn) {
	    	int id=Integer.parseInt(stock_id_txf.getText());
	    	som.setStation_id(station_id_txf.getText());
			som.setProduct_id(product_id_txf.getText());
			
			som.setQuantity(quantity_txf.getText());
			som.setLast_updated(last_updated_txf.getText());
	    	
	    }
	  else {
			int id=Integer.parseInt(stock_id_txf.getText());
			som.delete(id);}

	  }		
		public static void main(String[] args) {
			stockForm ef=new stockForm();
			System.out.println(ef);
		
			
		}

	}





