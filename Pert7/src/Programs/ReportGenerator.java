package Programs;
// File: ReportGenerator.java
import java.util.ArrayList;

public class ReportGenerator {
    private ArrayList<Sale> sales = new ArrayList<>();
    
    public void generateSalesReport() {
        System.out.println("\nSales Report:");
        for (Sale sale : sales) {
            System.out.println(sale.getProduct() + " - " + sale.getQuantity() + " - $" + sale.getTotal());
        }
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }
}