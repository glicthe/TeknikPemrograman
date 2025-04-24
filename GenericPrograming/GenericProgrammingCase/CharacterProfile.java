// ===== UPDATED FILE 6: CharacterProfile.java =====
// Class with multiple type parameters and new character stats
public class CharacterProfile<K, V> {
    private K characterId;
    private V characterLevel;
    private String className;
    private double health;       // New stat
    private double attack;       // New stat
    private double defense;      // New stat
    private Weapon equippedWeapon;

    public CharacterProfile(K id, V level, String className, double health, double attack, double defense) {
        this.characterId = id;
        this.characterLevel = level;
        this.className = className;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    // Generic method with bounded type parameter
    public <T extends Number> double calculatePowerLevel(T basePower) {
        return basePower.doubleValue() * ((Number) characterLevel).doubleValue();
    }

    // New method to calculate attack damage
    public double calculateAttackDamage() {
        if (equippedWeapon != null) {
            return attack * equippedWeapon.getDamage();
        }
        return attack;
    }

    // New method to take damage
    public void takeDamage(double damage) {
        double actualDamage = Math.max(damage - defense, 0);
        health -= actualDamage;
    }

    // New method to check if character is defeated
    public boolean isDefeated() {
        return health <= 0;
    }

    // New methods for equipping weapon
    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    // Getters for new stats
    public double getHealth() { return health; }
    public double getAttack() { return attack; }
    public double getDefense() { return defense; }

    // Setters for demonstration (normally you'd have better state management)
    public void setHealth(double health) { this.health = health; }
    public void setAttack(double attack) { this.attack = attack; }
    public void setDefense(double defense) { this.defense = defense; }

    // Existing getters
    public K getCharacterId() { return characterId; }
    public V getCharacterLevel() { return characterLevel; }
    public String getClassName() { return className; }
}