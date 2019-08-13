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

    public void setMyDeck(Que myQue, Deck myDeck) {

        while (true) {
            int canInput = myDeck.deckSize();

            System.out.println("┌──────────────────┐");
            System.out.println("│             전투덱 설정            │");
            System.out.println("└──────────────────┘");
            System.out.println("   1. 챔피언을 대기열로 이동");
            System.out.println("   2. 전투덱 조합 확인");
            System.out.println("   0. 뒤로가기");

            int su = sc.nextInt();
            if (su == 0) {
                break;
            } else if (su == 1) {
                if (su == 1) {
                    if (myDeck.output() == 1) { // 내 덱 출력
                        System.out.println("대기열에 넣을 챔피언을 선택해주세요(번호입력/ 뒤로가기는 0)");
                        int aa = sc.nextInt();
                        if (aa == 0) {

                        } else {
                            myQue.addQue(myDeck.deletDeck(aa));
                            //해당 챔피언 대기열에서 삭제, 덱에 추가
                        }
                    }
                }
            } else if (su == 2) {
                myDeck.deckClass(myDeck);
                myDeck.deckTribe(myDeck);
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

        if (myDeck.output() == 1) { //덱 출력

            System.out.println("     직업 시너지");

            for (int i = 0; i < myDeck.deckSize(); i++) { //덱에 있는 챔피언 직업 확인
                if (myDeck.retCham(i).getcClass().equals("싸움꾼")) {
                    brawler++;
                } else if (myDeck.retCham(i).getcClass().equals("암살자")) {
                    assasin++;
                } else if (myDeck.retCham(i).getcClass().equals("기사")) {
                    knight++;
                } else if (myDeck.retCham(i).getcClass().equals("검사")) {
                    gladiator++;
                } else if (myDeck.retCham(i).getcClass().equals("원소술사")) {
                    elementalist++;
                } else if (myDeck.retCham(i).getcClass().equals("수호자")) {
                    guardian++;
                } else if (myDeck.retCham(i).getcClass().equals("정찰대")) {
                    scout++;
                } else if (myDeck.retCham(i).getcClass().equals("형상변환자")) {
                    changer++;
                } else if (myDeck.retCham(i).getcClass().equals("마법사")) {
                    wizard++;
                } else if (myDeck.retCham(i).getcClass().equals("총잡이")) {
                    gunner++;
                }
            }

            if (brawler > 0 && brawler < 3) {
                System.out.println("   싸움꾼 : " + brawler);
            } else if (brawler >= 3 && brawler < 6) {
                System.out.println("   싸움꾼 : " + brawler + " (초기)");
            } else if (brawler >= 6) {
                System.out.println("   싸움꾼 : " + brawler + " (최종)");
            }

            if (assasin > 0 && assasin < 3) {
                System.out.println("   암살자 : " + assasin);
            } else if (assasin >= 3 && brawler < 6) {
                System.out.println("   암살자 : " + assasin + " (초기)");
            } else if (assasin >= 6) {
                System.out.println("   암살자 : " + assasin + " (최종)");
            }

            if (knight > 0 && knight < 2) {
                System.out.println("   기사 : " + knight);
            } else if (knight >= 2 && knight < 4) {
                System.out.println("   기사 : " + knight + " (초기)");
            } else if (knight >= 4 && knight < 6) {
                System.out.println("   기사 : " + knight + " (중기)");
            } else if (knight >= 6) {
                System.out.println("   기사 : " + knight + " (최종)");
            }

            if (gladiator > 0 && gladiator < 3) {
                System.out.println("   검사 : " + gladiator);
            } else if (gladiator >= 3 && gladiator < 6) {
                System.out.println("   검사 : " + gladiator + " (초기)");
            } else if (gladiator >= 6) {
                System.out.println("   검사 : " + gladiator + " (중기)");
            } else if (gladiator >= 9) {
                System.out.println("   검사 : " + gladiator + " (최종)");
            }

            if (wizard > 0 && wizard < 3) {
                System.out.println("   마법사 : " + wizard);
            } else if (wizard >= 3 && brawler < 6) {
                System.out.println("   마법사 : " + wizard + " (초기)");
            } else if (wizard >= 6) {
                System.out.println("   마법사 : " + wizard + " (최종)");
            }

            if (guardian > 0 && guardian < 2) {
                System.out.println("   수호자 : " + guardian);
            } else if (guardian >= 2){
                System.out.println("   수호자 : " + guardian + " (최종)");
            }

            if (elementalist > 0 && elementalist < 3) {
                System.out.println("   원소술사 : " + elementalist);
            } else if (elementalist >= 3) {
                System.out.println("   원소술사 : " + elementalist + " (최종)");
            }

            if (scout > 0 && scout < 2) {
                System.out.println("   정찰대 : " + scout);
            } else if (scout >= 2 && scout < 4) {
                System.out.println("   정찰대 : " + scout + " (초기)");
            } else if (scout >= 4) {
                System.out.println("   정찰대 : " + scout + " (최종)");
            }

            if (changer > 0 && changer < 3) {
                System.out.println("   형상변환자 : " + changer);
            } else if (changer >= 3 && changer < 6) {
                System.out.println("   형상변환자 : " + changer + " (초기)");
            } else if (changer >= 6) {
                System.out.println("   형상변환자 : " + changer + " (최종)");
            }

            if (gunner > 0 && gunner < 2) {
                System.out.println("   총잡이 : " + gunner);
            } else if (gunner >= 2 && gunner < 4) {
                System.out.println("   총잡이 : " + gunner + " (초기)");
            } else if (gunner >= 4 && gunner < 6) {
                System.out.println("   총잡이 : " + gunner + " (중기)");
            } else if (gunner >= 6) {
                System.out.println("   총잡이 : " + gunner + " (최종)");
            }
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

        for (int i = 0; i < myDeck.deckSize(); i++) { //덱에 있는 챔피언 직업 확인
            if (myDeck.retCham(i).getTribe().equals("공허")) {
                vacuity++;
            } else if (myDeck.retCham(i).getTribe().equals("귀족")) {
                nobility++;
            } else if (myDeck.retCham(i).getTribe().equals("닌자")) {
                ninja++;
            } else if (myDeck.retCham(i).getTribe().equals("빙하")) {
                glacier++;
            } else if (myDeck.retCham(i).getTribe().equals("악마")) {
                devil++;
            } else if (myDeck.retCham(i).getTribe().equals("야생")) {
                wild++;
            } else if (myDeck.retCham(i).getTribe().equals("요들")) {
                yodel++;
            } else if (myDeck.retCham(i).getTribe().equals("유령")) {
                ghost++;
            } else if (myDeck.retCham(i).getTribe().equals("제국")) {
                empire++;
            } else if (myDeck.retCham(i).getTribe().equals("해적")) {
                pirate++;
            }
        }

        if (vacuity > 0 && vacuity < 3) {
            System.out.println("   공허 : " + vacuity);
        } else if (vacuity >= 3) {
            System.out.println("   공허 : " + vacuity + " (초기)");
        }

        if (nobility > 0 && nobility < 3) {
            System.out.println("   귀족 : " + nobility);
        } else if (nobility >= 3 && nobility < 6) {
            System.out.println("   귀족 : " + nobility + " (초기)");
        } else if (nobility >= 6) {
            System.out.println("   귀족 : " + nobility + " (최종)");
        }

        if (ninja == 1) {
            System.out.println("   닌자 : " + ninja + " (초기)");
        } else if (ninja >= 2 && ninja < 4) {
            System.out.println("   닌자 : " + ninja);
        } else if (ninja == 4) {
            System.out.println("   닌자 : " + ninja + " (최종)");
        }

        if (glacier > 0 && glacier < 2) {
            System.out.println("   빙하 : " + glacier);
        } else if (glacier >= 2 && glacier < 4) {
            System.out.println("   빙하 : " + glacier + " (초기)");
        } else if (glacier >= 4 && glacier < 6) {
            System.out.println("   빙하 : " + glacier + " (중기)");
        } else if (glacier >= 6) {
            System.out.println("   빙하 : " + glacier + " (최종)");
        }

        if (devil > 0 && devil < 2) {
            System.out.println("   악마 : " + devil);
        } else if (devil >= 2 && devil < 4) {
            System.out.println("   악마 : " + devil + " (초기)");
        } else if (devil >= 4 && devil < 6) {
            System.out.println("   악마 : " + devil + " (중기)");
        } else if (devil >= 6) {
            System.out.println("   악마 : " + devil + " (최종)");
        }

        if (wild == 1) {
            System.out.println("   야생 : " + wild);
        } else if (wild >= 2 && wild < 4) {
            System.out.println("   야생 : " + wild + " (초기)");
        } else if (wild >= 4) {
            System.out.println("   야생 : " + wild + " (최종)");
        }

        if (yodel > 0 && yodel < 3) {
            System.out.println("   요들 : " + yodel);
        } else if (yodel >= 3 && yodel < 6) {
            System.out.println("   요들 : " + yodel + " (초기)");
        } else if (yodel >= 6) {
            System.out.println("   요들 " + yodel + " (최종)");
        }

        if (ghost == 1) {
            System.out.println("   유령 : " + ghost);
        } else if (ghost >= 2) {
            System.out.println("   유령 : " + ghost + " (최종)");
        }

        if (empire == 1) {
            System.out.println("   제국 : " + empire);
        } else if (empire >= 2 && empire < 4) {
            System.out.println("   제국 : " + empire + " (초기)");
        } else if (empire >= 4) {
            System.out.println("   제국 : " + empire + " (최종)");
        }

        if (pirate > 0 && pirate < 3) {
            System.out.println("   해적 : " + pirate);
        } else if (pirate >= 3) {
            System.out.println("   해적 : " + pirate + " (최종)");
        }

    }


    @Override
    public int output() {
        System.out.println("┌──────────────────┐");
        System.out.println("│           나의 챔피언 덱           │");
        System.out.println("└──────────────────┘");
        if(myDeck.size() == 0) {
            System.out.println("   덱에 챔피언이 없습니다.\n");
            return 0;
        }
        else {
            int stringLen;

            for (int i = 0; i < myDeck.size(); i++) {
                stringLen = myDeck.get(i).getName().length() + myDeck.get(i).getcClass().length() + myDeck.get(i).getTribe().length();

                if(stringLen==5 || stringLen == 6 || stringLen == 7 ) {
                    System.out.println((i + 1) + ". " + myDeck.get(i).getName() + " [" + myDeck.get(i).getcClass() + "][" + myDeck.get(i).getTribe() + "] \t\t\t" + myDeck.get(i).getGrade() + "성 "+myDeck.get(i).getGold()+"원");
                } else if(stringLen == 8 || stringLen == 9) {
                    System.out.println((i + 1) + ". " + myDeck.get(i).getName() + " [" + myDeck.get(i).getcClass() + "][" + myDeck.get(i).getTribe() + "] \t\t" + myDeck.get(i).getGrade() + "성 "+myDeck.get(i).getGold()+"원");
                } else if(stringLen == 10 || stringLen == 11) {
                    System.out.println((i + 1) + ". " + myDeck.get(i).getName() + " [" + myDeck.get(i).getcClass() + "][" + myDeck.get(i).getTribe() + "] \t" + myDeck.get(i).getGrade() + "성 "+myDeck.get(i).getGold()+"원");
                } else {
                    System.out.println((i + 1) + ". " + myDeck.get(i).getName() + " [" + myDeck.get(i).getcClass() + "][" + myDeck.get(i).getTribe() + "]" + myDeck.get(i).getGrade() + "성 "+myDeck.get(i).getGold()+"원");
                }
            }
            System.out.println();
            return 1;
        }
    }
}
