package Champion;

import Common.*;
import MyInfo.Deck;
import Output.*;

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

    }

        //볼리베어의 공격이 강화되어 여러 적에게 연쇄 피해를 입히고 적중 시 효과를 적용합니다.
        //최대 튕기는 횟수 : 2 / 3 / 4
        //연쇄 공격 피해량 증가율 : 0.8 / 0.9 / 1

    @Override
    public int useSkill(AllUnit[] target) {

        VarietySkillActive varietySkillActive = new VarietySkillActive();
        StatusOutput statusOutput = new StatusOutput();

        double deal = 0;
        int targetNum = 0;

        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                deal = getPower() * 0.8;
            }
            if (getGrade() == 2) { //1성일때
                deal = getPower() * 0.9;
            }
            targetNum = varietySkillActive.attackTwo(target, (int) deal);

            setMp(0);

            statusOutput.skillOutput("천둥 발톱");
            return targetNum;
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
            System.out.println("◎◎◎◎ 볼리베어 싸움꾼 (초기)특성 발동\t [HP + 300]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("볼리베어")){
                    deck.retCham(i).setHp(getHp() + 300); // 추가체력 300
                }
            }
        }
        else if(cnt >= 6) {
            System.out.println("◎◎◎◎ 볼리베어 싸움꾼 (최종)특성 발동\t [HP + 700]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("볼리베어")){
                    deck.retCham(i).setHp(getHp() + 700); // 추가체력 700
                }
            }
        }
    }
}
