// ===== UPDATED FILE: Monster.java =====
// Class representing monsters with scaling stats and new methods

public class Monster {
    private String name;
    private int level;
    private double health;
    private int attack;
    private int baseHealth;
    private int baseAttack;

    public Monster(String name, int baseHealth, int baseAttack) {
        this.name = name;
        this.baseHealth = baseHealth;
        this.baseAttack = baseAttack;
        this.level = 1;
        updateStats();
    }

    // Update monster stats based on level
    public void updateStats() {
        this.health = baseHealth * level;
        this.attack = baseAttack * level;
    }

    // Level up the monster
    public void levelUp() {
        level++;
        updateStats();
    }

    // New method to set health directly
    public void setHealth(double health) {
        this.health = health;
    }

    // Getter methods
    public String getName() { return name; }
    public int getLevel() { return level; }
    public double getHealth() { return health; }
    public int getAttack() { return attack; }
    public int getBaseHealth() { return baseHealth; }
    public int getBaseAttack() { return baseAttack; }
}