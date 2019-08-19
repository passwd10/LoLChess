package Computer;


import Common.*;
import Common.BeAttackable;

public class Dragon extends Monster {

    public Dragon(String name, double hp, int mp, double power, double attackSpeed, double armor) {
        super(name, hp, mp, power, attackSpeed, armor);
    }

    @Override
    public void attack(BeAttackable target) {
        System.out.print(getName());
        System.out.print(" [ HP " + Math.round(getHp())+" "); //때린놈의 상태
        System.out.println("/ MP " + getMp() +" ]");
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");
    }

    @Override
    public void beAttacked(Attackable attacker) {
        setHp(getHp()-attacker.getPower() * 100 / (100 + getArmor())); //hp 깎임

        if (getHp() < 0) {
            setHp(0);
        }

        System.out.print(getName());
        System.out.print(" [ HP " + Math.round(getHp()) + " "); //맞은놈의 상태
        System.out.println("/ MP " + getMp() + " ]");
        System.out.println();
    }

}
