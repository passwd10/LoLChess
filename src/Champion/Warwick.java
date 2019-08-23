package Champion;

import Common.*;
import MyInfo.Deck;
import Output.*;

public class Warwick extends Champion {

    public Warwick(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
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
    public void useSkill(AllUnit[] target) {
        //워윅이 가장 체력이 낮은 적에게 달려들어 1.5초 동안 기절시키고 피해를 입히며 자신의 체력을 회복합니다. 적중 시 효과가 적용됩니다.
        //피해량 : 150 / 225 / 300
        VarietySkillActive varietySkillActive = new VarietySkillActive();
        StatusOutput statusOutput = new StatusOutput();

        int deal = 0; //데미지

        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                deal = 150;
            }
            if (getGrade() == 2) { //2성일때
                deal = 225;
            }
            if (getGrade() == 3) { //3성일떄
                deal = 300;
            }

            varietySkillActive.attackOne(target, deal);
            setMp(0); //내 mp 0

            statusOutput.skillOutput("무한의 구속");
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
            System.out.println("■■■■■ 워윅 싸움꾼 (초기)특성 발동 ■■■■\t [HP + 300]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("워윅")){
                    deck.retCham(i).setHp(getHp() + 300); // 추가체력 300
                }
            }
        }
        else if(cnt >= 6) {
            System.out.println("■■■■■ 워윅 싸움꾼 (최종)특성 발동 ■■■■\t [HP + 700]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("워윅")){
                    deck.retCham(i).setHp(getHp() + 700); //추가체력 700
                }
            }
        }
    }
}
