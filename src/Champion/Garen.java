package Champion;

import Common.Attackable;
import Common.BeAttackable;
import MyInfo.Deck;

public class Garen extends Champion {

    public Garen(String name, String chamClass, String tribe, int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
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
        setHp(getHp()-attacker.getPower() * 100 / (100 + getArmor())); //hp 깎임

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
        //가렌이 4초 동안 검을 들고 회전하며 마법 피해에 면역 상태가 되고 주변 적에게 피해를 입힙니다.
        //틱당 피해량 : 40 / 65 / 90
        if (getMp() >= getMAX_MP()) {

            if (getGrade() == 1) { //1성일때
                champion.setHp(getHp()-160);
            } else if (getGrade() == 2) { //2성일때
                champion.setHp(getHp()-260);
            } else if (getGrade() == 3) { //3성일떄
                champion.setHp(getHp()-360);
            }
            setMp(0);
            champion.setMp(getMp() + 20);

            System.out.print(getName());
            System.out.print(" [ HP " + Math.round(getHp()) + " "); //스킬 사용한 놈의 상태
            System.out.println("/ MP " + getMp() + " ]");
            System.out.println("[Skill] 심판 "); //150, 275, 400
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
        int cnt=0;

        for(int i=0; i<deck.deckSize(); i++) {
            if(deck.retCham(i).getcClass().equals("기사")) {
                cnt++;
            }
        }

        if(cnt>=2 && cnt<4) {
            System.out.println("■■■■■ 가렌 기사 특성 발동(초기) ■■■■\t [방 + 20]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("가렌")){
                    deck.retCham(i).setArmor(getArmor() + 20); // 추가방어력 20
                }
            }
        } else if(cnt>=4 && cnt<6) {
            System.out.println("■■■■■ 가렌 기사 특성 발동(중급) ■■■■\t [방 + 40]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("가렌")){
                    deck.retCham(i).setArmor(getArmor() + 40); // 추가방어력 40
                }
            }
        }
        else if(cnt >= 6) {
            System.out.println("■■■■■ 가렌 기사 특성 발동(최종) ■■■■\t [방 + 80]");
            for(int i=0; i<deck.deckSize(); i++) {
                if(deck.retCham(i).getName().equals("가렌")){
                    deck.retCham(i).setArmor(getArmor() + 80); //추가방어력 80
                }
            }
        }
    }
}
