package logic;

public class Enemy {
    private String name;
    private Stats stats;

    public Enemy(String name, Stats stats) {
        this.name = name;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void attack(Player player) {
        int damage = stats.getAttack(); // Damage based on enemy stats
        System.out.println(name + " attacks " + player.getName() + " for " + damage + " damage!");
        player.takeDamage(damage);
    }

    public void takeDamage(int damage) {
        stats.setHealth(stats.getHealth() - damage);
        System.out.println(name + " takes " + damage + " damage! Remaining health: " + stats.getHealth());
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
}
