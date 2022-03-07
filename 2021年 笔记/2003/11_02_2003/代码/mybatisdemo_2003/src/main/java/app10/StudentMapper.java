package app10;

import java.util.List;

public interface StudentMapper {

    //查询所有学生
    List<Student> findAll() throws Exception;
    //学生修改
    int update(Student student) throws Exception;
}
