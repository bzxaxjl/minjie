package com.minjie.service.impl;

import com.minjie.dao.UserDao;
import com.minjie.pojo.User;
import com.minjie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/20
 * Time: 11:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) != 0;
    }
}
