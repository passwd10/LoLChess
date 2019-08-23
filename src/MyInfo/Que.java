package MyInfo;

import Champion.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Output.*;

public class Que extends MyInfo {

    List<Champion> myQue = new ArrayList(); //나의 챔피언 대기목록

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

            QueOutput queOutput = new QueOutput();

            queOutput.outputQueSetting(); //대기열 설정 출력

            int queInput = sc.nextInt();
            if (queInput == 0) {
                break;
            }

            if (queInput == 1) { //챔피언을 덱으로 이동
                chamToDeck(canInput, myLevel, myDeck, myQue, queOutput); //챔피언을 덱으로 이동
            }

            if (queInput == 2) { //챔피언 판매
                whichChamSell(queOutput, myQue, myGold); //어떤 챔피언을 판매할지
            }

            if (queInput > 2) {
                System.out.println("잘못 입력하셨습니다.");
            }
        }
    }

    private void whichChamSell(QueOutput queOutput, Que myQue, Gold myGold) {
        InfoOutput infoOutput = new InfoOutput();

        if (queOutput.outputQue(myQue) == 1) {

            System.out.println("어떤 챔피언을 판매하시겠습니까? (뒤로가기 0)");
            int selectSell = sc.nextInt();
            if (selectSell == 0) {

            }
            if (selectSell <= myQue.queSize() && selectSell > 0) {
                //챔피언
                myGold.gold += myQue.returnQue(selectSell - 1).getGold(); // 돈 추가
                myQue.deletQue(selectSell - 1);
                infoOutput.goldOutput(myGold);
            }
            if (selectSell > myQue.queSize()) {
                System.out.println("번호를 잘못 입력하셨습니다.");
            }
        }
    }

    private void chamToDeck(int canInput, Level myLevel, Deck myDeck, Que myQue, QueOutput queOutput) {
        //대기열에 있는 챔피언을 덱으로
        if(queOutput.outputQue(myQue)==1) { // 내 대기열 출력
            System.out.println("덱에 넣을 챔피언을 선택해주세요(번호입력/ 뒤로가기는 0)");
            int chooseCham = sc.nextInt();
            if (chooseCham != 0) {
                limitDeck(canInput, myLevel, myDeck, myQue, chooseCham); //덱에 들어가는 챔피언 수 제한
            }
        }
    }

    private void limitDeck(int canInput, Level myLevel, Deck myDeck, Que myQue, int chooseCham) {
        //덱에 들어가는 챔피언 수 제한
        if (canInput == myLevel.getMyLevel()) {
            System.out.println("덱에는 " + myLevel.getMyLevel() + "개의 챔피언까지만 넣을 수 있습니다.");
        }

        if (canInput != myLevel.getMyLevel()){
            checkDuplicate(myDeck, myQue, chooseCham); //내 대기열과 덱의 중복 검사
        }
    }

    private void checkDuplicate(Deck myDeck, Que myQue, int chooseCham) {
        //내 대기열과 덱의 중복 검사
        if (myDeck.isDeck(myQue.returnQue(chooseCham-1)) == 0) {
            System.out.println("덱에 챔피언을 중복해서 넣을 수 없습니다.");
        }

        if (myDeck.isDeck(myQue.returnQue(chooseCham-1)) != 0){
            myDeck.addDeck(myQue.deletQue(chooseCham-1));
            //해당 챔피언 대기열에서 삭제, 덱에 추가
        }
    }


}
