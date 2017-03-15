package dao;

import model.Skills;

import java.util.List;

public interface SkillsDao {
    public void updateSkill(String whereName);
    public List<Skills> getSkill();
    public void createSkill(String whereName);
    public void deleteSkill(String whereName);
}