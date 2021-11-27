package app09;

import java.util.List;

/**
 * 老师类
 */
public class Teacher {

    //老师编号
    private Integer id;
    //老师姓名
    private String name;

    //该老师所教授的学生
    private List<Student> students;

    //无参构造方法
    public Teacher(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
