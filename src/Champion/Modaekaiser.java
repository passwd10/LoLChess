package Champion;

import Common.*;
import Common.BeAttackable;
import MyInfo.Deck;
import Output.*;

public class Modaekaiser extends Champion {

    public Modaekaiser(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
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
        //모데카이저가 전방에 철퇴를 내리쳐 일직선상에 있는 적 두 명에게 피해를 입힙니다.
        //피해량 : 200 / 325 / 450
        VarietySkillActive varietySkillActive = new VarietySkillActive();
        StatusOutput statusOutput = new StatusOutput();

        int deal = 0;
        int targetNum = 0;

        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                deal = 200;
            }
            if (getGrade() == 2) { //2성일때
                deal = 325;
            }
            if (getGrade() == 3) { //3성일떄
                deal = 450;
            }

            while(target[targetNum].getHp() == 0) {
                targetNum++;
            }
            targetNum = varietySkillActive.attackTwo(target,deal);

            setMp(0);

            statusOutput.skillOutput("말\t살");
            return targetNum;
        }
        return 0;
    }

    @Override
    public void classSynergy(Deck deck) {
        int cnt=0;

        for(int i=0; i<deck.deckSize(); i++) {
            if(deck.retCham(i).getcClass().equals("기사")) {
                cnt++;
            }
        }

        if(cnt>=2 && cnt<4) {
            System.out.println("◎◎◎◎ 모데카이저 기사 (초기)특성 발동\t [방 + 20]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("모데카이저")){
                    deck.retCham(i).setArmor(getArmor() + 20); // 추가방어력 20
                }
            }
        } else if(cnt>=4 && cnt<6) {
            System.out.println("◎◎◎◎ 모데카이저 기사 (중기)특성 발동\t [방 + 40]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("모데카이저")){
                    deck.retCham(i).setArmor(getArmor() + 40); // 추가방어력 40
                }
            }
        }
        else if(cnt >= 6) {
            System.out.println("◎◎◎◎ 모데카이저 기사 (최종)특성 발동\t [방 + 80]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("모데카이저")){
                    deck.retCham(i).setArmor(getArmor() + 80); //추가방어력 80
                }
            }
        }
    }
}
