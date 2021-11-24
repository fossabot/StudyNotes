package app06;

import java.util.List;

public interface StudentMapper {

    //删除学生
    int studentDelete(Student student) throws Exception;
    //根据id批量删除学生(数组版本)
    int studentDeleteByArray(int[] ids) throws Exception;
    //根据id批量删除学生(集合版本)
    int studentDeleteByList(List<Integer> ids) throws Exception;
}
