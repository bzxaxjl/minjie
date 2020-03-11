package com.minjie.dao;

import com.minjie.pojo.Audio;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/29
 * Time: 11:11
 */
public interface AudioDao {
//    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================商户部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->
    /**
     * 插入音频相关信息
     * @param audio
     * @return
     */
    int insertAudio(Audio audio);

    /**
     * 查找用户的所有音频
     * @param
     * @return
     */
    List<Audio> selectAudio(int business_id);

    /**
     * 将音频移入回收站
     * @param audio_id
     * @return
     */

    int deleteAudio(int audio_id);

    /**
     * 显示回收站里的音频
     * @param business_id
     * @return
     */
    List<Audio> selectRestoreAudio(int business_id);

    /**
     * 还原回收站里的音频
     * @param audio_id
     * @return
     */
    int restoreAudio(int audio_id);
//    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================管理员部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->
    List<Audio> adminSelectAllAudio();

    List<Audio> adminSelectRecycleAudio();

    List<Audio> selectAudioByBusinessName(String var1);

    int adminDeleteAudio(int var1);

    int adminRestoreAudio(int var1);
}
