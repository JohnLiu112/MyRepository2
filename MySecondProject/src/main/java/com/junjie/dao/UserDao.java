package com.junjie.dao;

import com.junjie.model.User;

import java.util.List;

/**
 * Created by 刘俊杰 on 2018/9/28.
 */

public interface UserDao {
    //根据用户名字和密码查询用户
    User queryUser(User user);
    //根据用户名字查询用户
    User queryUserByName(String uname);
    //根据用户id查询用户
    User queryUserByUid(int uid);
    //增加用户
    void saveUser(User user);
    //删除用户
    void deleteUser(User user);
    //更新用户信息
    void updateUser(User user);
    //查询所有用户
    List<User> queryAllUsers();
}
