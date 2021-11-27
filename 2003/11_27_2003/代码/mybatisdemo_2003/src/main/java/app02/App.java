package app02;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.List;


/**
 * 测试类
 */
public class App {

    //引入日志对象
    private Logger logger = Logger.getLogger(App.class);

    @Test
    public void testAdd(){
        SqlSession sqlSession = null;
        //影响的行数(执行后返回一个整数，代表插入的行数)
        int updateRows = 0;
        //获取sqlSession对象
        sqlSession = MybatisUtils.getSqlSession();
        try {
            //获取mapper的代理对象
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //调用方法
            updateRows = mapper.add(new Student(3,"海娇",8000D));
            //判断是否添加成功
            if (updateRows>0){
                logger.debug("添加成功...");
            }
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            sqlSession.rollback();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFindById(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            Student student = sqlSession.getMapper(StudentMapper.class).findById(1);
            logger.debug(student);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFindAll(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            List<Student> studentList = sqlSession.getMapper(StudentMapper.class).findAll();
            /*for (Student student : studentList) {
                logger.debug(student);
            }*/
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = null;
        //影响的行数
        int updateRows = 0;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            updateRows = sqlSession.getMapper(StudentMapper.class).update(new Student(3, "邱海娇", 8500D));
            //判断是否更新成功
            if (updateRows>0){
                logger.debug("修改成功...");
            }
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            sqlSession.rollback();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = null;
        //影响的行数
        int updateRows = 0;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            updateRows = sqlSession.getMapper(StudentMapper.class).delete(new Student(2,null,null));
            if (updateRows>0){
                logger.debug("删除成功...");
            }
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            sqlSession.rollback();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
