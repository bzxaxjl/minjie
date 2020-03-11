package com.minjie.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/21
 * Time: 8:57
 */

/**
 * 登录用户
 */
public class LoginUser {
    /**
     * 登录用户id
     */
    private int login_user_id;
    /**
     * 登录用户姓名
     */
    private String login_user_name;

    public int getLogin_user_id() {
        return login_user_id;
    }

    public void setLogin_user_id(int login_user_id) {
        this.login_user_id = login_user_id;
    }

    public String getLogin_user_name() {
        return login_user_name;
    }

    public void setLogin_user_name(String login_user_name) {
        this.login_user_name = login_user_name;
    }
}
