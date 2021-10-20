package app02;

public interface StudentMapper {

    //学生添加
    int add(Student student) throws Exception;
    //按id查询学生
    Student findById(int id) throws Exception;
}
