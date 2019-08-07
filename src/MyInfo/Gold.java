package MyInfo;

public class Gold extends MyInfo {

    public int gold;

    public Gold(int gold) {
        this.gold = gold;
    }

    @Override
    public int output() {
        System.out.println("-------------------------------------");
        System.out.println("  내 골드 : "+gold + "원");
        System.out.println("-------------------------------------");
        return 1;
    }
}
