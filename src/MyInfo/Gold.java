package MyInfo;

public class Gold extends MyInfo {

    public int gold;
    private int plusGold;

    public Gold(int gold) {
        this.gold = gold;
    }

    public void plusGold() {
        //이자 계산해서 지급
        if (gold >= 0 && gold < 10) {
            plusGold = 0;
        } else if (gold >= 10 && gold < 20) {
            plusGold = 1;
        } else if (gold >= 20 && gold < 30) {
            plusGold = 2;
        } else if (gold >= 30 && gold < 40) {
            plusGold = 3;
        } else if (gold >= 40 && gold < 50) {
            plusGold = 4;
        } else {
            plusGold = 5;
        }
    }

    public int getPlusGold() {
        return this.plusGold;
    }

    @Override
    public int output() {
        System.out.println("   골드 : "+gold + "원 (이자 "+ plusGold + "원)");
        return 1;
    }
}
