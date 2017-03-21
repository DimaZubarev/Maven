package jdbc;

import java.sql.*;
import dao.SkillsDao;
import model.Skills;
import org.apache.log4j.Logger;
import utilites.ConnectionUtils;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcSkillsDao implements SkillsDao {

    private static final Logger LOGGER = Logger.getLogger(JdbcSkillsDao.class);
    static final String UPDATE_NAME_SKILL = "update skills set name_skill = ? where name_skill = ?";

    @Override
    public List<Skills> getSkill() {
        List<Skills> skill = new ArrayList<>();
        Skills skills = new Skills(0, null);
        int id = 0;
        String name = "";
        final String GET_SKILLS = "select * from skills";

        try {
            ResultSet resultSet = ConnectionUtils.performStatement(GET_SKILLS);
            while (resultSet.next()){
                skills.setId_skill(resultSet.getInt("id_skill"));
                skills.setName_skill(resultSet.getString("name_skill"));
                skill.add(skills);
                System.out.println(skills);
            }
            ConnectionUtils.closeStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при виводі таблиці Скіли");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public void deleteSkill(String whereName) {
        final String DELETE_SKILLS = "delete from skills where name_skill = ?";
        try {
            ConnectionUtils.preparedStatementCreateDelete(DELETE_SKILLS, whereName);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при підключенні до БД");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public void createSkill(String whereName) {
        final String INSERT_INTO_SKILLS = "insert into skills (name_skill) values(?)";
        try {
            ConnectionUtils.preparedStatementCreateDelete(INSERT_INTO_SKILLS, whereName);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при додованні навику до таблиці Скіли");
        } catch (ClassNotFoundException e){
        e.printStackTrace();
        }
    }

    @Override
    public void updateSkill(String otherName, String whereName) {
        try {
            ConnectionUtils.preparedStatementUpdate(UPDATE_NAME_SKILL, otherName, whereName);
            ConnectionUtils.closePrepearedStatement();
            ConnectionUtils.closeConnection();
        } catch (SQLException e) {
            LOGGER.error("Виникла помилка при заміні айді скіла в таблиці Скіли");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
