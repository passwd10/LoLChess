package MyInfo;

public class Life extends MyInfo {

    private int life;

    public int getLife() {return this.life;}
    public int setLife(int life) {return this.life =life; }
    @Override
    public int output() {
        System.out.println("   남은 생명력 : " + life);
        return 0;
    }
}
