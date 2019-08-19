package Computer;

import Common.AllUnit;

public abstract class Monster extends AllUnit {

    private double power;
    private String name;
    private double hp;
    private double attackSpeed;
    private double armor;
    private int mp;
    private final double MAX_HP; //전체 체력

    public Monster(String name, double hp,int mp, double power, double attackSpeed, double armor) {
        this.name = name;
        this.hp = hp;
        MAX_HP = hp;
        this.power= power;
        this.attackSpeed = attackSpeed;
        this.armor = armor;
        this.mp = mp;
    }

    public String getName() { return this.name; }
    public double getHp() { return this.hp; }
    public double setHp(double hp) { return this.hp = hp;}
    public double getAttackSpeed() {return this.attackSpeed; }
    public double getArmor() { return this.armor; }
    public int setMp(int mp) {return this.mp = mp;}
    public double getPower() { return this.power; }

    @Override
    public int getMAX_MP() {
        return this.mp;
    }

    @Override
    public double getMAX_HP() {
        return this.MAX_HP;
    }

    @Override
    public int getMp() {
        return this.mp;
    }

}
