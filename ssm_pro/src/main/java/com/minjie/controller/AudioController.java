package com.minjie.controller;

import com.minjie.pojo.Audio;
import com.minjie.pojo.Business;
import com.minjie.service.AudioService;
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
 * Date: 2020/2/29
 * Time: 11:12
 */
@Controller
@RequestMapping({"/AudioController"})
public class AudioController {
    @Autowired
    AudioService audioService;



    /**
     * 上传音频功能
     */
    @RequestMapping("/uploadAudio")
    public String uploadAudio(Audio audio, @RequestParam("audioFile") MultipartFile multipartFile, HttpServletRequest request){
        boolean result=false;
        try {
            result=audioService.upload(audio,multipartFile,request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result){
            return "../page/audio/addAudio.jsp";
        }
        else{
            return null;
        }
    }

    /**
     * 音频列表
     * @param request
     * @return
     */
    @RequestMapping("/getAllAudioInfo")
    public String getAllAudioInfo(HttpServletRequest request){
        Business business=(Business)request.getSession().getAttribute("business");
        List<Audio> audiolist=audioService.getAllAudioInfo(business.getBusiness_id());
        request.setAttribute("audiolist",audiolist);
        return "../page/audio/query_audio.jsp";
    }

    /**
     * 删除音频
     * @param audio_id
     * @param request
     * @return
     */
    @RequestMapping("/deleteAudio")
    public String deleteAudio(int audio_id ,HttpServletRequest request){

        boolean b= audioService.updateaudio(audio_id);
        if(b){
            request.setAttribute("msg","删除音频成功");
        }else{
            request.setAttribute("msg","删除音频失败");
        }
        return "../AudioController/getAllAudioInfo";
    }

    /**
     * 回收站列表
     * @param request
     * @return
     */
    @RequestMapping("/getRestoreAudio")
    public String getRestoreAudio(HttpServletRequest request){
        Business business=(Business)request.getSession().getAttribute("business");
        List<Audio> restoreaudiolist=audioService.getRestoreAudio(business.getBusiness_id());
        request.setAttribute("restoreaudiolist",restoreaudiolist);
        return "../page/audio/recyleAudioBus.jsp";
    }

    /**
     * 还原音频
     * @param audio_id
     * @param request
     * @return
     */
    @RequestMapping("/restoreAudio")
    public String restoreAudio(int audio_id,HttpServletRequest request){
        boolean b= audioService.restoreaudio(audio_id);
        if(b){
            request.setAttribute("msg","还原音频成功");
        }else{
            request.setAttribute("msg","还原音频失败，您的音频或许已被管理员删除");
        }
        return "../AudioController/getRestoreAudio";
    }




//    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================管理员部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->
    public AudioController() {
    }

    @RequestMapping({"/admingetAllAudio"})
    public String getAllAudio(HttpServletRequest request) {
        List<Audio> audiolist = this.audioService.getAllAudio();
        request.setAttribute("audiolist", audiolist);
        return "../page/audio/adminAudio.jsp";
    }

    @RequestMapping({"/admingetAudioByName"})
    public String getAudioByName(String business_username, HttpServletRequest request) {
        List<Audio> audiolist = this.audioService.getAudioByName(business_username);
        request.setAttribute("audiolist", audiolist);
        return "../page/audio/adminAudio.jsp";
    }

    @RequestMapping({"/admingetRecycleAudio"})
    public String getRecycleAudio(HttpServletRequest request) {
        List<Audio> audiorecyclelist = this.audioService.getRecycleAudio();
        request.setAttribute("audiorecyclelist", audiorecyclelist);
        return "../page/audio/recycleAudio.jsp";
    }

    @RequestMapping({"/adminDeleteAudio"})
    public String adminDeleteAudio(int audio_id, HttpServletRequest request) {
        boolean b = this.audioService.adminDeleteAudio(audio_id, request);
        if (b) {
            request.setAttribute("msg", "移入回收站成功");
        } else {
            request.setAttribute("msg", "移入回收站失败");
        }

        return "../AudioController/admingetAllAudio";
    }

    @RequestMapping({"/adminRestoreAudio"})
    public String adminRestoreAudio(int audio_id, HttpServletRequest request) {
        boolean b = this.audioService.adminRestoreAudio(audio_id, request);
        if (b) {
            request.setAttribute("msg", "恢复成功");
        } else {
            request.setAttribute("msg", "恢复失败");
        }

        return "../AudioController/admingetRecycleAudio";
    }
}
