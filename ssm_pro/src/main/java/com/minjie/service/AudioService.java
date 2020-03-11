package com.minjie.service;

import com.minjie.pojo.Audio;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/29
 * Time: 11:11
 */
public interface AudioService {

    /**
     * 上传音频
     * @param audio
     * @param multipartFile
     * @param request
     * @return
     * @throws IOException
     */
    boolean upload(Audio audio, MultipartFile multipartFile, HttpServletRequest request) throws IOException;

    /**
     * 根据商户id获取音频信息
     * @param business_id
     * @return
     */
    List<Audio> getAllAudioInfo(int business_id);


    /**
     * 通过更新audio状态来实现回收站删除
     * @param audio_id
     * @return
     */
    boolean updateaudio(int audio_id);

    /**
     * 查看回收站音频
     * @param business_id
     * @return
     */
    List<Audio> getRestoreAudio(int business_id);

    /**
     * 通过更新audio状态来实现回收站还原
     * @param audio_id
     * @return
     */
    boolean restoreaudio(int audio_id);
//    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================管理员部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->
    List<Audio> getAllAudio();

    List<Audio> getRecycleAudio();

    List<Audio> getAudioByName(String var1);

    boolean adminDeleteAudio(int var1, HttpServletRequest var2);

    boolean adminRestoreAudio(int var1, HttpServletRequest var2);
}
