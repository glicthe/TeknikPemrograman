// ===== FILE 4: ItemEqualityChecker.java =====
// Utility class with generic method using parameters
public class ItemEqualityChecker {
    // Generic method to check item equality
    public static <T, U extends GameItem<T>> boolean areItemsEqual(U item1, U item2) {
        return item1.getItemId().equals(item2.getItemId()) &&
               item1.getName().equals(item2.getName());
    }
}