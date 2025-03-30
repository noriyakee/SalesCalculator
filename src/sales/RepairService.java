package sales;

// Concrete class extending SaleItem for repair services
public class RepairService extends SaleItem {
    private int hoursWorked;

    // Constructor
    public RepairService(double pricePerHour, int hoursWorked) {
        super("Repair", pricePerHour);
        this.hoursWorked = hoursWorked;
    }

    // Implement calculateTotal for repair services
    @Override
    public double calculateTotal() {
        return price * hoursWorked;
    }
}
