package app03;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    //学生添加
    int add(Student student) throws Exception;
    /**
     * 无条件分页
     * start：表示在MySQL中从第几条记录的索引开始显示
     * size：表示MySQL中最多显示几条记录（容量）
     */
    List<Student> findAllByPage(Map<String,Object> map) throws Exception;
    //有条件的分页
    List<Student> findByNameByPage(Map<String,Object> map) throws Exception;
}
