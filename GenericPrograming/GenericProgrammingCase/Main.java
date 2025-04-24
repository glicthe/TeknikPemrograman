// ===== UPDATED FILE 7: Main.java =====
// Main class demonstrating all components and interactivity with battle system and inventory management

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameRunning = true;
        int levelStage = 1;

        // Create game entities
        Weapon startingWeapon = new Weapon(101, "Rusty Sword", 15, 10);
        Potion healingPotion = new Potion("POT-001", "Healing Potion", 2, "Restores 20 HP");
        Monster currentMonster = new Monster("Goblin", 200, 15);
        CharacterProfile<String, Integer> warrior = 
            new CharacterProfile<>("WAR-001", 1, "Warrior", 100.0, 5.0, 3.0);

        // Initialize inventories
        Inventory<Weapon> weaponInventory = new Inventory<>(5);
        Inventory<Potion> potionInventory = new Inventory<>(10);

        // Initial equipment and inventory setup
        weaponInventory.addItem(startingWeapon);
        potionInventory.addItem(healingPotion); // Use the healingPotion variable
        warrior.equipWeapon(startingWeapon);

        System.out.println("=== Game Started ===");
        System.out.println("Welcome to the realm of adventure!");

        while (gameRunning) {
            // Clear terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Display game status
            System.out.println("=== Game Status ===");
            System.out.println("Level Stage: " + levelStage);
            System.out.println("Monster: " + currentMonster.getName() + " (Level " + currentMonster.getLevel() + ")");
            System.out.println("Monster Health: " + currentMonster.getHealth());
            System.out.println("Player Health: " + warrior.getHealth());
            System.out.println("====================");
            System.out.println("What would you like to do?");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Manage Inventory");
            System.out.println("4. Check Stats");
            System.out.println("0. Exit game");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // Attack
                    double playerDamage = warrior.calculateAttackDamage();
                    System.out.println("You attack the " + currentMonster.getName() + " for " + playerDamage + " damage!");
                    currentMonster.setHealth(currentMonster.getHealth() - playerDamage);
                    
                    // Check if monster is defeated
                    if (currentMonster.getHealth() <= 0) {
                        System.out.println("You have defeated the " + currentMonster.getName() + "!");
                        levelStage++;
                        // Increase player stats and reset health
                        warrior.setHealth(100.0 + (levelStage - 1) * 5);
                        warrior.setAttack(warrior.getAttack() + 5);
                        warrior.setDefense(warrior.getDefense() + 5);
                        // Create a new monster for the next level
                        currentMonster = new Monster(
                            currentMonster.getName(),
                            currentMonster.getBaseHealth(),
                            currentMonster.getBaseAttack()
                        );
                        currentMonster.levelUp();
                    }
                    break;
                case 2: // Defend
                    System.out.println("You prepare to defend against the next attack.");
                    break;
                case 3: // Manage Inventory
                    manageInventory(scanner, warrior, weaponInventory, potionInventory);
                    break;
                case 4: // Check Stats
                    System.out.println("=== Player Stats ===");
                    System.out.println("Class: " + warrior.getClassName());
                    System.out.println("Health: " + warrior.getHealth());
                    System.out.println("Attack: " + warrior.getAttack());
                    System.out.println("Defense: " + warrior.getDefense());
                    System.out.println("Equipped Weapon: " + warrior.getEquippedWeapon().getName());
                    break;
                case 0: // Exit
                    System.out.println("Exiting game...");
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }

            // Monster turn (only after attack or defend)
            if (choice == 1 || choice == 2) { // Only let monster attack if player chose attack or defend
                double monsterDamage = currentMonster.getAttack();
                System.out.println("The " + currentMonster.getName() + " attacks you for " + monsterDamage + " damage!");
                warrior.takeDamage(monsterDamage);
                
                // Check if player is defeated
                if (warrior.isDefeated()) {
                    System.out.println("You have been defeated!");
                    gameRunning = false;
                }
            }

            // Wait for user to read output before clearing screen
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }

        scanner.close();
    }

    // New method for inventory management
    private static void manageInventory(Scanner scanner, CharacterProfile<String, Integer> warrior, Inventory<Weapon> weaponInventory, Inventory<Potion> potionInventory) {
        boolean managingInventory = true;

        while (managingInventory) {
            // Clear terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("=== Inventory Management ===");
            System.out.println("1. View Weapons");
            System.out.println("2. View Potions");
            System.out.println("3. Equip Weapon");
            System.out.println("4. Use Potion");
            System.out.println("0. Back");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: // View Weapons
                    System.out.println("=== Weapons ===");
                    for (int i = 0; i < weaponInventory.getItems().size(); i++) {
                        Weapon weapon = weaponInventory.getItems().get(i);
                        System.out.println((i + 1) + ". " + weapon.getName() + " (ID: " + weapon.getItemId() + ", Damage: " + weapon.getDamage() + ")");
                    }
                    break;
                case 2: // View Potions
                    System.out.println("=== Potions ===");
                    for (int i = 0; i < potionInventory.getItems().size(); i++) {
                        Potion potion = potionInventory.getItems().get(i);
                        System.out.println((i + 1) + ". " + potion.getName() + " (ID: " + potion.getItemId() + ", Effect: " + potion.getEffect() + ")");
                    }
                    break;
                case 3: // Equip Weapon
                    System.out.println("=== Equip Weapon ===");
                    for (int i = 0; i < weaponInventory.getItems().size(); i++) {
                        Weapon weapon = weaponInventory.getItems().get(i);
                        System.out.println((i + 1) + ". " + weapon.getName());
                    }
                    System.out.print("Select weapon to equip (0 to cancel): ");
                    int weaponChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (weaponChoice > 0 && weaponChoice <= weaponInventory.getItems().size()) {
                        Weapon selectedWeapon = weaponInventory.getItems().get(weaponChoice - 1);
                        warrior.equipWeapon(selectedWeapon);
                        System.out.println("Equipped " + selectedWeapon.getName());
                    }
                    break;
                case 4: // Use Potion
                    System.out.println("=== Use Potion ===");
                    for (int i = 0; i < potionInventory.getItems().size(); i++) {
                        Potion potion = potionInventory.getItems().get(i);
                        System.out.println((i + 1) + ". " + potion.getName());
                    }
                    System.out.print("Select potion to use (0 to cancel): ");
                    int potionChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    if (potionChoice > 0 && potionChoice <= potionInventory.getItems().size()) {
                        Potion selectedPotion = potionInventory.getItems().get(potionChoice - 1);
                        // For demonstration, restore 20 HP
                        warrior.setHealth(warrior.getHealth() + 20);
                        System.out.println("Used " + selectedPotion.getName() + ". Restored 20 HP.");
                        potionInventory.removeItem(potionChoice - 1); // Removed item from inventory
                    }
                    break;
                case 0: // Back
                    managingInventory = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }

            // Wait for user to read output before clearing screen
            System.out.print("Press Enter to continue...");
            scanner.nextLine();
        }
    }
}