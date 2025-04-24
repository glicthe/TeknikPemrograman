// ===== UPDATED FILE 2: Inventory.java =====
// Generic class with bounded type parameter
import java.util.ArrayList;
import java.util.List;

public class Inventory<T extends GameItem<?>> {
    private final List<T> items = new ArrayList<>();
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
    }

    // Generic method to add item if there's capacity
    public boolean addItem(T item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    // Method to remove item by index
    public T removeItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.remove(index);
        }
        return null;
    }

    // Method to get item by index
    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    // Wildcard parameter in method
    public int calculateTotalWeight(List<? extends GameItem<?>> items) {
        return items.stream().mapToInt(GameItem::getWeight).sum();
    }

    public List<T> getItems() { return new ArrayList<>(items); }
}