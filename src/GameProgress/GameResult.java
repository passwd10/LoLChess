package GameProgress;

import MyInfo.Gold;
import MyInfo.Level;
import MyInfo.Life;
import Output.GameResultOutput;
import Output.InfoOutput;

public class GameResult {

    public void gameResult(int roundResult, Gold myGold, Life life, Level level) {
        InfoOutput infoOutput = new InfoOutput();
        GameResultOutput gameResultOutput = new GameResultOutput();

        gameResultOutput.roundResult(roundResult, life); //라운드 결과 출력

        level.setMyXp(level.getMyXp() + 2); //경험치 2 증가
        level.isMyLevel(level.getMyXp());
        myGold.plusGold(); //이자계산해서 줌
        myGold.gold += 5; //보상금
        myGold.gold += myGold.getPlusGold();

        gameResultOutput.outputReward(life,myGold,infoOutput); // 라운드 보상 출력
    }

}
