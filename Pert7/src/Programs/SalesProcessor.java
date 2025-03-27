package Programs;
import java.util.Scanner;

public class SalesProcessor {
    private ReportGenerator reportGenerator;
    
    public SalesProcessor(ReportGenerator reportGenerator) {
        this.reportGenerator = reportGenerator;
    }

    public void processSale(Inventory inventory) {
        Scanner scanner = new Scanner(System.in);
        
        // Display available products
        System.out.println("Available Products:");
        for (Product product : inventory.getProducts()) {
            System.out.println(product.getId() + " - " + product.getName());
        }
        
        // Get user input for product ID
        System.out.print("\nEnter Product ID: ");
        String productId = scanner.nextLine();
        
        // Get user input for quantity
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        // Process sale
        Product product = inventory.findProductById(productId);
        if (product != null && product.getStock() >= quantity) {
            inventory.updateStock(productId, quantity);
            double total = product.getPrice() * quantity;
            
            // Create Sale object and add to report
            Sale sale = new Sale(product, quantity);
            reportGenerator.addSale(sale);
            
            System.out.println("\nSale processed: " + quantity + " " + product.getName() + " for $" + total);
        } else {
            System.out.println("\nSale could not be processed. Invalid product ID or insufficient stock.");
        }
        
        scanner.close();
    }
}