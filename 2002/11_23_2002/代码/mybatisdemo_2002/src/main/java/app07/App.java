package app07;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

/**
 * 测试类
 */
public class App {

    private Logger logger = Logger.getLogger(StudentMapper.class);

    @Test
    public void testStudentInsertByParts(){
        SqlSession sqlSession = null;
        try {
            //影响的行数
            int updateRows = 0;
            sqlSession = MybatisUtils.getSqlSession();
            updateRows = sqlSession.getMapper(StudentMapper.class)
                    .studentInsertByParts(new Student(11,"继达",7000D));
            //判断是否插入成功
            if (updateRows>0){
                logger.debug("插入成功...");
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
