package logic;

public class Item {
    private String name; // Name of the item
    private int cost;    // Cost of the item
    private int effectAmount; // Amount of effect (like health restored or attack increase)
    private String itemType; // Type of item ("Potion" or "Weapon")

    // Constructor to initialize the item
    public Item(String name, int cost, int effectAmount, String itemType) {
        this.name = name;
        this.cost = cost;
        this.effectAmount = effectAmount; // Initialize effect amount
        this.itemType = itemType; // Initialize item type
    }

    // Getter for the item name
    public String getName() {
        return name;
    }

    // Getter for the item cost
    public int getCost() {
        return cost;
    }

    // Method to use the item
    public void use(Player player) {
        if (itemType.equalsIgnoreCase("Potion")) {
            System.out.println(player.getName() + " uses a " + name + "!");
            player.getStats().setHealth(player.getStats().getHealth() + effectAmount); // Increase health
        } else if (itemType.equalsIgnoreCase("Weapon")) {
            System.out.println(player.getName() + " equips a " + name + "!");
            player.getStats().setAttack(player.getStats().getAttack() + effectAmount); // Increase attack power
        }
    }

    // Optional: You can add a method to describe the item
    public String describe() {
        return name + " (Cost: " + cost + " gold, Effect: " + effectAmount + ")";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getEffectAmount() {
        return effectAmount;
    }

    public void setEffectAmount(int effectAmount) {
        this.effectAmount = effectAmount;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
