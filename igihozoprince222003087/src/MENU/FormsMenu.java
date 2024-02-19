package MENU;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import customersForm.CustomersForm;
import productsForm.ProductsForm;
import salesForm.SalesForm;
import stationForm.StationForm;
import stockForm.stockForm;




public class FormsMenu extends JFrame implements ActionListener {
	JFrame frame;

	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private JMenu customersmenu;
    private JMenu productsmenu;
    private JMenu salesmenu;
    private JMenu stationsmenu;
    private JMenu stockmenu;
    private JMenu Logoutmenu;
    


	public FormsMenu() {
		// TODO Auto-generated constructor stub
	}
    
    private JMenuItem customersItem;
    private JMenuItem productsItem;
    private JMenuItem salesItem;
    private JMenuItem stationsItem;
    private JMenuItem stockItem;
    private JMenuItem logoutItem;
    private String loggedInUser;
    private boolean isSubscribed = false;

    public FormsMenu(String username) {
        this.loggedInUser = username;
        setTitle("Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create menu bar
        menuBar = new JMenuBar();
    

        // Create home menu
        customersmenu = new JMenu("Customers");
        productsmenu = new JMenu("Products");
        salesmenu= new JMenu("Sales");
        stationsmenu = new JMenu("Stations ");
        stockmenu = new JMenu("Stock");
        Logoutmenu = new JMenu("Logout");
        		

        // Create menu items
        menuBar.add(customersmenu);
        customersItem = new JMenuItem("CustomersForm");
        customersItem.addActionListener(this);
        
        menuBar.add(productsmenu);
        productsItem = new JMenuItem("ProductsItemForm");
        productsItem.addActionListener(this);
        
        menuBar.add(salesmenu);
        salesItem = new JMenuItem("SalesForm");
        salesItem.addActionListener(this);
        
        menuBar.add(stationsmenu);
        stationsItem = new JMenuItem("StationsForm");
        stationsItem.addActionListener(this);
        
        menuBar.add(stockmenu);
        stockItem = new JMenuItem("SupplierForm");
        stockItem.addActionListener(this);

        menuBar.add(Logoutmenu);
        logoutItem = new JMenuItem("Logout");
        logoutItem.addActionListener(this);

        // Add menu items to home menu
        customersmenu.add(customersItem);
        productsmenu.add(productsItem);
        salesmenu.add(salesItem);
        stationsmenu.add(stationsItem);
        stockmenu.add(stockmenu);
        Logoutmenu.addSeparator();
        Logoutmenu.add(logoutItem);

        // Add home menu to menu bar
        // Set menu bar to frame
        setJMenuBar(menuBar);

        // Initialize dashboard panel with background image
        JPanel dashboardPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the image
                ImageIcon imageIcon = new ImageIcon("C:\\Users\\mahoro chany\\Desktop\\New folder\\Bluesky.jpg");
                // Draw the image
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };



        // Initialize dashboard panel
        JPanel dashboardPanel1 = new JPanel();
        dashboardPanel1.setLayout(new BorderLayout());

        // Add components to dashboard panel
        JLabel titleLabel = new JLabel("WELCOME " + loggedInUser + " DASHBOARD");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        dashboardPanel1.add(titleLabel, BorderLayout.CENTER);

        // Add dashboard panel to frame
        add(dashboardPanel1);

        setVisible(true);
        
        customersmenu.add(customersItem);
        productsmenu.add(productsItem);
        salesmenu.add(salesItem);
        stationsmenu.add(stationsItem);
        stockmenu.add(stockmenu);
        Logoutmenu.addSeparator();
    }
   @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == customersItem) {
            new CustomersForm();
        
        } else if (e.getSource() == productsItem) {
            new ProductsForm();
        
        } else if (e.getSource() == salesItem) {
            new SalesForm();
       
        } else if (e.getSource() == stationsItem) {
           new StationForm();
        
        } else if (e.getSource() == stockmenu) {
           new stockForm();
       
        } else if (e.getSource() == logoutItem) {
            int choice = JOptionPane.showConfirmDialog(this, "Do you want to logout?", "Logout", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                dispose();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormsMenu("TO PROJECT"));
    }
}





