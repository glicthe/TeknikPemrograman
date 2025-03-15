package KasusJCF;

/**
 * File 1: Data Model (Record & Immutable Collection)
 * - Record untuk menyimpan data produk
 * - Contoh penggunaan Immutable Collection
 */
import java.util.List;

public record Product(
    String id,
    String name,
    double price,
    List<String> tags // Immutable List.of()
) {
    // Contoh factory method dengan Immutable List
    public static Product create(String id, String name, double price, String... tags) {
        return new Product(id, name, price, List.of(tags)); // Immutable List
    }
}
