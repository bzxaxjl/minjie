package com.minjie.dao;

import com.minjie.pojo.Businessinfo;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/22
 * Time: 14:38
 */
public interface BusinessinfoDao {
//<insert id="insertBusinessInfo" parameterType="int">

    /**
     * 插入商家信息
     * @param business_id
     * @return
     */
    int insertBusinessInfo(int business_id);

    int updatebusinessinfo(Businessinfo businessinfo);
}
