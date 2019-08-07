package Champion;

import Common.Attackable;
import Common.BeAttackable;

public class Chogas extends Champion {

    public Chogas(String name, String chamClass, String tribe, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
        super(name, chamClass, tribe, hp, mp, power, attackSpeed, armor, gold, grade);
    }

    @Override
    public void attack(BeAttackable target) {
        mp += 5; //때릴때 마다 5씩 회복

        /*
        double aa = 100 * getAttackSpeed();

        int time = 100000/(int)aa;

        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.print(getName());
        System.out.print(" [ HP " + Math.round(hp)+" "); //때린놈의 상태
        System.out.println("/ MP " + mp+" ]");

        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");

    }

    @Override
    public void beAttacked(Attackable attacker) {

        mp += 5; //맞을때 마다 5씩 회복

        hp -= attacker.getPower()*100/(100+getArmor()); //hp 깎임

        System.out.print(getName());
        System.out.print(" [ HP " + Math.round(hp)+" "); //맞은놈의 상태
        System.out.println("/ MP " + mp+" ]");
        System.out.println();
    }

    @Override
    public void classSynergy() {

    }

    @Override
    public void useSkill(BeAttackable target) {

    }

    @Override
    public void useSkill(BeAttackable target1, BeAttackable target2) {

    }

    @Override
    public void useSkill(BeAttackable target1, BeAttackable target2, BeAttackable target3) {

    }

    @Override
    public void useSkill(BeAttackable target1, BeAttackable target2, BeAttackable target3, BeAttackable target4) {

    }
}
