package com.minjie.service.impl;

import com.minjie.dao.LoginPassDao;
import com.minjie.dao.LoginUserDao;
import com.minjie.dao.SystemUserDao;
import com.minjie.pojo.*;
import com.minjie.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/24
 * Time: 15:10
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    SystemUserDao systemUserDao;
    @Autowired
    LoginUserDao loginUserDao;
    @Autowired
    LoginPassDao loginPassDao;

    @Override
    public List<SystemUserAndUsername> getSystemUserAllInfo() {
        return systemUserDao.selectSystemUserAllInfo();
    }

    @Override
    public SystemUserAndUsername selectSystemUserByID(int login_user_id) {
        return systemUserDao.selectSystemUserByID(login_user_id);
    }
    @Override
    public List<Businessinfo> getBusiness() {
        return systemUserDao.selectBusinessAndallinfo();
    }

    @Transactional
    public boolean updabusinessfreeze(String business_freeze, String business_id, HttpServletRequest request) {
        Business business=new Business();
        int business1=Integer.parseInt(business_id);
        business.setBusiness_id(business1);
        business.setBusiness_freeze(business_freeze);
        int res1=systemUserDao.updabusinessfreeze(business);
        if(res1>0 ){
            return true;
        }else{
            return false;
        }

    }

    @Override
    @Transactional
    public boolean updateSystemUser(SystemUserAndUsername systemUserAndUsername, HttpServletRequest request) {

        //获取session
        int login_user_id = ((LoginUser)request.getSession().getAttribute("loginUser")).getLogin_user_id();
        //修改用户名
        LoginUser loginUser = new LoginUser();
        loginUser.setLogin_user_id(login_user_id);
        loginUser.setLogin_user_name(systemUserAndUsername.getLogin_user_name());
        int res1 = loginUserDao.updateUserName(loginUser);
        //修改密码

        LoginPass loginPass = new LoginPass();
        loginPass.setLogin_pass_word(systemUserAndUsername.getLogin_pass_word());
        loginPass.setLogin_user_id(login_user_id);
        int res2 = loginPassDao.updatePassWord(loginPass);
        //修改用户名

        SystemUser systemUser = new SystemUser();
        systemUser.setLogin_user_id(login_user_id);
        systemUser.setUser_sex(systemUserAndUsername.getUser_sex());
        systemUser.setUser_tel(systemUserAndUsername.getUser_tel());
        systemUser.setUser_true_name(systemUserAndUsername.getUser_true_name());
        int res3 = systemUserDao.updateAllData(systemUser);

        if(res1 > 0&&res2 > 0&&res3 > 0){
            return true;
        }else{
            return false;
        }

    }


}
