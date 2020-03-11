package com.minjie.controller;

import com.minjie.pojo.Business;
import com.minjie.pojo.Businessinfo;
import com.minjie.pojo.Businesspass;
import com.minjie.service.BusinessLoginService;
import com.minjie.service.LoginService;
import com.minjie.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/21
 * Time: 17:14
 */
@Controller
@RequestMapping("/LoginController")
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    BusinessLoginService businessLoginService;
    @RequestMapping("/login")
    public String login(String login_user_name, String login_pass_word, HttpServletRequest request){
        Map<String,Object>map= new HashMap<>();
        map.put("login_user_name",login_user_name);
        map.put("login_pass_word",login_pass_word);

        Map<String,Object> returnmap = loginService.login(map,request);

        if((boolean)returnmap.get("result")){
            //登陆成功
            return "../page/main.jsp";
        }else{
            //登陆失败
            request.setAttribute("msg",returnmap.get("msg"));
            return "../index.jsp";

        }
    }
    @RequestMapping("/updateBusinessUser")
    public String updateBusinessUser(Business business, Businesspass businesspass , Businessinfo businessinfo, HttpServletRequest request){
        boolean b=businessLoginService.updateBusinessUser(business,businesspass,businessinfo,request);
        if(b){
            request.setAttribute("msg","修改成功");
        }else{
            request.setAttribute("msg","修改失败");
        }
        return "../page/business/addBusineeoper.jsp";
    }
}
