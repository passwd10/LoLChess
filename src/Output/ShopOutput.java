package Output;

import Champion.*;
import MyInfo.Gold;
import MyInfo.Level;

public class ShopOutput {


    public void outputShop(Level myLevel, Gold myGold, Champion[] chamList) {
        InfoOutput infoOutput = new InfoOutput();

        //상점 출력
        System.out.println("┌──────────────────┐");
        System.out.println("│             챔피언 상점            │");
        System.out.println("└──────────────────┘");

        for (int i = 0; i < 5; i++) {
            showAvailable(chamList, i); //무작위 챔피언 5개 출력
        }

        System.out.println("  6. 상점 새로고침\t\t\t\t\t2원");
        System.out.println("  7. 경험치(4XP) \t\t\t\t\t4원");
        System.out.println("┌──────────────────┐");
        System.out.println("│            플레이어 정보           │");
        System.out.println("└──────────────────┘");
        infoOutput.levelOutput(myLevel); //내 레벨
        System.out.println("   경험치 : " + myLevel.getMyXp() + " XP");
        myGold.plusGold(); // 이자 계산
        infoOutput.goldOutput(myGold); //내 현재 골드를 보여줌
        System.out.println(" 구매할 챔피언 번호를 입력하세요(종료 0)");
    }

    private void showAvailable(Champion[] chamList, int i) {
        //구매 가능한 챔피언의 목록을 출력해주는 메소드
        int stringLen = chamList[i].getName().length() + chamList[i].getcClass().length() + chamList[i].getTribe().length();

        if(stringLen==5 || stringLen == 6) {
            System.out.println("  "+(i + 1) + ". " + chamList[i].getName() + " [" + chamList[i].getcClass() + "][" + chamList[i].getTribe() + "]\t\t\t\t" + chamList[i].getGold() + "원");
        } else if(stringLen == 7 || stringLen == 8) {
            System.out.println("  "+(i + 1) + ". " + chamList[i].getName() + " [" + chamList[i].getcClass() + "][" + chamList[i].getTribe() + "]\t\t\t" + chamList[i].getGold() + "원");
        } else if(stringLen == 9 || stringLen == 10 || stringLen == 11) {
            System.out.println("  "+(i + 1) + ". " + chamList[i].getName() + " [" + chamList[i].getcClass() + "][" + chamList[i].getTribe() + "]\t\t" + chamList[i].getGold() + "원");
        } else {
            System.out.println("  " + (i + 1) + ". " + chamList[i].getName() + " [" + chamList[i].getcClass() + "][" + chamList[i].getTribe() + "]\t" + chamList[i].getGold() + "원");
        }
    }
}
