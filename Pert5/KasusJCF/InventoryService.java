package KasusJCF;
/**
 * File 2: Business Logic (List, Set, Map, Concurrent Collections)
 * - Manajemen inventori dengan ConcurrentHashMap
 * - Antrian pesanan dengan PriorityBlockingQueue
 * - Kategori produk dengan Set
 */

import java.util.*;
import java.util.concurrent.*;

public class InventoryService {
    // ConcurrentHashMap untuk thread-safe inventory (Map)
    private final ConcurrentHashMap<String, Integer> stock = new ConcurrentHashMap<>();
    
    // PriorityBlockingQueue untuk antrian pesanan (Queue & Concurrent)
    private final PriorityBlockingQueue<Order> orderQueue = new PriorityBlockingQueue<>();
    
    // Set untuk kategori unik (Concurrent)
    private final Set<String> categories = ConcurrentHashMap.newKeySet();
    
    // List untuk riwayat pesanan (synchronized List)
    private final List<Order> orderHistory = Collections.synchronizedList(new ArrayList<>());

    // Tambah stok produk
    public void addStock(Product product, int quantity, String category) {
        stock.put(product.id(), quantity);
        categories.add(category); // Set unik
    }

    // Place order dengan validasi Optional
    public Optional<String> placeOrder(Order order) {
        return Optional.ofNullable(stock.compute(order.product().id(), (k, v) -> {
            if (v == null || v < order.quantity()) {
                return v; // Tidak cukup stok
            }
            orderQueue.offer(order); // Tambah ke antrian
            return v - order.quantity();
        })).filter(newStock -> newStock >= 0)
          .map(newStock -> "Order placed, remaining stock: " + newStock);
    }

    // Proses antrian (Concurrent)
    public void processOrders() {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                while (!orderQueue.isEmpty()) {
                    Order order = orderQueue.poll();
                    if (order != null) {
                        orderHistory.add(order); // List
                        System.out.println("Diproses: " + order);
                    }
                }
            });
        }
        executor.shutdown();
    }

    // Getter for orderHistory
    public List<Order> getOrderHistory() {
        return orderHistory;
    }
}
