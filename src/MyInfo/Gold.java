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
        }
        if (gold >= 10 && gold < 20) {
            plusGold = 1;
        }
        if (gold >= 20 && gold < 30) {
            plusGold = 2;
        }
        if (gold >= 30 && gold < 40) {
            plusGold = 3;
        }
        if (gold >= 40 && gold < 50) {
            plusGold = 4;
        }
        if (gold >= 50) {
            plusGold = 5;
        }
    }

    public int getPlusGold() {
        return this.plusGold;
    }

}
