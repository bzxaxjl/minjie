package com.minjie.dao;

import com.minjie.pojo.Businesspass;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/22
 * Time: 14:44
 */
public interface BusinesspassDao {
// <!--#检查用户名对应的密码是否正确-->
//     <select id="selectByBusinessPass" parameterType="com.minjie.pojo.Businesspass" resultType="com.minjie.pojo.Businesspass">
    Businesspass selectByBusinessPass(Businesspass businesspass);
//        <insert id="insertBusinessPass" parameterType="com.minjie.pojo.Businesspass">
//     <!--#创建对应用户的密码-->
    int insertBusinessPass(Businesspass businesspass);


    int updatebusinessPassword(Businesspass businesspass);
}
