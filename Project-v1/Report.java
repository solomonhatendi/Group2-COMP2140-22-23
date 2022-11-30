import java.util.Date;

public class Report {
    private Date[] timePeriod;

    public Report(Date[] timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Date[] getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(Date[] timePeriod) {
        this.timePeriod = timePeriod;
    }

    public void lowStock(){
        System.out.println("Report for low stock items");
    }

    public void productPerformance(){
        System.out.println("Report for product performance");
    }

    public void inventoryReplenishment(){
        System.out.println("Report for inventory replenishment");
    }
}
