package KasusJCF;

/**
 * File 3: Data Transfer Object (Record & Comparable)
 * - Record untuk pesanan
 * - Implementasi Comparable untuk prioritas Queue
 */
import java.time.Instant;

public record Order(
    String id,
    Product product,
    int quantity,
    Instant timestamp,
    boolean isPriority // Prioritas untuk Queue
) implements Comparable<Order> {
    @Override
    public int compareTo(Order other) {
        // Prioritaskan pesanan isPriority=true
        int priorityCompare = Boolean.compare(other.isPriority, this.isPriority);
        return (priorityCompare != 0) ? priorityCompare : 
            this.timestamp.compareTo(other.timestamp);
    }
}