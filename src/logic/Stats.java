package logic;

public class Stats {
    private int health;
    private int experience;
    private int gold;
    private int attack;

    public Stats(int health, int experience, int gold, int attack) {
        this.health = health;
        this.experience = experience;
        this.gold = gold;
        this.attack = attack; // Initialize attack stat
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAttack() {
        return attack; // Getter for attack
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}


