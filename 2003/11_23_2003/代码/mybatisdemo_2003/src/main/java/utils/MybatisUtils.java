package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

/**
 * mybatis工具类
 */
public class MybatisUtils {

    //定义sqlSession工厂
    private static SqlSessionFactory sqlSessionFactory;

    //加载位于resources/mybatis.xml
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //获取SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    //禁止外界通过new方式进行创建
    private MybatisUtils(){}

    //获取SqlSession对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    //关闭SqlSession对象
    public static void closeSqlSession(SqlSession sqlSession){
        if(null!=sqlSession){
            //关闭session
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        //获取Connection对象
        Connection connection = MybatisUtils.getSqlSession().getConnection();
        System.out.println(connection!=null?"连接成功":"连接失败");
    }
}
