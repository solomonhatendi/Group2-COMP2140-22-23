package Dawns_Grocery_store;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextPane;

public class billingOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JButton add;
	private JButton clear;
	private JButton print;
	private JButton close;
	private JTextField IDtextField;
	private JLabel NameLabel;
	private JLabel IDLabel;
	private JTextField NametextField;
	private JLabel AmountLabel;
	private JTextField AmounttextField;
	private JLabel titleLabel;
	private JLabel statusLabel;
	private JButton search;
	private ArrayList<Product> plist;
	private DefaultTableModel model;
	private DecimalFormat df = new DecimalFormat("0.00");
	
	File filename = new File("Product.txt");
	
	//File filename = new File(fp);
    
	//private String n = NametextField.getText();
    
	public billingOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 788);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//plist = load(filename);
		add = new JButton("add");
		add.addActionListener(new Add1ButtonListener());
		clear = new JButton("clear");
		clear.addActionListener(new Clear1ButtonListener());
		print = new JButton("print");
		print.addActionListener(new Print1ButtonListener());
		close = new JButton("close");
		close.addActionListener(new Close1ButtonListener());
		search = new JButton("search");
		search.addActionListener(new Search1ButtonListener());
		
		IDLabel = new JLabel("ProdID");
		NameLabel = new JLabel("Name");
		AmountLabel = new JLabel("Amount");
		statusLabel = new JLabel(" ");
		
		IDtextField = new JTextField();
		IDtextField.setColumns(10);		
		
		NametextField = new JTextField();
		NametextField.setColumns(10);
		
		AmounttextField = new JTextField();
		AmounttextField.setColumns(10);
		
		titleLabel = new JLabel("BILLING/ORDER");
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));		
		
		JTextPane textPane = new JTextPane();
		
		scroll = new JScrollPane();
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(add)
										.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
										.addComponent(clear))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(AmountLabel)
											.addComponent(NameLabel)
											.addComponent(IDLabel))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(IDtextField)
											.addComponent(NametextField)
											.addComponent(AmounttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addComponent(search))
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(titleLabel)
								.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(statusLabel)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(close)
									.addPreferredGap(ComponentPlacement.RELATED, 804, Short.MAX_VALUE)
									.addComponent(print)))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(IDLabel)
								.addComponent(IDtextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(NameLabel)
								.addComponent(NametextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(AmountLabel)
								.addComponent(AmounttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addComponent(search)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(add)
								.addComponent(clear)))
						.addComponent(scroll, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
					.addComponent(statusLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(close)
						.addComponent(print))
					.addContainerGap())
		);
		
		table = new JTable();
		scroll.setViewportView(table);
		
		
		
		
		contentPane.setLayout(gl_contentPane);
	}
	
	private class Close1ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
	
	private class Add1ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //
        }
    }
	
	private class Print1ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //
        }
    }
	
	private class Clear1ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	
        	IDtextField.setText("");
            NametextField.setText("");
            AmounttextField.setText("");
            IDtextField.setBackground(Color.white);
            statusLabel.setText("");
        }
    }
	//
	//
	/*private class Search1ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	String[] columnNames=  {"PID","PName","Amount","Description","PCost"};
        	model=new DefaultTableModel(columnNames,0);
            table = new JTable(model);
            table.setEnabled(true);
            showTable(plist);
        	//
            try{
                BufferedReader reader = new BufferedReader(new FileReader(filename));
                String line;
                int i = 0;
                List<String> data = new ArrayList<String>();
                Scanner scan = new Scanner(System.in);
                while((line = reader.readLine()) != null){    
                	data.add(line);
                    String[] prodFound = data.get(i).split(",");
                    String name = NametextField.getText();
                    if(name.equals(prodFound[1])){
                    	System.out.println("Product Name:("+prodFound[1]+") Found\n----------------------------\n["
                    		+prodFound[0]+" "+prodFound[1]+
                            "]\nBrand:\n-"+prodFound[2]+
                            "\nDescription:\n-"+prodFound[3]+
                            "\nPrice:\n-"+prodFound[4]+
                            "\nAmount in Stock:\n-"+Integer.valueOf(prodFound[5]));
                        } 
                        i = i+1;
                    }
                    statusLabel.setText("Product with ID "+"'"+IDtextField.getText()+"'"+" was found.");
                    IDtextField.setBackground(Color.pink);
                }catch(Exception e1){
                	statusLabel.setText("Product with ID "+"'"+IDtextField.getText()+"'"+" was found.");
                	IDtextField.setBackground(Color.pink);}
            }
        }*/
	
	
	private class Search1ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			File f = filename;
			String[] col = {"PNAME","PDESC","PID","PRICE","STOCK"};
			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.setColumnIdentifiers(col);
			try {
				BufferedReader b = new BufferedReader(new FileReader(f));
				Object[] rows = b.lines().toArray();
				for (int i = 0; i<rows.length;i++){
					String l = rows[i].toString().trim();
					String[] row = l.split(",");
					model.addRow(row);
				}
				//table.setModel(rows,col);
				try {
					b.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}catch(FileNotFoundException e){
				statusLabel.setText("Product with ID "+"'"+IDtextField.getText()+"'"+" was not found.");
            	IDtextField.setBackground(Color.pink);
				Logger.getLogger(billingOrder.class.getName()).log(Level.SEVERE, null,e);
			}
		}
	}
}