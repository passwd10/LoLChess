package Common;

public interface Attackable {
    //때릴 수 있는 챔피언

    public void attack(BeAttackable target);

    public String getName();
    public double getHp();
    public int getMp();
    public double getArmor();
    public double getPower();
    public int getMAX_MP();
    public double getMAX_HP();
}
