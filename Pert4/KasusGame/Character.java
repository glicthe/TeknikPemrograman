// Abstract class representing a game character
public abstract class Character {
    protected String name;
    protected int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public abstract void attack(); // Abstract method for attacking
   

    public void takeDamage(int damage) {
        health -= damage; // Reduce health by damage taken
        System.out.println(name + " took " + damage + " damage. Remaining health: " + health);
    }

    public void defend() {
        System.out.println(name + " is defending!"); // Default defend action
    }
}
