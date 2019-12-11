package com.xiongben.test;


import com.xiongben.dao.IUserDao;
import com.xiongben.dao.impl.UserDaoImpl;
import com.xiongben.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;

    @Before
    public void init()throws Exception{
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
    }

    @After
    public void destory()throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    public static void main(String[] args)throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
//        SqlSession session = factory.openSession();
//        IUserDao userDao = session.getMapper(IUserDao.class);

        IUserDao userDao = new UserDaoImpl(factory);

        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }
//        session.close();
        in.close();
    }

    @Test
    public void testfindall()throws Exception{
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
        }

    }

    @Test
    public void testsave(){
        User user = new User();
        user.setUsername("卡卡西齐木");
        user.setAddress("北京市顺义区");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.saveUser(user);

    }
}
