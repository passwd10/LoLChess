package Common;

import Champion.*;

public interface SkillActive {
    //스킬 발동가능한 챔피언

    public int useSkill(AllUnit[] target); // 타겟에게 스킬 발동

    //public int getMp();
    public int getMAX_MP();
    public int getGrade();
}
