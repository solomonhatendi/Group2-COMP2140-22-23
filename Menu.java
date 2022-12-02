package g;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.table.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

// Menu options screen
public class Menu extends JFrame{
    // Creating instances of the inventory and sales which will be modified depending on menu options
    private Inventory itemsInventory = new Inventory();
    private Sales sales = new Sales();

    public Menu(){
    	super("Dawn's Grocery Inventory Management System - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int length = 350;
        int width = 450;
        setPreferredSize(new Dimension(width,length));
        setResizable(false); //window not resizable
        
    	JButton ViewProductButton = new JButton("View Items");
    	ViewProductButton.addActionListener(new ViewItemsListener());
    	
    	JButton AddProductButton = new JButton("Add Product");
    	AddProductButton.addActionListener(new AddItemsListener());//implement
    	
    	JButton OrderButton = new JButton("Order");
    	OrderButton.addActionListener(new CreateOrderListener());//implement
    	
    	JButton SalesButton = new JButton("Sales");
    	//SalesButton.addActionListener(new ViewSalesListener());//implement
    	
    	JButton ReportButton = new JButton("Report");
    	//ReportButton.addActionListener(new ViewReportsListener());
    	
    	JButton logoutButton = new JButton("Sign Out");
    	logoutButton.addActionListener(new logOutListener());
    	
    	JLabel menuLabel = new JLabel("Main Menu");
    	menuLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
    	
    	GroupLayout groupLayout = new GroupLayout(getContentPane());
    	groupLayout.setHorizontalGroup(
    		groupLayout.createParallelGroup(Alignment.TRAILING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(29)
    				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
    					.addComponent(SalesButton, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
    					.addComponent(ViewProductButton, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
    				.addPreferredGap(ComponentPlacement.RELATED)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(ReportButton, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
    					.addComponent(AddProductButton, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addPreferredGap(ComponentPlacement.UNRELATED, 12, Short.MAX_VALUE)
    						.addComponent(OrderButton, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(10)
    						.addComponent(logoutButton, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
    				.addGap(23))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addContainerGap(172, Short.MAX_VALUE)
    				.addComponent(menuLabel)
    				.addGap(163))
    	);
    	groupLayout.setVerticalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addComponent(menuLabel)
    				.addPreferredGap(ComponentPlacement.RELATED)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(OrderButton, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    						.addComponent(ViewProductButton, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
    						.addComponent(AddProductButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
    				.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    					.addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
    					.addComponent(ReportButton, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
    					.addComponent(SalesButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
    				.addGap(53))
    	);
    	getContentPane().setLayout(groupLayout);
        }
    
    private class ViewItemsListener implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                ViewItems itemsFrame = new ViewItems();
                itemsFrame.pack();
                itemsFrame.setVisible(true);
                dispose();
            }
        }
    
    private class logOutListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	Administrator adminFrame = new Administrator();
            adminFrame.pack();
            adminFrame.setVisible(true);
            dispose();
        }
    }
    
    private class AddItemsListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            AddItems items = new AddItems();
            items.pack();
            items.setVisible(true);
            dispose();
        }
    }
    
    private class CreateOrderListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            CreateOrder c = new CreateOrder();
            c.pack();
            c.setVisible(true);
            dispose();
        }
    }
}
