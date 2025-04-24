// ===== FILE 3: ItemProcessor.java =====
// Generic interface with type parameter
public interface ItemProcessor<T extends GameItem<?>> {
    void processItem(T item);
    T enhanceItem(T item, int enhancementValue);
}