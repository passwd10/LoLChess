package GameProgress;

import Champion.*;
import MyInfo.Deck;
import MyInfo.Que;

import java.util.ArrayList;
import java.util.List;

public class Upgrade {
    //등급 업그레이드

    Champion[] champions2 = new Champion[42]; //2성 챔피언
    Champion[] champions3 = new Champion[12]; //3성 챔피언

    public Upgrade() {
        // 챔피언
        champions2[0] = new Nar("나르","형상변환자","요들/야생",4,1350,125,90,0.7,30,6,2);

        // 1성 피오라, 트리스타나, 카직스, 카사딘, 워윅, 엘리스, 베인, 모데카이저, 다리우스, 니달리, 그레이브즈, 가렌
        //이름,직업,종족, 티어,체력,마나,파워,공속,방어력,가격,등급
        champions2[1] = new Khazix("카직스", "암살자", "공허", 1, 900, 50, 99, 0.6, 20, 3, 2);
        champions2[2] = new Darius("다리우스", "기사", "제국", 1, 1080, 100, 90, 0.5, 25, 3, 2);
        champions2[3] = new Garen("가렌", "기사", "귀족", 1, 1080, 100, 90, 0.55, 35, 3, 2);
        champions2[4] = new Modaekaiser("모데카이저", "기사", "유령", 1, 990, 100, 90, 0.5, 35, 3, 2);
        champions2[5] = new Warwick("워윅", "싸움꾼", "야생", 1, 1080, 150, 90, 0.6, 30, 3, 2);
        champions2[6] = new Fiora("피오라","검사","귀족",1,720,75,72,1.0,25,3,2);
        champions2[7] = new Tristana("트리스타나","총잡이","요들",1,900,50,90,0.7,20,3,2);
        champions2[8] = new Kassadin("카사딘","마법사","공허",1,990,0,99,0.6,25,3,2);
        champions2[9] = new Elise("엘리스","형상변환자","악마",1,810,100,81,0.6,20,3,2);
        champions2[10] = new Vayne("베인","정찰대","귀족",1,990,0,72,0.75,25,3,2);
        champions2[11] = new Nidalee("니달리","형상변환자","야생",1,900,100,90,0.65,20,3,2);
        champions2[12] = new Graves("그레이브즈","총잡이","해적",1,810,0,99,0.55,20,3,2);

        // 2성 파이크, 트위스트페이트, 제드, 아리, 쉔, 브라움, 바루스, 리산드라, 룰루, 루시안, 렉사이
        champions2[13] = new Lexai("렉사이", "싸움꾼", "공허", 2, 1170, 150, 90, 0.65, 20, 4, 2);
        champions2[14] = new Zed("제드", "암살자", "닌자", 2, 900, 75, 117, 0.65, 25, 4, 2);
        champions2[15] = new Pike("파이크","암살자","해적",2,1080,125,108,0.6,25,4,2);
        champions2[16] = new TwistedFate("트위스트페이트","마법사","해적",2,810,50,72,0.7,20,4,2);
        champions2[17] = new Ahri("아리","마법사","야생",2,810,75,90,0.55,20,4,2);
        champions2[18] = new Shen("쉔","검사","닌자",2,1170,150,117,0.7,30,4,2);
        champions2[19] = new Braum("브라움","수호자","빙하",2,1350,50,72,0.6,75,4,2);
        champions2[20] = new Varus("바루스","정찰대","악마",2,900,75,90,0.7,25,4,2);
        champions2[21] = new Lissandra("리산드라","원소술사","빙하",2,810,150,72,0.6,20,4,2);
        champions2[22] = new Lulu("룰루","마법사","요들",2,900,150,90,0.6,25,4,2);
        champions2[23] = new Lucian("루시안","총잡이","귀족",2,1080,35,117,0.65,25,4,2);

        // 3성 케넨 카타리나 이블린 애쉬 아트록스 뽀삐 볼리베어 베이가 모르가나 렝가 갱플랭크
        champions2[24] = new Bbobbi("뽀삐", "기사", "요들", 3, 1440, 75, 90, 0.5, 40, 5, 2);
        champions2[25] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3, 1260, 75, 135, 0.55, 30, 5, 2);
        champions2[26] = new Katarina("카타리나", "암살자", "제국", 3, 810, 100, 90, 0.65, 20, 5, 2);
        champions2[27] = new Kennen("케넨","원소술사","요들/닌자",3,990,150,126,0.65,20,5,2);
        champions2[28] = new Evelynn("이블린","암살자","악마",3,1080,75,126,0.6,20,5,2);
        champions2[29] = new Ashe("애쉬","정찰대","빙하",3,990,100,117,0.7,20,5,2);
        champions2[30] = new Aatrox("아트록스","검사","악마",3,1260,75,117,0.65,25,5,2);
        champions2[31] = new Veigar("베이가","마법사","요들",3,900,75,81,0.55,20,5,2);
        champions2[32] = new Morgana("모르가나","마법사","악마",3,1170,150,90,0.6,20,5,2);
        champions2[33] = new Rengar("렝가","암살자","야생",3,990,75,126,0.6,20,5,2);
        champions2[34] = new Gangplank("갱플랭크","검사/총잡이","해적",3,1260,100,99,0.65,20,5,2);

