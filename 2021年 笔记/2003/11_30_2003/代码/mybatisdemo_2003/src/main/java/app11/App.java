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

    Logger logger = Logger.getLogger(App.class);

    @Test
    public void testFindAll() throws Exception{
        //创建两个SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        StudentMapper studentMapper2 = sqlSession.getMapper(StudentMapper.class);
        //分别使用不同的SqlSesson对象执行两个相同的sql语句
        List<Student> studentList = studentMapper.findAll();
        List<Student> studentList2 = studentMapper2.findAll();
        logger.debug(studentList);
        logger.debug(studentList2);
        //关闭资源
        MybatisUtils.closeSqlSession(sqlSession);
        MybatisUtils.closeSqlSession(sqlSession2);
    }
}
