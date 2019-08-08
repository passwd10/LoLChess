package GameProgress;

import Champion.*;

import MyInfo.Gold;
import MyInfo.Level;
import MyInfo.Que;

import java.util.Random;
import java.util.Scanner;

public class Shop {

    Scanner sc = new Scanner(System.in);

    public void showAvailable(Champion[] chamList, int i) {
        //구매 가능한 챔피언의 목록을 출력해주는 메소드
        System.out.println((i + 1) + ". " + chamList[i].getName() + "(" + chamList[i].getcClass() + ")\t"+ "(" + chamList[i].getTribe() + ")\t" + chamList[i].getGold() + "원");
    }

    public void showShop(Champion[] champions, Champion[] chamList, Que myQue, Gold myGold, Level myLevel) {
        Random random = new Random();

        int[] purchased = new int[5]; //이미 구매한 챔피언들을 걸러내기 위한 표시

        while (true) { //챔피언 구매하기

            System.out.println("-------------------------------------");
            System.out.println("\t\t\t챔피언 상점");
            System.out.println("-------------------------------------");

            for (int i = 0; i < 5; i++) {
                showAvailable(chamList, i); //무작위 챔피언 5개 출력
            }
            System.out.println("6. 상점 새로고침\t\t\t2원");
            System.out.println("7. 경험치(4XP) \t\t\t\t4원");
            System.out.println("-------------------------------------");
            System.out.println("\t\t   플레이어 정보");
            myLevel.output(); //내 현재 레벨 출력
            System.out.println("   경험치 : " + myLevel.getMyXp()+" XP");
            myGold.plusGold(); // 이자 계산
            myGold.output(); //내 현재 골드를 보여줌
            System.out.println("구매할 챔피언 번호를 입력하세요(종료 0)");
            int num = sc.nextInt();
            if (num == 0) {
                //0 입력시 종료
                break;
            } else if(num == 6) {
                //상점 리셋
                if (myGold.gold > 1) {
                    myGold.gold -= 2; //2골드 차감

                    for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음
                        chamList[i] = champions[random.nextInt(12)]; //0~11까지 임의의 숫자 랜덤입력

                        for (int a = 0; a < i; a++) { //챔피언 중복검사
                            if (chamList[a] == chamList[i]) {
                                i--;
                                break;
                            }
                        }
                    }

                    for(int i=0; i<5; i++) {
                        purchased[i] = 0 ;
                    }

                } else {
                    System.out.println("골드가 부족합니다.");
                }

            } else if(num == 7) {
                //내 경험치 4추가
                if(myGold.gold < 4) {
                    System.out.println("골드가 부족합니다.");
                } else {
                    myGold.gold -= 4;
                    myLevel.setMyXp(myLevel.getMyXp() + 4); //경험치 증가
                    myLevel.isMyLevel(myLevel.getMyXp());
                }
            }
            else if (purchased[num - 1] == 1) {
                System.out.println("이미 구매한 챔피언입니다.");
            } else {
                if (myGold.gold < chamList[num - 1].getGold()) {
                    //내가 구매하려는 챔피언이 비싼경우
                    System.out.println("금액이 부족합니다.");
                } else {
                    myQue.addQue(chamList[num - 1]);
                    purchased[num - 1] = 1; //1은 구매했다는 표시
                    myGold.gold -= chamList[num-1].getGold(); //현재 골드에서 구매한 챔피언의 골드를 빼줌
                }
            }
        }
    }

}
