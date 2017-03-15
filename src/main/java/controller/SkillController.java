package controller;

import jdbc.JdbcSkillsDao;
import view.ConsoleDataInput;

import java.io.IOException;
import java.sql.SQLException;

public class SkillController implements GeneralController {

    @Override
    public void execute() throws IOException, ClassNotFoundException, SQLException {

        JdbcSkillsDao jdbcSkillsDao = new JdbcSkillsDao();
        int id_skill;
        String name_skill;
        int controlValue;

        ConsoleDataInput.writeMessage("*** SKILLS ***" + "\n" +
        "1 - createSkills | 2 - updateSkill | 3 - deleteSkill | 4 - getSkill \\n");

        controlValue = ConsoleDataInput.readInt();

        if(controlValue == 1){
            ConsoleDataInput.writeMessage("Введіть назву нового Скіла");
            name_skill = ConsoleDataInput.readString();
            jdbcSkillsDao.createSkill(name_skill);
        }else if(controlValue == 2){
            ConsoleDataInput.writeMessage("Введіть назву Скіла який потрібно змінити");
            name_skill = ConsoleDataInput.readString();
            jdbcSkillsDao.updateSkill(name_skill);
        }else if (controlValue == 3){
            ConsoleDataInput.writeMessage("Введіть назву Скіла який потрібно видалити");
        }else if(controlValue == 4){
            jdbcSkillsDao.getSkill();
        }else System.out.println("Ви ввели не коректне значення. Введіть: 1, 2, 3 або 4 ");
    }
}
