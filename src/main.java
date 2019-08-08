import Champion.*;
import Computer.*;
import GameProgress.GameResult;
import GameProgress.Round;
import GameProgress.Shop;
import MyInfo.*;

import java.util.Random;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {

        Champion[] champions = new Champion[12]; //게임상에 있는 모든 챔피언들을 담은 배열
        Champion[] champions2 = new Champion[12]; //2성 챔피언
        Champion[] champions3 = new Champion[12]; //3성 챔피언
        Champion[] botChampions = new Champion[12]; //챔피언 봇 배열

        Que myQue = new Que();
        Deck myDeck = new Deck();
        Shop shop = new Shop();
        Round round = new Round();
        ComDeck comDeck = new ComDeck();
        GameResult gameResult = new GameResult();
        Life life = new Life();

        champions[0] = new Akali("아칼리", "암살자", "닌자", 4, 640, 25, 70, 2, 20, 4, 1);
        champions[1] = new Zed("제드", "암살자", "닌자", 2, 500, 75, 60, 0.65, 25, 2, 1);
        champions[2] = new Katarina("카타리나", "암살자", "제국", 3, 450, 100, 50, 0.65, 20, 3, 1);
        champions[3] = new Khazix("카직스", "암살자", "공허", 1, 500, 50, 50, 0.6, 20, 1, 1);
        champions[4] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3, 700, 75, 75, 0.55, 30, 3, 1);
        champions[5] = new Chogas("초가스", "싸움꾼", "공허", 4, 1000, 150, 70, 0.55, 20, 4, 1);
        champions[6] = new Warwick("워윅", "싸움꾼", "야생", 1, 600, 150, 50, 0.6, 30, 1, 1);
        champions[7] = new Lexai("렉사이", "싸움꾼", "공허", 1, 650, 150, 40, 0.65, 20, 2, 1);
        champions[8] = new Bbobbi("뽀삐", "기사", "요들", 1, 800, 75, 50, 0.5, 40, 3, 1);
        champions[9] = new Darius("다리우스", "기사", "제국", 1, 600, 100, 50, 0.5, 25, 1, 1);
        champions[10] = new Garen("가렌", "기사", "귀족", 1, 600, 100, 55, 0.55, 35, 1, 1);
        champions[11] = new Modaekaiser("모데카이저", "기사", "유령", 1, 550, 100, 50, 0.5, 35, 1, 1);

        botChampions[0] = new Akali("아칼리", "암살자", "닌자", 4, 640, 25, 70, 2, 20, 4, 1);
        botChampions[1] = new Zed("제드", "암살자", "닌자", 2, 500, 75, 60, 0.65, 25, 2, 1);
        botChampions[2] = new Katarina("카타리나", "암살자", "제국", 3, 450, 100, 50, 0.65, 20, 3, 1);
        botChampions[3] = new Khazix("카직스", "암살자", "공허", 1, 500, 50, 50, 0.6, 20, 1, 1);
        botChampions[4] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3, 700, 75, 75, 0.55, 30, 3, 1);
        botChampions[5] = new Chogas("초가스", "싸움꾼", "공허", 4, 1000, 150, 70, 0.55, 20, 4, 1);
        botChampions[6] = new Warwick("워윅", "싸움꾼", "야생", 1, 600, 150, 50, 0.6, 30, 1, 1);
        botChampions[7] = new Lexai("렉사이", "싸움꾼", "공허", 1, 650, 150, 40, 0.65, 20, 2, 1);
        botChampions[8] = new Bbobbi("뽀삐", "기사", "요들", 1, 800, 75, 50, 0.5, 40, 3, 1);
        botChampions[9] = new Darius("다리우스", "기사", "제국", 1, 600, 100, 50, 0.5, 25, 1, 1);
        botChampions[10] = new Garen("가렌", "기사", "귀족", 1, 600, 100, 55, 0.55, 35, 1, 1);
        botChampions[11] = new Modaekaiser("모데카이저", "기사", "유령", 1, 550, 100, 50, 0.5, 35, 1, 1);

        Scanner sc = new Scanner(System.in);

        Champion[] chamList = new Champion[5]; //상점에서 챔피언 리스트는 5개만 보여줌

        Random random = new Random();

        int gameRound = 0;
        int roundResult; //각 라운드의 결과

        Level myLevel = new Level(1); //1레벨부터 시작
        Gold myGold = new Gold(100); //내 골드
        life.setLife(100); //생명력은 100으로 시작

        while (life.getLife() > 0) {
            gameRound++;
            roundResult = 0; //초기화

            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음
                chamList[i] = champions[random.nextInt(12)]; //0~11까지 임의의 숫자 랜덤입력

                for (int a = 0; a < i; a++) { //챔피언 중복검사
                    if (chamList[a] == chamList[i]) {
                        i--;
                        break;
                    }
                }
            }

            System.out.println("1. 챔피언 상점");
            System.out.println("2. 전투덱 설정");
            System.out.println("2. 대기열 설정");
            System.out.println("4. 나의 정보");
            int select = sc.nextInt();

            if(select == 1) {
                shop.showShop(champions, chamList, myQue, myGold, myLevel);
            } else if(select == 2) {

            } else if(select == 2) {

            } else if(select == 2) {

            } else {
                System.out.println("다시 입력해주세요");
            }

            myQue.output(); //내 대기열 출력

            myGold.output(); //내 골드 출력

            myDeck.setMyDeck(myLevel, myQue, myDeck, myGold);

            myDeck.output(); //내 덱 출력

            round.chamReset(myDeck); //내 챔피언 초기화

            comDeck.chooseDeck(gameRound); //컴퓨터 덱 설정
            roundResult = round.startStage(gameRound, myDeck, myGold, comDeck); //내덱,내돈, 3라운드, 챔피언3개
            gameResult.gameResult(roundResult, myGold, life, myLevel); //라운드 결과 출력

        }
    }
}
