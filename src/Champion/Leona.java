package Champion;

import Common.Attackable;
import Common.BeAttackable;
import MyInfo.Deck;

public class Leona extends Champion {

    public Leona(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
        super(name, chamClass, tribe, tier, hp, mp, power, attackSpeed, armor, gold, grade);
    }

    @Override
    public void attack(BeAttackable target) {
        
    }

    @Override
    public void beAttacked(Attackable attacker) {

    }

    @Override
    public void classSynergy(Deck deck) {

    }

    @Override
    public void useSkill(Champion champion) {

    }

    @Override
    public void useSkill(Champion champion1, Champion champion2) {

    }

    @Override
    public void useSkill(Champion champion1, Champion champion2, Champion champion3) {

    }

    @Override
    public void useSkill(Champion champion1, Champion champion2, Champion champion3, Champion champion4) {

    }
}