package com.qf.tools;

import com.qf.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Tools {

    private  static InputStream inputStream =null;
    private static SqlSession sqlSession =null;

    public static UserDao getUserDao() {
        String resource="mybatis-config.xml";
        try {
            //读取mybatis的配置信息
            inputStream = Resources.getResourceAsStream(resource);
            //使用配置信息创建出sqlSession工程
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //使用工厂打开一个连接
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            //使用Session对象加载你要执行的接口
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            //用接口调用要执行的方法
            return mapper;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void close(){
        if (sqlSession!=null){
            sqlSession.close();
        }
        if (inputStream!=null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
