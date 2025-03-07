public abstract class Weapon {
    protected String weaponName;

    public Weapon(String weaponName) {
        this.weaponName = weaponName;
    }

    public abstract void equip(); // Abstract method untuk equipping
    public abstract int getDamage(); // Abstract method untuk mendapatkan weapon damage
}
