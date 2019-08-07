package Champion;

import ChamClass.Assasin;
import Common.Attackable;
import Common.BeAttackable;

public class Akali extends Champion implements Assasin {

    public Akali(String name, String chamClass, String tribe, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
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
    public void useSkill(BeAttackable target) {

        if (mp >= getMAX_MP()) {
            System.out.println("오연투척검 발동"); //150, 275, 400
            if (getGrade() == 1) { //1성일때
                //target.setHp() -= 150;
            } else if (getGrade() == 2) { //2성일때
                //targetHp -= 275;
            } else if (getGrade() == 3) { //3성일떄
                //targetHp -= 400;
            }
            mp = 0;

        } else {

        }
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

    @Override
    public void classSynergy() {

    }
}
