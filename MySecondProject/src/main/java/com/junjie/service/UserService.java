package com.junjie.service;

import com.junjie.model.User;

/**
 * Created by 刘俊杰 on 2018/9/28.
 */
public interface UserService {
    //用户注册
    boolean register(User user);
    //用户登录
    User login(User user);
    //根据用户名字查询用户
    User queryUserByName(String uname);
    //根据用户id查询用户
    User queryUserByUid(int uid);
    //更新用户信息
    boolean updateUser(User user);

}
