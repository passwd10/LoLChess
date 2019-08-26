package Common;

public class VarietySkillActive {

    public int attackOne(AllUnit[] target, int deal) {
        //스킬로 한명을 공격
        int targetNum = 0;

        while(target[targetNum].getHp() == 0) {
            targetNum++;
        }

        target[targetNum].setHp(target[targetNum].getHp() - deal);
        target[targetNum].setMp(target[targetNum].getMp() + 20);

        return 1;
    }

    public int attackTwo(AllUnit[] target, int deal) {
        //스킬로 두명을 공격

        int targetNum = 0;

        while (target[targetNum].getHp() == 0) {
            targetNum++;
        }

        target[targetNum].setHp(target[targetNum].getHp() - deal);
        target[targetNum].setMp(target[targetNum].getMp() + 20);

        if (targetNum + 1 < target.length) {
            target[targetNum + 1].setHp(target[targetNum + 1].getHp() - deal);
            target[targetNum + 1].setMp(target[targetNum + 1].getMp() + 20);
            return 2;
        }

        return 1;
    }

    public int attackAll(AllUnit[] target, int deal) {

        int targetNum = 0;

        while(target[targetNum].getHp() == 0) {
            targetNum++;
        }

        int cnt = 0;
        while(targetNum < target.length) {
            cnt++;
            target[targetNum].setHp(target[targetNum].getHp() - deal);
            target[targetNum].setMp(target[targetNum].getMp() + 20);
            targetNum++;
        }

        return cnt;
    }
}
