package Output;

import MyInfo.Gold;
import MyInfo.Level;
import MyInfo.Life;

public class GameResultOutput {

    public void roundResult(int result, Life life) { //라운드 결과 출력
        if(result == 2) {
            System.out.println("\n  ▶▶▶▶▶▶ You Draw ◀◀◀◀◀◀");
        }
        if(result == 1) {
            System.out.println("\n  ▶▶▶▶▶▶ You Win ◀◀◀◀◀◀");
        }
        if(result == 0) {
            System.out.println("\n  ▶▶▶▶▶▶ You Lose ◀◀◀◀◀◀");
            life.setLife(life.getLife() - 2);
            //남은 상대챔피언 당 2씩 깎임
        }
    }

    public void outputReward(Life life, Gold myGold, InfoOutput infoOutput) {
        //라운드 보상 출력
        System.out.println("┌──────────────────┐");
        System.out.println("│            상태 및 보상            │");
        System.out.println("└──────────────────┘");
        System.out.println("   XP +2");
        System.out.println("   골드 +" + (5 + myGold.getPlusGold()));
        infoOutput.lifeOutput(life);
        System.out.println("────────────────────");
    }

    public void outputTotalResult(Level level, Gold myGold, Life life) {
        //최종 결과 출력
        InfoOutput infoOutput = new InfoOutput();

        System.out.println("┌──────────────────┐");
        System.out.println("│              최종 결과             │");
        System.out.println("└──────────────────┘");
        System.out.println("   레벨 : " + level.getMyLevel());
        System.out.println("   골드 : " + myGold.gold);
        infoOutput.lifeOutput(life);
        System.out.println("────────────────────");
        if (life.getLife() > 0) {
            //생명력이 0 이상이면 승급
            System.out.println("■□■□■□■ SILVER 승급 □■□■□■□");
        } else {
            System.out.println("■□■□■□■ 승급 실패 □■□■□■□");
        }
    }
}
