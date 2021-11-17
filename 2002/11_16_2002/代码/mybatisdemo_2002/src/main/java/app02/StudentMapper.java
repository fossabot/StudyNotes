package app02;

import java.util.List;

public interface StudentMapper {

    //学生添加
    int add(Student student) throws Exception;
    //按id查询学生
    Student findById(int id) throws Exception;
    //学生全查询
    List<Student> findAll() throws Exception;
    //学生更新
    int update(Student student) throws Exception;
    //学生删除
    int delete(Student student) throws Exception;
}
