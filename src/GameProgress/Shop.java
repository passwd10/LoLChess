package GameProgress;

import Champion.*;

import MyInfo.Gold;
import MyInfo.Level;
import MyInfo.Que;
import Output.ShopOutput;

import java.util.Random;
import java.util.Scanner;

public class Shop {

    private static int STOP_SHOPPING = 0; //쇼핑 그만
    private static int KEEP_SHOPPING = 1; //쇼핑 계속
    private static int NOT_BUY = 0; //아직 구매안함
    private static int ALSO_BUY = 1; //이미 구매
    private static int RIGHT_CHAM = 1; //알맞은 챔피언
    private static int NOTRIGHT_CHAM = 0; //알맞지 않은 챔피언

    Scanner sc = new Scanner(System.in);

    public void makeShop(Champion[] champions, Champion[] chamList, Que myQue, Gold myGold, Level myLevel, int[] purchased) {
        //상점 구성

        ShopOutput shopOutput = new ShopOutput();
        int shopping = KEEP_SHOPPING;

        while (shopping == KEEP_SHOPPING) { //챔피언을 계속 구매할지?

            shopOutput.outputShop(myLevel, myGold, chamList); //상점 출력

            int num = sc.nextInt();

            shopping = whichShopping(num, myGold, myLevel, chamList, myQue, champions, purchased); //무엇을 구매할것인가?

        }
    }

    private int whichShopping(int num, Gold myGold, Level myLevel, Champion[] chamList, Que myQue, Champion[] champions, int[] purchased) {
        if (num == 0) {
            //0 입력시 종료
            return STOP_SHOPPING;
        }

        if (num == 6) {
            //상점 리셋
            resetShop(myGold, myLevel, chamList, champions, purchased); //상점 리셋 메소드
            return KEEP_SHOPPING;
        }

        if (num == 7) {
            //내 경험치 4추가
            buyXp(myGold, myLevel); //경험치 구매
            return KEEP_SHOPPING;
        }

        if (num > 0 && num < 6) {
            purchased[num - 1] = canBuy(myGold, myQue, chamList, purchased, num); //챔피언 구매가능한가? 가능하면 구매
            return KEEP_SHOPPING;
        }

        if (num > 7) {
            System.out.println("   다시 입력 해주세요.");
            return KEEP_SHOPPING;
        }

        return STOP_SHOPPING; //그 외의 숫자를 입력하면 쇼핑 그만
    }

    private int canBuy(Gold myGold, Que myQue, Champion[] chamList, int[] purchased, int num) {
        //챔피언 구매가능한가? 가능하면 구매

        if (purchased[num - 1] == ALSO_BUY) {
            System.out.println("   이미 구매한 챔피언입니다.");
            return ALSO_BUY;
        }

        if (purchased[num - 1] == NOT_BUY) { //아직 구매안한 챔피언

            return buyCham(myGold, myQue, chamList, num); //챔피언 구매
        }

        return NOT_BUY;
    }

    private int buyCham(Gold myGold, Que myQue, Champion[] chamList, int num) {
        //num번째 챔피언 구매
        if (myGold.gold < chamList[num - 1].getGold()) {
            //내가 구매하려는 챔피언이 비싼경우
            System.out.println("   금액이 부족합니다.");
            return NOT_BUY;
        }

        if (myGold.gold >= chamList[num - 1].getGold()) {
            //구매할 돈이 있으면 구매
            myQue.addQue(chamList[num - 1]);
            myGold.gold -= chamList[num - 1].getGold(); //현재 골드에서 구매한 챔피언의 골드를 빼줌
            return ALSO_BUY;
        }

        return NOT_BUY;
    }

    private void buyXp(Gold myGold, Level myLevel) { //경험치 구매
        if (myGold.gold < 4) {
            System.out.println("   골드가 부족합니다.");
        } else {
            myGold.gold -= 4;
            myLevel.setMyXp(myLevel.getMyXp() + 4); //경험치 증가
            myLevel.isMyLevel(myLevel.getMyXp());
        }
    }

    private void resetShop(Gold myGold, Level myLevel, Champion[] chamList, Champion[] champions, int[] purchased) {
        //상점 리셋
        if (myGold.gold > 1) {
            myGold.gold -= 2; //2골드 차감

            emergeCham(chamList, champions, myLevel); //챔피언 출현

            for (int i = 0; i < 5; i++) {
                purchased[i] = 0;
            }

        }

        if (myGold.gold < 2) {
            System.out.println("   골드가 부족합니다.");
        }
    }

