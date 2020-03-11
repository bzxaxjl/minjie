package com.minjie.dao;

import com.minjie.pojo.LoginUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/21
 * Time: 16:24
 * 用户表 dao层
 */
public interface LoginUserDao {
    //<select id ="selectByUsername"
    // parameterType="string"
    // resultType="com.minjie.dao.LoginUser">

    List<LoginUser>selectByUsername(String login_user_name);

    /**
     * 修改用户名
     * @param loginUser
     * @return
     */
    int updateUserName(LoginUser loginUser);
}
