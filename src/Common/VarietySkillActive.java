package Common;

public class VarietySkillActive {

    public int attackOne(AllUnit[] target, int deal, int stunTime) {
        //스킬로 한명을 공격
        int targetNum = 0;

        while(target[targetNum].getHp() == 0) {
            targetNum++;
        }

        int finalTargetNum = targetNum;
        double firstAttackSpeed = target[targetNum].getAttackSpeed(); //변경 전 스피드

        new Thread(new Runnable() {
            @Override
            public synchronized void run() {
                try{
                    target[finalTargetNum].setAttackSpeed(10000); //공속느리게함
                    Thread.sleep(stunTime);
                    target[finalTargetNum].setAttackSpeed(firstAttackSpeed); //다시 변경
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
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
