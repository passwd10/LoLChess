package GameProgress;

import Computer.ComDeck;
import MyInfo.*;
import Champion.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Round {

    public void chamReset(Deck myDeck) {
        //챔피언을 초기상태로 리셋시킴
        for(int a=0; a<myDeck.deckSize(); a++) {
            myDeck.retCham(a).setHp(myDeck.retCham(a).getMAX_HP()); //HP초기화
            myDeck.retCham(a).setMp(0);           //MP 0으로 초기화
            myDeck.retCham(a).setArmor(myDeck.retCham(a).getFIRST_ARMOR()); //방어력 초기화
            myDeck.retCham(a).setPower(myDeck.retCham(a).getFIRST_POWER()); //공격력 초기화
        }

    }

    public void forcedInsert(Deck myDeck,Que myQue, Level myLevel) {
        //챔피언이 덱에 없을시 강제로 챔피언 삽입

        int interval = 0; //몇개의 챔피언을 더 넣어야하나

        if (myDeck.deckSize() < myLevel.getMyLevel()) {
            //내 레벨보다 적은수의 챔피언이 있으면 강제 삽입
            interval = myLevel.getMyLevel() - myDeck.deckSize(); //넣어야할 챔피언의 수

            ArrayList<Champion> insertCham = new ArrayList<Champion>(); //넣을 챔피언의 배열

            int isInput; //넣을 수 있냐?

            for(int i=0; i<myQue.queSize(); i++) {
                insertCham.add(myQue.returnQue(i)); // 다 넣음
                myQue.deletQue(i);
                i--;
            }

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

            if (insertCham.size() < interval) { //넣어야될 챔피언에비해 대기열이 작을경우
                for (int i = 0; i < insertCham.size(); i++) {
                    isInput = 1; //못넣음
                    for (int a = 0; a < myDeck.deckSize(); a++) {
                        if (myDeck.retCham(a) == insertCham.get(i)) {
                            isInput = 0;
                            myQue.addQue(insertCham.get(i)); //삭제한 챔피언을 다시 대기열로
                            insertCham.remove(i);
                            i--;
                            break;
                        }
                    }

                    if (isInput == 1) {
                        myDeck.addDeck(insertCham.get(i)); //강제 삽입
                        insertCham.remove(i); //삭제
                        i--;
                    }

                    if (insertCham.size() == 0) {
                        break; //다 넣었으면 종료
                    }
                }
            } else {
                int cnt = 0;
                for (int i = 0; i < insertCham.size(); i++) {
                    isInput = 1; //넣음
                    for (int a = 0; a < myDeck.deckSize(); a++) {
                        if (myDeck.retCham(a) == insertCham.get(i)) {
                            isInput = 0;
                            myQue.addQue(insertCham.get(i)); //삭제한 챔피언을 다시 대기열로
                            insertCham.remove(i);
                            i--;
                            break;
                        }
                    }

                    if (isInput == 1) {
                        myDeck.addDeck(insertCham.get(i)); //강제 삽입
                        insertCham.remove(i); //삭제
                        i--;
                        cnt++;
                    }

                    if (insertCham.size() == 0 || cnt == interval) {
                        for(int c=0; c<insertCham.size(); c++) { //insertCham에 있는 챔피언들 다시 대기열로
                            myQue.addQue(insertCham.get(c));
                        }
                        break; //다 넣었으면 종료
                    }

                }
            }

        }
    }

    public int startStage(int roundNum, Deck myDeck, ComDeck comDeck) {
        //스테이지 시작 챔피언 봇이 나올때

        Champion[] computer = new Champion[comDeck.deckSize()];
        for(int i=0; i<comDeck.deckSize(); i++) {
            computer[i] = comDeck.retCham(i);
            computer[i].setMp(0); //마나 초기화
        }

        System.out.println(roundNum + " 라운드를 시작하겠습니다.");
        for(int i=0; i<comDeck.deckSize(); i++) {
            if(computer[i].getGrade() == 0) {
                System.out.print(computer[i].getName() + " ");
            } else {
                System.out.print(computer[i].getName() + "(" + computer[i].getGrade() + "성) ");
            }
        }
        System.out.println("가 출현합니다.\n");

        int cnt = 0;
        int gameOver = 0; //게임이 끝나면 1로 바꿔줌
        int mRest = 0; //처치당한 내 챔피언
        int bRest = 0; // 처치한 봇 챔피언

        //long start = System.currentTimeMillis(); //시작시간
        for(int a=0; a< myDeck.deckSize(); a++) {
            myDeck.retCham(a).classSynergy(myDeck);
        }

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

                if (myDeck.retCham(a).getHp() == 0) {
                    System.out.println("[ Down ] " + myDeck.retCham(a).getName());
                } else {

                    if( myDeck.retCham(a).getMp() ==  myDeck.retCham(a).getMAX_MP()) {
                        myDeck.retCham(a).useSkill(computer[bRest]);
                    }
                    else {
                        myDeck.retCham(a).attack(computer[bRest]); //공격함
                    }
                    computer[bRest].beAttacked(myDeck.retCham(a)); //전투중 상태출력

                    if (computer[bRest].getHp() == 0) {
                        //공격을 받은 봇이 죽을때
                        bRest++;
                        if (bRest >= comDeck.deckSize()) { //챔피언을 다 처치함'
                            gameOver = 1;
                            break;
                        }
                    }
                }
            }

            for (int b = 0; b < comDeck.deckSize(); b++) {
                if (computer[b].getHp() == 0) {
                    //공격하는 봇이 죽으면
                    System.out.println("[ Down ] " + computer[b].getName());
                } else {
                    if( computer[b].getMp() != 0 && computer[b].getMp() ==  computer[b].getMAX_MP()) {
                        //마나게이지가 다 차면 스킬사용
                        computer[b].useSkill(myDeck.retCham(mRest));
                    } else {
                        computer[b].attack(myDeck.retCham(mRest)); //공격함
                    }
                    myDeck.retCham(mRest).beAttacked(computer[b]); //전투중 상태출력

                    if (myDeck.retCham(mRest).getHp() == 0) {
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
            System.out.println("=====================================================");
        }

        for (int a = 0; a < comDeck.deckSize(); a++) { //컴터 초기화
            computer[a].setHp(computer[a].getMAX_HP());
            computer[a].setMp(computer[a].getMAX_MP());
        }

        comDeck.clearDeck(); //컴퓨터 덱 초기화

        if (cnt == 20) {
            return 2; //무승부
        }

        if (bRest == 3) {
            return 1; //승리
        }

        if (mRest == myDeck.deckSize()) {
            return 0; //패배
        }

        return 1;
    }

}