    public void emergeCham(Champion[] chamList, Champion[] champions, Level myLevel) {
        //5개의 챔피언이 출현 (내 레벨에 따라 출현하는 챔피언의 티어가 다름)

        int chamPercent = 0; //몇티어 챔피언이 나올지 확률

        int playerLevel = myLevel.getMyLevel();

        whichCham(playerLevel, chamList, champions); //어떤 티어의 챔피언이 나올지 정해줌


    }

    private void whichCham(int playerLevel, Champion[] chamList, Champion[] champions) {

        if (playerLevel == 1 || playerLevel == 2) { //레벨이 1, 2인 경우
            //1,2레벨 100% 1티어
            randomPick(chamList, champions, 100, 0, 0, 0);
        }

        if (playerLevel == 3) {
            //3레벨 1티어 70%, 2티어 30%
            randomPick(chamList, champions, 70, 30, 0, 0);
        }

        if (playerLevel == 4) {
            //4레벨 1티어 55%, 2티어 30%, 3티어 15%
            randomPick(chamList, champions, 55, 30, 15, 0);
        }
        if (playerLevel == 5) {
            //5레벨 1티어 40, 2티어 30, 3티어 25, 4티어 5
            randomPick(chamList, champions, 40, 30, 25, 5);
        }
        if (playerLevel == 6) {
            //6레베 1티어 29, 2티어 30, 3티어,31, 4티어 10
            randomPick(chamList, champions, 29, 30, 31, 10);
        }
        if (playerLevel == 7) {
            //7레벨 1티어 24, 2티어 30, 3티어 31, 4티어 15
            randomPick(chamList, champions, 24, 30, 31, 15);
        }
        if (playerLevel == 8) {
            //8레벨 1티어 20, 2티어 24, 3티어 31, 4티어 25
            randomPick(chamList, champions, 20, 24, 31, 25);
        }
        if (playerLevel == 9) {
            //9레벨 1티어 10, 2티어 19, 3티어 31, 4티어 40
            randomPick(chamList, champions, 10, 19, 31, 40);
        }

    }

    private void randomPick(Champion[] chamList, Champion[] champions, int firstTier, int secondTier, int thirdTier, int fourthTier) {

        for (int chamNum = 0; chamNum < 5; chamNum++) { //무작위로 챔피언을 뽑음

            rightCham(chamList, chamNum, champions,firstTier,secondTier,thirdTier,fourthTier);
            //알맞은 챔피언이 나올때 까지 반복

        }

    }

    private void rightCham(Champion[] chamList, int chamNum, Champion[] champions, int firstTier, int secondTier, int thirdTier, int fourthTier) {

        Random random = new Random();

        int chamPercent = 0;
        chamPercent = random.nextInt(99) + 1; //1~100사이 퍼센트

        while (true) { //알맞은 챔피언이 뽑힐때까지 반복
            chamList[chamNum] = champions[random.nextInt(12)]; //0~42까지 임의의 숫자 랜덤입력

            if(adequateCham(chamPercent, chamList, 0,firstTier, chamNum, 1)==RIGHT_CHAM) {
                break;                  // 1티어 챔피언만
            }
            if (adequateCham(chamPercent, chamList, firstTier,firstTier+secondTier, chamNum, 2)==RIGHT_CHAM) {
                break;                  //2티어 챔피언만
            }
            if(adequateCham(chamPercent, chamList,firstTier+secondTier,firstTier+secondTier+thirdTier, chamNum, 3)==RIGHT_CHAM) {
                break;                  // 3티어 챔피언만
            }
            if(adequateCham(chamPercent, chamList,firstTier+secondTier+thirdTier,firstTier+secondTier+thirdTier+ fourthTier, chamNum, 4)==RIGHT_CHAM) {
                break;                  // 4티어
            }
        }
    }

    private int adequateCham(int chamPercent, Champion[] chamList,int startPercent, int endPercent, int chamNum, int chamTier) {

        if (chamPercent > startPercent && chamPercent <= endPercent) {
            //해당 확률 안에 있다면
            if (chamList[chamNum].getTier() == chamTier) {
                // 00 티어 챔피언이면
                return RIGHT_CHAM; //알맞은 챔피언을 찾음
            }
        }
        return NOTRIGHT_CHAM; //알맞지 않은 챔피언

    }
}
