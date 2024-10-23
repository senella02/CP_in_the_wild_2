package logic;
import java.util.List;
import java.util.Scanner;

public class Shop {
    private List<Item> items;

    public Shop(List<Item> items) {
        this.items = items;
    }

    public void openShop(Player player) {
        System.out.println("Welcome to the shop! Available items:");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ") " + item.getName() + " - Cost: " + item.getCost() + " gold");
        }

        System.out.println("Choose an item to buy (1-" + items.size() + ") or 0 to exit:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= items.size()) {
            Item selectedItem = items.get(choice - 1);
            if (player.getGold() >= selectedItem.getCost()) {
                player.spendGold(selectedItem.getCost());
                player.addItem(selectedItem); // Add the item to the player's inventory
                System.out.println(selectedItem.getName() + " purchased successfully!");
            } else {
                System.out.println("Not enough gold to buy " + selectedItem.getName() + ".");
            }
        } else if (choice == 0) {
            System.out.println("Exiting the shop.");
        } else {
            System.out.println("Invalid choice.");
        }
    }
}
