package com.minjie.service.impl;

import com.minjie.dao.AudioDao;
import com.minjie.pojo.Audio;
import com.minjie.pojo.Business;
import com.minjie.service.AudioService;
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
 * Date: 2020/2/29
 * Time: 11:10
 */
@Service
public class AudioServiceImpl implements AudioService {
    @Autowired
    AudioDao audioDao;

    public AudioServiceImpl() {
    }
    /**
     * 上传音频
     * @param audio
     * @param multipartFile
     * @param request
     * @return
     * @throws IOException
     */
    @Override
    public boolean upload(Audio audio, MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        //=====文件上传==========start====================================
        //1、设置当前文件路径（全路径：路径+文件名.扩展名）定义成文件类型
        //(1.1)获取项目的根目录
        String projectPath = request.getServletContext().getRealPath("");
        //(1.2)设置文件全路径
        String filePath=projectPath+"/audio/"+multipartFile.getOriginalFilename();
        //(1.3)创建file对象
        File file1=new File(filePath);
        //2、首次上传路径不存在，判断路径是否存在，不存在即创建父路径
        File fileParentFile=file1.getParentFile();
        if(!fileParentFile.exists()){
            fileParentFile.mkdirs();
        }
        //3、创建文件(路径+文件名.扩展名)空文件
        if(!file1.exists()){
            file1.createNewFile();
        }
        //4、转移文件
        multipartFile.transferTo(new File(filePath));
        Business business=(Business) request.getSession().getAttribute("business");
        audio.setAudio_src("/audio/"+multipartFile.getOriginalFilename());
        audio.setBusiness_id(business.getBusiness_id());
        int res=audioDao.insertAudio(audio);
        //2、带着相关参数执行数据库方法，返回结果即可
        if(res>0){
            return  true;
        }
        else {
            return false;
        }
    }

    /**
     * 音频列表
     * @param business_id
     * @return
     */

    @Override
    public List<Audio> getAllAudioInfo(int business_id) {
        return audioDao.selectAudio(business_id);
    }

    /**
     * 删除音频
     * @param audio_id
     * @return
     */
    @Override
    public boolean updateaudio(int audio_id) {
        int res=audioDao.deleteAudio(audio_id);
        if(res>0)
        {
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * 查看回收站里的音频
     * @param business_id
     * @return
     */

    @Override
    public List<Audio> getRestoreAudio(int business_id) {
        return audioDao.selectRestoreAudio(business_id);
    }

    @Override
    public boolean restoreaudio(int audio_id) {
        int res=audioDao.restoreAudio(audio_id);
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
    public List<Audio> getAllAudio() {
        return this.audioDao.adminSelectAllAudio();
    }

    public List<Audio> getRecycleAudio() {
        return this.audioDao.adminSelectRecycleAudio();
    }

    public List<Audio> getAudioByName(String business_username) {
        return this.audioDao.selectAudioByBusinessName(business_username);
    }

    public boolean adminDeleteAudio(int audio_id, HttpServletRequest request) {
        int res = this.audioDao.adminDeleteAudio(audio_id);
        return res > 0;
    }

    public boolean adminRestoreAudio(int audio_id, HttpServletRequest request) {
        int res = this.audioDao.adminRestoreAudio(audio_id);
        return res > 0;
    }
}