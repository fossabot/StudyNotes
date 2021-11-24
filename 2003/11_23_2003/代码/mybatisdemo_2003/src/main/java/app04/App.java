package app04;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
public class App {

    private Logger logger = Logger.getLogger(StudentMapper.class);

    @Test
    public void testFindAllByCondition(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //封装条件信息
            Map<String,Object> map = new LinkedHashMap<>();
            //将条件放入集合中
            map.put("pid",null);
            map.put("pname","李季2");
            map.put("psal",null);
            //获取mapper代理对象并调用方法
            List<Student> studentList = sqlSession.getMapper(StudentMapper.class).findAllByCondition(map);
            //打印查询结果
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
