package Common;

public interface BeAttackable {
    //공격 당할 수 있는 챔피언
    public void beAttacked(Attackable attacker);

    public String getName();
    public double getHp();
    public int getMp();
    public double getArmor();
    public double getPower();
    public int getMAX_MP();
    public double getMAX_HP();
}
