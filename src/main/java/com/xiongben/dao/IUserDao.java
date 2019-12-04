package com.xiongben.dao;

import com.xiongben.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
