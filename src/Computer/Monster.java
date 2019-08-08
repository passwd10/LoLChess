package Computer;

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

    public double getPower() { return this.power; }
    public String getName() { return this.name; }
    public double getHp() { return this.hp; }
    public double getAttackSpeed() {return this.attackSpeed; }
    public int getArmor() { return this.armor; }
}
