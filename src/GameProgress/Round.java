package GameProgress;

import Common.BotAttackThread;
import Common.PlayerAttackThread;
import Common.SkillActive;
import Common.TimeThread;
import Computer.ComDeck;
import MyInfo.*;
import Champion.*;
import Output.StatusOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntToDoubleFunction;

public class Round {

    private static final int GAME_OVER = 0;
    private static final int GAME_CONTINUE = 1;
    private static final int DOWN = 0;
    private static final int NOT_DOWN = 1;
    private static final int CANT_INPUT = 1;
    private static final int CAN_INPUT = 0;
    private static final int VICTORY = 1;
    private static final int DRAW = 2;
    private static final int DEFEAT = 0;

    private int mRest; //처치당한 내 챔피언
    private int bRest; // 처치한 봇 챔피언
    private int gameOver; //게임이 끝났는지 판단 / 게임이 끝나면 0로 바꿔줌

    public void chamReset(Deck myDeck) {
        //챔피언을 초기상태로 리셋시킴
        for (int a = 0; a < myDeck.deckSize(); a++) {
            myDeck.retCham(a).setHp(myDeck.retCham(a).getMAX_HP()); //HP초기화
            myDeck.retCham(a).setMp(0);           //MP 0으로 초기화
            myDeck.retCham(a).setArmor(myDeck.retCham(a).getFIRST_ARMOR()); //방어력 초기화
            myDeck.retCham(a).setPower(myDeck.retCham(a).getFIRST_POWER()); //공격력 초기화
        }

    }

    public void forcedInsert(Deck myDeck, Que myQue, Level myLevel) {
        //챔피언이 덱에 없을시 강제로 챔피언 삽입

        int interval = 0; //몇개의 챔피언을 더 넣어야하나

        List<Champion> insertCham = new ArrayList<Champion>(); //넣을 챔피언의 배열

        if (myDeck.deckSize() < myLevel.getMyLevel()) {
            //내 레벨보다 적은수의 챔피언이 있으면 강제 삽입
            interval = myLevel.getMyLevel() - myDeck.deckSize(); //넣어야할 챔피언의 수

            int isInput = CAN_INPUT; //대기열로 다시 들어가나? 지금은 들어갈 수 있는 상태

            moveQue(insertCham, myQue); //내 큐에있는 챔피언을 insertCham으로 옮김

            checkInsert(insertCham, myQue); //insertCham 중복 체크

            if (insertCham.size() <= interval) { //넣어야될 챔피언에비해 대기열이 작거나 같을경우

                inputAllQue(insertCham, myDeck, myQue, isInput); //내 대기열에있는 챔피언을 덱으로 다 넣어줌

            }

            if (insertCham.size() > interval) {  //넣어야될 챔피언에비해 대기열이 클을경우

                inputPartQue(insertCham, myDeck, myQue, isInput, interval); //내 대기열의 챔피언중 일부만 덱에 넣어줌

            }

        }
    }

    private void inputPartQue(List<Champion> insertCham, Deck myDeck, Que myQue, int isInput, int interval) {
        int cnt = 0;
        for (int i = 0; i < insertCham.size(); i++) {

            isInput = returnToQue(i, myDeck, insertCham, myQue); //대기열에서 꺼낸 챔피언을 다시 대기열에 넣는가? 덱에넣는가?

            if (isInput == CANT_INPUT) {
                myDeck.addDeck(insertCham.get(i)); //강제 삽입
                insertCham.remove(i); //삭제
                cnt++;
            }

            insertToQue(insertCham, cnt, interval, myQue); //insertCham에 있는 챔피언들 다시 대기열로
        }
    }

    private void insertToQue(List<Champion> insertCham, int cnt, int interval, Que myQue) {
        //insertCham의 크기가 0이거나 넣어야될 챔피언을 다 넣으면
        if (insertCham.size() == 0 || cnt == interval) {
            for (int c = 0; c < insertCham.size(); c++) { //insertCham에 있는 챔피언들 다시 대기열로
                myQue.addQue(insertCham.get(c));
            }
        }
    }

