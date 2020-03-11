package com.minjie.pojo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/29
 * Time: 11:08
 */
public class Audio {
    private int audio_id;
    private String audio_title;
    private String audio_src;
    private String audio_date;
    private int business_id;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private String business_username;
    private String business_info_legal_person;

    public String getBusiness_info_legal_person() {
        return business_info_legal_person;
    }

    public void setBusiness_info_legal_person(String business_info_legal_person) {
        this.business_info_legal_person = business_info_legal_person;
    }

    private int delete_by;

    public Audio() {
    }

    public int getAudio_id() {
        return this.audio_id;
    }

    public void setAudio_id(int audio_id) {
        this.audio_id = audio_id;
    }

    public String getAudio_title() {
        return this.audio_title;
    }

    public void setAudio_title(String audio_title) {
        this.audio_title = audio_title;
    }

    public String getAudio_src() {
        return this.audio_src;
    }

    public void setAudio_src(String audio_src) {
        this.audio_src = audio_src;
    }

    public String getAudio_date() {
        return this.audio_date;
    }

    public void setAudio_date(String audio_date) {
        this.audio_date = audio_date;
    }

    public int getBusiness_id() {
        return this.business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public String getBusiness_username() {
        return this.business_username;
    }

    public void setBusiness_username(String business_username) {
        this.business_username = business_username;
    }

    public int getDelete_by() {
        return this.delete_by;
    }

    public void setDelete_by(int delete_by) {
        this.delete_by = delete_by;
    }
}
