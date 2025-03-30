package sales;

// Abstract class representing a sale item
public abstract class SaleItem {
    protected String name;
    protected double price;

    // Constructor
    public SaleItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Abstract method for calculating total sales
    public abstract double calculateTotal();

    // Method to display sales details
    public void displayTotal() {
        System.out.println(name + " Total Sales: ₱" + calculateTotal());
    }
}
