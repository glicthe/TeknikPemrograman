package KasusJCF;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        InventoryService service = new InventoryService();
        
        // Tambah produk (Immutable List.of() dari File 1)
        Product laptop = Product.create("P1", "Laptop", 15000000, "Elektronik", "Premium");
        service.addStock(laptop, 100, "Elektronik");

        // Simulasi pesanan multithread
        ExecutorService userExecutor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            final int userId = i;
            userExecutor.submit(() -> {
                Order order = new Order(
                    "ORD" + userId,
                    laptop,
                    2,
                    Instant.now(),
                    userId == 1 // Prioritas untuk ORD1
                );
                
                // Validasi dengan Optional (File 2)
                Optional<String> result = service.placeOrder(order);
                result.ifPresentOrElse(
                    stock -> System.out.println("Berhasil: " + order.id()),
                    () -> System.out.println("Gagal: " + order.id())
                );
            });
        }
        userExecutor.shutdown();
        userExecutor.awaitTermination(2, TimeUnit.SECONDS);

        // Proses antrian
        service.processOrders();

        // Ambil laporan (Immutable List)
        List<Order> report = List.copyOf(service.getOrderHistory()); // Immutable
        System.out.println("\nLaporan (Immutable):");
        report.forEach(System.out::println);
    }
}
