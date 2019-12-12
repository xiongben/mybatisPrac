package com.xiongben.dao.impl;

import com.xiongben.dao.IUserDao;
import com.xiongben.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl  {
    private SqlSessionFactory factory;

    public  UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll(){
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.xiongben.dao.IUserDao.findAll");
        session.close();
        return users;
    }

    public void saveUser(User user) {

    }
}
