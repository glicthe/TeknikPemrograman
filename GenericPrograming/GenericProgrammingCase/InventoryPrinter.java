// ===== FILE 5: InventoryPrinter.java =====
// Class demonstrating wildcard parameters
import java.util.List;

public class InventoryPrinter {
    // Unbounded wildcard for printing any inventory
    public static void printInventoryContents(List<?> inventory) {
        System.out.println("=== Inventory Contents ===");
        inventory.forEach(item -> {
            if (item instanceof GameItem) {
                GameItem<?> gi = (GameItem<?>) item;
                System.out.printf("ID: %s | Name: %s%n", gi.getItemId(), gi.getName());
            }
        });
    }
}