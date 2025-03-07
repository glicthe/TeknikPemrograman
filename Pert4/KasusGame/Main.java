public class Main {
    public static void main(String[] args) {
        // Create weapons
        Weapon sword = new Sword();
        Weapon staff = new Staff();

        // Create characters
        Character warrior = new Warrior("Allain", 10000, sword);
        Character mage = new Mage("Ranggo", 8000, staff);

        // Equip weapons
        sword.equip();
        staff.equip(); 

        System.out.println();

        // Characters attack
        warrior.attack(); // Polymorphic call
        mage.attack();    // Polymorphic call

        System.out.println();

        // Characters take damage
        warrior.takeDamage(200);
        mage.takeDamage(300);

        System.out.println();

        // Characters defend
        warrior.defend(); // Polymorphic call
        mage.defend();    // Polymorphic call
    }
}