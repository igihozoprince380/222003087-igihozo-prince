package Mycustomers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class customers {
	private int customer_id;
	private String 	customer_name;
	private String email ;
	private String phone_number;
	public customers(int customer_id,String customer_name,String email ,String phone_number){
	super();
	this.customer_id= customer_id;
	this.customer_name= customer_name;
	this.email= email;
	this.phone_number=phone_number;
	
		
	}
	public customers() {
		// TODO Auto-generated constructor stub
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
public void makeconnection() {
}
public void insertData() {
// JDBC URL, username, and password of MySQL server
String host = "jdbc:mysql://localhost/petrol_sales_and_stockcontrol";
String user = "root";
String password = "";

// SQL query to insert data
String sql = "INSERT INTO customers(customer_name,email,phone_number) VALUES (?,?,?)";

try (
// Establish the connection
Connection con = DriverManager.getConnection(host, user, password);

// Create a prepared statement
	PreparedStatement preparedStatement = con.prepareStatement(sql);
    ) {
// Set the values for the prepared statement

preparedStatement.setString(1, this. customer_name);
preparedStatement.setString(2, this.email);
preparedStatement.setString(3, this.phone_number);
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
public void update(int inputcustomer_id) {
// JDBC URL, username, and password of MySQL server
String url = "jdbc:mysql://localhost/petrol_sales_and_stockcontrol";
String user = "root";
String password = "";

// SQL query to update data
String sql = "UPDATE customers SET  	customer_name=? email=? phone_number=?   WHERE customers_id = ?";

try (
// Establish the con
Connection con = DriverManager.getConnection(url, user, password);

// Create a prepared statement
PreparedStatement stm = con.prepareStatement(sql);
) {
// Set the new values for the update
  
  stm.setString(1, this.getCustomer_name());
  stm.setString(2, this.getEmail());
  stm.setString(2, this.getPhone_number());

  
  
  
  
  // Assuming there is a column named 'id' for the WHERE clause

  stm.setInt(2, inputcustomer_id);

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
public void delete(int inputcustomer_id) {
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
pl.setInt(1, inputcustomer_id); // Assuming there is a column named 'id' for the WHERE clause

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




