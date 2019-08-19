package MyInfo;

public class Level extends MyInfo {

    private int myLevel; //레벨
    private int myXp; //경험치


    public Level(int myLevel) {
        this.myLevel = myLevel;
    }

    public void isMyLevel(int myXp) { //총 경험치에 비례한 나의 레벨
        int[] leastXp = new int[10];
        for(int a=0; a<10; a++) {
            leastXp[a] = a*(a+1); // leastXp[ 내레벨 -1 ] = 최소 경험치
            if(myXp < leastXp[a]) {
                setMyLevel(a);
                break;
            }
        }
        //setMyLevel(10); //내 레벨 10
    }

    public int setMyXp(int myXp) {
        return this.myXp = myXp;
    }

    public int getMyXp() {
        return this.myXp;
    }

    public int setMyLevel(int myLevel) {
        return this.myLevel = myLevel;
    }

    public int getMyLevel() {
        return this.myLevel;
    }

}
