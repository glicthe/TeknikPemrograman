public class Mage extends Character implements Actions, Equipable {
    private Weapon weapon;

    public Mage(String name, int health, Weapon weapon) {
        super(name, health);
        this.weapon = weapon;
    }

    @Override
    public void attack() {
        System.out.println(name + " casts a spell with " + weapon.weaponName + " for " + weapon.getDamage() + " damage.");
    }

    @Override
    public void equip() {
        System.out.println("Equipped the " + weapon.weaponName);
    }
}