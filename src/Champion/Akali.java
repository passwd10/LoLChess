package Champion;

import ChamClass.Assasin;
import Common.Attackable;
import Common.BeAttackable;
import Common.ClassSynergy;
import MyInfo.Deck;

public class Akali extends Champion {

    public Akali(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
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

        setMp(getMp() + 8); //맞을때 마다 8씩 회복
        setHp(getHp() -attacker.getPower() * 100 / (100 + getArmor())); //hp 깎임

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
    public void useSkill(Champion champion) {

        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                champion.setHp(getHp()-150);
            } else if (getGrade() == 2) { //2성일때
                champion.setHp(getHp()-275);
            } else if (getGrade() == 3) { //3성일떄
                champion.setHp(getHp()-400);
            }
            setMp(0);
            champion.setMp(champion.getMp() + 20);

            System.out.print(getName());
            System.out.print(" [ HP " + Math.round(getHp()) + " "); //스킬 사용한 놈의 상태
            System.out.println("/ MP " + getMp() + " ]");
            System.out.println("[Skill] 오연투척검 "); //150, 275, 400
            System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");
        } else {

        }
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

    @Override
    public void classSynergy(Deck deck) {
        int cnt = 0;

        for (int i = 0; i < deck.deckSize(); i++) {
            if (deck.retCham(i).getcClass().equals("암살자")) {
                cnt++;
            }
        }

        if (cnt >= 3 && cnt < 6) {
            System.out.println("■■■■ 아칼리 암살자 (초기)특성 발동 ■■■■\t [공 x 1.5]");
            for (int i = 0; i < deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("아칼리")){
                    deck.retCham(i).setPower(getPower()*1.5);
                }
            }
        } else if (cnt >= 6) {
            System.out.println("■■■■ 아칼리 암살자 특성 발동(최종) ■■■■\t [공 x 3.0]");
            for (int i = 0; i < deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("아칼리")){
                    deck.retCham(i).setPower(getPower()*3.0);
                }
            }
        }
    }

}
