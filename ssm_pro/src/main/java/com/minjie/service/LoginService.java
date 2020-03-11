package com.minjie.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/21
 * Time: 16:40
 * 登陆相关业务流程
 */
public interface LoginService {

    Map<String,Object> login(Map<String,Object> map, HttpServletRequest request);
}

