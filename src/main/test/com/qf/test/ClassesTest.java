package com.qf.test;

import com.qf.dao.ClassesDao;
import com.qf.pojo.Classes;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassesTest {
    @Test
    public void test1(){
        String resource="mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassesDao mapper = sqlSession.getMapper(ClassesDao.class);
        List<Classes> all = mapper.findAll(1);
        System.out.println(all);
    }
}
