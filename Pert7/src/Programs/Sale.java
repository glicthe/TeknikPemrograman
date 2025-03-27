package Programs;

public class Sale {
    private Product product;
    private int quantity;
    private double total;

    public Sale(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.total = product.getPrice() * quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return product.getName() + " (" + product.getId() + ") - Quantity: " + quantity + " - Total: $" + total;
    }
}