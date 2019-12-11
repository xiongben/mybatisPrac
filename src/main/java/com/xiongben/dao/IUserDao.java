package com.xiongben.dao;

import com.xiongben.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao {
//    @Select("select * from user")
    List<User> findAll();

    /*
    * 保存用户
    * */
    void saveUser(User user);
}
