package Common;

import Computer.ComDeck;
import MyInfo.Deck;
import Output.*;

public class BotAttackThread implements Runnable {

    Deck myDeck;
    ComDeck comDeck;
    StatusOutput statusOutput;
    int mRest;
    int comDeckNum;

    private static final int GAME_OVER = 0;
    private static final int GAME_CONTINUE = 1;
    private static final int DOWN = 0;
    private static final int NOT_DOWN = 1;

    public BotAttackThread(Deck myDeck, ComDeck comDeck, StatusOutput statusOutput, int mRest, int comDeckNum) {
        this.myDeck = myDeck;
        this.comDeck = comDeck;
        this.statusOutput = statusOutput;
        this.mRest = mRest;
        this.comDeckNum = comDeckNum;
    }

    double attackSpeed; //챔피언 공격속도
    int attackTime;

    @Override
    public void run() {
        attackSpeed = 100 * comDeck.retCham(comDeckNum).getAttackSpeed();
        attackTime = 100000 / (int) attackSpeed;
        while (this.mRest<comDeck.deckSize() && myDeck.retCham(this.mRest).getHp() > 0 && comDeck.retCham(comDeckNum).getHp() > 0) {
            //내 hp가 0이상이면 컴퓨터가 계속 때림

            try {
                synchronized (java.lang.Object.class) {
                    hitMyDeck(statusOutput, comDeck, myDeck, comDeck, this.mRest);
                }
                Thread.sleep(attackTime);
                if(isDown(comDeck, comDeckNum) == DOWN) {
                    Thread.interrupted();
                }
                if(isGameOver(myDeck) == GAME_OVER) {
                    Thread.interrupted();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

    private synchronized void hitMyDeck(StatusOutput statusOutput, ComDeck comDeck, Deck myDeck, ComDeck comDeck1, int mRest) {
        statusOutput.attackerStatus(comDeck.retCham(comDeckNum)); //내 상태
        System.out.print(" -> ");
        myDeck.retCham(mRest).beAttacked(comDeck.retCham(comDeckNum));
        statusOutput.beAttackerStatus(myDeck.retCham(mRest)); //컴퓨터 상태
        System.out.println();
    }

    private int isGameOver(Deck myDeck) {
        if (myDeck.retCham(mRest).getHp() == 0) {
            //공격받은 플레이어가 죽으면
            this.mRest++;
            if (this.mRest == myDeck.deckSize()) {
                //내 챔피언들이 다 처리됨
                return GAME_OVER;
            }
        }
        return GAME_CONTINUE;
    }

    private int isDown(ComDeck comDeck, int b) { //컴퓨터가 DOWN 됐나?
        if (comDeck.retCham(b).getHp() == 0) {
            //공격하는 봇이 죽으면
            System.out.println(comDeck.retCham(b).getName() + " [ Down ]");
            return DOWN;
        }
        return NOT_DOWN;
    }
}
