package app03;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;
import utils.MybatisUtils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 */
public class App {

    private Logger logger = Logger.getLogger(App.class);

    @Test
    public void testAdd(){
        SqlSession sqlSession = null;
        //影响的行数
        int updateRows = 0;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //循环插入
            for (int i=1;i<=10;i++){
                //获取代理对象并调用方法
                updateRows = sqlSession.getMapper(StudentMapper.class).add(new Student(i,"李季"+i,5000D));
            }
            //判断插入是否成功
            if (updateRows>0){
                logger.debug("批量插入成功...");
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
    public void testFindAllByPage(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //定义Map集合
            Map<String,Object> map = new LinkedHashMap<>();
            //将条件封装到Map集合中
            map.put("start",0);
            map.put("size",3);
            //获取mapper代理对象并调用方法
            List<Student> studentList = sqlSession.getMapper(StudentMapper.class).findAllByPage(map);
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }

    @Test
    public void testFindByNameByPage(){
        SqlSession sqlSession = null;
        try {
            sqlSession = MybatisUtils.getSqlSession();
            //定义Map集合
            Map<String,Object> map = new HashMap<>();
            //将条件封装到Map集合中
            map.put("pname","季");
            map.put("start",3);
            map.put("size",3);
            //获取mapper代理对象并调用方法
            List<Student> studentList = sqlSession.getMapper(StudentMapper.class).findByNameByPage(map);
            //打印分页（有条件）的查询结果
            logger.debug(studentList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtils.closeSqlSession(sqlSession);
        }
    }
}
