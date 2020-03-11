package com.minjie.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/22
 * Time: 12:03
 */
public class Businessinfo {


    private int business_info_id;
    private String  business_info_name;
    private String  business_info_legal_person;
    private String  getBusiness_info_legal_person_tel;
    private String business_info_legal_person_tel;

    public String getBusiness_info_legal_person_tel() {
        return business_info_legal_person_tel;
    }

    public void setBusiness_info_legal_person_tel(String business_info_legal_person_tel) {
        this.business_info_legal_person_tel = business_info_legal_person_tel;
    }

    private int business_id;

    private String business_freeze;
    private String business_pass_word;
    private String business_username;

    public String getBusiness_freeze() {
        return business_freeze;
    }

    public void setBusiness_freeze(String business_freeze) {
        this.business_freeze = business_freeze;
    }

    public String getBusiness_pass_word() {
        return business_pass_word;
    }

    public void setBusiness_pass_word(String business_pass_word) {
        this.business_pass_word = business_pass_word;
    }

    public String getBusiness_username() {
        return business_username;
    }

    public void setBusiness_username(String business_username) {
        this.business_username = business_username;
    }

    public int getBusiness_info_id() {
        return business_info_id;
    }

    public void setBusiness_info_id(int business_info_id) {
        this.business_info_id = business_info_id;
    }

    public String getBusiness_info_name() {
        return business_info_name;
    }

    public void setBusiness_info_name(String business_info_name) {
        this.business_info_name = business_info_name;
    }

    public String getBusiness_info_legal_person() {
        return business_info_legal_person;
    }

    public void setBusiness_info_legal_person(String business_info_legal_person) {
        this.business_info_legal_person = business_info_legal_person;
    }

    public String getGetBusiness_info_legal_person_tel() {
        return getBusiness_info_legal_person_tel;
    }

    public void setGetBusiness_info_legal_person_tel(String getBusiness_info_legal_person_tel) {
        this.getBusiness_info_legal_person_tel = getBusiness_info_legal_person_tel;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }
}
