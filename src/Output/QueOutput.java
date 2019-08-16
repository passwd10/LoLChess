package Output;

import MyInfo.*;

public class QueOutput {

    public void outputQueSetting() { //대기열설정 출력
        System.out.println("┌──────────────────┐");
        System.out.println("│             대기열 설정            │");
        System.out.println("└──────────────────┘");
        System.out.println("   1. 챔피언을 덱으로 이동");
        System.out.println("   2. 챔피언 판매");
        System.out.println("   0. 뒤로가기");
    }

    public int outputQue(Que myQue) { //대기열 출력

        //챔피언 대기창 출력
        System.out.println("┌──────────────────┐");
        System.out.println("│         나의 챔피언 대기목록       │");
        System.out.println("└──────────────────┘");
        if (myQue.queSize() == 0) {
            System.out.println("   대기열에 챔피언이 없습니다.\n");
            return 0;
        }

        if (myQue.queSize() != 0) {
            queStringLen(myQue); //que 문자열 길이
            System.out.println();
            return 1;
        }

        return 1;
    }

    private void queStringLen(Que myQue) {
        int stringLen;

        for (int i = 0; i < myQue.queSize(); i++) {
            stringLen = myQue.returnQue(i).getName().length() + myQue.returnQue(i).getcClass().length() + myQue.returnQue(i).getTribe().length();

            if (stringLen == 5 || stringLen == 6 || stringLen == 7) {
                System.out.println((i + 1) + ". " + myQue.returnQue(i).getName() + " [" + myQue.returnQue(i).getcClass() + "][" + myQue.returnQue(i).getTribe() + "] \t\t\t" + myQue.returnQue(i).getGrade() + "성 " + myQue.returnQue(i).getGold() + "원");
            }
            if (stringLen == 8 || stringLen == 9) {
                System.out.println((i + 1) + ". " + myQue.returnQue(i).getName() + " [" + myQue.returnQue(i).getcClass() + "][" + myQue.returnQue(i).getTribe() + "] \t\t" + myQue.returnQue(i).getGrade() + "성 " + myQue.returnQue(i).getGold() + "원");
            }
            if (stringLen == 10 || stringLen == 11) {
                System.out.println((i + 1) + ". " + myQue.returnQue(i).getName() + " [" + myQue.returnQue(i).getcClass() + "][" + myQue.returnQue(i).getTribe() + "] \t" + myQue.returnQue(i).getGrade() + "성 " + myQue.returnQue(i).getGold() + "원");
            }
            if (stringLen >= 12) {
                System.out.println((i + 1) + ". " + myQue.returnQue(i).getName() + " [" + myQue.returnQue(i).getcClass() + "][" + myQue.returnQue(i).getTribe() + "]" + myQue.returnQue(i).getGrade() + "성 " + myQue.returnQue(i).getGold() + "원");
            }

        }
    }

}
