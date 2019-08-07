package GameProgress;

import MyInfo.*;
import Champion.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Round {

    public void chamReset(Deck myDeck) {
        //챔피언을 초기상태로 리셋시킴
        for(int a=0; a<myDeck.deckSize(); a++) {
            myDeck.retCham(a).hp = myDeck.retCham(a).getMAX_HP(); //HP초기화
            myDeck.retCham(a).mp = 0;           //MP 0으로 초기화
        }

    }

    public int startStage(int i, Deck myDeck, Gold myGold, Champion champion1, Champion champion2, Champion champion3) {
        //스테이지 시작 챔피언 봇이 나올때

        Champion[] computer = new Champion[3];
        computer[0] = champion1;
        computer[1] = champion2;
        computer[2] = champion3;

        computer[0].mp = 0;
        computer[1].mp = 0;
        computer[2].mp = 0;

        System.out.println(i + " 라운드를 시작하겠습니다.");
        System.out.println(computer[0].getName() + ", " + computer[1].getName() + ", " + computer[2].getName() + "가 출현합니다.\n");

        int cnt = 0;
        int gameOver = 0; //게임이 끝나면 1로 바꿔줌
        int mRest = 0; //처치당한 봇 챔피언
        int bRest = 0; // 처치한 봇 챔피언

        //long start = System.currentTimeMillis(); //시작시간

        while (cnt == 20 || gameOver == 0) {
            cnt++;
            /*
            long end = System.currentTimeMillis(); //종료 시간
            if ((end - start) / 1000 >= 30) {
                System.out.println("시간 초과");
                System.out.println(" 무승부 ");
                break;
            }*/

            for (int a = 0; a < myDeck.deckSize(); a++) {

                if (myDeck.retCham(a).hp <= 0) {
                    System.out.println("[ Down ] " + myDeck.retCham(a).getName());
                } else {
                    myDeck.retCham(a).attack(computer[bRest]); //공격함
                    computer[bRest].beAttacked(myDeck.retCham(a)); //전투중 상태출력

                    if (computer[bRest].hp <= 0) {
                        //공격을 받은 봇이 죽을때
                        bRest++;
                        if (bRest >= 3) { //챔피언을 다 처치함'
                            gameOver = 1;
                            break;
                        }
                    }
                }
            }

            for (int b = 0; b < 3; b++) {
                if (computer[b].hp <= 0) {
                    //공격하는 봇이 죽으면
                    System.out.println("[ Down ] " + computer[b].getName());
                } else {
                    computer[b].attack(myDeck.retCham(mRest)); //공격함
                    myDeck.retCham(mRest).beAttacked(computer[b]); //전투중 상태출력

                    if (myDeck.retCham(mRest).hp <= 0) {
                        //공격받은 플레이어가 죽으면
                        mRest++;
                        if (mRest >= myDeck.deckSize()) {
                            //내 챔피언들이 다 처리됨
                            gameOver = 1;
                            break;
                        }
                    }
                }
            }
        }

        for (int a = 0; a < 3; a++) { //컴터 초기화
            computer[a].hp = computer[a].getMAX_HP();
            computer[a].mp = computer[a].getMAX_MP();
        }

        if (cnt == 20) {
            System.out.println("\n▶▶▶▶▶▶ You Draw ◀◀◀◀◀◀");
            myGold.gold += 7; //보상금
            return 2;
        }

        if (bRest == 3) {
            System.out.println("\n▶▶▶▶▶▶ You Win ◀◀◀◀◀◀");
            myGold.gold += 10; //보상금
            return 1;
        }

        if (mRest == myDeck.deckSize()) {
            System.out.println("\n▶▶▶▶▶▶ You Lose ◀◀◀◀◀◀");
            System.out.println("▶▶▶▶▶▶ Game Over ◀◀◀◀◀◀");
            return 0;
        }

        return 1;
    }

}
