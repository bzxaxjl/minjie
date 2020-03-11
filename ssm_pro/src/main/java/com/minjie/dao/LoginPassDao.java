package com.minjie.dao;

import com.minjie.pojo.LoginPass;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/21
 * Time: 16:25
 * 密码表 Dao层
 */
public interface LoginPassDao {
    /**
     * 给定map参数，返回查询结果
     * @param map
     * @return
     */
    //<select id ="selectByPasswordndUserId"
    // parameterType="hashmap"
    // resultType="com.minjie.dao.LoginPass">
    List<LoginPass> selectByPasswordAndUserId(Map<String ,Object>map);


    /**
     * 修改登陆密码
     * @param loginPass
     * @return
     */
    int updatePassWord(LoginPass loginPass);
}
