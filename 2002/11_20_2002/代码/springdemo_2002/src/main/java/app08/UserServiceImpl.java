package app08;

public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("添加类一个用户...");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户...");
    }

    @Override
    public void update() {
        System.out.println("修改了一个用户...");
    }

    @Override
    public void select() {
        System.out.println("查询了一个用户...");
    }
}
