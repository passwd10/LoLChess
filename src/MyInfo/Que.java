package MyInfo;

import Champion.*;
import java.util.ArrayList;

public class Que extends MyInfo {

    ArrayList<Champion> myQue = new ArrayList(); //나의 챔피언 대기목록

    public int queSize() { //큐 사이즈 반환
        return myQue.size();
    }

    public Champion deletQue(int i) {
        //대기열의 챔피언 삭제
        Champion delete = myQue.get(i-1);
        myQue.remove(delete);
        return delete;
    }

    public void addQue(Champion champion) {
        //대기열에 챔피언 저장하는 메소드
        if (myQue.size() >= 9) {
            System.out.println("대기열이 가득 찼습니다.");
        } else {
            myQue.add(champion); //대기열에 추가
            System.out.println(champion.getName()+"을(를) 대기열에 넣었습니다.");
        }
    }

    public Champion returnQue(int i) {
        //대기열의 챔피언 반환
        return myQue.get(i-1);
    }

    @Override
    public int output() {
        //챔피언 대기창 출력
        System.out.println("-------------------------------------");
        System.out.println("\t\t나의 챔피언 대기목록");
        System.out.println("-------------------------------------");
        if(myQue.size() == 0) {
            System.out.println("대기열에 챔피언이 없습니다.\n");
            return 0;
        }
        else {
            for (int i = 0; i < myQue.size(); i++) {
                System.out.println((i + 1) + ". " + myQue.get(i).getName() + "(" + myQue.get(i).getcClass() + ")\t" + myQue.get(i).getGrade() + "성\t\t" + myQue.get(i).getGold() + "원");
            }
            System.out.println("");
            return 1;
        }
    }
}
