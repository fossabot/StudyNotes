package app01;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

public class App {

    private Logger logger = Logger.getLogger(App.class);

    @Test
    public void testAdd1() {
        //定义对象
        SqlSession sqlSession = null;
        try {
            //获取sqlSession对象
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper代理丢向并调用方法
            sqlSession.getMapper(StudentMapper.class).add1();
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
    public void testAdd2(){
        SqlSession sqlSession = null;
        //影响的行数
        int updateRows = 0;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            updateRows = sqlSession.getMapper(StudentMapper.class).add2(new Student(2, "春然", 7000D));
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
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
