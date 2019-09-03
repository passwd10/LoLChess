package Computer;

import Champion.*;
import Common.*;

import java.util.ArrayList;
import java.util.List;

public class ComDeck {
    //컴퓨터의 라운드 별 덱

    AllUnit[] monsters = new Monster[10]; //갖고있는 몬스터 목록
    AllUnit[] champions = new Champion[42]; //갖고있는 챔피언 목록
    AllUnit[] champions2 = new Champion[42]; //갖고있는 챔피언 목록
    AllUnit[] champions3 = new Champion[42]; //갖고있는 챔피언 목록

    List comDeck = new ArrayList<AllUnit>(); //컴퓨터 덱 목록

    public ComDeck() {
        //몇라운드인지 입력받음
        
        monsters[0] = new Minion("근거리미니언1",477,0,12,1.25,0);
        monsters[1] = new Minion("근거리미니언2",477,0,12,1.25,0);
        monsters[2] = new Minion("원거리미니언1",296,0,24,0.667,0);
        monsters[3] = new Minion("원거리미니언2",296,0,24,0.667,0);
        monsters[4] = new Dragon("드래곤",3500,0,100,0.5,0);

        //챔피언
        //아트록스, 아리, 아칼리, 애쉬, 뽀삐, 볼리베어, 브랜드, 브라움, 초가서, 다리우스, 드레이븐, 엘리스, 이블린, 피오라, 갱플

        champions[0] = new Nar("나르(봇)","형상변환자","요들/야생",4,750,125,50,0.7,30,4,1);

        // 1성 피오라, 트리스타나, 카직스, 카사딘, 워윅, 엘리스, 베인, 모데카이저, 다리우스, 니달리, 그레이브즈, 가렌
        //이름,직업,종족, 티어,체력,마나,파워,공속,방어력,가격,등급
        champions[1] = new Khazix("카직스(봇)", "암살자", "공허", 1, 500, 50, 50, 0.6, 20, 1, 1);
        champions[2] = new Darius("다리우스(봇)", "기사", "제국", 1, 600, 100, 50, 0.5, 25, 1, 1);
        champions[3] = new Garen("가렌(봇)", "기사", "귀족", 1, 600, 100, 55, 0.55, 35, 1, 1);
        champions[4] = new Modaekaiser("모데카이저(봇)", "기사", "유령", 1, 550, 100, 50, 0.5, 35, 1, 1);
        champions[5] = new Warwick("워윅(봇)", "싸움꾼", "야생", 1, 600, 150, 50, 0.6, 30, 1, 1);
        champions[6] = new Fiora("피오라(봇)","검사","귀족",1,400,75,40,1.0,25,1,1);
        champions[7] = new Tristana("트리스타나(봇)","총잡이","요들",1,500,50,50,0.7,20,1,1);
        champions[8] = new Kassadin("카사딘(봇)","마법사","공허",1,550,0,55,0.6,25,1,1);
        champions[9] = new Elise("엘리스(봇)","형상변환자","악마",1,450,100,45,0.6,20,1,1);
        champions[10] = new Vayne("베인(봇)","귀족","정찰대",1,550,0,40,0.75,25,1,1);
        champions[11] = new Nidalee("니달리(봇)","형상변환자","야생",1,500,100,50,0.65,20,1,1);
        champions[12] = new Graves("그레이브즈(봇)","총잡이","해적",1,450,0,55,0.55,20,1,1);

        // 2성 파이크, 트위스트페이트, 제드, 아리, 쉔, 브라움, 바루스, 리산드라, 룰루, 루시안, 렉사이
        champions[13] = new Lexai("렉사이(봇)", "싸움꾼", "공허", 2, 650, 150, 40, 0.65, 20, 2, 1);
        champions[14] = new Zed("제드(봇)", "암살자", "닌자", 2, 500, 75, 60, 0.65, 25, 2, 1);
        champions[15] = new Pike("파이크(봇)","암살자","해적",2,600,125,60,0.6,25,2,1);
        champions[16] = new TwistedFate("트위스트페이트(봇)","마법사","해적",2,450,50,40,0.7,20,2,1);
        champions[17] = new Ahri("아리(봇)","마법사","야생",2,450,75,50,0.55,20,2,1);
        champions[18] = new Shen("쉔(봇)","검사","닌자",2,650,150,65,0.7,30,2,1);
        champions[19] = new Braum("브라움(봇)","수호자","빙하",2,750,50,40,0.6,75,2,1);
        champions[20] = new Varus("바루스(봇)","정찰대","악마",2,500,75,50,0.7,25,2,1);
        champions[21] = new Lissandra("리산드라(봇)","원소술사","빙하",2,450,150,40,0.6,20,2,1);
        champions[22] = new Lulu("룰루(봇)","마법사","요들",2,500,150,50,0.6,25,2,1);
        champions[23] = new Lucian("루시안(봇)","총잡이","귀족",2,600,35,65,0.65,25,2,1);

        // 3성 케넨 카타리나 이블린 애쉬 아트록스 뽀삐 볼리베어 베이가 모르가나 렝가 갱플랭크
        champions[24] = new Bbobbi("뽀삐(봇)", "기사", "요들", 3, 800, 75, 50, 0.5, 40, 3, 1);
        champions[25] = new Bolibear("볼리베어(봇)", "싸움꾼", "빙하", 3, 700, 75, 75, 0.55, 30, 3, 1);
        champions[26] = new Katarina("카타리나(봇)", "암살자", "제국", 3, 450, 100, 50, 0.65, 20, 3, 1);
        champions[27] = new Kennen("케넨(봇)","원소술사","요들/닌자",3,550,150,70,0.65,20,3,1);
        champions[28] = new Evelynn("이블린(봇)","암살자","악마",3,600,75,70,0.6,20,3,1);
        champions[29] = new Ashe("애쉬(봇)","정찰대","빙하",3,550,100,65,0.7,20,3,1);
        champions[30] = new Aatrox("아트록스(봇)","검사","악마",3,700,75,65,0.65,25,3,1);
        champions[31] = new Veigar("베이가(봇)","마법사","요들",3,500,75,45,0.55,20,3,1);
        champions[32] = new Morgana("모르가나(봇)","마법사","악마",3,650,150,50,0.6,20,3,1);
        champions[33] = new Rengar("렝가(봇)","암살자","야생",3,550,75,70,0.6,20,3,1);
        champions[34] = new Gangplank("갱플랭크(봇)","검사/총잡이","해적",3,700,100,55,0.65,20,3,1);

        // 4성 킨드레드 초가스 아칼리 세주아니 브랜드 레오나 드레이븐 나르
        champions[35] = new Akali("아칼리(봇)", "암살자", "닌자", 4, 640, 25, 70, 0.7, 20, 4, 1);
        champions[36] = new Chogas("초가스(봇)", "싸움꾼", "공허", 4, 1000, 150, 70, 0.55, 20, 4, 1);
        champions[37] = new Sejuani("세주아니(봇)","기사","빙하",4,850,150,45,0.55,40,4,1);
        champions[38] = new Brand("브랜드(봇)","원소술사","악마",4,700,125,60,0.6,25,4,1);
        champions[39] = new Kindred("킨드레드(봇)","정찰대","유령",4,600,150,60,0.65,20,4,1);
        champions[40] = new Leona("레오나(봇)","수호자","귀족",4,750,100,45,0.55,100,4,1);
        champions[41] = new Draven("드레이븐(봇)","검사","제국",4,700,50,75,0.75,25,4,1);

        //2성
        champions2[0] = new Akali("아칼리(봇)", "암살자", "닌자", 4, 1260, 25, 126, 0.7, 20, 6, 2);
        champions2[1] = new Chogas("초가스(봇)", "싸움꾼", "공허", 4, 1800, 150, 126, 0.55, 20, 6, 2);
        champions2[2] = new Sejuani("세주아니(봇)","기사","빙하",4,1530,150,81,0.55,40,6,2);
        champions2[3] = new Brand("브랜드(봇)","원소술사","악마",4,1260,125,108,0.6,25,6,2);
        champions2[4] = new Kindred("킨드레드(봇)","정찰대","유령",4,1080,150,108,0.65,20,6,2);
        champions2[5] = new Leona("레오나(봇)","수호자","귀족",4,1350,100,81,0.55,100,6,2);
        champions2[6] = new Draven("드레이븐(봇)","검사","제국",4,1260,50,135,0.75,25,6,2);


        //3성
        champions3[0] = new Akali("아칼리(봇)", "암살자", "닌자", 4, 2520, 25, 252, 0.7, 20, 8, 3);
        champions3[1] = new Zed("제드(봇)", "암살자", "닌자", 2, 1800, 75, 234, 0.65, 25, 6, 3);
        champions3[2] = new Katarina("카타리나(봇)", "암살자", "제국", 3, 1620, 100, 180, 0.65, 20, 7, 3);
        champions3[3] = new Khazix("카직스(봇)", "암살자", "공허", 1, 1800, 50, 198, 0.6, 20, 5, 3);
        champions3[4] = new Bolibear("볼리베어(봇)", "싸움꾼", "빙하", 3, 2520, 75, 270, 0.55, 30, 7, 3);
        champions3[5] = new Chogas("초가스(봇)", "싸움꾼", "공허", 4, 3600, 150, 252, 0.55, 20, 8, 3);
        champions3[6] = new Warwick("워윅(봇)", "싸움꾼", "야생", 1, 2160, 150, 180, 0.6, 30, 5, 3);
        champions3[7] = new Lexai("렉사이(봇)", "싸움꾼", "공허", 2, 2340, 150, 180, 0.65, 20, 6, 3);
        champions3[8] = new Bbobbi("뽀삐(봇)", "기사", "요들", 3, 2880, 75, 180, 0.5, 40, 7, 3);
        champions3[9] = new Darius("다리우스(봇)", "기사", "제국", 1, 2160, 100, 180, 0.5, 25, 5, 3);
        champions3[10] = new Garen("가렌(봇)", "기사", "귀족", 1, 2160, 100, 180, 0.55, 35, 5, 3);
        champions3[11] = new Modaekaiser("모데카이저(봇)", "기사", "유령", 1, 1980, 100, 180, 0.5, 35, 5, 3);

    }

