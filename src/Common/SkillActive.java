package Common;

import Champion.Champion;

public interface SkillActive {
    //스킬 발동가능한 챔피언

    public void useSkill(Champion champion); //스킬 발동 target 1개

    public void useSkill(Champion champion1, Champion champion2); //스킬 발동 target 2개

    public void useSkill(Champion champion1,Champion champion2,Champion champion3); //스킬 발동 target 3개

    public void useSkill(Champion champion1,Champion champion2,Champion champion3,Champion champion4); //스킬 발동 target 4개

    //public int getMp();
    public int getMAX_MP();
    public int getGrade();
}
