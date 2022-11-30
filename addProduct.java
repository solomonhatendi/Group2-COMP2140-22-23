import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class product {

    private String name;
    private String manufacturer;
    private String UPC;
    private String category;
    private int units;
    private double price;
    private String expiration;

    public product(String name, String manufacturer, String UPC, String category, int units, double price,
            String expiration) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.UPC = UPC;
        this.category = category;
        this.units = units;
        this.price = price;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getUPC() {
        return UPC;
    }

    public String getCategory() {
        return category;
    }

    public int getUnits() {
        return units;
    }

    public double getPrice() {
        return price;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String toString(){
        return "Name: " + name + "\nManufacturer: " + manufacturer + "\nUPC: " + UPC + "\nCategory: " + category + "\nUnits: " + units + "\nPrice: " + price + "\nExpiration: " + expiration+"\n";
    }

}

public class vie {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<product> products = new ArrayList<product>();
        int choice = 0;
        while (choice != 3) {
            System.out.println("1. Create a new product");
            System.out.println("2. Display all products");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            if (choice == 1) {
                System.out.print("Enter product name: ");
                String name = input.next();
                System.out.print("Enter manufacturer: ");
                String manufacturer = input.next();


                System.out.print("Enter UPC: ");
                String UPC = input.next();
                
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getUPC().equals(UPC)) {
                        System.out.println("The UPC is already in use");
                        System.out.print("Enter UPC: ");
                        UPC = input.next();
                    }
                }

        

                System.out.print("Enter category: ");
                String category = input.next();
                System.out.print("Enter number of units: ");
                int units = input.nextInt();
                System.out.print("Enter unit price: ");
                double price = input.nextDouble();
                System.out.print("Enter expiration date: ");
                String date = input.next();
                product p = new product(name, manufacturer, UPC, category, units, price, date);
                products.add(p);
            } else if (choice == 2) {
                for (product p : products) {
                    System.out.println(p);
                }
            }
        }
    }
}