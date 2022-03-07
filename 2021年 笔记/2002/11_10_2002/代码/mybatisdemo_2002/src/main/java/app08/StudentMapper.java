package app08;

import java.util.List;

public interface StudentMapper {

    //查询所有学生，以及对应的老师的信息
    List<Student> getStudent() throws Exception;
}
