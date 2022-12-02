package g;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
// When the user clicks the create item button, 
// they will be able to enter product details which will then be stored in the system.
public class AddItems extends JFrame {
	
	private Inventory itemsInventory = new Inventory();
	
	private JTextField upcField;
	private JTextField nameField;
	private JTextField priceField;
	private JTextField qntyField;
	private JTextField brandField;
	private JTextField bbField;
	private JTextField catField;
	

	
	public AddItems(){
            // Setting configuration for Create Item window
            super("Dawn's Grocery Inventory Management System - Add Product");
            int length = 500;
            int width = 500;
            setPreferredSize(new Dimension(width,length));
            setResizable(true);
            
            JButton AddButton = new JButton("Add");
            AddButton.addActionListener(new addItemConfirmListener());
            
            JButton BackButton = new JButton("Back");
            BackButton.addActionListener(new BackButtonListener());
            
            JLabel upcLabel = new JLabel("ITEM UPC");
            
            JLabel nameLabel = new JLabel("ITEM NAME");
            
            JLabel priceLabel = new JLabel("PRICE");
            
            JLabel qntyLabel = new JLabel("QUANTITY");
            
            JLabel brandLabel = new JLabel("MANUFACTURER");
            
            JLabel bbLabel = new JLabel("EXPIRATION DATE");
            
            JLabel catLabel = new JLabel("CATEGORY");
            
            JLabel lblNewLabel_7 = new JLabel("ADD ITEM");
            
            upcField = new JTextField();
            upcField.setColumns(10);
            
            nameField = new JTextField();
            nameField.setColumns(10);
            
            priceField = new JTextField();
            priceField.setColumns(10);
            
            qntyField = new JTextField();
            qntyField.setColumns(10);
            
            brandField = new JTextField();
            brandField.setColumns(10);
            
            bbField = new JTextField();
            bbField.setColumns(10);
            
            catField = new JTextField();
            catField.setColumns(10);
            GroupLayout groupLayout = new GroupLayout(getContentPane());
            groupLayout.setHorizontalGroup(
            	groupLayout.createParallelGroup(Alignment.LEADING)
            		.addGroup(groupLayout.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
            				.addGroup(groupLayout.createSequentialGroup()
            					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            						.addComponent(bbLabel)
            						.addComponent(catLabel)
            						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
            							.addGroup(groupLayout.createSequentialGroup()
            								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            									.addComponent(upcLabel)
            									.addComponent(nameLabel)
            									.addComponent(priceLabel)
            									.addComponent(qntyLabel)
            									.addComponent(brandLabel))
            								.addGap(26)
            								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
            									.addComponent(brandField)
            									.addComponent(qntyField)
            									.addComponent(priceField)
            									.addComponent(nameField)
            									.addGroup(groupLayout.createSequentialGroup()
            										.addPreferredGap(ComponentPlacement.RELATED)
            										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
            											.addComponent(catField, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
            											.addComponent(bbField)))
            									.addComponent(upcField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
            							.addGroup(groupLayout.createSequentialGroup()
            								.addGap(100)
            								.addComponent(AddButton)
            								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            								.addComponent(BackButton))))
            					.addContainerGap(89, Short.MAX_VALUE))
            				.addGroup(groupLayout.createSequentialGroup()
            					.addGap(211)
            					.addComponent(lblNewLabel_7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            					.addGap(192))))
            );
            groupLayout.setVerticalGroup(
            	groupLayout.createParallelGroup(Alignment.TRAILING)
            		.addGroup(groupLayout.createSequentialGroup()
            			.addContainerGap()
            			.addComponent(lblNewLabel_7)
            			.addGap(12)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(upcLabel)
            				.addComponent(upcField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(18)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(nameLabel)
            				.addComponent(nameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(18)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(priceLabel)
            				.addComponent(priceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(18)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(qntyLabel)
            				.addComponent(qntyField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(18)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(brandLabel)
            				.addComponent(brandField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(18)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(bbLabel)
            				.addComponent(bbField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(18)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(catLabel)
            				.addComponent(catField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            			.addGap(18)
            			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
            				.addComponent(AddButton)
            				.addComponent(BackButton))
            			.addContainerGap())
            );
            getContentPane().setLayout(groupLayout);
        }
	
	
    private class addItemConfirmListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String upcValue = upcField.getText();
            String nameValue = nameField.getText();
            String priceValue = priceField.getText();
            String qtyValue = qntyField.getText();
            String manValue = brandField.getText();
            String expValue = bbField.getText();//bb = best before
            String catValue = catField.getText();//cat = category

            // System.out.println(itemsInventory.getItem(upcValue).getUPC());
            if(!(itemsInventory.getItem(upcValue).getUPC() == null)){
                JOptionPane.showMessageDialog(null, "UPC already exists. Please enter a different value.");
            }
          
            // If input value is incorrect, an error will be thrown
            
            try{
            	String file = "ITEMS.txt";
                BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
                Item newItem = new Item(upcValue, nameValue, Double.parseDouble(priceValue), Integer.parseInt(qtyValue), manValue, expValue, catValue);
                //itemsInventory.addItem(newItem);
                writer.write(upcValue+","+nameValue+","+Double.parseDouble(priceValue)+","+Integer.parseInt(qtyValue)+","+manValue+","+expValue+","+catValue+"\n");
                writer.close();
            	
            } catch(Exception err) {
                JOptionPane.showMessageDialog(null, "An error occurred. Please double check your input values.");
            }
            
            // System.out.println(itemsInventory);
            dispose();
            Menu menuFrame = new Menu();
            menuFrame.pack();
            menuFrame.setVisible(true);
        }
    }
    
    private class BackButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
        	Menu menuFrame = new Menu();
            menuFrame.pack();
            menuFrame.setVisible(true);
            dispose();
        }
    }
}

       