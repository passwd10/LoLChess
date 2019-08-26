package Champion;

import Common.AllUnit;
import Common.*;
import Common.BeAttackable;
import MyInfo.Deck;
import Output.*;

public class Chogas extends Champion {

    public Chogas(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
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


    }

    @Override
    public void beAttacked(Attackable attacker) {

        setMp(getMp() + 8); //맞을때 마다 8씩 회복
        setHp(getHp()-attacker.getPower() * 100 / (100 + getArmor())); //hp 깎임

        if (getHp() < 0) {
            setHp(0);
        }

        if (getMp() > getMAX_MP()) {
            setMp(getMAX_MP());
        }


    }


    @Override
    public int useSkill(AllUnit[] target) {
        //초가스가 땅을 파열시켜 대상 지역에 있는 적 모두를 기절시키고 피해를 입힙니다.
        //피해량 : 200 / 400 / 600
        //띄워올리기 지속시간 : 1.5 / 1.75 / 2
        VarietySkillActive varietySkillActive = new VarietySkillActive();
        StatusOutput statusOutput = new StatusOutput();

        int deal = 0;
        int targetNum = 0;

        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                deal = 200;
            }
            if (getGrade() == 2) { //2성일때
                deal = 400;
            }
            if (getGrade() == 3) { //3성일떄
                deal = 600;
            }

            targetNum = varietySkillActive.attackAll(target, deal);

            setMp(0);
            statusOutput.skillOutput("파  멸");
            return targetNum; //allCham
        }
        return 0;
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
            System.out.println("◎◎◎◎ 초가스 싸움꾼 (초기)특성 발동\t [HP + 300]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("초가스")){
                    deck.retCham(i).setHp(getHp() + 300); // 추가체력 300
                }
            }
        }
        else if(cnt >= 6) {
            System.out.println("◎◎◎◎ 초가스 싸움꾼 (최종)특성 발동\t [HP + 700]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("초가스")){
                    deck.retCham(i).setHp(getHp() + 700); //추가체력 700
                }
            }
        }
    }
}
