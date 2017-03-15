package model;

public class Skills {
    private int id_skill;
    private String name_skill;

    public Skills(int id_skill, String name_skill) {
        this.id_skill = id_skill;
        this.name_skill = name_skill;
    }
    public Skills(){}

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public String getName_skill() {
        return name_skill;
    }

    public void setName_skill(String name_skill) {
        this.name_skill = name_skill;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "id_skill=" + id_skill +
                ", name_skill='" + name_skill + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skills skills = (Skills) o;

        if (id_skill != skills.id_skill) return false;
        return name_skill != null ? name_skill.equals(skills.name_skill) : skills.name_skill == null;
    }

    @Override
    public int hashCode() {
        int result = id_skill;
        result = 31 * result + (name_skill != null ? name_skill.hashCode() : 0);
        return result;
    }

    //statement.execute("insert into skills (name_skill) values('Scala')");
    //Python
}
