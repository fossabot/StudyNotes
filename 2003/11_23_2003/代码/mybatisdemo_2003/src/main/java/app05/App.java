package app05;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

/**
 * 测试类
 */
public class App {

    private Logger logger = Logger.getLogger(App.class);

    @Test
    public void testUpdateByCondition(){
        SqlSession sqlSession = null;
        try {
            //影响的行数
            int updateRows = 0;
            sqlSession = MybatisUtils.getSqlSession();
            //获取mapper的代理对象并调用方法
            updateRows = sqlSession.getMapper(StudentMapper.class).updateByCondition(new Student(5,"陈阳",null));
            //判断是否修改成功
            if (updateRows>0){
                logger.debug("修改成功...");
            }
            //提交实务
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
