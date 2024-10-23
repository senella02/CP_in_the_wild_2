package logic;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void useItem(String itemName, Player character) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                item.use(character);
                items.remove(item);
                break;
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }
}

