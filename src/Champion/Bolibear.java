package Champion;

import Common.AllUnit;
import Common.*;
import Common.BeAttackable;
import MyInfo.Deck;

public class Bolibear extends Champion {

    public Bolibear(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
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
    public void useSkill(AllUnit champion) {
        //볼리베어의 공격이 강화되어 여러 적에게 연쇄 피해를 입히고 적중 시 효과를 적용합니다.
        //최대 튕기는 횟수 : 2 / 3 / 4
        //연쇄 공격 피해량 증가율 : 0.8 / 0.9 / 1
    }

    @Override
    public void useSkill(Champion champion1, Champion champion2) {
        if (getGrade() == 1) { //1성일때
            if (getMp() >= getMAX_MP()) {
                champion1.setHp(champion1.getHp() -getPower() * 0.8);
                champion2.setHp(champion2.getHp() -getPower() * 0.8);

                champion1.setMp(champion1.getMp() + 20);
                champion2.setMp(champion2.getMp() + 20);

                setMp(0);

                System.out.print(getName());
                System.out.print(" [ HP " + Math.round(getHp()) + " "); //스킬 사용한 놈의 상태
                System.out.println("/ MP " + getMp() + " ]");
                System.out.println("[Skill] 천둥 발톱 "); //150, 275, 400
                System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");
            } else {

            }
        }
    }

    @Override
    public void useSkill(Champion champion1, Champion champion2, Champion champion3) {
        if (getGrade() == 2) { //1성일때
            if (getMp() >= getMAX_MP()) {
                champion1.setHp(getHp() -getPower() * 0.9);
                champion2.setHp(getHp() -getPower() * 0.9);
                champion3.setHp(getHp() -getPower() * 0.9);


                champion1.setMp(getMp() + 20);
                champion2.setMp(getMp() + 20);
                champion3.setMp(getMp() + 20);

                setMp(0);

                System.out.print(getName());
                System.out.print(" [ HP " + Math.round(getHp()) + " "); //스킬 사용한 놈의 상태
                System.out.println("/ MP " + getMp() + " ]");
                System.out.println("[Skill] 천둥 발톱 "); //150, 275, 400
                System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");
            } else {

            }
        }
    }

    @Override
    public void useSkill(Champion champion1, Champion champion2, Champion champion3, Champion champion4) {
        if (getGrade() == 3) { //1성일때
            if (getMp() >= getMAX_MP()) {
                champion1.setHp(getHp() -getPower());
                champion2.setHp(getHp() -getPower());
                champion3.setHp(getHp() -getPower());
                champion4.setHp(getHp() -getPower());


                champion1.setMp(getMp() + 20);
                champion2.setMp(getMp() + 20);
                champion3.setMp(getMp() + 20);
                champion4.setMp(getMp() + 20);

                setMp(0);

                System.out.print(getName());
                System.out.print(" [ HP " + Math.round(getHp()) + " "); //스킬 사용한 놈의 상태
                System.out.println("/ MP " + getMp() + " ]");
                System.out.println("[Skill] 천둥 발톱 "); //150, 275, 400
                System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓");
            } else {

            }
        }
    }

    @Override
    public void classSynergy(Deck deck) {
        int cnt=0;

        for(int i=0; i<deck.deckSize(); i++) {
            if(deck.retCham(i).getcClass().equals("싸움꾼")) {
                cnt++;
            }
        }

        if(cnt>=3 && cnt<6) {
            System.out.println("■■■ 볼리베어 싸움꾼 (초기)특성 발동 ■■■■\t [HP + 300]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("볼리베어")){
                    deck.retCham(i).setHp(getHp() + 300); // 추가체력 300
                }
            }
        }
        else if(cnt >= 6) {
            System.out.println("■■■ 볼리베어 싸움꾼 (최종)특성 발동 ■■■■\t [HP + 700]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("볼리베어")){
                    deck.retCham(i).setHp(getHp() + 700); // 추가체력 700
                }
            }
        }
    }
}
