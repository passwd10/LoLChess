package Champion;

import Common.AllUnit;
import Common.*;
import Common.BeAttackable;
import MyInfo.Deck;

public class Ashe extends Champion {

    public Ashe(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
        super(name, chamClass, tribe, tier, hp, mp, power, attackSpeed, armor, gold, grade);
    }

    @Override
    public void attack(BeAttackable target) {
        setMp(getMp() + 8); //때릴때 마다 8씩 회복

        /* 공격속도에 따른 실행 시간 차이
        double aa = 100 * getAttackSpeed();

        int time = 100000/(int)aa;

        try{
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (getMp() > getMAX_MP()) {
            setMp(getMAX_MP());
        }

        System.out.print(getName());
        System.out.print(" [ HP " + Math.round(getHp())+" "); //때린놈의 상태
        System.out.println("/ MP " + getMp() +" ]");
        System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");

    }

    @Override
    public void beAttacked(Attackable attacker) {

        setMp(getMp() + 8) ; //맞을때 마다 8씩 회복
        setHp(getHp() - attacker.getPower() * 100 / (100 + getArmor())); //hp 깎임

        if (getHp() < 0) {
            setHp(0);
        }

        if (getMp() > getMAX_MP()) {
            setMp(getMAX_MP());
        }

        System.out.print(getName());
        System.out.print(" [ HP " + Math.round(getHp()) + " "); //맞은놈의 상태
        System.out.println("/ MP " + getMp() + " ]");
        System.out.println();

    }

    @Override
    public void classSynergy(Deck deck) {

    }

    @Override
    public int useSkill(AllUnit[] target) {
        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                target[0].setHp(target[0].getHp()-200);
            } else if (getGrade() == 2) { //2성일때
                target[0].setHp(target[0].getHp()-400);
            } else if (getGrade() == 3) { //3성일떄
                target[0].setHp(target[0].getHp()-600);
            }
            setMp(0);
            target[0].setMp(target[0].getMp() + 20);

            System.out.print(getName());
            System.out.print(" [ HP " + Math.round(getHp()) + " "); //스킬 사용한 놈의 상태
            System.out.println("/ MP " + getMp() + " ]");
            System.out.println("[Skill] 마법의 수정화살 "); //150, 275, 400
            System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");
        }
        return 1;
    }


}
