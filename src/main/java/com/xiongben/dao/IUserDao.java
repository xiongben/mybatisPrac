package com.xiongben.dao;

import com.xiongben.domain.QueryVo;
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

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findById(Integer userId);

    /**
     * 名字模糊查找
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据queryVo中的条件查询用户
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入条件查询
     * @param user
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id集合查询
     * @param vo
     * @return
     */
    List<User> findUserInIds(QueryVo vo);
}
