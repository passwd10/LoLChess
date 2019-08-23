package Output;

import Common.AllUnit;

public class StatusOutput {
    //때리고 맞을때의 상태 출력

    public void attackerStatus(AllUnit attacker){
        //때린놈의 상태
        if(attacker.getHp() < 0) {
            attacker.setHp(0);
        }
        System.out.print(attacker.getName());
        System.out.print(" [ HP " + Math.round(attacker.getHp())+" "); //때린놈의 상태
        System.out.print("/ MP " + attacker.getMp() +" ]");
    }

    public void beAttackerStatus(AllUnit beAttacker) {
        //맞은놈의 상태
        if(beAttacker.getHp() < 0) {
            beAttacker.setHp(0);
        }
        System.out.print(beAttacker.getName());
        System.out.print(" [ HP " + Math.round(beAttacker.getHp()) + " "); //맞은놈의 상태
        System.out.print("/ MP " + beAttacker.getMp() + " ]");
    }

    public void skillOutput(String skillName) {
        //스킬 사용
        System.out.print("\n[Skill] " + skillName + " " ); //150, 275, 400
    }
}
