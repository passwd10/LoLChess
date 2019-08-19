package MyInfo;

import Champion.Champion;
import Common.AllUnit;
import Output.DeckOutput;

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
        Champion delete = myDeck.get(i - 1);
        myDeck.remove(delete);
        return delete;
    }

    public Champion retCham(int i) {
        //내 덱에서 싸울 챔피언을 반환해줌
        Champion fightCham = myDeck.get(i);
        return fightCham;
    }

    /*public AllUnit retCham(int i) {
        //컴퓨터 덱에서 싸울 챔피언을 반환해줌
        AllUnit fightCham = (AllUnit)myDeck.get(i);
        return fightCham;
    }*/

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

        DeckOutput deckOutput = new DeckOutput(); //덱 출력

        while (true) {

            deckOutput.outputDeckSet(); //덱 세팅창 출력

            int deckNum = sc.nextInt();
            if (deckNum == 0) {
                break;
            }

            if (deckNum == 1) {
                chamToQue(deckOutput, myDeck, myQue); //내 챔피언을 대기열로 이동시키는 메소드
            }

            if (deckNum == 2) {
                myDeck.deckClass(myDeck);
                myDeck.deckTribe(myDeck);
            }
        }
    }

    private void chamToQue(DeckOutput deckOutput, Deck myDeck, Que myQue) {
        //덱에있는 챔피언을 대기열로 옮기는 메소드
        if (deckOutput.outputDeck(myDeck) == 1) { // 내 덱 출력
            System.out.println("대기열에 넣을 챔피언을 선택해주세요(번호입력/ 뒤로가기는 0)");
            int inputNum = sc.nextInt();
            if (inputNum == 0) {

            }
            if (inputNum != 0) {
                myQue.addQue(myDeck.deletDeck(inputNum));
                //해당 챔피언 대기열에서 삭제, 덱에 추가
            }
        }
    }

    public void deckClass(Deck myDeck) {
        //덱 직업 조합 확인
        int brawler = 0; //싸움꾼
        int assasin = 0; //암살자
        int knight = 0; //기사
        int gladiator = 0; //검사
        int elementalist = 0; //원소술사
        int guardian = 0; //수호자
        int scout = 0; //정찰대
        int changer = 0; //형상 변환자
        int wizard = 0;//마법사
        int gunner = 0; //총잡이

        DeckOutput deckOutput = new DeckOutput(); //덱 출력

        if (deckOutput.outputDeck(myDeck) == 1) { //덱 출력

            System.out.println("     직업 시너지");

            checkClass(myDeck, brawler, assasin, knight, gladiator, elementalist, guardian, scout, changer, wizard, gunner); //덱에 있는 챔피언 직업 확인하는 메소드

            needTwo(guardian, "수호자"); //2개(수호자)
            needThree(elementalist, "원소술사"); //세개 챔피언 필요한 직업(원소술사)
            needTwoFour(scout, "정찰대"); //두개네개 (정찰대)
            needTwoFourSix(knight, "기사"); //2,4,6 (기사, 총잡이)
            needTwoFourSix(gunner, "총잡이"); //2,4,6 (기사, 총잡이)
            needThreeSix(brawler, "싸움꾼"); //세개여섯개 챔피언  필요한 직업(싸움꾼, 암살자, 마법사, 형상변환자)
            needThreeSix(assasin, "암살자"); //세개여섯개 챔피언  필요한 직업(싸움꾼, 암살자, 마법사, 형상변환자)
            needThreeSix(wizard, "마법사"); //세개여섯개 챔피언  필요한 직업(싸움꾼, 암살자, 마법사, 형상변환자)
            needThreeSix(changer, "형상변환자"); //세개여섯개 챔피언  필요한 직업(싸움꾼, 암살자, 마법사, 형상변환자)

            needThreeSixNine(gladiator, "검사"); //세개여섯개아홉개 챔피언(검사)


        } else {
            System.out.println(" 덱에 챔피언이 없습니다.");
        }

    }


    public void deckTribe(Deck myDeck) {
        //덱 직업 조합 확인

        int vacuity = 0; //공허
        int nobility = 0; //귀족
        int ninja = 0; //닌자
        int glacier = 0; //빙하
        int devil = 0; //악마
        int wild = 0;//야생
        int yodel = 0;//요들
        int ghost = 0;//유령
        int empire = 0;//제국
        int pirate = 0;//해적

        System.out.println("\n     종족 시너지");

        checkTribe(myDeck, vacuity, nobility, ninja, glacier, devil, wild, yodel, ghost, empire, pirate);
        //덱에 있는 챔피언 종족 확인하는 메소드

        needTwo(ghost, "유령"); //2개(유령)
        needThree(vacuity, "공허"); //세개 챔피언 필요한 직업(공허, 해적)
        needThree(pirate, "해적"); //세개 챔피언 필요한 직업(공허, 해적)
        needOneFour(ninja, "닌자"); //한개네개 챔피언 필요한 직업(닌자)
        needTwoFour(wild, "야생"); //두개네개 (야생, 제국)
        needTwoFour(empire, "제국"); //두개네개 (야생, 제국)
        needTwoFourSix(glacier, "빙하"); //2,4,6 (빙하, 악마)
        needTwoFourSix(devil, "악마"); //2,4,6 (빙하, 악마)
        needThreeSix(nobility, "귀족"); //세개여섯개 챔피언  필요한 직업(귀족, 요들)
        needThreeSix(yodel, "요들"); //세개여섯개 챔피언  필요한 직업(귀족, 요들)

    }

    private void needThreeSixNine(int chamNum, String chamProperty) {
        if (chamNum > 0 && chamNum < 3) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
        if (chamNum >= 3 && chamNum < 6) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (초기)");
        }
        if (chamNum >= 6) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (중기)");
        }
        if (chamNum >= 9) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (최종)");
        }
    }

    private void needThreeSix(int chamNum, String chamProperty) {

        if (chamNum > 0 && chamNum < 3) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
        if (chamNum >= 3 && chamNum < 6) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (초기)");
        }
        if (chamNum >= 6) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (최종)");
        }

    }

    private void needTwoFourSix(int chamNum, String chamProperty) {
        if (chamNum > 0 && chamNum < 2) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
        if (chamNum >= 2 && chamNum < 4) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (초기)");
        }
        if (chamNum >= 4 && chamNum < 6) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (중기)");
        }
        if (chamNum >= 6) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (최종)");
        }

    }

    private void needTwoFour(int chamNum, String chamProperty) {
        if (chamNum == 1) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
        if (chamNum >= 2 && chamNum < 4) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (초기)");
        }
        if (chamNum >= 4) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (최종)");
        }
    }


    private void needOneFour(int chamNum, String chamProperty) {

        if (chamNum == 1) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (초기)");
        }
        if (chamNum >= 2 && chamNum < 4) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
        if (chamNum == 4) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (최종)");
        }
        if (chamNum > 4) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
    }

    private void needTwo(int chamNum, String chamProperty) {
        if (chamNum == 1) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
        if (chamNum >= 2) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (최종)");
        }
    }

    private void needThree(int chamNum, String chamProperty) {
        if (chamNum > 0 && chamNum < 3) {
            System.out.println("   " + chamProperty + ": " + chamNum);
        }
        if (chamNum >= 3) {
            System.out.println("   " + chamProperty + ": " + chamNum + " (최종)");
        }

    }

    private void checkClass(Deck myDeck, int brawler, int assasin, int knight, int gladiator, int elementalist, int guardian, int scout, int changer, int wizard, int gunner) {
        for (int i = 0; i < myDeck.deckSize(); i++) { //덱에 있는 챔피언 직업 확인
            if (myDeck.retCham(i).getcClass().equals("싸움꾼")) {
                brawler++;
            }
            if (myDeck.retCham(i).getcClass().equals("암살자")) {
                assasin++;
            }
            if (myDeck.retCham(i).getcClass().equals("기사")) {
                knight++;
            }
            if (myDeck.retCham(i).getcClass().equals("검사")) {
                gladiator++;
            }
            if (myDeck.retCham(i).getcClass().equals("원소술사")) {
                elementalist++;
            }
            if (myDeck.retCham(i).getcClass().equals("수호자")) {
                guardian++;
            }
            if (myDeck.retCham(i).getcClass().equals("정찰대")) {
                scout++;
            }
            if (myDeck.retCham(i).getcClass().equals("형상변환자")) {
                changer++;
            }
            if (myDeck.retCham(i).getcClass().equals("마법사")) {
                wizard++;
            }
            if (myDeck.retCham(i).getcClass().equals("총잡이")) {
                gunner++;
            }
        }
    }

    private void checkTribe(Deck myDeck, int vacuity, int nobility, int ninja, int glacier, int devil, int wild, int yodel, int ghost, int empire, int pirate) {
        for (int i = 0; i < myDeck.deckSize(); i++) { //덱에 있는 챔피언 직업 확인
            if (myDeck.retCham(i).getTribe().equals("공허")) {
                vacuity++;
            }
            if (myDeck.retCham(i).getTribe().equals("귀족")) {
                nobility++;
            }
            if (myDeck.retCham(i).getTribe().equals("닌자")) {
                ninja++;
            }
            if (myDeck.retCham(i).getTribe().equals("빙하")) {
                glacier++;
            }
            if (myDeck.retCham(i).getTribe().equals("악마")) {
                devil++;
            }
            if (myDeck.retCham(i).getTribe().equals("야생")) {
                wild++;
            }
            if (myDeck.retCham(i).getTribe().equals("요들")) {
                yodel++;
            }
            if (myDeck.retCham(i).getTribe().equals("유령")) {
                ghost++;
            }
            if (myDeck.retCham(i).getTribe().equals("제국")) {
                empire++;
            }
            if (myDeck.retCham(i).getTribe().equals("해적")) {
                pirate++;
            }
        }
    }


}