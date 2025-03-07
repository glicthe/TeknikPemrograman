public class Staff extends Weapon implements Equipable {
    public Staff() {
        super("Staff");
    }

    @Override
    public int getDamage() {
        return 350; // Damage value for the staff
    }

    @Override
    public void equip() {
        System.out.println("Equipped the " + weaponName); // Implementing equip method
    }
}
