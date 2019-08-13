package GameProgress;

import Champion.*;

import MyInfo.Gold;
import MyInfo.Level;
import MyInfo.Que;

import java.util.Random;
import java.util.Scanner;

public class Shop {

    Scanner sc = new Scanner(System.in);

    public void showShop(Champion[] champions, Champion[] chamList, Que myQue, Gold myGold, Level myLevel, int[] purchased) {

        while (true) { //챔피언 구매하기

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
            myLevel.output(); //내 현재 레벨 출력
            System.out.println("   경험치 : " + myLevel.getMyXp() + " XP");
            myGold.plusGold(); // 이자 계산
            myGold.output(); //내 현재 골드를 보여줌
            System.out.println(" 구매할 챔피언 번호를 입력하세요(종료 0)");
            int num = sc.nextInt();
            if (num == 0) {
                //0 입력시 종료
                break;
            } else if (num == 6) {
                //상점 리셋
                if (myGold.gold > 1) {
                    myGold.gold -= 2; //2골드 차감

                    randomCham(chamList, champions,myLevel); //챔피언 무작위 호출

                    for (int i = 0; i < 5; i++) {
                        purchased[i] = 0;
                    }

                } else {
                    System.out.println("   골드가 부족합니다.");
                }
            } else if (num == 7) {
                //내 경험치 4추가
                if (myGold.gold < 4) {
                    System.out.println("   골드가 부족합니다.");
                } else {
                    myGold.gold -= 4;
                    myLevel.setMyXp(myLevel.getMyXp() + 4); //경험치 증가
                    myLevel.isMyLevel(myLevel.getMyXp());
                }
            } else if (purchased[num - 1] == 1) {
                System.out.println("   이미 구매한 챔피언입니다.");
            } else {
                if (myGold.gold < chamList[num - 1].getGold()) {
                    //내가 구매하려는 챔피언이 비싼경우
                    System.out.println("   금액이 부족합니다.");
                } else {
                    myQue.addQue(chamList[num - 1]);
                    purchased[num - 1] = 1; //1은 구매했다는 표시
                    myGold.gold -= chamList[num - 1].getGold(); //현재 골드에서 구매한 챔피언의 골드를 빼줌
                }
            }
        }
    }

