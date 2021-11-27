package app14;

/**
 * 自定义异常
 */
public class MyException extends Exception {

    //异常信息
    private String msg;

    //无参构造方法
    public MyException(){}

    //有参构造方法
    public MyException(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
