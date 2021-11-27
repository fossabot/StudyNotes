package app09;

import java.util.Date;

/**
 * 员工类
 */
public class Emp {

    //员工编号
    private Integer id;
    //员工用户名
    private String username;
    //员工薪水
    private Double salary;
    //员工入职日期
    private Date hiredate;

    //无参构造方法
    public Emp(){}

    //有参构造方法
    public Emp(Integer id, String username, Double salary, Date hiredate) {
        this.id = id;
        this.username = username;
        this.salary = salary;
        this.hiredate = hiredate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", salary=" + salary +
                ", hiredate=" + hiredate +
                '}';
    }
}
