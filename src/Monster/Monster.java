package Monster;

public class Monster {

    private double power;
    private String name;
    private double hp;
    private double attackSpeed;
    private int armor;

    public Monster(String name, double hp, double power, double attackSpeed, int armor) {
        this.name = name;
        this.hp = hp;
        this.power= power;
        this.attackSpeed = attackSpeed;
        this.armor = armor;
    }
}
