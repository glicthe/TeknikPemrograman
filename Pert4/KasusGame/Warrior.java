// Class representing a warrior character
public class Warrior extends Character implements Actions, Equipable {
    private Weapon weapon;

    public Warrior(String name, int health, Weapon weapon) {
        super(name, health);
        this.weapon = weapon;
    }

    @Override // interface implementation
    public void attack() {
        System.out.println(name + " attacks with " + weapon.weaponName + " for " + weapon.getDamage() + " damage.");
    } 

    @Override // interface implementation
    public void equip() {
        System.out.println("Equipped the " + weapon.weaponName);
    }
}