    private void inputAllQue(List<Champion> insertCham, Deck myDeck, Que myQue, int isInput) {

        for (int i = 0; i < insertCham.size(); i++) {

            isInput = returnToQue(i, myDeck, insertCham, myQue); //대기열에서 꺼낸 챔피언을 다시 대기열에 넣는가? 덱에넣는가?

            if (isInput == CANT_INPUT) { //대기열에 넣을수 없으면
                myDeck.addDeck(insertCham.get(i)); //덱에 강제 삽입
                insertCham.remove(i); //삭제
                i--;
            }

            if (insertCham.size() == 0) {
                break; //다 넣었으면 종료
            }
        }
    }

    private int returnToQue(int i, Deck myDeck, List<Champion> insertCham, Que myQue) {
        //내 덱에 넣으려는 챔피언이 이미 존재한다면?
        for (int a = 0; a < myDeck.deckSize(); a++) {
            if (myDeck.retCham(a) == insertCham.get(i)) {
                myQue.addQue(insertCham.get(i)); //삭제한 챔피언을 다시 대기열로
                insertCham.remove(i);
                i--;
                return CAN_INPUT; //대기열에 넣을 수 있음
            }
        }
        return CANT_INPUT; //대기열에 못넣음
    }

    private void checkInsert(List<Champion> insertCham, Que myQue) {
        //insertcham 중복체크
        for (int i = 0; i < insertCham.size(); i++) {
            //insertCham 안에서의 중복값 확인하기
            for (int a = 0; a < i; a++) {
                if (insertCham.get(a) == insertCham.get(i)) {
                    myQue.addQue((insertCham.get(i)));
                    insertCham.remove(i);
                    i--;
                    break;
                }
            }
        }
    }

    private void moveQue(List<Champion> insertCham, Que myQue) {
        //내 대기열에 있는 챔프를 insertCham으로 옮김
        for (int i = 0; i < myQue.queSize(); i++) {
            insertCham.add(myQue.returnQue(i)); // 다 넣음
            myQue.deletQue(i);
            i--;
        }
    }

    public int startStage(int roundNum, Deck myDeck, ComDeck comDeck) {
        //스테이지 시작 챔피언 봇이 나올때
        StatusOutput statusOutput = new StatusOutput(); //각 객체의 상태 출력

        for (int i = 0; i < comDeck.deckSize(); i++) {
            comDeck.retCham(i).setMp(0); //마나 초기화
        }

        comAppeared(comDeck); //컴퓨터 챔피언이 뭐가 나오나?

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
                " " + roundNum + " 라운드를 시작합니다" +
                " ━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");

        this.gameOver = 1;
        this.mRest = 0; //처치당한 내 챔피언
        this.bRest = 0; // 처치한 봇 챔피언

        isSynergy(myDeck); //시너지 확인

        /*if(roundTimeThread(3) == DRAW) {
            return DRAW;
        }*/
/*
        TimeThread timeThread = new TimeThread(3);
        Thread timer = new Thread(timeThread);
        timer.start();*/

        attackThread(myDeck, comDeck, statusOutput, bRest, mRest); //공격 쓰레드

        int myCnt = 0;
        int botCnt = 0;
        for (int i = 0; i < comDeck.deckSize(); i++) {
            if (comDeck.retCham(i).getHp() == 0) {
                botCnt++;
            }
        }

        for (int j = 0; j < myDeck.deckSize(); j++) {
            if (myDeck.retCham(j).getHp() == 0) {
                myCnt++;
            }
        }

        for (int a = 0; a < comDeck.deckSize(); a++) { //컴터 Hp,Mp 초기화
            comDeck.retCham(a).setHp(comDeck.retCham(a).getMAX_HP());
            comDeck.retCham(a).setMp(comDeck.retCham(a).getMAX_MP());
        }

        if (botCnt == comDeck.deckSize()) {
            comDeck.clearDeck(); //컴퓨터 덱 초기화
            return VICTORY; //승리
        }

        if (myCnt == myDeck.deckSize()) {
            comDeck.clearDeck(); //컴퓨터 덱 초기화
            return DEFEAT; //패배
        }

