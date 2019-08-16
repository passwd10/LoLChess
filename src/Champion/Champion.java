package Champion;

import Common.*;

public abstract class Champion implements BeAttackable, Attackable, SkillActive, ClassSynergy{
    //캐릭터 추상클래스

    private String name;
    private String cClass; // 직업
    private String tribe; // 종족
    private double hp; //현재 체력
    private final double MAX_HP; //전체 체력
    private int mp; //마나
    private final int MAX_MP; //전체마나
    private double power; //공격력
    private final double FIRST_POWER; //처음 공격력
    private double armor; //방어력
    private final double FIRST_ARMOR; //처음 방어력
    private int gold; //가격
    private double attackSpeed; //공격 속도
    private String skillName; //스킬 이름
    private int skillDam; //스킬 데미지
    private int grade; //몇성인지 등급
    private int tier; //챔피언 티어

    public Champion(String name, String chamClass, String tribe,int tier, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
        this.cClass = chamClass;
        this.tribe = tribe;
        this.name = name;
        this.tier = tier;
        MAX_HP = hp;
        this.hp = hp;
        MAX_MP = mp;
        this.mp = mp;
        this.power = power;
        FIRST_POWER = power;
        this.armor = armor;
        FIRST_ARMOR = armor;
        this.gold = gold;
        this.grade = grade;
        this.attackSpeed = attackSpeed;
    }

    public double getHp() { return this.hp; }

    public double setHp(double hp) { return  this.hp = hp; }

    public int getMp() { return this.mp; }

    public int setMp(int mp) { return this.mp = mp; }

    public String getName() {
        return this.name;
    }

    public String getcClass() { return this.cClass; }

    public String getTribe() { return this.tribe; }

    public double getPower() {
        return this.power;
    }

    public double setPower(double power) { return this.power = power; }

    public double getArmor() {
        return this.armor;
    }

    public double setArmor(double armor) { return this.armor = armor; }

    public int getMAX_MP() {
        return this.MAX_MP;
    }

    public double getMAX_HP() {
        return this.MAX_HP;
    }

    public double getFIRST_POWER() { return this.FIRST_POWER;}

    public double getFIRST_ARMOR() { return this.FIRST_ARMOR;}

    public int getGrade() {
        return this.grade;
    }

    public int getGold() { return this.gold; }

    public double getAttackSpeed() { return this.attackSpeed; }

    public int getTier() { return this.tier; }


}