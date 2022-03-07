package app11;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.List;

/**
 * 测试类
 */
public class App {

    private Logger logger = Logger.getLogger(App.class);

    @Test
    public void testFindAll() throws Exception{
        //获取两个SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        //获取第一个StudentMapper并查询
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = studentMapper.findAll();
        logger.debug(studentList);
        //关闭第一个SqlSession
        MybatisUtils.closeSqlSession(sqlSession);
        //获取第二个StudentMapper并查询
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        List<Student> studentList2 = studentMapper2.findAll();
        logger.debug(studentList2);
        logger.debug(studentList==studentList2);
        //关闭第二个SqlSession
        MybatisUtils.closeSqlSession(sqlSession2);
    }
}
