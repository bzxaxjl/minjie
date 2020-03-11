package com.minjie.pojo;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/26
 * Time: 10:22
 */
public class Video {

    private int video_id;
    private String video_title;
    private String video_src;
    private Date video_date;
    private int business_id;
    private String business_username;
    private int status;
    private String business_info_legal_person;

    public String getBusiness_info_legal_person() {
        return business_info_legal_person;
    }

    public void setBusiness_info_legal_person(String business_info_legal_person) {
        this.business_info_legal_person = business_info_legal_person;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBusiness_username() {
        return business_username;
    }

    public void setBusiness_username(String business_username) {
        this.business_username = business_username;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_src() {
        return video_src;
    }

    public void setVideo_src(String video_src) {
        this.video_src = video_src;
    }

    public Date getVideo_date() {
        return video_date;
    }

    public void setVideo_date(Date video_date) {
        this.video_date = video_date;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }
}
