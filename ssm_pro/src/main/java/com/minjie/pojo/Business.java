package com.minjie.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/22
 * Time: 12:02
 */
public class Business {
    /**
     * 商家id
     */
    private int business_id;
    /**
     * 商家登录名
     */
    private String business_username;
    private String business_freeze;

    public String getBusiness_freeze() {
        return business_freeze;
    }

    public void setBusiness_freeze(String business_freeze) {
        this.business_freeze = business_freeze;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_username() {
        return business_username;
    }

    public void setBusiness_username(String business_username) {
        this.business_username = business_username;
    }
}
