package app09;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {

    //获取老师信息
    //List<Teacher> getTeacher() throws Exception;
    //获取指定老师下的所有学生及老师的信息
    Teacher getTeacher(@Param("tid") int id) throws Exception;
    Teacher getTeacher2(@Param("tid") int id) throws Exception;
}
