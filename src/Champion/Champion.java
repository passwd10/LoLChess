package Champion;

import Common.Attackable;
import Common.BeAttackable;
import Common.ClassSynergy;
import Common.SkillActive;

public abstract class Champion implements BeAttackable, Attackable, SkillActive, ClassSynergy {
    //캐릭터 추상클래스

    private String name;
    private String cClass; // 직업
    private String tribe; // 종족
    public double hp; //현재 체력
    private final double MAX_HP; //전체 체력
    public int mp; //마나
    private final int MAX_MP; //전체마나
    private double power; //공격력
    private double armor; //방어력
    private int gold; //가격
    private double attackSpeed; //공격 속도
    private String skillName; //스킬 이름
    private int skillDam; //스킬 데미지
    private int grade; //몇성인지 등급

    public Champion(String name, String chamClass, String tribe, int hp, int mp, int power, double attackSpeed, int armor, int gold, int grade) {
        this.cClass = chamClass;
        this.tribe = tribe;
        this.name = name;
        MAX_HP = hp;
        this.hp = hp;
        MAX_MP = mp;
        this.mp = mp;
        this.power = power;
        this.armor = armor;
        this.gold = gold;
        this.grade = grade;
        this.attackSpeed = attackSpeed;
    }

    public double getHp() { return this.hp; }

    public double setHp(int hp) { return  this.hp = hp; }

    public int getMp() { return this.mp; }

    public int setMp() { return this.mp = mp; }

    public String getName() {
        return this.name;
    }

    public String getcClass() { return this.cClass; }

    public String getTribe() { return this.tribe; }

    public double getPower() {
        return this.power;
    }

    public double getArmor() {
        return this.armor;
    }

    public int getMAX_MP() {
        return this.MAX_MP;
    }

    public double getMAX_HP() {
        return this.MAX_HP;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getGold() { return this.gold; }

    public double getAttackSpeed() { return this.attackSpeed; }

}