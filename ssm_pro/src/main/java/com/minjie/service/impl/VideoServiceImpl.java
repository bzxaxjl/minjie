package com.minjie.service.impl;

import com.minjie.dao.VideoDao;
import com.minjie.pojo.Business;
import com.minjie.pojo.Video;
import com.minjie.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/26
 * Time: 12:03
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    VideoDao videoDao;

    public VideoServiceImpl() {
    }



    public boolean uploadBus(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //=====文件上传==========start====================================
        //1、设置当前文件路径（全路径：路径+文件名.扩展名）定义成文件类型
        //(1.1)获取项目的根目录
        String projectPath = request.getServletContext().getRealPath("");
        //(1.2)设置文件全路径
        String filePath=projectPath+"/video/"+multipartFile.getOriginalFilename();
        //(1.3)创建file对象
        File file=new File(filePath);
        //2、首次上传路径不存在，判断路径是否存在，不存在即创建父路径
        File fileParentFile=file.getParentFile();
        if(!fileParentFile.exists()){
            fileParentFile.mkdirs();
        }
        //3、创建文件(路径+文件名.扩展名)空文件
        if(!file.exists()){
            file.createNewFile();
        }
        System.out.println(file+"====================");
        //4、转移文件
        multipartFile.transferTo(new File(filePath));
        //=======================end============================
        //=====数据保存==========start====================================
        Business business=(Business) request.getSession().getAttribute("business");
        video.setVideo_src("/video/"+multipartFile.getOriginalFilename());
        video.setBusiness_id(business.getBusiness_id());
        //1、获取对应的Dao层
        int res=videoDao.businsertVideo(video);
        //2、带着相关参数执行数据库方法，返回结果即可
        if(res>0){
            return  true;
        }
        else {
            return false;
        }
        //=======================end============================

    }
    /**
     * 显示视频列表信息
     * @param business_id
     * @return
     */
    @Override
    public List<Video> getAllVideoInfo(int business_id)
    {

        return videoDao.busselectVideo(business_id);
    }

    /**
     * 删除视频
     * @param video_id
     * @return
     */
    @Override
    public boolean updatevideo(int video_id) {
        int res=videoDao.busdeleteVideo(video_id);
        if(res>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 查看回收站里的视频
     * @param business_id
     * @return
     */
    @Override
    public List<Video> getRestoreVideo(int business_id) {
        return videoDao.selectRestoreVideo(business_id);
    }

    /**
     * 还原视频
     * @param video_id
     * @return
     */
    @Override
    public boolean restorevideo(int video_id) {
        int res=videoDao.restoreVideo(video_id);
        if(res>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    //    <!--=================================================================-->
//    <!--=================================================================-->
//    <!--=======================管理员部分=================================-->
//    <!--=================================================================-->
//    <!--=================================================================-->
    public boolean upload(Video video, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String projectPatch = request.getServletContext().getRealPath("");
        String filePath = projectPatch + "/video/" + multipartFile.getOriginalFilename();
        File file = new File(filePath);
        File fileParentFile = file.getParentFile();
        if (!fileParentFile.exists()) {
            fileParentFile.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println(file + "----------------");
        multipartFile.transferTo(new File(filePath));
        Business business = (Business)request.getSession().getAttribute("business");
        video.setVideo_src("/video/" + multipartFile.getOriginalFilename());
        video.setBusiness_id(business.getBusiness_id());
        int res = this.videoDao.insertVideo(video);
        return res > 0;
    }
    public List<Video> getAllVideo() {
        return this.videoDao.adminSelectAllVideo();
    }

    public List<Video> getRecycleVideo() {
        return this.videoDao.adminSelectRecycleVideo();
    }

    public List<Video> getVideoByName(String business_username) {
        return this.videoDao.selectVideoByBusinessName(business_username);
    }

    public boolean adminDeleteVideo(int video_id, HttpServletRequest request) {
        int res = this.videoDao.adminDeleteVideo(video_id);
        return res > 0;
    }

    public boolean adminRestoreVideo(int video_id, HttpServletRequest request) {
        int res = this.videoDao.adminRestoreVideo(video_id);
        return res > 0;
    }
}