    public void showAvailable(Champion[] chamList, int i) {
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

    public void randomCham(Champion[] chamList, Champion[] champions, Level myLevel) {
        //챔피언 무작위 5개 호출

        Random random = new Random();

        int chamPercent = 0; //몇티어 챔피언이 나올지 확률

        if (myLevel.getMyLevel() == 1 || myLevel.getMyLevel() == 2) { //레벨이 1, 2인 경우
            //1,2레벨 100% 1티어
            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음
                chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                if(chamList[i].getTier() != 1) {
                    //1티어 챔피언이 아니면
                    i--; //다시 뽑음
                }
            }
        } else if (myLevel.getMyLevel() == 3) { //레벨 3
            //3레벨 1티어 70%, 2티어 30%
            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음

                chamPercent = random.nextInt(99)+1; //1~100사이 퍼센트

                while(true){
                    chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                    if (chamPercent <= 70) {
                        //70%는 1티어
                        if (chamList[i].getTier() == 1) {
                            //1티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else {
                        //30%는 2티어
                        if (chamList[i].getTier() == 2) {
                            //2티어 챔피언이면 반복문 탈출
                            break;
                        }
                    }
                }

            }
        } else if (myLevel.getMyLevel() == 4) { //레벨 4
            //4레벨 1티어 55%, 2티어 30%, 3티어 15%
            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음

                chamPercent = random.nextInt(99)+1; //1~100사이 퍼센트

                while(true){
                    chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                    if (chamPercent <= 55) {
                        if (chamList[i].getTier() == 1) {
                            //1티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>55 && chamPercent <= 85) {
                        if (chamList[i].getTier() == 2) {
                            //2티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else {
                        //30%는 2티어
                        if (chamList[i].getTier() == 3) {
                            //3티어 챔피언이면 반복문 탈출
                            break;
                        }
                    }
                }
            }
        } else if (myLevel.getMyLevel() == 5) { //레벨 5
            //5레벨 1티어 40, 2티어 30, 3티어 25, 4티어 5
            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음

                chamPercent = random.nextInt(99)+1; //1~100사이 퍼센트

                while(true){
                    chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                    if (chamPercent <= 40) {
                        if (chamList[i].getTier() == 1) {
                            //1티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>40 && chamPercent <= 70) {
                        if (chamList[i].getTier() == 2) {
                            //2티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>70 && chamPercent <= 95) {
                        if (chamList[i].getTier() == 3) {
                            //3티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else {
                        //30%는 2티어
                        if (chamList[i].getTier() == 4) {
                            //4티어 챔피언이면 반복문 탈출
                            break;
                        }
                    }
                }
            }
        } else if (myLevel.getMyLevel() == 6) {
            //6레베 1티어 29, 2티어 30, 3티어,31, 4티어 10
            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음

                chamPercent = random.nextInt(99)+1; //1~100사이 퍼센트

                while(true){
                    chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                    if (chamPercent <= 29) {
                        if (chamList[i].getTier() == 1) {
                            //1티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>29 && chamPercent <= 59) {
                        if (chamList[i].getTier() == 2) {
                            //2티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>59 && chamPercent <= 90) {
                        if (chamList[i].getTier() == 3) {
                            //3티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else {
                        if (chamList[i].getTier() == 4) {
                            //4티어 챔피언이면 반복문 탈출
                            break;
                        }
                    }
                }
            }
        } else if (myLevel.getMyLevel() == 7) {
            //7레벨 1티어 24, 2티어 30, 3티어 31, 4티어 15
            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음

                chamPercent = random.nextInt(99)+1; //1~100사이 퍼센트

                while(true){
                    chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                    if (chamPercent <= 24) {
                        if (chamList[i].getTier() == 1) {
                            //1티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>24 && chamPercent <= 54) {
                        if (chamList[i].getTier() == 2) {
                            //2티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>54 && chamPercent <= 85) {
                        if (chamList[i].getTier() == 3) {
                            //3티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else {
                        if (chamList[i].getTier() == 4) {
                            //4티어 챔피언이면 반복문 탈출
                            break;
                        }
                    }
                }
            }
        } else if (myLevel.getMyLevel() == 8) {
            //8레벨 1티어 20, 2티어 24, 3티어 31, 4티어 25
            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음

                chamPercent = random.nextInt(99)+1; //1~100사이 퍼센트

                while(true){
                    chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                    if (chamPercent <= 20) {
                        if (chamList[i].getTier() == 1) {
                            //1티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>20 && chamPercent <= 44) {
                        if (chamList[i].getTier() == 2) {
                            //2티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>44 && chamPercent <= 75) {
                        if (chamList[i].getTier() == 3) {
                            //3티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else {
                        if (chamList[i].getTier() == 4) {
                            //4티어 챔피언이면 반복문 탈출
                            break;
                        }
                    }
                }
            }
        } else {
            //9레벨 1티어 10, 2티어 19, 3티어 31, 4티어 40

            for (int i = 0; i < 5; i++) { //무작위로 챔피언을 뽑음

                chamPercent = random.nextInt(99)+1; //1~100사이 퍼센트

                while(true){
                    chamList[i] = champions[random.nextInt(42)]; //0~42까지 임의의 숫자 랜덤입력

                    if (chamPercent <= 10) {
                        if (chamList[i].getTier() == 1) {
                            //1티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>10 && chamPercent <= 29) {
                        if (chamList[i].getTier() == 2) {
                            //2티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else if(chamPercent>29 && chamPercent <= 60) {
                        if (chamList[i].getTier() == 3) {
                            //3티어 챔피언이면 반복문 탈출
                            break;
                        }
                    } else {
                        if (chamList[i].getTier() == 4) {
                            //4티어 챔피언이면 반복문 탈출
                            break;
                        }
                    }
                }
            }
        }

    }

}
