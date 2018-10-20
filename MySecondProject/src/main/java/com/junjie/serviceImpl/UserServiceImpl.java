package com.junjie.serviceImpl;

import com.junjie.dao.UserDao;
import com.junjie.model.User;
import com.junjie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 刘俊杰 on 2018/9/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /*public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }*/


    public boolean register(User user) {
        if (user == null) {
            System.err.println("用户为空，请重新输入");
            return false;
        }
        userDao.saveUser(user);
        return true;
    }


    public User login(User user) {
        if (user == null) {
            System.err.println("用户为空，请重新输入");
            return null;
        }
        System.out.println(user);
        User user1 = userDao.queryUser(user);
        if (user1 == null) {
            return null;
        }
        if (user1.getU_id() != 0) {
            return user1;
        }
        return null;
    }


    public User queryUserByName(String uname) {
        if (uname != null) {
            return userDao.queryUserByName(uname);

        }
        return null;
    }


    public User queryUserByUid(int uid) {
        if (uid > 0) {
            return userDao.queryUserByUid(uid);
        }
        return null;
    }


    public boolean updateUser(User user) {
        if (user == null) {
            return false;
        }
        userDao.updateUser(user);
        return true;
    }
}
