import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddProduct {
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public AddProduct(){
        prepareGUI();
    }

    public static void main(String[] args){
        AddProduct  addProduct = new AddProduct();      
        addProduct.showTextFieldDemo();
    }

    private void prepareGUI(){
        mainFrame = new JFrame("Add Product");
        mainFrame.setSize(400,400);
        mainFrame.setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });    
        headerLabel = new JLabel("", JLabel.CENTER);        
        statusLabel = new JLabel("",JLabel.CENTER);    

        statusLabel.setSize(350,100);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);  
    }

    private void showTextFieldDemo(){

        headerLabel.setText("Add Product"); 

        final JLabel  productNameLabel= new JLabel("Product Name: ", JLabel.RIGHT);
        final JTextField productNameText = new JTextField(6);

        final JLabel  manufacturerLabel= new JLabel("Manufacturer: ", JLabel.RIGHT);
        final JTextField manufacturerText = new JTextField(6);

        final JLabel  productCodeLabel= new JLabel("Product Code: ", JLabel.RIGHT);
        final JTextField productCodeText = new JTextField(6);

        final JLabel  categoryLabel= new JLabel("Category: ", JLabel.RIGHT);
        final JTextField categoryText = new JTextField(6);

        final JLabel  unitLabel= new JLabel("Number of Units: ", JLabel.RIGHT);
        final JTextField unitText = new JTextField(6);

        final JLabel  priceLabel= new JLabel("Unit Price: ", JLabel.RIGHT);
        final JTextField priceText = new JTextField(6);

        final JLabel  expirationLabel= new JLabel("Expiration Date: ", JLabel.RIGHT);
        final JTextField expirationText = new JTextField(6);

        JButton confirmButton = new JButton("Confirm");

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Product Name: " + productNameText.getText();
                data += ", Manufacturer: " + manufacturerText.getText();
                data += ", Product Code: " + productCodeText.getText();
                data += ", Category: " + categoryText.getText();
                data += ", Number of Units: " + unitText.getText();
                data += ", Unit Price: " + priceText.getText();
                data += ", Expiration Date: " + expirationText.getText();

                statusLabel.setText(data);
            }
        }); 

        controlPanel.add(productNameLabel);
        controlPanel.add(productNameText);
        controlPanel.add(manufacturerLabel);          
        controlPanel.add(manufacturerText);
        controlPanel.add(productCodeLabel);
        controlPanel.add(productCodeText);
        controlPanel.add(categoryLabel);
        controlPanel.add(categoryText);
        controlPanel.add(unitLabel);
        controlPanel.add(unitText);
        controlPanel.add(priceLabel);
        controlPanel.add(priceText);
        controlPanel.add(expirationLabel);
        controlPanel.add(expirationText);
        controlPanel.add(confirmButton);
        mainFrame.setVisible(true);  
    }
}