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

    public void setMyDeck(Que myQue, Deck myDeck, Gold myGold) {

        while(true) {
            System.out.println("-------------------------------------");
            System.out.println("\t\t덱 설정 페이지 입니다");
            System.out.println("-------------------------------------");
            System.out.println("1. 대기열에서 덱으로 옮김");
            System.out.println("2. 덱에서 대기열로 옮김");
            System.out.println("3. 대기열에서 챔피언 판매");
            System.out.println("0. 종료 및 전투 시작");
            int su = sc.nextInt();
            if (su == 0) {
                break;
            } else if (su == 1) {
                if(myQue.output()==1) { // 내 대기열 출력
                    System.out.println("덱에 넣을 챔피언을 선택해주세요(번호입력/ 뒤로가기는 0)");
                    int aa = sc.nextInt();
                    if(aa==0) {

                    }
                    else {
                        if (isDeck(myQue.returnQue(aa)) == 0) {
                            System.out.println("덱에 챔피언을 중복해서 넣을 수 없습니다.");
                        } else {
                            myDeck.addDeck(myQue.deletQue(aa));
                            //해당 챔피언 대기열에서 삭제, 덱에 추가
                        }
                    }
                }

            } else if (su == 2) {
                if(myDeck.output()==1) { // 내 덱 출력
                    System.out.println("대기열에 넣을 챔피언을 선택해주세요(번호입력/ 뒤로가기는 0)");
                    int aa = sc.nextInt();
                    if(aa==0) {

                    }
                    else {
                        myQue.addQue(myDeck.deletDeck(aa));
                        //해당 챔피언 대기열에서 삭제, 덱에 추가
                    }
                }
            } else if (su == 3) {
                if(myQue.output() == 1) {
                    System.out.println("어떤 챔피언을 판매하시겠습니까? (뒤로가기 0)");
                    int bb = sc.nextInt();
                    if(bb==0) {

                    }else if(bb <= myQue.queSize() && bb > 0){
                        //챔피언
                        myGold.gold += myQue.returnQue(bb).getGold(); // 돈 추가
                        myQue.deletQue(bb);
                        myGold.output();
                    }
                    else {
                        System.out.println("번호를 잘못 입력하셨습니다.");
                    }
                }
            }

            else {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    @Override
    public int output() {
        System.out.println("-------------------------------------");
        System.out.println("\t\t나의 챔피언 덱");
        System.out.println("-------------------------------------");
        if(myDeck.size() == 0) {
            System.out.println("덱에 챔피언이 없습니다.\n");
            return 0;
        }
        else {
            for (int i = 0; i < myDeck.size(); i++) {
                System.out.println((i + 1) + ". " + myDeck.get(i).getName() + "(" + myDeck.get(i).getcClass() + ")\t" + myDeck.get(i).getGrade() + "성\t\t" + myDeck.get(i).getGold()+ "원");
            }
            System.out.println("");
            return 1;
        }
    }
}
