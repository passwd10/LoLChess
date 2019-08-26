package Common;

import Computer.ComDeck;
import MyInfo.*;
import Output.*;

public class PlayerAttackThread implements Runnable {

    Deck myDeck;
    ComDeck comDeck;
    StatusOutput statusOutput;
    int bRest;
    int deckNum;

    private static final int GAME_OVER = 0;
    private static final int GAME_CONTINUE = 1;
    private static final int DOWN = 0;
    private static final int NOT_DOWN = 1;

    public PlayerAttackThread(Deck myDeck, ComDeck comDeck, StatusOutput statusOutput, int bRest, int deckNum) {
        this.myDeck = myDeck;
        this.comDeck = comDeck;
        this.statusOutput = statusOutput;
        this.bRest = bRest;
        this.deckNum = deckNum;
    }

    double attackSpeed; //챔피언 공격속도
    int attackTime;

    @Override
    public void run() {
        attackSpeed = 100 * myDeck.retCham(deckNum).getAttackSpeed();
        attackTime = 100000 / (int) attackSpeed;
        while (this.bRest < comDeck.deckSize() &&comDeck.retCham(this.bRest).getHp() > 0 && myDeck.retCham(deckNum).getHp() > 0) {
            //상대 hp가 0이상이면 계속 때림

            try {
                synchronized (java.lang.Object.class) { //동기화
                    if(myDeck.retCham(deckNum).getMp() == myDeck.retCham(deckNum).getMAX_MP()) {
                        skill(statusOutput, myDeck, comDeck, deckNum, this.bRest);
                    }
                    if(myDeck.retCham(deckNum).getMp() < myDeck.retCham(deckNum).getMAX_MP()) {
                        hitComDeck(statusOutput, myDeck, comDeck, deckNum, this.bRest);//컴퓨터 덱을 계속 떄림
                    }
                }
                Thread.sleep(attackTime);
                if(isDown(myDeck, deckNum)==DOWN) {
                    Thread.interrupted();
                } //내 챔피언이 Down됐나?
                if(isGameOver(comDeck)==GAME_OVER) {
                    Thread.interrupted();//게임이 끝나나?
                }
                if (this.bRest == comDeck.deckSize()) {
                    //컴퓨터 유닛들이 다 처리됨
                    break;
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    private void skill(StatusOutput statusOutput, Deck myDeck, ComDeck comDeck,int deckNum, int bRest) {
        int targetNum = 0;
        System.out.print("[ Player ]");
        statusOutput.attackerStatus(myDeck.retCham(deckNum)); //내 상태
        System.out.print("\t──\uD83D\uDCA5");
        targetNum = myDeck.retCham(deckNum).useSkill(comDeck.allUnits()); //스킬발동
        System.out.print("\uD83D\uDCA5─→\t");
        for(int i=0; i<targetNum; i++) {
            statusOutput.beAttackerStatus(comDeck.retCham(bRest+i)); //컴퓨터 상태
        }
        System.out.println();

    }

    private synchronized void hitComDeck(StatusOutput statusOutput, Deck myDeck, ComDeck comDeck, int deckNum, int bRest) {
        System.out.print("[ Player ]");
        statusOutput.attackerStatus(myDeck.retCham(deckNum)); //내 상태
        myDeck.retCham(deckNum).attack(comDeck.retCham(bRest)); //플레이어가 때림
        System.out.print("\t──\uD83D\uDC4AATTACK\uD83D\uDC4A─→\t");
        comDeck.retCham(bRest).beAttacked(myDeck.retCham(deckNum)); // 컴퓨터가 맞음
        statusOutput.beAttackerStatus(comDeck.retCham(bRest)); //컴퓨터 상태
        System.out.println();
    }

    private synchronized int isGameOver(ComDeck comDeck) {
        if (comDeck.retCham(bRest).getHp() == 0) {
            //공격을 받은 봇이 죽을때
            this.bRest++;
            if (this.bRest == comDeck.deckSize()) { //챔피언을 다 처치함'
                return GAME_OVER; //게임 종료
            }
        }
        return GAME_CONTINUE;
        // 게임진행
    }

    private synchronized int isDown(Deck myDeck, int deckNum) { //내 챔피언이 DOWN 됐나?
        if (myDeck.retCham(deckNum).getHp() == 0) { //체력 0이면 Down
            System.out.print("[ Player ]\t");
            System.out.println(myDeck.retCham(deckNum).getName() + "\t[ Down ]☠️☠️☠️");
            return DOWN;
        }
        return NOT_DOWN;
    }

}
