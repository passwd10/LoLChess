import Champion.*;
import Computer.*;
import GameProgress.*;
import MyInfo.*;
import Output.*;

import javax.swing.*;
import java.util.Random;
import java.util.Scanner;


public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Champion[] champions = new Champion[12]; //게임상에 있는 모든 챔피언들을 담은 배열

        Que myQue = new Que();
        Deck myDeck = new Deck();
        Shop shop = new Shop();
        Round round = new Round();
        ComDeck comDeck = new ComDeck();
        GameResult gameResult = new GameResult();
        Life life = new Life();
        Upgrade upgrade = new Upgrade(); //등급 업그레이드
        DeckOutput deckOutput = new DeckOutput(); //내 덱 출력 클래스
        QueOutput queOutput = new QueOutput(); //내 대기열 출력 클래스
        InfoOutput infoOutput = new InfoOutput(); //내 정보 출력 클래스
        ProgressOutput progressOutput = new ProgressOutput(); //게임 진행관련 출력
        GameResultOutput gameResultOutput = new GameResultOutput(); //최종 결과 출력

        // 챔피언
        //champions[0] = new Nar("나르", "형상변환자", "요들/야생", 4, 750, 125, 50, 0.7, 30, 4, 1);

        // 1성 피오라, 트리스타나, 카직스, 카사딘, 워윅, 엘리스, 베인, 모데카이저, 다리우스, 니달리, 그레이브즈, 가렌
        //이름,직업,종족, 티어,체력,마나,파워,공속,방어력,가격,등급
        champions[0] = new Khazix("카직스", "암살자", "공허", 1, 500, 50, 50, 0.6, 20, 1, 1);
        champions[1] = new Darius("다리우스", "기사", "제국", 1, 600, 100, 50, 0.5, 25, 1, 1);
        champions[2] = new Garen("가렌", "기사", "귀족", 1, 600, 100, 55, 0.55, 35, 1, 1);
        champions[3] = new Modaekaiser("모데카이저", "기사", "유령", 1, 550, 100, 50, 0.5, 35, 1, 1);
        champions[4] = new Warwick("워윅", "싸움꾼", "야생", 1, 600, 150, 50, 0.6, 30, 1, 1);
        /*champions[6] = new Fiora("피오라", "검사", "귀족", 1, 400, 75, 40, 1.0, 25, 1, 1);
        champions[7] = new Tristana("트리스타나", "총잡이", "요들", 1, 500, 50, 50, 0.7, 20, 1, 1);
        champions[8] = new Kassadin("카사딘", "마법사", "공허", 1, 550, 0, 55, 0.6, 25, 1, 1);
        champions[9] = new Elise("엘리스", "형상변환자", "악마", 1, 450, 100, 45, 0.6, 20, 1, 1);
        champions[10] = new Vayne("베인", "정찰대", "귀족", 1, 550, 0, 40, 0.75, 25, 1, 1);
        champions[11] = new Nidalee("니달리", "형상변환자", "야생", 1, 500, 100, 50, 0.65, 20, 1, 1);
        champions[12] = new Graves("그레이브즈", "총잡이", "해적", 1, 450, 0, 55, 0.55, 20, 1, 1);
*/
        // 2성 파이크, 트위스트페이트, 제드, 아리, 쉔, 브라움, 바루스, 리산드라, 룰루, 루시안, 렉사이
        champions[5] = new Lexai("렉사이", "싸움꾼", "공허", 2, 650, 150, 40, 0.65, 20, 2, 1);
        champions[6] = new Zed("제드", "암살자", "닌자", 2, 500, 75, 60, 0.65, 25, 2, 1);
        /*champions[15] = new Pike("파이크", "암살자", "해적", 2, 600, 125, 60, 0.6, 25, 2, 1);
        champions[16] = new TwistedFate("트위스트페이트", "마법사", "해적", 2, 450, 50, 40, 0.7, 20, 2, 1);
        champions[17] = new Ahri("아리", "마법사", "야생", 2, 450, 75, 50, 0.55, 20, 2, 1);
        champions[18] = new Shen("쉔", "검사", "닌자", 2, 650, 150, 65, 0.7, 30, 2, 1);
        champions[19] = new Braum("브라움", "수호자", "빙하", 2, 750, 50, 40, 0.6, 75, 2, 1);
        champions[20] = new Varus("바루스", "정찰대", "악마", 2, 500, 75, 50, 0.7, 25, 2, 1);
        champions[21] = new Lissandra("리산드라", "원소술사", "빙하", 2, 450, 150, 40, 0.6, 20, 2, 1);
        champions[22] = new Lulu("룰루", "마법사", "요들", 2, 500, 150, 50, 0.6, 25, 2, 1);
        champions[23] = new Lucian("루시안", "총잡이", "귀족", 2, 600, 35, 65, 0.65, 25, 2, 1);
*/
        // 3성 케넨 카타리나 이블린 애쉬 아트록스 뽀삐 볼리베어 베이가 모르가나 렝가 갱플랭크
        champions[7] = new Bbobbi("뽀삐", "기사", "요들", 3, 800, 75, 50, 0.5, 40, 3, 1);
        champions[8] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3, 700, 75, 75, 0.55, 30, 3, 1);
        champions[9] = new Katarina("카타리나", "암살자", "제국", 3, 450, 100, 50, 0.65, 20, 3, 1);
        /*champions[27] = new Kennen("케넨", "원소술사", "요들/닌자", 3, 550, 150, 70, 0.65, 20, 3, 1);
        champions[28] = new Evelynn("이블린", "암살자", "악마", 3, 600, 75, 70, 0.6, 20, 3, 1);
        champions[29] = new Ashe("애쉬", "정찰대", "빙하", 3, 550, 100, 65, 0.7, 20, 3, 1);
        champions[30] = new Aatrox("아트록스", "검사", "악마", 3, 700, 75, 65, 0.65, 25, 3, 1);
        champions[31] = new Veigar("베이가", "마법사", "요들", 3, 500, 75, 45, 0.55, 20, 3, 1);
        champions[32] = new Morgana("모르가나", "마법사", "악마", 3, 650, 150, 50, 0.6, 20, 3, 1);
        champions[33] = new Rengar("렝가", "암살자", "야생", 3, 550, 75, 70, 0.6, 20, 3, 1);
        champions[34] = new Gangplank("갱플랭크", "검사/총잡이", "해적", 3, 700, 100, 55, 0.65, 20, 3, 1);
*/
        // 4성 킨드레드 초가스 아칼리 세주아니 브랜드 레오나 드레이븐 나르
        champions[10] = new Akali("아칼리", "암살자", "닌자", 4, 640, 25, 70, 2, 20, 4, 1);
        champions[11] = new Chogas("초가스", "싸움꾼", "공허", 4, 1000, 150, 70, 0.55, 20, 4, 1);
       /* champions[37] = new Sejuani("세주아니", "기사", "빙하", 4, 850, 150, 45, 0.55, 40, 4, 1);
        champions[38] = new Brand("브랜드", "원소술사", "악마", 4, 700, 125, 60, 0.6, 25, 4, 1);
        champions[39] = new Kindred("킨드레드", "정찰대", "유령", 4, 600, 150, 60, 0.65, 20, 4, 1);
        champions[40] = new Leona("레오나", "수호자", "귀족", 4, 750, 100, 45, 0.55, 100, 4, 1);
        champions[41] = new Draven("드레이븐", "검사", "제국", 4, 700, 50, 75, 0.75, 25, 4, 1);
        */// 5성 케일 카서스 야스오 애니비아 스웨인 미스포츈


        Champion[] chamList = new Champion[5]; //상점에서 챔피언 리스트는 5개만 보여줌

        Random random = new Random();

        int gameRound = 1;
        int roundResult; //각 라운드의 결과

        progressOutput.tutorial(); //게임 튜토리얼

        Level myLevel = new Level(1); //1레벨부터 시작
        Gold myGold = new Gold(100); //내 골드
        life.setLife(10); //생명력은 10으로 시작

        shop.emergeCham(chamList, champions, myLevel); //챔피언 무작위 호출

        while (life.getLife() > 0) {

            progressOutput.firstScreen(gameRound); //라운드 첫화면 출력
            //gameContent(myLevel, myGold); //게임 컨텐츠 실행
            int[] purchased = new int[5]; //이미 구매한 챔피언들을 걸러내기 위한 표시

            int select = sc.nextInt();

            if (select == 1) {
                shop.makeShop(champions, chamList, myQue, myGold, myLevel, purchased);
                queOutput.outputQue(myQue); //내 대기열 출력
                infoOutput.goldOutput(myGold); //내 골드 출력
                upgrade.upgradCham(myDeck, myQue);
            }
            if (select == 2) { //대기열 세팅
                myQue.setMyQue(myLevel, myQue, myDeck, myGold);
            }
            if (select == 3) { //덱 세팅
                myDeck.setMyDeck(myQue, myDeck);
            }
            if (select == 4) { //내 정보 출력
                myInfo(infoOutput, queOutput, deckOutput, myLevel, myGold, life, myQue, myDeck); //내 정보 출력

            }
            if (select == 0) { //전투 시작
                roundResult = 0; //초기화

                round.forcedInsert(myDeck, myQue, myLevel); //챔피언이 모자랄시 강제 삽입

                round.chamReset(myDeck); //내 챔피언 초기화

                comDeck.chooseDeck(gameRound); //컴퓨터 덱 설정
                roundResult = round.startStage(gameRound, myDeck, comDeck); //내덱,내돈, 3라운드, 챔피언3개
                gameResult.gameResult(roundResult, myGold, life, myLevel); //라운드 결과 출력
                if (gameRound == 10) {
                    gameResultOutput.outputTotalResult(myLevel, myGold, life); //최종 결과 출력
                    break; //게임 종료
                }
                gameRound++; //게임라운드 up
                shop.emergeCham(chamList, champions, myLevel); //챔피언 무작위 호출
                for (int i = 0; i < 5; i++) {
                    purchased[i] = 0; //구매한 챔피언 초기화
                }
            }
            if (select > 4) {
                System.out.println("다시 입력해주세요");
            }

            if(life.getLife() <= 0) {
                //생명력 0이하일때
                System.out.println("  생명력이 0 이 되었습니다. 게임을 종료합니다.");
            }
        }
    }

    private static void myInfo(InfoOutput infoOutput, QueOutput queOutput, DeckOutput deckOutput, Level myLevel, Gold myGold, Life life, Que myQue, Deck myDeck) {
        System.out.println("┌──────────────────┐");
        infoOutput.levelOutput(myLevel); // 레벨출력
        infoOutput.goldOutput(myGold); //골드출력
        infoOutput.lifeOutput(life); //라이프 출력
        System.out.println("└──────────────────┘\n");
        queOutput.outputQue(myQue); //대기열 출력
        deckOutput.outputDeck(myDeck); //덱 출력
    }


}
