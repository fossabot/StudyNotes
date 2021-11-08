package app04;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    //有条件在查询所有学生
    List<Student> findAllByCondition(Map<String,Object> map) throws Exception;
}
