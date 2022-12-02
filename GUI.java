package g;

// Driver class for Dawn’s Grocery Inventory Management System
 
public class GUI{
    public GUI(){
    	
    }
    public static void main(String args[]) {
        Administrator adminFrame = new Administrator(); //Starts the admin Class
        adminFrame.pack();
        adminFrame.setVisible(true);//makes the login screen visible
    }
}