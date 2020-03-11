package com.minjie.controller;

import com.minjie.pojo.*;
import com.minjie.service.AudioService;
import com.minjie.service.SystemUserService;
import com.minjie.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/24
 * Time: 15:12
 */
@Controller
@RequestMapping("/SystemUserController")
public class SystemUserController {

    @Autowired
    SystemUserService systemUserService;
    @Autowired
    VideoService videoService;
    @Autowired
    AudioService audioService;
    @RequestMapping("/getSystemUserAllInfo")
    public String getSystemUserAllInfo(HttpServletRequest request){
        List<SystemUserAndUsername> list = systemUserService.getSystemUserAllInfo();
        request.setAttribute("list",list);
        return "../page/system/systemoper.jsp";
    }

    @RequestMapping("/getSystemUserByID")
    @ResponseBody
    public SystemUserAndUsername getSystemUserByID(HttpServletRequest request){
        HttpSession session = request.getSession();
        int login_user_id = ((LoginUser)session.getAttribute("loginUser")).getLogin_user_id();
        return systemUserService.selectSystemUserByID(login_user_id);
    }
    @RequestMapping("/updateSystemUser")
    public String updateSystemUser(SystemUserAndUsername systemUserAndUsername,HttpServletRequest request){
        boolean b = systemUserService.updateSystemUser(systemUserAndUsername,request);

        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }
        return "../page/system/addSystemoper.jsp";
    }

    @RequestMapping("/getBusiness")
    public String getBusiness(HttpServletRequest request){
        List<Businessinfo> list=systemUserService.getBusiness();
        request.setAttribute("list",list);
        return "../page/system/businessoper.jsp";
    }

    @RequestMapping("/updabusinessfreeze")
    public String updabusinessfreeze(int business_id, int business_freeze,  HttpServletRequest request) throws IOException {
        String id=Integer.toString(business_id);
        String freeze;
        if(business_freeze==1){
            freeze="点击解冻";
        }else{
            freeze="点击冻结";
        }
        boolean b= systemUserService.updabusinessfreeze(freeze,id,request);
        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }
        return "../SystemUserController/getBusiness";
    }

    @RequestMapping("/getAllVideoInfo")
    public String getAllVideoInfo(int business_id, HttpServletRequest request){
        List<Video> videolist= videoService.getAllVideoInfo(business_id);
        request.setAttribute("videolist",videolist);
        return "../page/video/queery_Video.jsp";
    }
    @RequestMapping("/getAllAudioInfo")
    public String getAllAudioInfo(int business_id, HttpServletRequest request){
        List<Audio> audiolist=audioService.getAllAudioInfo(business_id);
        request.setAttribute("audiolist",audiolist);
        return "../page/audio/query_audio.jsp";
    }

}