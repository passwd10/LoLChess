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


        System.out.println("-------------------------------------");
        System.out.println("\t\t\t   상 태");
        System.out.println("  XP +2");
        System.out.println("  골드 +"+(5+myGold.getPlusGold()));
        life.output();
    }
}
