package logic;

public class Quest {
    private String questName;
    private String questDescription;
    private int rewardXP;
    private int rewardGold;
    private Enemy enemy;

    public Quest(String questName, String questDescription, int rewardXP, int rewardGold, Enemy enemy) {
        this.questName = questName;
        this.questDescription = questDescription;
        this.rewardXP = rewardXP;
        this.rewardGold = rewardGold;
        this.enemy = enemy;
    }

    public String getQuestName() {
        return questName;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public int getRewardXP() {
        return rewardXP;
    }

    public int getRewardGold() {
        return rewardGold;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
