public class Sword extends Weapon implements Equipable {
    public Sword() {
        super("Sword");
    }

    @Override
    public int getDamage() {
        return 250; // Damage value for the sword
    }

    @Override
    public void equip() {
        System.out.println("Equipped the " + weaponName); // Implementing equip method
    }
}