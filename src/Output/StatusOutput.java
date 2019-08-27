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
        printHpMp(attacker);

    }

    private void printHpMp(AllUnit attacker) {
        int hpLength = (int)(Math.log10(Math.round(attacker.getHp())))+1;
        int mpLength = (int)(Math.log10(attacker.getMp())+1);
        if(attacker.getMp() == 0) {
            mpLength = 1;
        }
        if(hpLength + mpLength < 4) {
            System.out.print(" [ HP " + Math.round(attacker.getHp())+" "); //때린놈의 상태
            System.out.print("/ MP " + attacker.getMp() +" ]\t\t");
        }
        if(hpLength + mpLength >= 4){
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

    public void beAttackedSkillStatus(AllUnit beAttacker) {
        //맞은놈의 상태
        if(beAttacker.getHp() < 0) {
            beAttacker.setHp(0);
        }
        System.out.print(" " + beAttacker.getName());
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
        if(!unit.getName().endsWith("(봇)")) {
            playerName(unit);
        }
        if(unit.getName().endsWith("(봇)")) {
            botName(unit);
        }
    }

    private void botName(AllUnit unit) {
        if (unit.getName().length() == 3) {
            System.out.print("      " + unit.getName() + "     ");
        }
        if (unit.getName().length() == 4) {
            System.out.print("     " + unit.getName() + "    ");
        }
        if (unit.getName().length() == 5) {
            System.out.print("    " + unit.getName() + "   ");
        }
        if (unit.getName().length() == 6) {
            System.out.print("   " + unit.getName() + "  ");
        }
        if (unit.getName().length() > 6) {
            System.out.print("  " + unit.getName() + " ");
        }
    }

    private void playerName(AllUnit unit) {
        if (unit.getName().length() == 2) {
            System.out.print("      " + unit.getName() + "     ");
        }
        if (unit.getName().length() == 3) {
            System.out.print("     " + unit.getName() + "    ");
        }
        if (unit.getName().length() == 4) {
            System.out.print("    " + unit.getName() + "   ");
        }
        if (unit.getName().length() == 5) {
            System.out.print("   " + unit.getName() + "  ");
        }
        if (unit.getName().length() > 5 && unit.getName().length() <= 7) {
            System.out.print(" " + unit.getName() + " ");
        }
        if (unit.getName().length() > 7) {
            System.out.print(unit.getName());
        }
    }

    public void skillOutput(String skillName) {
        //스킬 사용
        if(skillName.length() <= 4) {
            System.out.print("\t──\uD83D\uDCA5");
            System.out.print(skillName);
            System.out.print("\uD83D\uDCA5→\t");
        }
        if(skillName.length() == 5) {
            System.out.print("\t─\uD83D\uDCA5");
            System.out.print(skillName);
            System.out.print("\uD83D\uDCA5→\t");
        }
        if(skillName.length() > 5) {
            System.out.print("\t─\uD83D\uDCA5");
            System.out.print(skillName);
            System.out.print("\uD83D\uDCA5→\t");
        }

    }
}
