package Output;

import java.util.Scanner;

public class ProgressOutput {

    Scanner sc = new Scanner(System.in);

    public void tutorial() {
        //게임 시작 창

        //첫 화면
        System.out.println("┌──────────────────┐");
        System.out.println("│      롤토체스(1인용) 시작하기      │");
        System.out.println("└──────────────────┘");
        System.out.println("   1. 이어하기(서비스 준비중)");
        System.out.println("   2. 새로하기");
        int a = sc.nextInt();
        //새로하기
        System.out.println("아이디를 입력해주세요");
        String nickname = sc.next();
        System.out.println("환영합니다 " + nickname + " 님");
        System.out.println("롤토체스의 규칙을 이해하고 계신가요?(Y/N)");
        char ans = sc.next().charAt(0);
        if (ans == 'Y' || ans == 'y') {
            System.out.println(" ■□■□■□ BRONZE 난이도 ■□■□■□");
        } else {
            System.out.println("라운드 시작 화면입니다.");
            System.out.println("┌──────────────────┐\n" +
                    "│\t\t\t\t1 라운드\t\t\t  │\n" +
                    "├──────────────────┤\n" +
                    "│\t\t\t\t\t\t\t\t\t  │\n" +
                    "│  1. 챔피언 상점                    │\n" +
                    "│  2. 대기열 설정                    │\n" +
                    "│  3. 전투덱 설정                    │\n" +
                    "│  4. 나의 정보                      │\n" +
                    "│  0. 전투 시작                      │\n" +
                    "│\t\t\t\t\t\t\t\t\t  │\n" +
                    "└──────────────────┘");
            System.out.println("라운드가 시작되면 \'챔피언상점\', \'대기열설정\', \'전투덱설정\', \'나의정보\' 을 선택할 수 있습니다. ");
            //System.out.println("카운트다운이 종료되면 준비단계에서 전투단계로 넘어갑니다.");
            System.out.println("다음(아무거나입력)");
            String next = sc.next();
            System.out.println("\n\n챔피언 상점입니다.");
            System.out.println("┌──────────────────┐\n" +
                    "│             챔피언 상점            │\n" +
                    "└──────────────────┘\n" +
                    "  1. 카사딘 [마법사][공허]\t\t\t1원\n" +
                    "  2. 카직스 [암살자][공허]\t\t\t1원\n" +
                    "  3. 다리우스 [기사][제국]\t\t\t1원\n" +
                    "  4. 모데카이저 [기사][유령]\t\t1원\n" +
                    "  5. 그레이브즈 [총잡이][해적]\t\t1원\n" +
                    "  6. 상점 새로고침\t\t\t\t\t2원\n" +
                    "  7. 경험치(4XP) \t\t\t\t\t4원\n");
            System.out.println("상점에서는 \'골드\'를 소모하여 전투에서 사용할 챔피언을 구매합니다.\n" +
                    "매 라운드가 시작할 때, 챔피언 상점은 \'자동\'으로 갱신됩니다.");

            System.out.println("모든 챔피언은 각각의 \'종족\'과 \'직업\'을 보유하고 있으며, 덱에 \'배치\'\n" +
                    "될때 여럿의 \'같은\'종족 또는 직업의 챔피언이 존재한다면 \'시너지효과\'가 추가됩니다.");
            System.out.println("다음(아무숫자나입력)");
            next = sc.next();
            System.out.println("\n\n 대기열 설정 입니다.");
            System.out.println("┌──────────────────┐\n" +
                    "│             대기열 설정            │\n" +
                    "└──────────────────┘\n" +
                    "   1. 챔피언을 덱으로 이동\n" +
                    "   2. 챔피언 판매\n" +
                    "   0. 뒤로가기\n");
            System.out.println("챔피언을 전투덱으로 이동시키거나 판매할 수 있습니다.");
            System.out.println("\'대기열\'의 챔피언을 \'챔피언덱\'으로 옮겨놓아야 전투에 참여할 수 있습니다");
            System.out.println("다음(아무숫자나입력)");
            next = sc.next();
            System.out.println("\n\n전투덱 설정 입니다.");
            System.out.println("┌──────────────────┐\n" +
                    "│             전투덱 설정            │\n" +
                    "└──────────────────┘\n" +
                    "   1. 챔피언을 대기열로 이동\n" +
                    "   2. 전투덱 조합 확인\n" +
                    "   0. 뒤로가기\n");

            System.out.println("챔피언을 대기열로 이동시키거나 나의 전투덱 조합을 확인 할 수 있습니다.");
            System.out.println("덱에는 레벨이 올라갈때 마다 1개의 챔피언이 추가로 올라갈 수 있습니다.");
            System.out.println("다음(아무숫자나입력)");
            next = sc.next();
            System.out.println("전투에 대해 설명드리겠습니다.");
            System.out.println("전투가 시작되면" + nickname + "님은 적의 공격을 방어하거나 적에게 공격을 가하여" +
                    "자신의 라이프 포인트를 지켜야합니다.");
            System.out.println("라운드가 끝나면 \'골드\'와 \'경험치\'를 획득할 수 있으며, 필요한 경험치를 모두\n" +
                    "획득하시면 나의 \'레벨\'을 올릴 수 있습니다.");
            System.out.println("\'방어에 실패할 경우\', 상대방의 남은 챔피언 수에 따라 \'생명력이 감소\'합니다.\n" +
                    "\'생명력\'이 0이 되면 게임에서 \'패배\'합니다.");

            System.out.println(nickname + "님께서 \'3개\'의 서로 같은 챔피언을 보유하면 챔피언의 \'등급\'이 올라갑니다");

            System.out.println("\n규칙설명이 끝났습니다");
            System.out.println(" ■□■□■□ BRONZE 난이도 ■□■□■□");

        }

    }

    public void firstScreen(int gameRound) {
        //라운드 첫화면 출력
        System.out.println("┌──────────────────┐");
        System.out.println("│\t\t\t\t"+gameRound+" 라운드\t\t\t  │");
        System.out.println("├──────────────────┤");
        System.out.println("│\t\t\t\t\t\t\t\t\t  │");
        System.out.println("│  1. 챔피언 상점                    │");
        System.out.println("│  2. 대기열 설정                    │");
        System.out.println("│  3. 전투덱 설정                    │");
        System.out.println("│  4. 나의 정보                      │");
        System.out.println("│  0. 전투 시작                      │");
        System.out.println("│\t\t\t\t\t\t\t\t\t  │");
        System.out.println("└──────────────────┘");
        System.out.print(" 숫자입력 >>  ");
    }

}
