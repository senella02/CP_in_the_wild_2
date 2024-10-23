package logic;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Stats stats; // Use Stats class for player stats
    private List<Item> inventory; // Player's inventory

    public Player(String name, int health, int experience, int gold) {
        this.name = name;
        this.stats = new Stats(health, experience, gold, 10); // Initialize stats with a default attack value
        this.inventory = new ArrayList<>(); // Initialize inventory
    }

    public int getHealth() {
        return stats.getHealth(); // Get health from Stats
    }

    public int getGold() {
        return stats.getGold(); // Get gold from Stats
    }

    public void attack(Enemy enemy) {
        int damage = stats.getAttack(); // Use player's attack stat
        System.out.println(name + " attacks " + enemy.getName() + " for " + damage + " damage!");
        enemy.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        stats.setHealth(stats.getHealth() - damage);
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + stats.getHealth());
    }

    public void gainExperience(int exp) {
        stats.setExperience(stats.getExperience() + exp); // Update experience
        System.out.println(name + " gains " + exp + " experience! Total experience: " + stats.getExperience());
    }

    public void addGold(int gold) {
        stats.setGold(stats.getGold() + gold); // Update gold
        System.out.println(name + " gains " + gold + " gold! Total gold: " + stats.getGold());
    }

    public void spendGold(int amount) {
        if (amount <= stats.getGold()) {
            stats.setGold(stats.getGold() - amount);
            System.out.println(name + " spends " + amount + " gold. Remaining gold: " + stats.getGold());
        } else {
            System.out.println("Not enough gold to spend!");
        }
    }

    public void addItem(Item item) {
        inventory.add(item);
        System.out.println(name + " has acquired " + item.getName() + "!");
    }

    public void useItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                // Here you can define how the item affects the player
                System.out.println(name + " uses " + item.getName() + "!");
                inventory.remove(item);
                return;
            }
        }
        System.out.println("Item not found in inventory.");
    }

    public void showInventory() {
        System.out.println(name + "'s Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
}
