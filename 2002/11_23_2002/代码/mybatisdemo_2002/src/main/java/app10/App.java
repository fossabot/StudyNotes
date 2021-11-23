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
            //执行两次相同的查询语句
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
    public void testFindAll2() throws Exception{
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //获取第一个mapper对象
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();
        //获取第二个mapper对象
        StudentMapper studentMapper2 = sqlSession2.getMapper(StudentMapper.class);
        //执行相同的SQL语句
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
            //获取mapper代理对象
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            //调用查询方法
            List<Student> studentList = studentMapper.findAll();
            //获取某一个学生（获取集合中的第一个学生）
            Student student = studentList.get(0);
            //修改学生
            student.setName("挂机很猖獗");
            studentMapper.update(student);
            //提交事务
            sqlSession.commit();
            //再次查询
            studentList = studentMapper.findAll();
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            sqlSession.rollback();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
