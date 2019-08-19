package Output;

import MyInfo.Gold;
import MyInfo.Level;
import MyInfo.Life;

public class InfoOutput {
    //라이프, 골드, 레벨 출력

    public int goldOutput(Gold gold) { //내 골드
        System.out.println("   골드 : "+gold.gold + "원 (이자 "+ gold.getPlusGold() + "원)");
        return 1;
    }

    public int levelOutput(Level myLevel) {
        System.out.print("   레벨 : " + myLevel.getMyLevel() + " Lv");
        System.out.println("  [" + (myLevel.getMyLevel()+1) +"Lv까지 " + (myLevel.getMyLevel()*(myLevel.getMyLevel()+1)-myLevel.getMyXp()) +"XP 필요]");
        return 0;
    }

    public int lifeOutput(Life life) {
        System.out.println("   남은 생명력 : " + life.getLife());
        return 0;
    }
}
