package com.xiongben.test;


import com.xiongben.dao.IAccountDao;
import com.xiongben.dao.IRoleDao;
import com.xiongben.dao.IUserDao;
import com.xiongben.dao.impl.UserDaoImpl;
import com.xiongben.domain.Account;
import com.xiongben.domain.QueryVo;
import com.xiongben.domain.Role;
import com.xiongben.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession session;
    private IUserDao userDao;
    private IAccountDao accountDao;
    private IRoleDao roleDao;

    @Before
    public void init()throws Exception{
         in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        session = factory.openSession();
        userDao = session.getMapper(IUserDao.class);
        accountDao = session.getMapper(IAccountDao.class);
        roleDao = session.getMapper(IRoleDao.class);
    }

    @After
    public void destory()throws Exception{
        session.commit();
        session.close();
        in.close();
    }

    public static void main(String[] args)throws Exception {
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//        SqlSession session = factory.openSession();
//        IUserDao userDao = session.getMapper(IUserDao.class);

//        IUserDao userDao = new UserDaoImpl(factory);
//
//        List<User> users = userDao.findAll();
//        for (User user : users){
//            System.out.println(user);
//        }
//        session.close();
//        in.close();
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

    @Test
    public void testupdate(){
        User user = new User();
        user.setId(49);
        user.setUsername("宇智波佐助");
        user.setAddress("火影村");
        user.setSex("男");
        user.setBirthday(new Date());
        userDao.updateUser(user);

    }

    @Test
    public void testdelete(){
        userDao.deleteUser(48);
    }

    @Test
    public void testfindByid(){
        User user = userDao.findById(49);
        System.out.println(user);
    }

    @Test
    public void testfindByNames(){
        List<User> users = userDao.findByName("%王%");
        for (User user : users){
            System.out.println(user);
        }
    }

    /**
     * 测试查询总数据条数
     */
    @Test
    public void testfindaccounts(){
        int count = userDao.findTotal();
        System.out.println(count);
    }

    @Test
    public void testfindByVo(){
        QueryVo vo = new QueryVo();
        User userp = new User();
        userp.setUsername("%齐木%");
        vo.setUser(userp);
        List<User> users = userDao.findUserByVo(vo);
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindByCondition(){
        User u = new User();
        u.setUsername("老王");
        u.setSex("男");
        List<User> users = userDao.findUserByCondition(u);
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void testFindByIds(){
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(41);
        ids.add(42);
        ids.add(46);
        vo.setIds(ids);
        List<User> users = userDao.findUserInIds(vo);
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void  testFindAll2(){
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testfindAll3(){
        List<User> users = userDao.findAll();
        for (User user : users){
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    @Test
    public void testRoleFindAll(){
        List<Role> roles = roleDao.findAll();
        for(Role role : roles){
            System.out.println("======每个角色信息========");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }
}
