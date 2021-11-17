package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;

/**
 * 工具类
 */
public class MybatisUtils {

    //定义SqlSession工厂
    private static SqlSessionFactory sqlSessionFactory;

    //加载mybatis.xml配置文件
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //获取SqlSession工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            //抛出运行时异常
            throw new RuntimeException(e);
        }
    }

    //禁止外界实例化
    private MybatisUtils(){}

    //获取SqlSession对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    //关闭SqlSession
    public static void closeSqlSession(SqlSession sqlSession){
        if (null!=sqlSession){
            sqlSession.close();
        }
    }

    public static void main(String[] args) {
        //获取数据库连接
        Connection connection = MybatisUtils.getSqlSession().getConnection();
        System.out.println(connection!=null?"连接成功":"连接失败");
    }
}
