package com.minjie.dao;
import com.minjie.pojo.Business;
import com.minjie.pojo.Businessinfo;
import com.minjie.pojo.SystemUser;
import com.minjie.pojo.SystemUserAndUsername;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bzx
 * Date: 2020/2/24
 * Time: 15:04
 */
public interface SystemUserDao {

    /**
     * 查询所有系统用户信息
     * @return
     */
    List<SystemUserAndUsername> selectSystemUserAllInfo();

    /**
     * 根据id查询系统用户信息
     * @param login_user_id
     * @return
     */
    SystemUserAndUsername selectSystemUserByID(int login_user_id);

    /**
     * 修改个人信息
     * @param systemUser
     * @return
     */
    int updateAllData(SystemUser systemUser);

    /**
     * 冻结
     * @return
     */
    List<Businessinfo> selectBusinessAndallinfo();

    int updabusinessfreeze(Business business);

}
