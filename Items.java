public class Items {
    private String name;
    private int damageBoost;
    private int healthBoost;

    public Items(String name, int damageBoost, int healthBoost) {
        this.name = name;
        this.damageBoost = damageBoost;
        this.healthBoost = healthBoost;
    }

    public String getName() {
        return name;
    }

    public int getDamageBoost() {
        return damageBoost;
    }

    public int getHealthBoost() {
        return healthBoost;
    }
}