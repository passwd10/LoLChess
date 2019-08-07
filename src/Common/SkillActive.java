package Common;

public interface SkillActive {
    //스킬 발동가능한 챔피언

    public void useSkill(BeAttackable target); //스킬 발동 target 1개

    public void useSkill(BeAttackable target1, BeAttackable target2); //스킬 발동 target 2개

    public void useSkill(BeAttackable target1, BeAttackable target2, BeAttackable target3); //스킬 발동 target 3개

    public void useSkill(BeAttackable target1, BeAttackable target2, BeAttackable target3, BeAttackable target4); //스킬 발동 target 4개

    //public int getMp();
    public int getMAX_MP();
    public int getGrade();
}
