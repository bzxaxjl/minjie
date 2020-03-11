package com.minjie.service;

import com.minjie.pojo.Business;
import com.minjie.pojo.Businessinfo;
import com.minjie.pojo.Businesspass;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/22
 * Time: 14:50
 */
public interface BusinessLoginService {

    /**
     * 商家登录功能
     * @return
     */
    Map<String,Object> businessLogin(Map<String,Object> map, HttpServletRequest request);

    /**
     * 商家注册功能
     * @param map
     * @return
     */
    Map<String,Object> businessRegister(Map<String,Object> map,HttpServletRequest request);

    /**
     * Created with IntelliJ IDEA.
     * User: bzx
     * Date: 2020/2/24
     * Time: 15:08
     */

    boolean updateBusinessUser(Business business, Businesspass businesspass , Businessinfo businessinfo, HttpServletRequest request);

    Businessinfo selectBusinessUserByid(int business_id);
}
