package MyInfo;

import Champion.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Que extends MyInfo {

    ArrayList<Champion> myQue = new ArrayList(); //나의 챔피언 대기목록

    Scanner sc = new Scanner(System.in);

    public int queSize() { //큐 사이즈 반환
        return myQue.size();
    }

    public Champion deletQue(int i) {
        //대기열의 챔피언 삭제
        //Champion delete = myQue.get(i-1);
        Champion delete = myQue.get(i);
        myQue.remove(delete);
        return delete;
    }

    public void addQue(Champion champion) {
        //대기열에 챔피언 저장하는 메소드
        if (myQue.size() >= 9) {
            System.out.println("   대기열이 가득 찼습니다.");
        } else {
            myQue.add(champion); //대기열에 추가
            System.out.println("   "+champion.getName()+"을(를) 대기열에 넣었습니다.");
        }
    }

    public Champion returnQue(int i) {
        //대기열의 챔피언 반환
        return myQue.get(i);
    }

    public void setMyQue(Level myLevel,Que myQue, Deck myDeck, Gold myGold) {

        while(true) {
            int canInput = myDeck.deckSize();
            System.out.println("┌──────────────────┐");
            System.out.println("│             대기열 설정            │");
            System.out.println("└──────────────────┘");
            System.out.println("   1. 챔피언을 덱으로 이동");
            System.out.println("   2. 챔피언 판매");
            System.out.println("   0. 뒤로가기");
            int su = sc.nextInt();
            if (su == 0) {
                break;
            } else if (su == 1) {
                if(myQue.output()==1) { // 내 대기열 출력
                    System.out.println("덱에 넣을 챔피언을 선택해주세요(번호입력/ 뒤로가기는 0)");
                    int aa = sc.nextInt();
                    if (aa == 0) {

                    } else {
                        if (canInput == myLevel.getMyLevel()) {
                            System.out.println("덱에는 " + myLevel.getMyLevel() + "개의 챔피언까지만 넣을 수 있습니다.");
                        } else {
                            if (myDeck.isDeck(myQue.returnQue(aa-1)) == 0) {
                                System.out.println("덱에 챔피언을 중복해서 넣을 수 없습니다.");
                            } else {
                                myDeck.addDeck(myQue.deletQue(aa-1));
                                //해당 챔피언 대기열에서 삭제, 덱에 추가
                            }
                        }
                    }
                }

            } else if (su == 2) {
                if(myQue.output() == 1) {
                    System.out.println("어떤 챔피언을 판매하시겠습니까? (뒤로가기 0)");
                    int bb = sc.nextInt();
                    if(bb==0) {

                    }else if(bb <= myQue.queSize() && bb > 0){
                        //챔피언
                        myGold.gold += myQue.returnQue(bb-1).getGold(); // 돈 추가
                        myQue.deletQue(bb-1);
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
        //챔피언 대기창 출력
            System.out.println("┌──────────────────┐");
            System.out.println("│         나의 챔피언 대기목록       │");
            System.out.println("└──────────────────┘");
        if(myQue.size() == 0) {
            System.out.println("   대기열에 챔피언이 없습니다.\n");
            return 0;
        }
        else {
            for (int i = 0; i < myQue.size(); i++) {
                System.out.println("   "+(i + 1) + ". " + myQue.get(i).getName() + "(" + myQue.get(i).getcClass() + ")\t" + myQue.get(i).getGrade() + "성\t\t" + myQue.get(i).getGold() + "원");
            }
            System.out.println("");
            return 1;
        }
    }
}
