package app01;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

/**
 * 测试类
 */
public class App {

    //定义日志对象
    Logger logger = Logger.getLogger(App.class);

    @Test
    public void testAdd(){
        SqlSession sqlSession = null;
        try {
            //获取SqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            sqlSession.getMapper(StudentMapper.class).add();
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
    public void testAdd2(){
        SqlSession sqlSession = null;
        //影响的行数
        int updateRows = 0;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理对象并调用方法
            updateRows = sqlSession.getMapper(StudentMapper.class).add2(new Student(2,"郝月",8000D));
            //判断是否插入成功
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
            //关闭资源
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
