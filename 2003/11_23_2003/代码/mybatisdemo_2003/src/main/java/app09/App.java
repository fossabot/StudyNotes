package app09;

import org.apache.ibatis.annotations.Param;
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

    /*@Test
    public void testGetTeacher(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            List<Teacher> teacherList = sqlSession.getMapper(TeacherMapper.class).getTeacher();
            logger.debug(teacherList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }*/

    @Test
    public void testGetTeacher(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            Teacher teacher = sqlSession.getMapper(TeacherMapper.class).getTeacher(1);
            logger.debug(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testGetTeacher2(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            Teacher teacher = sqlSession.getMapper(TeacherMapper.class).getTeacher2(1);
            logger.debug(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
