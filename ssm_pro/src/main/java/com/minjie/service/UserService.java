package com.minjie.service;

import com.minjie.pojo.User;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/20
 * Time: 11:09
 * 业务层接口
 */
public interface UserService {
    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);
}
