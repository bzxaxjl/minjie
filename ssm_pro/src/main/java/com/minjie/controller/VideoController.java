package com.minjie.controller;

import com.minjie.pojo.Business;
import com.minjie.pojo.Video;
import com.minjie.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/26
 * Time: 11:07
 */
@Controller
@RequestMapping({"/VideoController"})
public class VideoController {
    @Autowired
    VideoService videoService;

    public VideoController() {
    }

    /**
     * 上传视频功能
     */
    @RequestMapping({"/uploadVideo"})
    public String uploadVideo(Video video, @RequestParam("videoFile") MultipartFile multipartFile, HttpServletRequest request) {
        boolean result = false;
        System.out.println(video.getVideo_title());
        System.out.println(multipartFile + "------------------");

        try {
            result = this.videoService.uploadBus(video, multipartFile, request);
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return result ? "../page/video/addVideo.jsp" : null;
    }

    /**
     * 视频列表
     * @param request
     * @return
     */
    @RequestMapping("/getAllVideoInfo")
    public String getAllVideoInfo(HttpServletRequest request){
        Business business=(Business)request.getSession().getAttribute("business");
        List<Video> videolist=videoService.getAllVideoInfo(business.getBusiness_id());
        request.setAttribute("videolist",videolist);
        return "../page/video/query_video.jsp";
    }

    /**
     * 删除视频
     * @param video_id
     * @param request
     * @return
     */
    @RequestMapping("/busdeleteVideo")
    public String busdeleteVideo(int video_id ,HttpServletRequest request){

        boolean b= videoService.updatevideo(video_id);
        if(b){
            request.setAttribute("msg","删除视频成功");
        }else{
            request.setAttribute("msg","删除视频失败");
        }
        return "../VideoController/getAllVideoInfo";
    }

    /**
     * 回收站列表
     * @param request
     * @return
     */
    @RequestMapping("/getRestoreVideo")
    public String getRestoreVideo(HttpServletRequest request){
        Business business=(Business)request.getSession().getAttribute("business");
        List<Video> restorevideolist=videoService.getRestoreVideo(business.getBusiness_id());
        request.setAttribute("restorevideolist",restorevideolist);
        return "../page/video/recyleVideoBus.jsp";
    }

    /**
     * 还原视频
     * @param video_id
     * @param request
     * @return
     */
    @RequestMapping("/restoreVideo")
    public String restoreVideo(int video_id,HttpServletRequest request){
        boolean b= videoService.restorevideo(video_id);
        if(b){
            request.setAttribute("msg","还原视频成功");
        }else{
            request.setAttribute("msg","还原视频失败，您的视频或许已被管理员删除");
        }
        return "../VideoController/getRestoreVideo";
    }


    //    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================管理员部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->
    @RequestMapping({"/admingetVideoByName"})
    public String getVideoByName(String business_username, HttpServletRequest request) {
        List<Video> videolist = this.videoService.getVideoByName(business_username);
        request.setAttribute("videolist", videolist);
        return "../page/video/adminVideo.jsp";
    }

    @RequestMapping({"/admingetAllVideo"})
    public String getAllVideo(HttpServletRequest request) {
        List<Video> videolist = this.videoService.getAllVideo();
        request.setAttribute("videolist", videolist);
        return "../page/video/adminVideo.jsp";
    }

    @RequestMapping({"/admingetRecycleVideo"})
    public String getRecycleVideo(HttpServletRequest request) {
        List<Video> videorecyclelist = this.videoService.getRecycleVideo();
        request.setAttribute("videorecyclelist", videorecyclelist);
        return "../page/video/recycleVideo.jsp";
    }

    @RequestMapping({"/adminDeleteVideo"})
    public String deleteVideo(int video_id, HttpServletRequest request) {
        boolean b = this.videoService.adminDeleteVideo(video_id, request);
        if (b) {
            request.setAttribute("msg", "移入回收站成功");
        } else {
            request.setAttribute("msg", "移入回收站失败");
        }

        return "../VideoController/admingetAllVideo";
    }

    @RequestMapping({"/adminRestoreVideo"})
    public String adminRestoreVideo(int video_id, HttpServletRequest request) {
        boolean b = this.videoService.adminRestoreVideo(video_id, request);
        if (b) {
            request.setAttribute("msg", "恢复成功");
        } else {
            request.setAttribute("msg", "恢复失败");
        }

        return "../VideoController/admingetRecycleVideo";
    }
}
