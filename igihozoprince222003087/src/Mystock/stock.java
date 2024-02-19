package Mystock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class stock {
	private int stock_id;
	private String 	station_id;
	private String product_id  ;
	private String 	quantity;
	private String last_updated;
	
	
	public stock(int stock_id,String station_id,String product_id,String quantity,String last_updated){
	super();
	this. stock_id=  stock_id;
	this. station_id=  station_id;
	this.product_id= product_id;
	this.	quantity=	quantity;
	this. last_updated= last_updated;
	
}


	public stock() {
		// TODO Auto-generated constructor stub
	}


	public int getStock_id() {
		return stock_id;
	}


	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}


	public String getStation_id() {
		return station_id;
	}


	public void setStation_id(String station_id) {
		this.station_id = station_id;
	}


	public String getProduct_id() {
		return product_id;
	}


	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getLast_updated() {
		return last_updated;
	}


	public void setLast_updated(String last_updated) {
		this.last_updated = last_updated;
	}
public void makeconnection() {
}
		public void insertData() {
	// JDBC URL, username, and password of MySQL server
    String host = "jdbc:mysql://localhost/petrol_sales_and_stockcontrol";
    String user = "root";
    String password = "";

    // SQL query to insert data
    String sql = "INSERT INTO stock( station_id,product_id,quantity,last_updated) VALUES (?,?,?,?)";
	
    try (
        // Establish the connection
        Connection con = DriverManager.getConnection(host, user, password);

        // Create a prepared statement
    		PreparedStatement preparedStatement = con.prepareStatement(sql);
    	    ) {
        // Set the values for the prepared statement
    	
       preparedStatement.setString(1, this. station_id);
       preparedStatement.setString(2, this.product_id);
       preparedStatement.setString(3, this.quantity);
       preparedStatement.setString(4, this.last_updated);
      
       //preparedStatement.setString(6, this.gender);
       
          
        
        // Execute the query
        int rowsAffected = preparedStatement.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
        	System.out.println("Data insert successfully!");
            JOptionPane.showMessageDialog(null, "Data insert successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to insert data.");
            JOptionPane.showMessageDialog(null, "Failed to register data.!","After insert",JOptionPane.ERROR_MESSAGE);

        }

    } catch (SQLException e) {
        e.printStackTrace();
    }}
 
		public static ResultSet viewData() {
	        String host = "jdbc:mysql://localhost/petrol_sales_and_stockcontrol";
	        String user = "root";
	        String password = "";

	        String sql = "SELECT * FROM customers";

	        try {
	            Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);
	            return preparedStatement.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
public void update(int inputstock_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/petrol_sales_and_stockcontrol";
    String user = "root";
    String password = "";

    // SQL query to update data
    String sql = "UPDATE stock SET  station_id=? product_id=? quantity=? last_updated=?  WHERE stock_id = ?";

    try (
        // Establish the con
        Connection con = DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement stm = con.prepareStatement(sql);
    ) {
        // Set the new values for the update
    	  
          stm.setString(1, this.getStation_id());
          stm.setString(2, this.getProduct_id());
          stm.setString(3, this.getQuantity());
          stm.setString(4, this.getLast_updated());
          
          
          
          
          
          // Assuming there is a column named 'id' for the WHERE clause
       
          stm.setInt(5, inputstock_id);
       
        // Execute the update
        int rowsAffected = stm.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data updated successfully!");
            JOptionPane.showMessageDialog(null, "Data updated successfully!!","After update",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to update data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to update data. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }   
}
public void delete(int inputstock_id) {
	// JDBC URL, username, and password of MySQL server
    String url = "jdbc:mysql://localhost/petrol_sales_and_stockcontrol";
    String user = "root";
    String password = "";

    // SQL query to delete data
    String sql = "DELETE FROM Employees WHERE  customer_id =?";

    try (
        // Establish the 
        Connection con= DriverManager.getConnection(url, user, password);

        // Create a prepared statement
        PreparedStatement pl = con.prepareStatement(sql);
    ) {
        // Set the value for the WHERE clause
        pl.setInt(1, inputstock_id); // Assuming there is a column named 'id' for the WHERE clause

        // Execute the delete
        int rowsAffected = pl.executeUpdate();

        // Check the result
        if (rowsAffected > 0) {
            System.out.println("Data deleted successfully!");
            JOptionPane.showMessageDialog(null, "Data deleted successfully!","After delete",JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.out.println("Failed to delete data. No matching record found.");
            JOptionPane.showMessageDialog(null, "Failed to delete data. No matching record found. No matching record found.!","After insert",JOptionPane.INFORMATION_MESSAGE);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
}


