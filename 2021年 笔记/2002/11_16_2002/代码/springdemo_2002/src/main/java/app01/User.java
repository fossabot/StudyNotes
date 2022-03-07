package app01;

/**
 * 用户类
 */
public class User {

    //编号
    private Integer id;
    //姓名
    private String name;

    public User(){
        System.out.println("----------User对象创建----------");
    }

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

    public void initUser(){
        System.out.println("创建对象之后，初始化...");
    }

    public void destroyUser(){
        System.out.println("IOC容器销毁，user对象回收...");
    }
}
