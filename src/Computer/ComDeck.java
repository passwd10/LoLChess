package Computer;

import Champion.*;

import java.util.ArrayList;

public class ComDeck {
    //컴퓨터의 라운드 별 덱

    Champion[] monsters = new Champion[10]; //갖고있는 몬스터 목록
    Champion[] champions = new Champion[20]; //갖고있는 챔피언 목록

    ArrayList<Champion> comDeck = new ArrayList<Champion>(); //컴퓨터 덱 목록

    public ComDeck() {
        //몇라운드인지 입력받음

        monsters[0] = new Minion("근거리미니언1","","",0,477,0,12,1.25,0,0,0);
        monsters[1] = new Minion("근거리미니언2","","",0,477,0,12,1.25,0,0,0);
        monsters[2] = new Minion("원거리리미니언1","","",0,296,0,24,0.667,0,0,0);
        monsters[3] = new Minion("원거리리미니언2","","",0,296,0,24,0.667,0,0,0);

        champions[0] = new Akali("아칼리", "암살자", "닌자", 4,640, 25, 70, 2, 20, 4, 1);
        champions[1] = new Zed("제드", "암살자", "닌자", 2,500, 75, 60, 0.65, 25, 2, 1);
        champions[2] = new Katarina("카타리나", "암살자", "제국",3, 450, 100, 50, 0.65, 20, 3, 1);
        champions[3] = new Khazix("카직스", "암살자", "공허", 1,500, 50, 50, 0.6, 20, 1, 1);
        champions[4] = new Bolibear("볼리베어", "싸움꾼", "빙하", 3,700, 75, 75, 0.55, 30, 3, 1);
        champions[5] = new Chogas("초가스", "싸움꾼", "공허", 4,1000, 150, 70, 0.55, 20, 4, 1);
        champions[6] = new Warwick("워윅", "싸움꾼", "야생", 1,600, 150, 50, 0.6, 30, 1, 1);
        champions[7] = new Lexai("렉사이", "싸움꾼", "공허", 1,650, 150, 40, 0.65, 20, 2, 1);
        champions[8] = new Bbobbi("뽀삐", "기사", "요들",1, 800, 75, 50, 0.5, 40, 3, 1);
        champions[9] = new Darius("다리우스", "기사", "제국",1, 600, 100, 50, 0.5, 25, 1, 1);
        champions[10] = new Garen("가렌", "기사", "귀족",1, 600, 100, 55, 0.55, 35, 1, 1);
        champions[11] = new Modaekaiser("모데카이저", "기사", "유령",1, 550, 100, 50, 0.5, 35, 1, 1);

    }

    public void chooseDeck(int roundNum) {
        if(roundNum == 1) { //1라운드
            comDeck.add(monsters[0]);
            comDeck.add(monsters[1]);
        }
        else if(roundNum == 2) { //2라운드
            comDeck.add(monsters[0]);
            comDeck.add(monsters[1]);
            comDeck.add(monsters[2]);
        } else if(roundNum == 3) { //3라운드
            comDeck.add(monsters[0]);
            comDeck.add(monsters[1]);
            comDeck.add(monsters[2]);
            comDeck.add(monsters[3]);
        } else if(roundNum == 4) {
            comDeck.add(champions[0]);
            comDeck.add(champions[1]);
        } else if(roundNum == 5) {

        } else if(roundNum == 6) {

        }
    }


    public void clearDeck() {
        //덱의 챔피언 삭제
        comDeck.clear();
    }

    public Champion retCham(int i) {
        //내 덱에서 싸울 챔피언을 반환해줌
        Champion fightCham = comDeck.get(i);
        return fightCham;
    }

    public int deckSize() { //덱 사이즈
        return comDeck.size();
    }



}
