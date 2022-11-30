import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private final int orderID;
    private static final AtomicInteger counter = new AtomicInteger();
    private Item item;
    private double total;
    private Date date;

    public Order(Item item, double total, Date date){
        this.item = item;
        this.total = total;
        this.date = date;
        orderID = counter.incrementAndGet();
    }

    public Order(){
        orderID = counter.incrementAndGet();
    }

    public Item getItem() {
        return item;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "Order: "+ getOrderID() + "\n" + getItem();
    }
}
