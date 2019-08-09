package GameProgress;

import Champion.*;
import MyInfo.Deck;
import MyInfo.Que;

import java.util.ArrayList;

public class Upgrade {
    //등급 업그레이드

    Champion[] champions2 = new Champion[12]; //2성 챔피언
    Champion[] champions3 = new Champion[12]; //3성 챔피언

    public void upgradCham(Deck myDeck, Que myQue) {
        champions2[0] = new Akali("아칼리", "암살자", "닌자", 4, 1260, 25, 126, 0.7, 20, 4, 2);
        champions2[1] = new Zed("제드", "암살자", "닌자", 2, 900, 75, 117, 0.65, 25, 2, 2);
        champions2[2] = new Katarina("카타리나", "암살자", "제국", 3, 810, 100, 90, 0.65, 20, 3, 2);
        champions2[3] = new Khazix("카직스", "암살자", "공허", 1, 900, 50, 99, 0.6, 20, 1, 2);
        champions2[4] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3, 1260, 75, 135, 0.55, 30, 3, 2);
        champions2[5] = new Chogas("초가스", "싸움꾼", "공허", 4, 1800, 150, 126, 0.55, 20, 4, 2);
        champions2[6] = new Warwick("워윅", "싸움꾼", "야생", 1, 1080, 150, 90, 0.6, 30, 1, 2);
        champions2[7] = new Lexai("렉사이", "싸움꾼", "공허", 2, 1170, 150, 90, 0.65, 20, 2, 2);
        champions2[8] = new Bbobbi("뽀삐", "기사", "요들", 3, 1440, 75, 90, 0.5, 40, 3, 2);
        champions2[9] = new Darius("다리우스", "기사", "제국", 1, 1080, 100, 90, 0.5, 25, 1, 2);
        champions2[10] = new Garen("가렌", "기사", "귀족", 1, 1080, 100, 90, 0.55, 35, 1, 2);
        champions2[11] = new Modaekaiser("모데카이저", "기사", "유령", 1, 990, 100, 90, 0.5, 35, 1, 2);

        champions3[0] = new Akali("아칼리", "암살자", "닌자", 4, 2520, 25, 252, 0.7, 20, 4, 3);
        champions3[1] = new Zed("제드", "암살자", "닌자", 2, 1800, 75, 234, 0.65, 25, 2, 3);
        champions3[2] = new Katarina("카타리나", "암살자", "제국", 3, 1620, 100, 180, 0.65, 20, 3, 3);
        champions3[3] = new Khazix("카직스", "암살자", "공허", 1, 1800, 50, 198, 0.6, 20, 1, 3);
        champions3[4] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3, 2520, 75, 270, 0.55, 30, 3, 3);
        champions3[5] = new Chogas("초가스", "싸움꾼", "공허", 4, 3600, 150, 252, 0.55, 20, 4, 3);
        champions3[6] = new Warwick("워윅", "싸움꾼", "야생", 1, 2160, 150, 180, 0.6, 30, 1, 3);
        champions3[7] = new Lexai("렉사이", "싸움꾼", "공허", 2, 2340, 150, 180, 0.65, 20, 2, 3);
        champions3[8] = new Bbobbi("뽀삐", "기사", "요들", 3, 2880, 75, 180, 0.5, 40, 3, 3);
        champions3[9] = new Darius("다리우스", "기사", "제국", 1, 2160, 100, 180, 0.5, 25, 1, 3);
        champions3[10] = new Garen("가렌", "기사", "귀족", 1, 2160, 100, 180, 0.55, 35, 1, 3);
        champions3[11] = new Modaekaiser("모데카이저", "기사", "유령", 1, 1980, 100, 180, 0.5, 35, 1, 3);

        int decksize = myDeck.deckSize();
        int quesize = myQue.queSize();
        int allSize = decksize + quesize; //덱과 대기열 전체 크기
        ArrayList<Champion> myAllCham = new ArrayList<Champion>(); //덱과 대기열의 모든 챔피언

        for (int i = 0; i < decksize; i++) {
            //덱을 한곳에 저장
            myAllCham.add(myDeck.retCham(0));
            myDeck.deletDeck(1); //저장한 덱은 삭제
        }

        for (int j = 0; j < quesize; j++) {
            //대기열을 한곳에 저장
            myAllCham.add(myQue.returnQue(0));
            myQue.deletQue(0); //저장한 대기열은 삭제
        }

        int[] array1 = new int[allSize]; //1성 확인
        int[] array2 = new int[allSize]; //2성 확인

        for (int i = 0; i < allSize; i++) {
            //덱과 대기열 챔프 중복검사
            if (myAllCham.get(i).getGrade() == 1) {
                //1성인 경우
                for (int a = 0; a < i; a++) {
                    if (myAllCham.get(i).getName().equals(myAllCham.get(a).getName())) {
                        //내가 갖고있는 챔프중 이름이 중복되는 챔프가 있으면
                        array1[i] += 1; //중복챔피언이라고 확인해줌
                    }
                }
            }
        }

        for (int i = 0; i < allSize; i++) {
            //1성 챔피언을 2성으로 바꿔주고 나머지 1성 챔프를 삭제
            if (array1[i] == 2) {
                //1성 3개가 모인경우

                int removeCnt = 0; //지울 챔피언의 수

                for (int a = 0; a < allSize ; a++) {
                    //관련 1성챔프 3개 삭제
                    if ((myAllCham.get(i).getName().equals(myAllCham.get(a).getName())) && (removeCnt < 4)) {
                        //중복되는 이름이 있고
                        myAllCham.remove(a);
                        //a--;
                        removeCnt++; // 3개 이상은 못지움
                    }

                }


                for (int b = 0; b < 12; b++) {
                    //2성챔피언 추가
                    if (myAllCham.get(i).getName().equals(champions2[b].getName())) {
                        //내가갖고있는 챔피언과 2성챔피언들의 이름을 비교함
                        myAllCham.add(champions2[b]); //2성 챔피언 추가
                        array1[i] = 0; //바꿨으니 0으로 초기화
                    }
                }
            }
        }

        //대기열과 덱에 다시 배분
        for (int i = 0; i < myAllCham.size(); i++) {
            if (myAllCham.size() < 9) {
                //넣으려는 챔피언 수가 9보다 작으면 다 대기열에 넣어버림
                myQue.addQue(myAllCham.get(i));
            } else { //9보다 크면 대기열에 9 나머지는 덱
                if (i < 9) {
                    myQue.addQue(myAllCham.get(i));
                } else {
                    myDeck.addDeck(myAllCham.get(i));
                }
            }
        }

    }
}