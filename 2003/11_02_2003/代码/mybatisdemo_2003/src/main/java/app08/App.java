package app08;

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
    public void testGetStudent(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取Mapper代理对象并调用方法
            List<Student> studentList = sqlSession.getMapper(StudentMapper.class).getStudent();
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetStudent2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            List<Student> studentList = sqlSession.getMapper(StudentMapper.class).getStudent2();
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
