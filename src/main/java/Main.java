import controller.SkillController;
import dao.SkillsDao;
import jdbc.JdbcSkillsDao;
import model.Skills;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SkillController sc = new SkillController();
        try {
            sc.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
