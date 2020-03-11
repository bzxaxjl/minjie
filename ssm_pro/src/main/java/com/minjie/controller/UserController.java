package com.minjie.controller;

import com.minjie.pojo.User;
import com.minjie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/20
 * Time: 11:14
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService ;

    @RequestMapping("/addUser")
    public String addUser(User user){

        boolean b = userService.addUser(user);
        if(b){
            return "../page/success.jsp";
        }else{
            return "../page/error.jsp";
        }
    }
}
