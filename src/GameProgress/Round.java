package GameProgress;

import Common.AllUnit;
import Common.SkillActive;
import Computer.ComDeck;
import MyInfo.*;
import Champion.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

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

        ArrayList<Champion> insertCham = new ArrayList<Champion>(); //넣을 챔피언의 배열

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

    private void inputPartQue(ArrayList<Champion> insertCham, Deck myDeck, Que myQue, int isInput, int interval) {
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

    private void insertToQue(ArrayList<Champion> insertCham, int cnt, int interval, Que myQue) {
        //insertCham의 크기가 0이거나 넣어야될 챔피언을 다 넣으면
        if (insertCham.size() == 0 || cnt == interval) {
            for (int c = 0; c < insertCham.size(); c++) { //insertCham에 있는 챔피언들 다시 대기열로
                myQue.addQue(insertCham.get(c));
            }
        }
    }

    private void inputAllQue(ArrayList<Champion> insertCham, Deck myDeck, Que myQue, int isInput) {

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

    private int returnToQue(int i, Deck myDeck, ArrayList<Champion> insertCham, Que myQue) {
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

    private void checkInsert(ArrayList<Champion> insertCham, Que myQue) {
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

    private void moveQue(ArrayList<Champion> insertCham, Que myQue) {
        //내 대기열에 있는 챔프를 insertCham으로 옮김
        for (int i = 0; i < myQue.queSize(); i++) {
            insertCham.add(myQue.returnQue(i)); // 다 넣음
            myQue.deletQue(i);
            i--;
        }
    }

    public int startStage(int roundNum, Deck myDeck, ComDeck comDeck) {
        //스테이지 시작 챔피언 봇이 나올때

        for (int i = 0; i < comDeck.deckSize(); i++) {
            comDeck.retCham(i).setMp(0); //마나 초기화
        }

        System.out.println(roundNum + " 라운드를 시작하겠습니다.");

        comAppeared(comDeck); //컴퓨터 챔피언이 뭐가 나오나?

        int gameRound = 0;
        this.gameOver = 1;
        this.mRest = 0; //처치당한 내 챔피언
        this.bRest = 0; // 처치한 봇 챔피언

        //long start = System.currentTimeMillis(); //시작시간

        isSynergy(myDeck); //시너지 확인

        while (gameRound < 20 && gameOver == 1) {
            gameRound++;
            /*
            long end = System.currentTimeMillis(); //종료 시간
            if ((end - start) / 1000 >= 30) {
                System.out.println("시간 초과");
                System.out.println(" 무승부 ");
                break;
            }*/

            playerAttack(myDeck, comDeck); //내 공격

            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            botAttack(myDeck, comDeck); //컴퓨터 공격

            System.out.println("========================= " + gameRound + " ===========================");
        }

        for (int a = 0; a < comDeck.deckSize(); a++) { //컴터 초기화
            comDeck.retCham(a).setHp(comDeck.retCham(a).getMAX_HP());
            comDeck.retCham(a).setMp(comDeck.retCham(a).getMAX_MP());
        }


        if (this.bRest == comDeck.deckSize()) { //봇 유닛을 모두 처치했으면
            comDeck.clearDeck(); //컴퓨터 덱 초기화
            return VICTORY; //승리
        }

        if (this.mRest == myDeck.deckSize()) { //내 유닛이 모두 처치당했으면
            comDeck.clearDeck(); //컴퓨터 덱 초기화
            return DEFEAT; //패배
        }

        if (gameRound == 21) {
            comDeck.clearDeck(); //컴퓨터 덱 초기화
            return DRAW; //무승부
        }

        return 1;
    }

    private void botAttack(Deck myDeck, ComDeck comDeck) {
        //컴퓨터 공격
        for (int b = 0; b < comDeck.deckSize(); b++) {

            if (isDownCom(comDeck, b) == NOT_DOWN && gameOver == GAME_CONTINUE) {

                isMaxMpCom(myDeck, b, comDeck); // Computer mp가 꽉 차면 스킬 사용

                myDeck.retCham(this.mRest).beAttacked(comDeck.retCham(b)); //전투중 상태출력

                gameOver = isGameOverCom(myDeck);

            }
        }
    }

    private void playerAttack(Deck myDeck, ComDeck comDeck) {
        //내 공격
        for (int deckNum = 0; deckNum < myDeck.deckSize(); deckNum++) {

            if (isDown(myDeck, deckNum) == NOT_DOWN && gameOver == GAME_CONTINUE) { //체력이 0인가? 0이면 Down

                isMaxMp(myDeck, deckNum, comDeck); // mp가 꽉 차면 스킬 사용

                comDeck.retCham(this.bRest).beAttacked(myDeck.retCham(deckNum)); //전투중 상태출력

                gameOver = isGameOver(comDeck); //게임이 끝났는지 판단

            }
        }
    }

    private void comAppeared(ComDeck comDeck) { //출현하는 봇챔피언 출력
        for (int i = 0; i < comDeck.deckSize(); i++) {
            System.out.print(comDeck.retCham(i).getName() + " ");
        }

        System.out.println("가 출현합니다.\n");

    }

    private int isDownCom(ComDeck comDeck, int b) { //컴퓨터가 DOWN 됐나?
        if (comDeck.retCham(b).getHp() == 0) {
            //공격하는 봇이 죽으면
            System.out.println("[ Down ] " + comDeck.retCham(b).getName());
            return DOWN;
        }
        return NOT_DOWN;
    }

    private int isDown(Deck myDeck, int a) { //내 챔피언이 DOWN 됐나?
        if (myDeck.retCham(a).getHp() == 0) { //체력 0이면 Down
            System.out.println("[ Down ] " + myDeck.retCham(a).getName());
            return DOWN; //Down
        }
        return NOT_DOWN; //진행
    }

    private void isMaxMp(Deck myDeck, int deckNum, ComDeck comDeck) {

        if (myDeck.retCham(deckNum).getMp() == myDeck.retCham(deckNum).getMAX_MP()) {
            //마나가 다 차면 스킬 사용
            if(myDeck.retCham(deckNum) instanceof SkillActive) {
                myDeck.retCham(deckNum).useSkill(comDeck.retCham(this.bRest));
            }
        }

        if(myDeck.retCham(deckNum).getMp() != myDeck.retCham(deckNum).getMAX_MP()){
            //마나가 다 차지 않으면 평타
            myDeck.retCham(deckNum).attack(comDeck.retCham(this.bRest)); //공격함
        }

    }

    private void isMaxMpCom(Deck myDeck, int b, ComDeck comDeck) {

        if (comDeck.retCham(b).getMp() == comDeck.retCham(b).getMAX_MP()) {
            //마나게이지가 다 차면 스킬사용
            if(comDeck.retCham(b) instanceof SkillActive) { //스킬 사용이 가능하다면
                ((SkillActive) comDeck.retCham(b)).useSkill(myDeck.retCham(this.mRest));
            }
        }

        if (comDeck.retCham(b).getMp() != comDeck.retCham(b).getMAX_MP()){
            comDeck.retCham(b).attack(myDeck.retCham(this.mRest)); //공격함
        }
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