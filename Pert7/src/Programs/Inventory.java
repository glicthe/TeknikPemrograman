package Programs;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    public void loadProducts() {
        products.add(new Product("P001", "Laptop", 999.99, 10));
        products.add(new Product("P002", "Mouse", 19.99, 50));
        products.add(new Product("P003", "Keyboard", 49.99, 30));
    }

    public Product findProductById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void updateStock(String id, int quantity) {
        Product p = findProductById(id);
        if (p != null) {
            p.setStock(p.getStock() - quantity);
        }
    }

    // New method to get all products
    public ArrayList<Product> getProducts() {
        return products;
    }
}