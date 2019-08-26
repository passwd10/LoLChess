package Output;

import Common.AllUnit;

public class StatusOutput {
    //때리고 맞을때의 상태 출력

    public void attackerStatus(AllUnit attacker){
        //때린놈의 상태
        if(attacker.getHp() < 0) {
            attacker.setHp(0);
        }

        printName(attacker);
        hpBlock(attacker);
        if(Math.round(attacker.getHp()) >= 100 && attacker.getMp() >= 100) {
            System.out.print(" [ HP " + Math.round(attacker.getHp())+" "); //때린놈의 상태
            System.out.print("/ MP " + attacker.getMp() +" ]");
        } else {
            System.out.print(" [ HP " + Math.round(attacker.getHp())+" "); //때린놈의 상태
            System.out.print("/ MP " + attacker.getMp() +" ]\t");
        }

    }

    public void beAttackerStatus(AllUnit beAttacker) {
        //맞은놈의 상태
        if(beAttacker.getHp() < 0) {
            beAttacker.setHp(0);
        }

        printName(beAttacker);
        hpBlock(beAttacker);
        System.out.print(" [ HP " + Math.round(beAttacker.getHp()) + " "); //맞은놈의 상태
        System.out.print("/ MP " + beAttacker.getMp() + " ]");
    }


    private void hpBlock(AllUnit unit) {
        double oneBlock = unit.getMAX_HP() / 5;
        if(unit.getMAX_HP() == unit.getHp()) {
            System.out.print(" ■■■■■");
        }
        if(oneBlock*4 <= unit.getHp() && oneBlock*5 > unit.getHp()) {
            System.out.print(" ■■■■□");
        }
        if(oneBlock*3 <= unit.getHp() && oneBlock*4 > unit.getHp()) {
            System.out.print(" ■■■□□");
        }
        if(oneBlock*2 <= unit.getHp() && oneBlock*3 > unit.getHp()) {
            System.out.print(" ■■□□□");
        }
        if(oneBlock*1 <= unit.getHp() && oneBlock*2 > unit.getHp()) {
            System.out.print(" ■□□□□");
        }
        if(oneBlock*1 > unit.getHp()) {
            System.out.print(" □□□□□");
        }
    }

    private void printName(AllUnit unit) {
        System.out.print("\t");
        if(unit.getName().length() == 2) {
            System.out.print("     "+unit.getName()+"    ");
        }
        if(unit.getName().length() == 3) {
            System.out.print("    "+unit.getName()+"   ");
        }
        if(unit.getName().length() == 4) {
            System.out.print("   "+unit.getName()+"  ");
        }
        if(unit.getName().length() == 5) {
            System.out.print("  "+unit.getName()+" ");
        }
        if(unit.getName().length() > 5) {
            System.out.print(unit.getName());
        }
    }

    public void skillOutput(String skillName) {
        //스킬 사용
        System.out.print(skillName); //150, 275, 400
    }
}
