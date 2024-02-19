package stationForm;

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

import Mystation.station;


public class StationForm implements ActionListener {
	JFrame frame;
	JLabel station_id_lb=new JLabel("station_id");
	JLabel station_name_lb=new JLabel("station_name");
	JLabel location_lb=new JLabel(" location");
	
	JTextField station_id_txf=new JTextField();
	JTextField station_name_txf=new JTextField();
	JTextField location_txf=new JTextField();
	
	
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
	public StationForm() {
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
		frame.setTitle("STATION FORM");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		}

	private void setLocationandSize() {
		station_id_lb.setBounds(10, 10, 130, 30);
		station_name_lb.setBounds(10, 50, 180, 30);
		location_lb.setBounds(10, 90, 100, 30);
		
		
		
		station_id_txf.setBounds(200, 10, 170, 30);
		station_name_txf.setBounds(200, 50, 170, 30);
		location_txf.setBounds(200, 90, 170, 30);
		
		
		//Buttons CRUD
		insert_btn.setBounds(10,250, 100, 60);
		Read_btn.setBounds(120,250, 100, 60);
		update_tbtn.setBounds(230,250, 100, 60);
		delete_btn.setBounds(340,250, 100, 60);
		table.setBounds(500, 10, 600, 240);
		
	}
	private void setFontforall() {
		Font font = new Font("Georgia", Font.BOLD, 18);

		station_id_lb.setFont(font);
		station_name_lb.setFont(font);
		location_lb.setFont(font);
		
		

		station_id_txf.setFont(font);
		station_name_txf.setFont(font);
		location_txf.setFont(font);
		
		
		//Buttons CRUD
		Font fonti = new Font("Courier New", Font.BOLD, 15);

		insert_btn.setFont(fonti);
		Read_btn.setFont(fonti);
		update_tbtn.setFont(fonti);
		delete_btn.setFont(fonti);

	}
	private void addComponentToFrame() {
		frame.add(station_id_lb);
		frame.add(station_name_lb);
		frame.add(location_lb);
		
		
		
		frame.add(station_id_txf);
		frame.add(station_name_txf);
		frame.add(location_txf);
		
		
		//Buttons CRUD
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_tbtn);
		frame.add(delete_btn);
		frame.add(table);
	}
public void actionPerformed(ActionEvent e) {
		
	 station som=new station();
		if(e.getSource()==insert_btn) {
			som.setStation_name(station_name_txf.getText());
			som.setLocation(location_txf.getText());
			
			
			
			som.insertData();
			
		}else if (e.getSource() == Read_btn) {
			model.setColumnCount(0);
			model.setRowCount(1);
			model.addColumn("station_id");
            model.addColumn("station_name");
            model.addColumn("location");
         
            
            
           
            ResultSet resultSet =station.viewData();
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
	    	int id=Integer.parseInt(station_id_txf.getText());
	    	som.setStation_name(station_name_txf.getText());
			som.setLocation(location_txf.getText());
			
			
	    	
	    }
	  else {
			int id=Integer.parseInt(station_id_txf.getText());
			som.delete(id);}

	  }		
		public static void main(String[] args) {
			StationForm ef=new StationForm();
			System.out.println(ef);
		
			
		}

	}
