package Champion;

import Common.*;
import MyInfo.Deck;
import Output.*;

public class Akali extends Champion {

    public Akali(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
        super(name, chamClass, tribe, tier, hp, mp, power, attackSpeed, armor, gold, grade);
    }

    @Override
    public void attack(BeAttackable target) {
        setMp(getMp() + 8); //때릴때 마다 8씩 회복

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

    @Override
    public int useSkill(AllUnit[] target) {

        VarietySkillActive varietySkillActive = new VarietySkillActive();
        StatusOutput statusOutput = new StatusOutput();

        int deal = 0;
        int targetNum = 0;

        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                deal = 150;
            }
            if (getGrade() == 2) { //2성일때
                deal = 275;
            }
            if (getGrade() == 3) { //3성일떄
                deal = 400;
            }

           targetNum = varietySkillActive.attackOne(target,deal,0);

            setMp(0);

            statusOutput.skillOutput("오연투척검");
            return targetNum;
        }
        return 0;
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
            System.out.println("◎◎◎◎ 아칼리 암살자 (초기)특성 발동\t [공 x 1.5]");
            for (int i = 0; i < deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("아칼리")){
                    deck.retCham(i).setPower(getPower()*1.5);
                }
            }
        } else if (cnt >= 6) {
            System.out.println("◎◎◎◎ 아칼리 암살자 특성 발동(최종)\t [공 x 3.0]");
            for (int i = 0; i < deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("아칼리")){
                    deck.retCham(i).setPower(getPower()*3.0);
                }
            }
        }
    }

}
