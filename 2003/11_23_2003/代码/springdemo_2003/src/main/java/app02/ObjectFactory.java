package app02;

/**
 * 工厂创建对象
 */
public class ObjectFactory {

    //实例方法创建对象
    public User getInstance(){
        return new User(100,"调用实例方法...");
    }

    //静态方法创建对象
    public static User getStaticInstance(){
        return new User(101,"调用静态方法...");
    }
}
