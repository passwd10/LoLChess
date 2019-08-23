package Computer;

import Champion.*;
import Common.*;
import Common.BeAttackable;
import MyInfo.Deck;

public class Minion extends Monster {

    public Minion(String name, double hp, int mp, double power, double attackSpeed, double armor) {
        super(name, hp, mp, power, attackSpeed, armor);
    }

    @Override
    public void attack(BeAttackable target) {

    }

    @Override
    public void beAttacked(Attackable attacker) {
        setHp(getHp()-attacker.getPower() * 100 / (100 + getArmor())); //hp 깎임

        if (getHp() < 0) {
            setHp(0);
        }

    }


}
