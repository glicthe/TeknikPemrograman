package Programs;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        ReportGenerator reports = new ReportGenerator();
        SalesProcessor sales = new SalesProcessor(reports);
        
        inventory.loadProducts();
        sales.processSale(inventory);
        reports.generateSalesReport();
    }
}