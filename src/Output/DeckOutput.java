package Output;

import MyInfo.*;

public class DeckOutput {

    public void outputDeckSet() {
        System.out.println("┌──────────────────┐");
        System.out.println("│             전투덱 설정            │");
        System.out.println("└──────────────────┘");
        System.out.println("   1. 챔피언을 대기열로 이동");
        System.out.println("   2. 전투덱 조합 확인");
        System.out.println("   0. 뒤로가기");
    }

    public int outputDeck(Deck myDeck) {
        System.out.println("┌──────────────────┐");
        System.out.println("│           나의 챔피언 덱           │");
        System.out.println("└──────────────────┘");
        if (myDeck.deckSize() == 0) {
            System.out.println("   덱에 챔피언이 없습니다.\n");
            return 0;
        }

        if (myDeck.deckSize() != 0) {

            outputDeckCham(myDeck); //덱 챔피언 문자크기별 출력
            System.out.println();
            return 1;
        }

        return 1;
    }

    private void outputDeckCham(Deck myDeck) {
        int stringLen;

        for (int i = 0; i < myDeck.deckSize(); i++) {
            stringLen = myDeck.retCham(i).getName().length() + myDeck.retCham(i).getcClass().length() + myDeck.retCham(i).getTribe().length();

            if (stringLen == 5 || stringLen == 6 || stringLen == 7) {
                System.out.println((i + 1) + ". " + myDeck.retCham(i).getName() + " [" + myDeck.retCham(i).getcClass() + "][" + myDeck.retCham(i).getTribe() + "] \t\t\t" + myDeck.retCham(i).getGrade() + "성 " + myDeck.retCham(i).getGold() + "원");
            }
            if (stringLen == 8 || stringLen == 9) {
                System.out.println((i + 1) + ". " + myDeck.retCham(i).getName() + " [" + myDeck.retCham(i).getcClass() + "][" + myDeck.retCham(i).getTribe() + "] \t\t" + myDeck.retCham(i).getGrade() + "성 " + myDeck.retCham(i).getGold() + "원");
            }
            if (stringLen == 10 || stringLen == 11) {
                System.out.println((i + 1) + ". " + myDeck.retCham(i).getName() + " [" + myDeck.retCham(i).getcClass() + "][" + myDeck.retCham(i).getTribe() + "] \t" + myDeck.retCham(i).getGrade() + "성 " + myDeck.retCham(i).getGold() + "원");
            }
            if (stringLen > 11) {
                System.out.println((i + 1) + ". " + myDeck.retCham(i).getName() + " [" + myDeck.retCham(i).getcClass() + "][" + myDeck.retCham(i).getTribe() + "]" + myDeck.retCham(i).getGrade() + "성 " + myDeck.retCham(i).getGold() + "원");
            }
        }
    }

}
