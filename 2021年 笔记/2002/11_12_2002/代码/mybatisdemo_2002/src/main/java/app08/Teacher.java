package app08;

/**
 * 老师类
 */
public class Teacher {

    //老师编号
    private Integer id;
    //老师姓名
    private String name;

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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