        // 4성 킨드레드 초가스 아칼리 세주아니 브랜드 레오나 드레이븐 나르
        champions2[35] = new Akali("아칼리", "암살자", "닌자", 4, 1260, 25, 126, 0.7, 20, 6, 2);
        champions2[36] = new Chogas("초가스", "싸움꾼", "공허", 4, 1800, 150, 126, 0.55, 20, 6, 2);
        champions2[37] = new Sejuani("세주아니","기사","빙하",4,1530,150,81,0.55,40,6,2);
        champions2[38] = new Brand("브랜드","원소술사","악마",4,1260,125,108,0.6,25,6,2);
        champions2[39] = new Kindred("킨드레드","정찰대","유령",4,1080,150,108,0.65,20,6,2);
        champions2[40] = new Leona("레오나","수호자","귀족",4,1350,100,81,0.55,100,6,2);
        champions2[41] = new Draven("드레이븐","검사","제국",4,1260,50,135,0.75,25,6,2);
        // 5성 케일 카서스 야스오 애니비아 스웨인 미스포츈


        champions3[0] = new Akali("아칼리", "암살자", "닌자", 4, 2520, 25, 252, 0.7, 20, 8, 3);
        champions3[1] = new Zed("제드", "암살자", "닌자", 2, 1800, 75, 234, 0.65, 25, 6, 3);
        champions3[2] = new Katarina("카타리나", "암살자", "제국", 3, 1620, 100, 180, 0.65, 20, 7, 3);
        champions3[3] = new Khazix("카직스", "암살자", "공허", 1, 1800, 50, 198, 0.6, 20, 5, 3);
        champions3[4] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3, 2520, 75, 270, 0.55, 30, 7, 3);
        champions3[5] = new Chogas("초가스", "싸움꾼", "공허", 4, 3600, 150, 252, 0.55, 20, 8, 3);
        champions3[6] = new Warwick("워윅", "싸움꾼", "야생", 1, 2160, 150, 180, 0.6, 30, 5, 3);
        champions3[7] = new Lexai("렉사이", "싸움꾼", "공허", 2, 2340, 150, 180, 0.65, 20, 6, 3);
        champions3[8] = new Bbobbi("뽀삐", "기사", "요들", 3, 2880, 75, 180, 0.5, 40, 7, 3);
        champions3[9] = new Darius("다리우스", "기사", "제국", 1, 2160, 100, 180, 0.5, 25, 5, 3);
        champions3[10] = new Garen("가렌", "기사", "귀족", 1, 2160, 100, 180, 0.55, 35, 5, 3);
        champions3[11] = new Modaekaiser("모데카이저", "기사", "유령", 1, 1980, 100, 180, 0.5, 35, 5, 3);

    }

    public void upgradCham(Deck myDeck, Que myQue) {

        int decksize = myDeck.deckSize();
        int quesize = myQue.queSize();
        int allSize = decksize + quesize; //덱과 대기열 전체 크기
        List<Champion> myAllCham = new ArrayList<Champion>(); //덱과 대기열의 모든 챔피언

        addDeckToAllCham(myAllCham, myDeck, decksize); //덱을 AllCham에 저장
        addQueToAllCham(myAllCham, myQue, quesize); //대기열을 AllCham에 저장

        int[] array1 = new int[allSize]; //1성 확인
        int[] array2 = new int[allSize]; //2성 확인

        totalDuplicate(myAllCham, array1, array2, allSize); //1성 2성 챔피언 전체 중복검사

        for (int i = 0; i < allSize; i++) {
            //1성 챔피언을 2성으로 바꿔주고 나머지 1성 챔프를 삭제
            if (array1[i] == 2) {
                //1성 3개가 모인경우

                int removeCnt = 0; //지운 챔피언의 수
                String removeCham = myAllCham.get(i).getName(); //지울 챔피언의 이름

                int immsiSize = allSize; //임시 사이즈 저장
                deleteFirstGrade(immsiSize, removeCham, myAllCham, removeCnt); //1성 챔피언 3개 삭제
                addSecondGrade(i, removeCham, myAllCham, array1); //2성 챔피언 1개 추가

            }

            //3성 업데이트할때 쓰기
            /*if (array2[i] == 2) { //2성 챔피언을 3성으로 바꿔주고 나머지 2성 챔프를 삭제
                //2성 3개가 모인경우

                int removeCnt = 0; //지운 챔피언의 수
                String removeCham = myAllCham.get(i).getName(); //지울 챔피언의 이름

                int immsiSize = allSize; //임시 사이즈 저장

                for (int a = 0; a < immsiSize; a++) {
                    //관련 1성챔프 3개 삭제

                    if ((removeCham.equals(myAllCham.get(a).getName())) && (removeCnt < 4)) {
                        //중복되는 이름이 있고
                        myAllCham.remove(a);
                        a--;
                        immsiSize--;
                        removeCnt++; // 3개 이상은 못지움

                    }
                }

                for (int b = 0; b < 12; b++) {
                    //2성챔피언 추가
                    if (removeCham.equals(champions3[b].getName())) {
                        //내가갖고있는 챔피언과 2성챔피언들의 이름을 비교함
                        myAllCham.add(champions3[b]); //2성 챔피언 추가
                        array1[i] = 0; //바꿨으니 0으로 초기화
                    }
                }
            }*/
        }

        returnToQueDeck(myAllCham, myQue, myDeck); //대기열과 덱에 다시 챔피언 배분
    }

    private void addSecondGrade(int i, String removeCham, List<Champion> myAllCham, int[] array1) {
        //2성 챔피언 1개 추가
        for (int b = 0; b < 12; b++) {
            if (removeCham.equals(champions2[b].getName())) {
                //내가갖고있는 챔피언과 2성챔피언들의 이름을 비교함
                myAllCham.add(champions2[b]); //2성 챔피언 추가
                array1[i] = 0; //바꿨으니 0으로 초기화
            }
        }
    }

    private void deleteFirstGrade(int immsiSize, String removeCham, List<Champion> myAllCham, int removeCnt) {
        //관련 1성챔프 3개 삭제

        for (int a = 0; a < immsiSize; a++) {

            if ((removeCham.equals(myAllCham.get(a).getName())) && (removeCnt < 4)) {
                //중복되는 이름이 있고
                myAllCham.remove(a);
                a--;
                immsiSize--;
                removeCnt++; // 3개 이상은 못지움

            }
        }
    }

    private void totalDuplicate(List<Champion> myAllCham, int[] array1, int[] array2, int allSize) {
        //1성 2성 전체 중복검사
        for (int i = 0; i < allSize; i++) {
            //덱과 대기열 챔프 중복검사
            if (myAllCham.get(i).getGrade() == 1) {
                duplicateDeckQue1(i, myAllCham, array1); //1성챔피언 덱과 대기열 챔프 중복검사
            }
            if (myAllCham.get(i).getGrade() == 2) {
                duplicateDeckQue2(i, myAllCham, array2); //2성챔피언 덱과 대기열 챔프 중복검사
            }

        }
    }

    private void addQueToAllCham(List myAllCham, Que myQue, int queSize) {
        for (int j = 0; j < queSize; j++) {
            //대기열을 한곳에 저장
            myAllCham.add(myQue.returnQue(0));
            myQue.deletQue(0); //저장한 대기열은 삭제
        }
    }

    private void addDeckToAllCham(List<Champion> myAllCham, Deck myDeck, int deckSize) {
        for (int i = 0; i < deckSize; i++) {
            //덱을 한곳에 저장
            myAllCham.add(myDeck.retCham(0));
            myDeck.deletDeck(1); //저장한 덱은 삭제
        }
    }

    private void duplicateDeckQue2(int i, List<Champion> myAllCham, int[] array2) {
        //2성인 경우
        for (int a = 0; a < i; a++) {
            if (myAllCham.get(i).getName().equals(myAllCham.get(a).getName())) {
                //내가 갖고있는 챔프중 이름이 중복되는 챔프가 있으면
                array2[i] += 1; //중복챔피언이라고 확인해줌
            }
        }

    }

    private void duplicateDeckQue1(int i, List<Champion> myAllCham, int[] array1) {
        //1성인 경우
        for (int a = 0; a < i; a++) {
            if (myAllCham.get(i).getName().equals(myAllCham.get(a).getName())) {
                //내가 갖고있는 챔프중 이름이 중복되는 챔프가 있으면
                array1[i] += 1; //중복챔피언이라고 확인해줌
            }
        }

    }

    private void returnToQueDeck(List<Champion> myAllCham, Que myQue, Deck myDeck) {
        //대기열과 덱에 다시 배분
        for (int i = 0; i < myAllCham.size(); i++) {
            if (myAllCham.size() < 9) {
                //넣으려는 챔피언 수가 9보다 작으면 다 대기열에 넣어버림
                myQue.addQue(myAllCham.get(i));
            }
            if (myAllCham.size() >= 9){ //9보다 크면 대기열에 9 나머지는 덱
                if (i < 9) {
                    myQue.addQue(myAllCham.get(i));
                }
                if (i >= 9){
                    myDeck.addDeck(myAllCham.get(i));
                }
            }
        }
    }
}