        comDeck.clearDeck(); //컴퓨터 덱 초기화
        return DRAW; //무승부
    }

    private int roundTimeThread(int time) {
        /*TimeThread timeThread = new TimeThread(3); //라운드 시간 쓰레드
        Thread roundTime = new Thread(timeThread);
        roundTime.start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Thread.sleep(time * 1000); //30초
                        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t 시간초과");
                        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" +
                                " 라운드 종료 " +
                                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
                        Thread.interrupted();
                        break;
                    } catch (Exception e) {

                    }
                }
            }
        }).start();

        return DRAW;
    }

    private void attackThread(Deck myDeck, ComDeck comDeck, StatusOutput statusOutput, int bRest, int mRest) {

        PlayerAttackThread[] attackThreads = new PlayerAttackThread[myDeck.deckSize()]; //내 덱챔피언들 쓰레드
        BotAttackThread[] botAttackThreads = new BotAttackThread[comDeck.deckSize()]; //봇 챔피언 쓰레드

        Thread[] player = new Thread[myDeck.deckSize()];
        Thread[] bot = new Thread[comDeck.deckSize()];

        for (int i = 0; i < myDeck.deckSize(); i++) {
            attackThreads[i] = new PlayerAttackThread(myDeck, comDeck, statusOutput, bRest, i);
            player[i] = new Thread(attackThreads[i]);
            player[i].start(); //내 덱챔피언 공격 시작
        }

        for (int j = 0; j < comDeck.deckSize(); j++) {
            botAttackThreads[j] = new BotAttackThread(myDeck, comDeck, statusOutput, mRest, j);
            bot[j] = new Thread(botAttackThreads[j]);
            bot[j].start(); //상대 챔피언 공격 시작
        }

        try {
            for (int i = 0; i < myDeck.deckSize(); i++) {
                player[i].join();
            }
            for (int j = 0; j < comDeck.deckSize(); j++) {
                bot[j].join();
            }
        } catch (InterruptedException e) {
        }
    }


    private void comAppeared(ComDeck comDeck) { //출현하는 봇챔피언 출력
        System.out.print("\t");
        for (int i = 0; i < comDeck.deckSize(); i++) {
            System.out.print(comDeck.retCham(i).getName() + " ");
        }

        System.out.print("가 출현합니다.");


        System.out.println("\t3 초후 시작합니다");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\uD83D\uDD52  THREE ");
        try {
            Thread.sleep(1000); //3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\uD83D\uDD51   TWO ");

        try {
            Thread.sleep(1000); //3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\uD83D\uDD50   ONE ");
        try {
            Thread.sleep(1000); //3초 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void isMaxMp(Deck myDeck, int deckNum, ComDeck comDeck) {
        myDeck.retCham(deckNum).useSkill(comDeck.allUnits()); //스킬
        myDeck.retCham(deckNum).attack(comDeck.retCham(this.bRest)); //평타
    }

    private void isMaxMpCom(Deck myDeck, int b, ComDeck comDeck) {

       if(comDeck instanceof SkillActive) {
           ((SkillActive) comDeck.retCham(b)).useSkill(myDeck.allUnits()); //스킬
       }
        comDeck.retCham(b).attack(myDeck.retCham(this.mRest)); //평타

    }

    private int isGameOverCom(Deck myDeck) {
        if (myDeck.retCham(this.mRest).getHp() == 0) {
            //공격받은 플레이어가 죽으면
            this.mRest++;
            if (this.mRest == myDeck.deckSize()) {
                //내 챔피언들이 다 처리됨
                return GAME_OVER;
            }
        }
        return GAME_CONTINUE;
    }

    private int isGameOver(ComDeck comDeck) {
        if (comDeck.retCham(this.bRest).getHp() == 0) {
            //공격을 받은 봇이 죽을때
            this.bRest++;
            if (this.bRest == comDeck.deckSize()) { //챔피언을 다 처치함'
                return GAME_OVER; //게임 종료
            }
        }
        return GAME_CONTINUE; // 게임진행
    }


    private void isSynergy(Deck myDeck) {
        //시너지가 발동 가능한지 점검해주는 메소드
        for (int a = 0; a < myDeck.deckSize(); a++) {
            myDeck.retCham(a).classSynergy(myDeck);
        }
        // Todo: TribeSynergy 발동
    }


}