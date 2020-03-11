package com.minjie.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/21
 * Time: 8:58
 */

/**
 * 登陆密码实体
 */
public class LoginPass {
    /**
     * 登陆密码id
     */
    private int login_pass_id;
    /**
     * 登陆密码内容
     */
    private String login_pass_word;
    /**
     * 系统用户的外键
     */
    private int login_user_id;

    public int getLogin_pass_id() {
        return login_pass_id;
    }

    public void setLogin_pass_id(int login_pass_id) {
        this.login_pass_id = login_pass_id;
    }

    public String getLogin_pass_word() {
        return login_pass_word;
    }

    public void setLogin_pass_word(String login_pass_word) {
        this.login_pass_word = login_pass_word;
    }

    public int getLogin_user_id() {
        return login_user_id;
    }

    public void setLogin_user_id(int login_user_id) {
        this.login_user_id = login_user_id;
    }
}
