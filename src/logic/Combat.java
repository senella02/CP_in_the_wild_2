package logic;

import java.util.Scanner;

public class Combat {
    private Player player;
    private Enemy enemy;

    public Combat(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public boolean startCombat() {
        Scanner scanner = new Scanner(System.in);

        while (player.getStats().getHealth() > 0 && enemy.getStats().getHealth() > 0) {

            player.attack(enemy);
            // Check if enemy is still alive before attacking back
            if (enemy.getStats().getHealth() > 0) {
                System.out.println(enemy.getStats().getHealth() + " remaining.");
                enemy.takeDamage(player.getStats().getAttack());
            }
        }

        if (player.getStats().getHealth() <= 0) {
            System.out.println("You were defeated.");
            return false;
        } else {
            System.out.println("You defeated " + enemy.getStats().getHealth() + "!");
            return true;
        }
    }
}
