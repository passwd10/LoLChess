package GameProgress;

import MyInfo.Gold;
import MyInfo.Level;
import MyInfo.Life;

public class GameResult {

    public void gameResult(int roundResult, Gold myGold, Life life, Level level) {
        if (roundResult == 2) {
            System.out.println("\n▶▶▶▶▶▶ You Draw ◀◀◀◀◀◀");
        }

        if (roundResult == 1) {
            System.out.println("\n▶▶▶▶▶▶ You Win ◀◀◀◀◀◀");
        }

        if (roundResult == 0) {
            System.out.println("\n▶▶▶▶▶▶ You Lose ◀◀◀◀◀◀");
            life.setLife(life.getLife() - 2);
            //남은 상대챔피언 당 2씩 깎임
        }


        level.setMyXp(level.getMyXp() + 2); //경험치 2 증가
        level.isMyLevel(level.getMyXp());
        myGold.plusGold(); //이자계산해서 줌
        myGold.gold += 5; //보상금
        myGold.gold += myGold.getPlusGold();


        System.out.println("┌──────────────────┐");
        System.out.println("│            상태 및 보상            │");
        System.out.println("└──────────────────┘");
        System.out.println("   XP +2");
        System.out.println("   골드 +"+(5+myGold.getPlusGold()));
        life.output();
        System.out.println("────────────────────");

    }

    public void totalResult(Gold myGold, Life life, Level level) {

            System.out.println("┌──────────────────┐");
            System.out.println("│              최종 결과             │");
            System.out.println("└──────────────────┘");
            System.out.println("   레벨 : " + level.getMyLevel());
            System.out.println("   골드 : " + myGold.gold);
            life.output();
            System.out.println("────────────────────");
            if(life.getLife() > 0) {
                //생명력이 0 이상이면 승급
                System.out.println("■□■□■□■ SILVER 승급 □■□■□■□");
            } else {
                System.out.println("■□■□■□■ 승급 실패 □■□■□■□");
            }

    }
}
