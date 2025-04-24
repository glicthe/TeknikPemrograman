// ===== FILE 1: GameItem.java =====
// Base class for game items demonstrating inheritance with generics
public abstract class GameItem<T> {
    protected T itemId;
    protected String name;
    protected int weight;

    public GameItem(T itemId, String name, int weight) {
        this.itemId = itemId;
        this.name = name;
        this.weight = weight;
    }

    public abstract void useItem();  // Abstract method to be implemented by subclasses

    public T getItemId() { return itemId; }
    public String getName() { return name; }
    public int getWeight() { return weight; }
}

// Weapon subclass with Integer ID
class Weapon extends GameItem<Integer> {
    private int damage;

    public Weapon(Integer id, String name, int weight, int damage) {
        super(id, name, weight);
        this.damage = damage;
    }
    
    // Add getter for damage
    public int getDamage() { 
        return damage; 
    }

    @Override
    public void useItem() {
        System.out.printf("Using %s! Deals %d damage%n", name, damage);
    }
}

// Potion subclass with String ID
class Potion extends GameItem<String> {
    private String effect;

    public Potion(String id, String name, int weight, String effect) {
        super(id, name, weight);
        this.effect = effect;
    }

    // Add getter for effect
    public String getEffect() {  // Added getEffect() method
        return effect;
    }

    @Override
    public void useItem() {
        System.out.printf("Drinking %s! Effect: %s%n", name, effect);
    }
}