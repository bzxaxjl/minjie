package com.minjie.service.impl;

import com.minjie.dao.BusinessDao;
import com.minjie.dao.BusinessinfoDao;
import com.minjie.dao.BusinesspassDao;
import com.minjie.pojo.Business;
import com.minjie.pojo.Businessinfo;
import com.minjie.pojo.Businesspass;
import com.minjie.service.BusinessLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/22
 * Time: 14:56
 */

@Service
public class BusinessLoginServiceImpl implements BusinessLoginService {

    @Autowired
    BusinessDao businessDao;
    @Autowired
    BusinesspassDao businesspassDao;
    @Autowired
    BusinessinfoDao businessinfoDao;
    /**
     * 登录相关操作
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> businessLogin(Map<String, Object> map, HttpServletRequest request) {

        Map<String, Object> returnmap = new HashMap<>();

        //1 接收数据
        String business_username = (String)map.get("business_username");
        String business_pass_word = (String)map.get("business_pass_word");
        //2 开始处理登录功能
        Business business=businessDao.selectByUsername(business_username);
        String business_freeze=business.getBusiness_freeze();
        System.out.println(business_freeze);
        if(business!=null){  //用户名存在继续判断密码
            if(business_freeze.equals("点击冻结") ){
                System.out.println("成功");
                Businesspass businessPass=new Businesspass();
                businessPass.setBusiness_id(business.getBusiness_id());
                businessPass.setBusiness_pass_word(business_pass_word);
                Businesspass businessPass1=businesspassDao.selectByBusinessPass(businessPass);
                if(businessPass1!=null){ //登陆成功
                    returnmap.put("result",true);
                    //获取session
                    HttpSession session=request.getSession();
                    //1在section空间中保存一份角色类型
                    session.setAttribute("roleType","2");//1就是超级管理员
                    //2在section空间中保存一份用户相关信息
                    session.setAttribute("business",business);
                    //结束
                }else{
                    System.out.println("失败");
                    returnmap.put("result",false);
                    returnmap.put("msg","请审核你的密码是否填错");
                    returnmap.put("falseType",1);
                }
            }else{
                returnmap.put("result",false);
                returnmap.put("msg","您的账号已经被冻结了");
                returnmap.put("falseType",2);
            }
        }else{   //反馈信息
            returnmap.put("result",false);
            returnmap.put("msg","你没有账号要重新创建，我们可以直接帮你创建");
            returnmap.put("falseType",3);
        }
        return returnmap;
    }

    /**
     *
     * @param map
     * @return
     */
    @Override
    @Transactional
    public Map<String, Object> businessRegister(Map<String, Object> map,HttpServletRequest request) {

        Map<String, Object> returnmap = new HashMap<>();

        //1 接收数据
        String business_username = (String)map.get("business_username");
        String business_pass_word = (String)map.get("business_pass_word");

        //1 创建用户
        int res1 = businessDao.insertBusiness(business_username);
        //2 查询当前用户的id
        Business business = businessDao.selectByUsername(business_username);
        //3 创建对应用户的密码
        Businesspass businesspass = new Businesspass();
        businesspass.setBusiness_pass_word(business_pass_word);
        businesspass.setBusiness_id(business.getBusiness_id());
        int res2 = businesspassDao.insertBusinessPass(businesspass);
        //4 创建账户商家信息
        int res3 = businessinfoDao.insertBusinessInfo(business.getBusiness_id());
        if(res1>0 && res2>0 && res3>0){

            //获取session
            HttpSession session = request.getSession();
            //保存的角色类型
            session.setAttribute("roleType","2");
            //将当前的用户信息放到
            session.setAttribute("business",business);



            returnmap.put("result",true);
            returnmap.put("msg","注册成功");
        }else{
            returnmap.put("result",false);
            returnmap.put("msg","注册失败");
        }
        return returnmap;
    }
    @Transactional
    public boolean updateBusinessUser(Business business, Businesspass businesspass , Businessinfo businessinfo, HttpServletRequest request) {
        //获取session
        int business_id=((Business)request.getSession().getAttribute("business")).getBusiness_id();
        //修改用户名
        Business business1=new Business();
        business1.setBusiness_id(business_id);
        business1.setBusiness_username(business.getBusiness_username());
        int res1=businessDao.updatebusinessname(business1);
        //修改密码
        Businesspass businessPass1=new Businesspass();
        businessPass1.setBusiness_id(business_id);
        businessPass1.setBusiness_pass_word(businesspass.getBusiness_pass_word());
        int res2=businesspassDao.updatebusinessPassword(businessPass1);
        //修改用户信息
        Businessinfo businessInfo1=new Businessinfo();
        businessInfo1.setBusiness_id(business_id);
        businessInfo1.setBusiness_info_name(businessinfo.getBusiness_info_name());
        businessInfo1.setBusiness_info_legal_person(businessinfo.getBusiness_info_legal_person());
        businessInfo1.setBusiness_info_legal_person_tel(businessinfo.getBusiness_info_legal_person_tel());
        int res3=businessinfoDao.updatebusinessinfo(businessInfo1);
//        System.out.println("-----------------------------------");
//        System.out.println(res1);
//        System.out.println(res2);
//        System.out.println(res3);
//        System.out.println("-----------------------------------");
        if(res1>0 && res2>0 && res3>0){
            return true;
        }else{
            return false;
        }

    }
    @Override
    public Businessinfo selectBusinessUserByid(int business_id) {
        return businessDao.selectBusinessUserByid(business_id);
    }

}
