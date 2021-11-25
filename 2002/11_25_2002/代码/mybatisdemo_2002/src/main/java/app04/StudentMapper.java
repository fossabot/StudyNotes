package app04;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    //有条件的查询所有学生
    List<Student> findAllByCondition(Map<String,Object> map) throws Exception;
}
