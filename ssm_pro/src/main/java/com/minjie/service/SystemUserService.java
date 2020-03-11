package com.minjie.service;

import com.minjie.pojo.Businessinfo;
import com.minjie.pojo.SystemUserAndUsername;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/24
 * Time: 15:10
 */
public interface SystemUserService {

    List<SystemUserAndUsername> getSystemUserAllInfo();

    /**
     * 根据id查询系统用户信息
     * @param login_user_id
     * @return
     */
    SystemUserAndUsername selectSystemUserByID(int login_user_id);


    /**
     * 修改系统用户的数据
     * @param systemUserAndUsername
     * @param request
     * @return
     */
    boolean updateSystemUser(SystemUserAndUsername systemUserAndUsername, HttpServletRequest request);

    List<Businessinfo> getBusiness();

    boolean updabusinessfreeze(String business_freeze, String business_id, HttpServletRequest request);
}
