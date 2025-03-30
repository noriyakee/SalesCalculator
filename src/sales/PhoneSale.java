package sales;

// Concrete class extending SaleItem for phones
public class PhoneSale extends SaleItem {
    private int quantitySold;

    // Constructor
    public PhoneSale(double price, int quantitySold) {
        super("Phone", price);
        this.quantitySold = quantitySold;
    }

    // Implement calculateTotal for phone sales
    @Override
    public double calculateTotal() {
        return price * quantitySold;
    }
}
