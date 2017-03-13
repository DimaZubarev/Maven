package dao;

import model.Skills;

import java.util.List;

public interface SkillsDao {
    Skills updateSkillName(String whereName, int changeId);
    Skills updateSkillId(int changeId, String whereName);
    Skills getSkills();
    Skills insertIntoSkills(String name_skill);
    boolean deleteSkill(String name);
}
