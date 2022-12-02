package g;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JLabel;

public class CreateOrder extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private CreateOrderListener itemFrame;
	private Inventory itemsInventory = new Inventory();
    private ArrayList<Item> itemsList = itemsInventory.getItemsList();
    private JTable table;
    private JTextField textField;
    private JTextField textField_1;

    public CreateOrder(){
    	
    	
    	
    	
        // Setting configuration for Create Order window
        super("Dawn's Grocery Inventory Management System - Create Order");
        setSize(getToolkit().getScreenSize()); 
        setResizable(true);
        
        JScrollPane scrollPane = new JScrollPane();
        
        JButton OrderButton = new JButton("Order");
        
        JButton backButton = new JButton("Back");
        
        JButton SearchButton = new JButton("Search");
        
        textField = new JTextField();
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        
        JLabel qntyLabel = new JLabel("Amount");
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(109)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        					.addGroup(groupLayout.createSequentialGroup()
        						.addComponent(OrderButton)
        						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(backButton))
        					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(qntyLabel)
        						.addComponent(SearchButton))
        					.addGap(54)
        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(794, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(28)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 202, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(SearchButton)
        				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(28)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(qntyLabel))
        			.addGap(43)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(OrderButton)
        				.addComponent(backButton))
        			.addGap(84))
        );
        getContentPane().setLayout(groupLayout);
        
        String[] columnNames = {"UPC", "Name", "Unit Price", "Quantity", "Manufacturer", "Expiration Date", "Category"};
        
        // Getting items from inventory list and displaying on table
        ArrayList<Item> itemsList = itemsInventory.getItemsList();
        String data[][] = new String[itemsList.size()][columnNames.length];
        for (int i = 0; i < itemsList.size(); i++){
            data[i][0] = itemsList.get(i).getUPC();
            data[i][1] = itemsList.get(i).getName();
            data[i][2] = Double.toString(itemsList.get(i).getUnitPrice());
            data[i][3] = Integer.toString(itemsList.get(i).getQuantity());
            data[i][4] = itemsList.get(i).getManufacturer();
            data[i][5] = itemsList.get(i).getExpiration();
            data[i][6] = itemsList.get(i).getCategory();
        }
        table=new JTable(data,columnNames);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"UPC", "Name", "Unit Price", "Quantity", "Manufacturer", "Expiration Date", "Add Item"
        	}
        ) {
        	/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
        		Object.class, Object.class, Integer.class, Object.class, Object.class, Object.class, Boolean.class
        	};
        	public Class getColumnClass(int columnIndex) {
        		return columnTypes[columnIndex];
        	}
        });
        scrollPane.setViewportView(table);
        getContentPane().setLayout(groupLayout);
    }
    
}