package game;
import logic.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GameSystem {
    private Player player;
    private List<Quest> availableQuests;
    private final Shop shop;

    public GameSystem() {
        availableQuests = new ArrayList<>();
        availableQuests.add(new Quest("Defeat the Goblin King", "Kill the Goblin King in the forest", 50, 100, new Enemy("Goblin King", new Stats(80, 0, 10, 3))));
        availableQuests.add(new Quest("Rescue the Villager", "Defeat the bandits and rescue the villager", 70, 150, new Enemy("Bandit Leader", new Stats(90, 0, 12, 5))));
        availableQuests.add(new Quest("Find the Lost Treasure", "Fight through a dungeon and find the treasure", 100, 200, new Enemy("Dungeon Beast", new Stats(100, 0, 15, 7))));
        availableQuests.add(new Quest("Slay the Forest Troll", "Hunt down and defeat the Forest Troll that has been terrorizing the nearby villages.", 100, 200, new Enemy("Forest Troll", new Stats(120, 0, 10, 5))));
        availableQuests.add(new Quest("Protect the Merchant Caravan", "Defend the merchant caravan from bandit attacks while they travel through the forest.", 80, 150, new Enemy("Bandit", new Stats(50, 0, 8, 2))));
        availableQuests.add(new Quest("Retrieve the Stolen Gem", "A valuable gem has been stolen by a cunning thief. Track down the thief and retrieve the gem.", 90, 180, new Enemy("Cunning Thief", new Stats(70, 0, 12, 3))));
        availableQuests.add(new Quest("Investigate the Haunted Cave", "Explore the haunted cave and uncover the mystery behind the ghost sightings.", 70, 160, new Enemy("Ghost", new Stats(60, 0, 5, 0))));
        availableQuests.add(new Quest("Defend the Castle Walls", "Join the castle guard to fend off an attack by an invading army.", 120, 250, new Enemy("Invading Soldier", new Stats(100, 0, 15, 8))));
        // Create a new Shop instance
        shop = new Shop();
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the RPG Game!");
        System.out.println("Choose your character class: 1) Warrior 2) Mage 3) Archer");
        int choice = scanner.nextInt();

        switch (choice) {
            case 2: player = new Player("Mage", new Stats(80, 50, 10, 3)); break;
            case 3: player = new Player("Archer", new Stats(90, 0, 12, 4)); break;
            default: player = new Player("Warrior", new Stats(100, 0, 15, 5)); break;
        }

        chooseQuest();
    }

    public void chooseQuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a quest:");

        for (int i = 0; i < availableQuests.size(); i++) {
            System.out.println((i + 1) + ") " + availableQuests.get(i).getQuestName() + " - " + availableQuests.get(i).getQuestDescription());
        }

        int questChoice = scanner.nextInt();
        Quest selectedQuest = availableQuests.get(questChoice - 1);
        System.out.println("You selected: " + selectedQuest.getQuestName());

        // Start combat for the selected quest
        Combat combat = new Combat(player, selectedQuest.getEnemy());
        boolean questCompleted = combat.startCombat();

        if (questCompleted) {
            System.out.println("You have completed the quest: " + selectedQuest.getQuestName());
            player.gainExperience(selectedQuest.getRewardXP());
            player.earnGold(selectedQuest.getRewardGold());
            shop.openShop(player); // Open the shop after completing the quest
        } else {
            System.out.println("You failed the quest...");
        }

        // Offer to start a new quest or quit
        System.out.println("Do you want to choose another quest? (yes/no)");
        String response = scanner.next();

        if (response.equalsIgnoreCase("yes")) {
            chooseQuest();
        } else {
            System.out.println("Game over. Thanks for playing!");
        }
    }
}
