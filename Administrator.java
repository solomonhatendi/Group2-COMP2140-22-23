package g;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

// Login screen
public class Administrator extends JFrame{
    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JFrame adminFrame;
    public Administrator(){
        // Setting configuration for Administrator window
        super("Dawn's Grocery Inventory Management System - Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setPreferredSize(getToolkit().getScreenSize());
        int length = 200;
        int width = 400;
        setPreferredSize(new Dimension(width,length));
        setResizable(false); //window not resizable

        // Creating panel for admin components
        JPanel adminPnl = new JPanel();

        // Adding username and password fields
        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        usernameField = new JTextField(20);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        passwordField = new JPasswordField(20);

     
        JButton adminLoginBtn = new JButton("Login");
        adminLoginBtn.setBounds(300, 430, 200, 68);
        adminLoginBtn.addActionListener(new AdminLoginBtnListener());

        getContentPane().add(adminPnl, BorderLayout.EAST);
        
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new closeBtnListener());
        GroupLayout gl_adminPnl = new GroupLayout(adminPnl);
        gl_adminPnl.setHorizontalGroup(
        	gl_adminPnl.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_adminPnl.createSequentialGroup()
        			.addGap(22)
        			.addGroup(gl_adminPnl.createParallelGroup(Alignment.LEADING)
        				.addComponent(adminLoginBtn)
        				.addComponent(usernameLabel)
        				.addComponent(passwordLabel))
        			.addGap(31)
        			.addGroup(gl_adminPnl.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_adminPnl.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_adminPnl.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_adminPnl.createSequentialGroup()
        					.addComponent(closeButton)
        					.addContainerGap())))
        );
        gl_adminPnl.setVerticalGroup(
        	gl_adminPnl.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_adminPnl.createSequentialGroup()
        			.addGap(26)
        			.addGroup(gl_adminPnl.createParallelGroup(Alignment.BASELINE)
        				.addComponent(usernameLabel)
        				.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(gl_adminPnl.createParallelGroup(Alignment.BASELINE)
        				.addComponent(passwordLabel)
        				.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(35)
        			.addGroup(gl_adminPnl.createParallelGroup(Alignment.BASELINE)
        				.addComponent(adminLoginBtn)
        				.addComponent(closeButton))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        adminPnl.setLayout(gl_adminPnl);
    }

    // When the user clicks the login button the username and password will be checked
    private class AdminLoginBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // When the user successfully logs in, they will have access to the menu options
            if(usernameField.getText().equals("admin") && (String.valueOf(passwordField.getPassword()).equals("password"))){
                Menu menuFrame = new Menu();
                menuFrame.pack();
                menuFrame.setVisible(true);
                dispose();
                //setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password.");
                usernameField.setText("");
                passwordField.setText("");
            }

        }
    }
    
    private class closeBtnListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	System.exit(0);
        }
    }
}
