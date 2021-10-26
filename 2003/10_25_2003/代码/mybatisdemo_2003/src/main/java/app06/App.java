package app06;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试类
 */
public class App {

    private Logger logger = Logger.getLogger(App.class);

    @Test
    public void testStudentDelete(){
        SqlSession sqlSession = null;
        try {
            //影响的行数
            int updateRows = 0;
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            updateRows = sqlSession.getMapper(StudentMapper.class).studentDelete(new Student(3,null,null));
            //判断删除是否成功
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

    @Test
    public void testStudentDeleteByArray(){
        SqlSession sqlSession = null;
        try {
            //影响的行数
            int updateRows = 0;
            sqlSession = MybatisUtils.getSqlSession();
            //传递的参数
            int[] ids = {6,7};
            //获取mapper代理对象并调用方法
            updateRows = sqlSession.getMapper(StudentMapper.class).studentDeleteByArray(ids);
            //批量删除是否成功
            if (updateRows>0){
                logger.debug("批量删除成功...");
            }
            //提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            sqlSession.rollback();
        } finally {
            //关闭资源
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testStudentDeleteByList(){
        SqlSession sqlSession = null;
        sqlSession = MybatisUtils.getSqlSession();
        //影响的行数
        int updateRows = 0;
        //传入的参数(方式一)
        //List<Integer> ids = new ArrayList<>();
        //向集合中添加元素
        //ids.add(8);
        //ids.add(9);
        List<Integer> ids = Arrays.asList(8, 9);
        //获取mapper代理对象并调用方法
        //updateRows = sqlSession.getMapper(StudentMapper.class).studentDeleteByList();
    }
}
