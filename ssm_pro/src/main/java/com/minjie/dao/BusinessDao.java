package com.minjie.dao;

import com.minjie.pojo.Business;
import com.minjie.pojo.Businessinfo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/22
 * Time: 14:40
 */
public interface BusinessDao {
//        <select id="selectByUsername" parameterType="String" resultType="com.minjie.pojo.Business">

    /**
     * 检查当前对应用户名的数据
     * @param business_username
     * @return
     */
    Business selectByUsername(String business_username);
//        <insert id="insertBusiness" parameterType="String" >

    /**
     * 插入商家登录名信息
     * @param business_username
     * @return
     */
    int insertBusiness(String business_username);

    /**
     * 修改商家姓名
     * @param business
     * @return
     */
    int updatebusinessname(Business business);

    Businessinfo selectBusinessUserByid(int business_id);
}
