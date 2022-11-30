import java.util.concurrent.atomic.AtomicInteger;

public class Invoice {
    private final int id;
    private static final AtomicInteger counter = new AtomicInteger();
    private Order order;

    public Invoice(){
        id = counter.incrementAndGet();
    }

    public Invoice(Order order){
        id = counter.incrementAndGet();        
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
