package com.minjie.service;

import com.minjie.pojo.Video;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/26
 * Time: 10:38
 */
public interface VideoService {


    /**
     * 上传视频
     * @param video
     * @param multipartFile
     * @param request
     * @return
     * @throws IOException
     */
   boolean uploadBus(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException;

    /**
     * 根据商户id获取视频信息
     * @param business_id
     * @return
     */
    List<Video> getAllVideoInfo(int business_id);


    /**
     * 通过更新video状态来实现回收站删除
     * @param video_id
     * @return
     */
    boolean updatevideo(int video_id);

    /**
     * 查看回收站视频
     * @param business_id
     * @return
     */
    List<Video> getRestoreVideo(int business_id);

    /**
     * 通过更新video状态来实现回收站还原
     * @param video_id
     * @return
     */
    boolean restorevideo(int video_id);


//    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================管理员部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->

    boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException;

    List<Video> getAllVideo();

    List<Video> getRecycleVideo();

    List<Video> getVideoByName(String var1);

    boolean adminDeleteVideo(int var1, HttpServletRequest var2);

    boolean adminRestoreVideo(int var1, HttpServletRequest var2);
}
