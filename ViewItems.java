package g;

import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;




public class ViewItems extends JFrame {

    private Inventory itemsInventory = new Inventory();
    private JTable table;
    

    //private ViewItemsListener itemFrame;

    public ViewItems(){
        // Setting configuration for View Items window
        super("Dawn's Grocery Inventory Management System - View Products");
        int length = 700;
        int width = 1000;
        setPreferredSize(new Dimension(width,length));
        setResizable(true);
        
     // Adding test data to inventory
        Item testDataItem = new Item("0 77975 02231 3", "Snyder’s of Hanover Mini Pretzels, 3.5 OZ", 120.00, 35, "Snyder's of Hanover", "23/12/22", "Snacks");
        itemsInventory.addItem(testDataItem);
        
        JScrollPane scrollPane = new JScrollPane();
        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(new SaveButtonListener());
        
        JButton delButton = new JButton("DELETE");
        delButton.addActionListener(new DeleteButtonListener());
        
        JButton backButton = new JButton("BACK");
        backButton.addActionListener(new BackButtonListener());
        
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(saveButton)
        					.addGap(113)
        					.addComponent(delButton)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(backButton))
        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(saveButton)
        				.addComponent(backButton)
        				.addComponent(delButton))
        			.addGap(20))
        );
        
        //table = new JTable();
        
        
     // Setting column names for the table
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
        scrollPane.setViewportView(table);
        getContentPane().setLayout(groupLayout);
    }
    
 // When the delete button is pressed, the selected item will be removed from the inventory
    private class DeleteButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                String UPC = "";
                for(int i=0; i< table.getRowCount(); i++){
                    if(selectedRow == i){
                        UPC = String.valueOf(table.getValueAt(i, 0));
                    }                        
                }
                JOptionPane.showMessageDialog(null, "Product information successfully deleted.");
                itemsInventory.removeItem(UPC);
				dispose();
				Menu menuFrame = new Menu();
	            menuFrame.pack();
	            menuFrame.setVisible(true);
        }
    }
    
    // When the save button is clicked, the edited item will be updated
    private class SaveButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            // The new value will replace the value in the previous value
            if (table.getCellEditor() != null) {
                DefaultCellEditor cellEditor = (DefaultCellEditor) table.getCellEditor();
                String value = ((JTextField) cellEditor.getComponent()).getText();
                int editedColumn = table.getSelectedColumn();
                int editedRow = table.getSelectedRow();
                table.setValueAt(value, editedRow, editedColumn);
                for(int i=0; i< table.getRowCount(); i++){
                    if(editedRow == i){
                        String UPC = String.valueOf(table.getValueAt(i, 0));
                        Item item = itemsInventory.getItem(UPC);
                        item.modify(editedColumn, value);
                    }                        
                }
            }
            JOptionPane.showMessageDialog(null, "Product information saved.");
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
    