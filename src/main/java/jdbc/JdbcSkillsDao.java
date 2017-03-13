package jdbc;

import java.sql.*;
import dao.SkillsDao;
import model.Skills;
import org.apache.log4j.Logger;
import javax.sql.DataSource;
import java.sql.SQLException;

public class JdbcSkillsDao implements SkillsDao {

    private static final Logger LOGGER = Logger.getLogger(JdbcSkillsDao.class);
    private DataSource dataSource;

    @Override
    public Skills updateSkillName(String changeName, int whereId) {
        Skills skills = null;
        final String UPDATE_SKILL_NAME = "update skills set name = ? where id = ?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_SKILL_NAME);
            ps.setString(1, changeName);
            ps.setInt(2, whereId);
            ps.executeUpdate(UPDATE_SKILL_NAME);
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при заміні назви скіла в таблиці Скіли");
        }
            return skills;
    }

    @Override
    public Skills updateSkillId( int changeId, String whereName) {
        Skills skills = null;
        final String UPDATE_SKILL_ID = "update skills set id = ? where name = ?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_SKILL_ID);
            ps.setInt(1, changeId);
            ps.setString(2, whereName);
            ps.executeUpdate(UPDATE_SKILL_ID);
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при заміні айді скіла в таблиці Скіли");
        }
        return skills;
    }

    @Override
    public Skills getSkills() {
        Skills skills = null;
        final String GET_SKILLS = "select * from skills";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_SKILLS);
            ResultSet resultSet = ps.executeQuery(GET_SKILLS);
            while (resultSet.next()){
                Skills skill = new Skills();
                skill.setId_skill(resultSet.getInt("id_skill"));
                skill.setName_skill(resultSet.getString("name_skill"));
            }
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при виводі таблиці Скіли");
        }

        return skills;
    }

    @Override
    public Skills insertIntoSkills(String name_skill) {
        Skills skills = null;
        final String INSERT_INTO_SKILLS = "insert into skills (name_skill) values(?)";
        try {
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            if(name_skill != null){
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO_SKILLS);
            ps.setString(1, name_skill);
            ps.executeUpdate();
            }
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при додованні навику до таблиці Скіли");
        }
        return skills;
    }

    @Override
    public boolean deleteSkill(String whereName) {
        final String DELETE_SKILLS = "delete from skills where name = ?";
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_SKILLS);
            ps.setString(1, whereName);
            ps.executeUpdate(DELETE_SKILLS);
            return true;
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при підключенні до БД");
            return false;
        }
    }
}
