package MyInfo;

import Champion.Champion;

import java.util.ArrayList;
import java.util.Scanner;

public class Deck extends MyInfo {

    ArrayList<Champion> myDeck = new ArrayList(); //나의 챔피언 덱 목록

    Scanner sc = new Scanner(System.in);

    public void addDeck(Champion champion) {
        //덱에 챔피언 저장하는 메소드
        myDeck.add(champion); //대기열에 추가
        System.out.println(champion.getName() + "을(를) 덱에 넣었습니다.");
    }

    public Champion deletDeck(int i) {
        //덱의 챔피언 삭제
        Champion delete = myDeck.get(i-1);
        myDeck.remove(delete);
        return delete;
    }

    public Champion retCham(int i) {
        //내 덱에서 싸울 챔피언을 반환해줌
        Champion fightCham = myDeck.get(i);
        return fightCham;
    }

    public int deckSize() { //덱 사이즈
        return myDeck.size();
    }

    public int isDeck(Champion champion) { //덱에 겹치는 챔프가 있는지 확인해줌
        for (int i = 0; i < deckSize(); i++) {
            if (myDeck.get(i).getName().equals(champion.getName())) {
                return 0;
            }
        }
        return 1;
    }

    public void setMyDeck(Que myQue, Deck myDeck) {

        while (true) {
            int canInput = myDeck.deckSize();

            System.out.println("┌──────────────────┐");
            System.out.println("│             전투덱 설정            │");
            System.out.println("└──────────────────┘");
            System.out.println("   1. 챔피언을 대기열로 이동");
            System.out.println("   2. 전투덱 조합 확인");
            System.out.println("   0. 뒤로가기");

            int su = sc.nextInt();
            if (su == 0) {
                break;
            } else if (su == 1) {
                if (su == 1) {
                    if (myDeck.output() == 1) { // 내 덱 출력
                        System.out.println("대기열에 넣을 챔피언을 선택해주세요(번호입력/ 뒤로가기는 0)");
                        int aa = sc.nextInt();
                        if (aa == 0) {

                        } else {
                            myQue.addQue(myDeck.deletDeck(aa));
                            //해당 챔피언 대기열에서 삭제, 덱에 추가
                        }
                    }
                }
            } else if (su == 2) {
                int brawler = 0; //싸움꾼
                int assasin = 0; //암살자
                int knight = 0; //기사

                if (myDeck.output() == 1) { //덱 출력

                    for (int i = 0; i < myDeck.deckSize(); i++) { //덱에 있는 챔피언 직업 확인
                        if (myDeck.retCham(i).getcClass().equals("싸움꾼")) {
                            brawler++;
                        } else if (myDeck.retCham(i).getcClass().equals("암살자")) {
                            assasin++;
                        } else if (myDeck.retCham(i).getcClass().equals("기사")) {
                            knight++;
                        }
                    }

                    if (brawler > 0 && brawler < 3) {
                        System.out.println("   싸움꾼 : " + brawler);
                    } else if (brawler >= 3 && brawler < 6) {
                        System.out.println("   싸움꾼 : " + brawler + " (초기)");
                    } else if (brawler >= 6) {
                        System.out.println("   싸움꾼 : " + brawler + " (최종)");
                    }

                    if (assasin > 0 && assasin < 3) {
                        System.out.println("   암살자 : " + assasin);
                    } else if (assasin >= 3 && brawler < 6) {
                        System.out.println("   암살자 : " + assasin + " (초기)");
                    } else if (assasin >= 6) {
                        System.out.println("   암살자 : " + assasin + " (최종)");
                    }

                    if (knight > 0 && knight < 2) {
                        System.out.println("   기사 : " + knight);
                    } else if (knight >= 2 && knight < 4) {
                        System.out.println("   기사 : " + knight + " (초기)");
                    } else if (knight >= 4 && knight < 6) {
                        System.out.println("   기사 : " + knight + " (중기)");
                    } else if (knight >= 6) {
                        System.out.println("   기사 : " + knight + " (최종)");
                    }

                } else {

                }
            }
        }
    }


    @Override
    public int output() {
        System.out.println("┌──────────────────┐");
        System.out.println("│           나의 챔피언 덱           │");
        System.out.println("└──────────────────┘");
        if(myDeck.size() == 0) {
            System.out.println("   덱에 챔피언이 없습니다.\n");
            return 0;
        }
        else {
            for (int i = 0; i < myDeck.size(); i++) {
                System.out.println("   "+(i + 1) + ". " + myDeck.get(i).getName() + "(" + myDeck.get(i).getcClass() + ")\t" + myDeck.get(i).getGrade() + "성\t\t" + myDeck.get(i).getGold()+ "원");
            }
            System.out.println("");
            return 1;
        }
    }
}
