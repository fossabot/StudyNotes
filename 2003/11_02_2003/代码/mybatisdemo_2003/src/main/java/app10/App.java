package app10;

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
    public void testFindAll(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            //执行两次查询语句
            List<Student> studentList = studentMapper.findAll();
            List<Student> studentList2 = studentMapper.findAll();
            logger.debug(studentList);
            logger.debug(studentList2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void  testFindAll2() throws Exception{
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取mapper代理对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //获取第二个SqlSession对象
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        //进行相同SQL的执行
        List<Student> studentList = studentMapper.findAll();
        List<Student> studentList2 = studentMapper2.findAll();
        logger.debug(studentList);
        logger.debug(studentList2);
        //关闭资源
        MybatisUtils.closeSqlSession(sqlSession);
        MybatisUtils.closeSqlSession(sqlSession2);
    }

    @Test
    public void testFindAll3(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            //调用全查询方法
            List<Student> studentList = studentMapper.findAll();
            //修改学生
            Student student = studentList.get(0);
            //修改学生
            student.setName("一级缓存");
            studentMapper.update(student);
            //提交食物
            sqlSession.commit();
            //再次查询
            studentList = studentMapper.findAll();
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            sqlSession.rollback();
        } finally {
            //关闭资源
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
