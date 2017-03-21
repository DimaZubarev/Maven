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
        String whereName;
        String otherName;

        int controlValue;

        ConsoleDataInput.writeMessage("*** SKILLS ***" + "\n" +
        "1 - createSkills | 2 - updateSkill | 3 - deleteSkill | 4 - getSkill");

        controlValue = ConsoleDataInput.readInt();

        if(controlValue == 1){
            ConsoleDataInput.writeMessage("Введіть назву нового Скіла");
            whereName = ConsoleDataInput.readString();
            jdbcSkillsDao.createSkill(whereName);
        }else if(controlValue == 2){
            ConsoleDataInput.writeMessage("Введіть назву  нового Скіла  та який потрібно змінити");
            otherName = ConsoleDataInput.readString();
            whereName = ConsoleDataInput.readString();
            jdbcSkillsDao.updateSkill(otherName, whereName);
        }else if (controlValue == 3){
            ConsoleDataInput.writeMessage("Введіть назву Скіла який потрібно видалити");
            whereName = ConsoleDataInput.readString();
            jdbcSkillsDao.deleteSkill(whereName);
        }else if(controlValue == 4){
            jdbcSkillsDao.getSkill();
        }else System.out.println("Ви ввели не коректне значення. Введіть: 1, 2, 3 або 4 ");
    }
}
