package com.minjie.dao;

import com.minjie.pojo.Video;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/26
 * Time: 10:34
 */
public interface VideoDao {


    /**
     * 插入视频相关信息
     * @param video
     * @return
     */
    int businsertVideo(Video video);

    /**
     * 获取用户的所有视频
     * @param business_id
     * @return
     */
    List<Video> busselectVideo(int business_id);

    /**
     * 将视频移入回收站
     * @param video_id
     * @return
     */
    int busdeleteVideo(int video_id);

    /**
     * 显示回收站里的视频
     * @param business_id
     * @return
     */
    List<Video> selectRestoreVideo(int business_id);

    /**
     * 还原回收站里的视频
     * @param video_id
     * @return
     */
    int restoreVideo(int video_id);
//    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================管理员部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->
    int insertVideo(Video var1);

    List<Video> selectVideoByBusinessName(String var1);

    List<Video> adminSelectAllVideo();

    List<Video> adminSelectRecycleVideo();

    int adminDeleteVideo(int var1);

    int adminRestoreVideo(int var1);
}
