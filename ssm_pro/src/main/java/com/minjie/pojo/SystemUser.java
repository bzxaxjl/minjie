package com.minjie.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/21
 * Time: 8:52
 */

/**
 * 系统用户
 */
public class SystemUser {
    /**
     *用户id
     */
    private int user_id;
    /**
     * 用户真实姓名
     */
    private String user_true_name;
    /**
     * 用户电话
     */
    private String user_tel;
    /**
     * 用户性别
     */
    private String user_sex;
    /**
     * 系统用户的外键
     */
    private int login_user_id;

    public int getLogin_user_id() {
        return login_user_id;
    }

    public void setLogin_user_id(int login_user_id) {
        this.login_user_id = login_user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_true_name() {
        return user_true_name;
    }

    public void setUser_true_name(String user_true_name) {
        this.user_true_name = user_true_name;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getUser_sex() {
        return user_sex;
    }

    public void setUser_sex(String user_sex) {
        this.user_sex = user_sex;
    }
}