    public void chooseDeck(int roundNum) {
        if(roundNum == 1) { //1라운드 근거리1,2
            //comDeck.add(champions[2]);
            //comDeck.add(champions[5]);
            comDeck.add((AllUnit)monsters[0]);
            comDeck.add((AllUnit)monsters[1]);
        }
        if(roundNum == 2) { //2라운드 근거리 1,2 원거리1
            comDeck.add(monsters[0]);
            comDeck.add(monsters[1]);
            comDeck.add(monsters[2]);
        }
        if(roundNum == 3) { //3라운드 근거리1,2 원거리1,2
            comDeck.add(monsters[0]);
            comDeck.add(monsters[1]);
            comDeck.add(monsters[2]);
            comDeck.add(monsters[3]);
        }
        if(roundNum == 4) { //4라운드 카직스, 다리우스
            comDeck.add(champions[1]);
            comDeck.add(champions[2]);
        }
        if(roundNum == 5) { //가렌, 모데카이져, 워윅
            comDeck.add(champions[3]);
            comDeck.add(champions[4]);
            comDeck.add(champions[5]);
        }
        if(roundNum == 6) { //2성 1개 1성 2개
            comDeck.add(champions2[0]);
            comDeck.add(champions[4]);
            comDeck.add(champions[5]);
        }
        if(roundNum == 7) { //2성 2개 1성 2개
            comDeck.add(champions2[0]);
            comDeck.add(champions2[1]);
            comDeck.add(champions[13]);
            comDeck.add(champions[14]);
        }
        if(roundNum == 8) { //2성 3개 1성 1개
            comDeck.add(champions2[0]);
            comDeck.add(champions2[1]);
            comDeck.add(champions2[2]);
            comDeck.add(champions[24]);
        }
        if(roundNum == 9) {  //3성 1개 2성 2개 1성2개
            comDeck.add(champions3[0]);
            comDeck.add(champions3[1]);
            comDeck.add(champions3[2]);
            comDeck.add(champions2[3]);
            comDeck.add(champions2[4]);
            comDeck.add(champions[152]);
        }
        if(roundNum == 10) { //용
            comDeck.add(monsters[4]);
        }
    }

    public void clearDeck() {
        //덱의 챔피언 삭제
        comDeck.clear();
    }

    public AllUnit retCham(int chamNum) {
        //컴퓨터 덱에서 싸울 챔피언을 반환해줌
        AllUnit unit = (AllUnit)comDeck.get(chamNum);
        return unit;
    }

    public AllUnit[] allUnits() {
        //컴퓨터 덱의 모든 유닛을 반환
        AllUnit[] allComDeck = new AllUnit[comDeck.size()];

        for(int i=0; i<comDeck.size(); i++) {
            allComDeck[i] = (AllUnit)comDeck.get(i);
        }

        return allComDeck;
    }

    public int deckSize() { //덱 사이즈
        return comDeck.size();
    }



}
