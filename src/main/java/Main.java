import dao.SkillsDao;
import jdbc.JdbcSkillsDao;
import model.Skills;

/**
 * Created by Dimon on 13.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        JdbcSkillsDao jsd = new JdbcSkillsDao();
        jsd.insertIntoSkills("Scala");
    }
}
